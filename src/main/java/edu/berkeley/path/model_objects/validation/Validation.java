/**
 * Copyright (c) 2013, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *   Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 **/
package edu.berkeley.path.model_objects.validation;

import edu.berkeley.path.model_objects.scenario.Scenario;
import edu.berkeley.path.model_objects.network.Network;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsError;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.compiler.PackageBuilderErrors;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.io.*;

/**
 * Validate Scenario Model Object.  This class has utility methods to validate
 * the based on the following criteria:
 * <ul>
 * <li>Validate Serialized (XML) model object against XSD schema</li>
 * <li>Validate Model Object based on Database Schema restrictions (ie. foreign
 * key constraints)</li>
 * <li>Validate specific model object using Drools rule engine based on
 * application context.</li>
 * </ul>
 *
 * @author mnjuhn
 */
public class Validation {

  public final String schemaFileName = "scenario.xsd";
  public final String rulesFilePath = "/edu/berkeley/path/model_objects/scenario/";

  /**
   * Validation context. The validation class will validate accordingly based on it's given context.
   */
  public static enum ValidationContext {
    /**
     * Validate Object to Database Schema (ie. check foreign key constraints
     */
    DATABASE,
    /**
     * Validation for Common Sense validation rules
     */
    COMMON,
    /**
     * Runnable for Framework, includes common rules
     */
    FRAMEWORK
  }

  /**
   * Serialization context. The validation class will validate accordingly based on it's given context.
   */
  public static enum SerializationContext {
    /**
     * Validate XML serialized representation of object
     */
    XML,
    /**
     * Validate JON serialized representation of object
     */
    JSON
  }

  /**
   *
   */
  public static enum ObjectType {
    SCENARIO,
    NETWORK
    // TODO: Add rest of objects to validate against
  }

  /**
   * Internal helper function to get appropriate rules file based on
   * validation context and framework.
   *
   * @param context   validation context
   * @param objType   Name of Object Type
   * @return Rules file
   */
  private Reader getRulesFile(ValidationContext context, ObjectType objType)
      throws IOException {
    String ruleFile = this.rulesFilePath + objType.name().toLowerCase() + "_" +
        context.name().toLowerCase() + ".drl";
    InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
    return new InputStreamReader(resourceAsStream);

  }

  /**
   * Internal helper function to check for Drool package errors.
   *
   * @param packageBuilder drools package containing all loaded rules files
   * @throws IllegalArgumentException if errors are found
   */
  private void checkForRulePackageErrors(PackageBuilder packageBuilder) throws IllegalArgumentException {
    PackageBuilderErrors errors = packageBuilder.getErrors();

    // If there are errors in the rules file(s) contruct error message to capture them all
    if (errors.getErrors().length > 0) {
      StringBuilder errorMessages = new StringBuilder();
      errorMessages.append("Drools Package Builder Errors\n");
      for (int i = 0; i < errors.getErrors().length; i++) {
        DroolsError errorMessage = errors.getErrors()[i];
        errorMessages.append(errorMessage);
        errorMessages.append("\n");
      }
      errorMessages.append("Could not parse knowledge");

      throw new IllegalArgumentException(errorMessages.toString());
    }
  }

  /**
   * Internal helper function to add packaged drool rules files to rules base.
   * A rule base is a run-time component whereby packages can be added and removed.
   * Since the Rule Base is constructed each time for the validation procedures, if the
   * Rules (ie. drl file) is changed, re-compilation should not be necessary.
   *
   * @param packageBuilder drools package containing all loaded rules files
   * @return Rule file as InputStreamReader Object
   */
  private RuleBase addRulesToWorkingMemory(PackageBuilder packageBuilder) {
    // add rules file(s) (rules package) to working memory (rule base)
    RuleBase ruleBase = RuleBaseFactory.newRuleBase();
    org.drools.rule.Package rulesPackage = packageBuilder.getPackage();
    ruleBase.addPackage(rulesPackage);

    return ruleBase;
  }

  /**
   * Add Scenario to rules file.
   *
   * @param context Validation context
   * @param obj     Scenario Object
   * @throws IOException
   * @throws DroolsParserException
   * @throws IllegalArgumentException
   */
  private WorkingMemory constructScenarioPackage(ValidationContext context, Scenario scenario)
      throws IOException, DroolsParserException, IllegalArgumentException {


    PackageBuilder packageBuilder = new PackageBuilder();
    // Add appropriate drl files based on context to package
    packageBuilder.addPackageFromDrl(getRulesFile(context, ObjectType.SCENARIO));
    packageBuilder.addPackageFromDrl(getRulesFile(context, ObjectType.NETWORK));
    checkForRulePackageErrors(packageBuilder);

    // Add rulebase from package to working memory
    RuleBase ruleBase = addRulesToWorkingMemory(packageBuilder);
    WorkingMemory workingMemory = ruleBase.newStatefulSession();

    // insert scenario object into working memory
    workingMemory.insert(scenario);
    // for each network insert it into memory
    for (Network network : scenario.getListOfNetworks()) {
      workingMemory.insert(network);
    }

    return workingMemory;
  }

  /**
   * Function to initialize drools Rules based on the context passed in.
   * Essentially loads the appropriate rule files based on run context and
   * object being evaluated.
   *
   * @param context Run context to be based upon
   * @param objName   Name of Object
   * @return Drools Working memeory for given run context
   * @throws IOException
   * @throws DroolsParserException
   * @throws IllegalArgumentException
   */
  private WorkingMemory startDrools(ValidationContext context, Object obj)
      throws IOException, DroolsParserException, IllegalArgumentException {

    WorkingMemory workingMemory = null;

    // match object name to validation object enumeration
    String className = obj.getClass().getSimpleName().toUpperCase();
    ObjectType objType = ObjectType.valueOf(className);
    // call appropriate function to put rules into memory based on object type
    switch(objType) {
      case SCENARIO :
        workingMemory = constructScenarioPackage(context, (Scenario) obj);
        break;
      default :
        throw new IllegalArgumentException("Validation not supported for " +
            obj.getClass().getName() + " object.");
    }

    return workingMemory;
  }

  /**
   * Validate given Data Access Object in context given.
   *
   * @param obj     Object to validate
   * @param objId   Id of object being validated
   * @param context context to validate object to
   */
  public ValidationResult validate(Object obj, Long objId, ValidationContext context) {

    String objName = obj.getClass().getName();
    ValidationResult result = new ValidationResult(objName, objId, context.name());

    try {
      // load drools rule base into working based on context and object
      WorkingMemory workingMemory = startDrools(context, obj);
      workingMemory.insert(result);

      int numOfRules = workingMemory.fireAllRules();
      result.setNumOfRulesFired(numOfRules);

    } catch (Exception e) {
      result.addMessage("Unable to validate " + objName + " With ID " + objId +
          ". This is most likely caused by a incorrectly defined validation rule or missing " +
          "validation file. " + e.getMessage(), ValidationMessage.Severity.ERROR);
    }

    return result;
  }

  /**
   * Validate given serialized object string to object and context given.
   *
   * @param serializedObject     Serialized Object to validate
   * @param obj                  Object being validated
   * @param context              Context to validate object to
   */
  public ValidationResult validate(String serializedObject, Object obj, SerializationContext context) {

    String error = "";
    String objName = obj.getClass().getSimpleName();
    ValidationResult result = new ValidationResult(objName, null, context.name());
    // validate serialized object to XML
    if (context == SerializationContext.XML) {
      error = validateXML(serializedObject);
    }
    // TODO: be able to validate JSON

    // If there was an error message add it to validation result
    if (error != null && error != "") {
      result.addMessage(error, ValidationMessage.Severity.ERROR);
    }
    return result;
  }

  /**
   * Validate XML file against model object schema.
   *
   * @param   xmlFile xml file to validate
   * @return  Validation Result, will be null if none exist
   */
  private String validateXML(String xml) {

    String errorMsg = "";

    // TODO: Currently only validates against scenario xsd.
    // add lookup Map to correct file based on object class name
    // Read in schema file name
    File schemaFile = new File(this.schemaFileName);
    Source xmlSourceFile = new StreamSource(new StringReader(xml));
    SchemaFactory schemaFactory =
        SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    try {
      Schema schema = schemaFactory.newSchema(schemaFile);
      Validator validator = schema.newValidator();
      validator.validate(xmlSourceFile);

    } catch (SAXException e) {
      errorMsg = "Invalid XML file: " + e.getLocalizedMessage();
    } catch (IOException e) {
      errorMsg = "Error reading XML file: " + e.getLocalizedMessage();
    }

    return errorMsg;
  }

}
