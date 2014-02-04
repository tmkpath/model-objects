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
package edu.berkeley.path.model_objects.util;

import edu.berkeley.path.model_objects.MOException;
import edu.berkeley.path.model_objects.scenario.Scenario;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import core.Monitor;
import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsError;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.compiler.PackageBuilderErrors;
import org.drools.rule.*;
import org.drools.rule.Package;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

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

  /**
   * Validation context. The validation class will validate accordingly based on it's given context.
   */
  public static enum Context {
    /**
     * Validate XML serialized representation of object
     */
    XML,
    /**
     * Validate JON serialized representation of object
     */
    JSON,
    /**
     * Validate Object to Database Schema (ie. check foreign key constraints
     */
    DATABASE,
    /**
     * Validation for Common Sense validation rules
     */
    COMMON,
    /**
     * Runnable
     */
    RUNNABLE
  }

  private static final Map<Context, String> contextFileMap;
  static {
    Map<Context, String> cMap = new HashMap<Context, String>();
    cMap.put(Context.XML, "");
    cMap.put(Context.JSON, "");
    cMap.put(Context.DATABASE, "/edu/berkeley/path/model_objects/scenario/database.drl");
    cMap.put(Context.COMMON, "/edu/berkeley/path/model_objects/scenario/common.drl");
    contextFileMap = Collections.unmodifiableMap(cMap);
  }

  private Reader getRuleFileAsReader(String ruleFile) {
    InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

    return new InputStreamReader(resourceAsStream);
  }

  private RuleBase addRulesToWorkingMemory(PackageBuilder packageBuilder) {
    RuleBase ruleBase = RuleBaseFactory.newRuleBase();
    org.drools.rule.Package rulesPackage = packageBuilder.getPackage();
    ruleBase.addPackage(rulesPackage);

    return ruleBase;
  }

  private void assertNoRuleErrors(PackageBuilder packageBuilder) {
    PackageBuilderErrors errors = packageBuilder.getErrors();

    if (errors.getErrors().length > 0) {
      StringBuilder errorMessages = new StringBuilder();
      errorMessages.append("Found errors in package builder\n");
      for (int i = 0; i < errors.getErrors().length; i++) {
        DroolsError errorMessage = errors.getErrors()[i];
        errorMessages.append(errorMessage);
        errorMessages.append("\n");
      }
      errorMessages.append("Could not parse knowledge");

      throw new IllegalArgumentException(errorMessages.toString());
    }
  }

  private RuleBase initialiseDrools(Context context) throws IOException, DroolsParserException {
    PackageBuilder packageBuilder = new PackageBuilder();

    String ruleFile = this.contextFileMap.get(context);
    Reader reader = getRuleFileAsReader(ruleFile);
    packageBuilder.addPackageFromDrl(reader);

    assertNoRuleErrors(packageBuilder);
    return addRulesToWorkingMemory(packageBuilder);
  }

  /**
   * Validate given Data Access Object in context given
   *
   * @param obj     Object to validate
   * @param objId   Id of object being validated
   * @param context context to validate object to
   */
  public ValidationResult validate(Object obj, Long objId, Context context) throws MOException {

    String objName = obj.getClass().getName();
    ValidationResult result = new ValidationResult(objName, objId, context.name());
    // get rules file based on context

    try {
      RuleBase ruleBase = initialiseDrools(context);
      WorkingMemory workingMemory = ruleBase.newStatefulSession();

      workingMemory.insert(obj);
      workingMemory.insert(result);
      int numOfRules = workingMemory.fireAllRules();
      result.setNumOfRulesFired(numOfRules);

    } catch (Exception e) {
      throw new MOException(e, "Error trying to validate " + objName + " With ID " + objId );
    }

    return result;
  }

  /**
   * Validate given serialized object string to object and context given
   *
   * @param serializedObject     Serialized Object to validate
   * @param obj                  Object being validated
   * @param context              Context to validate object to
   */
  public ValidationResult validate(String serializedObject, Object obj, Context context) throws MOException {

    String error = "";
    String objName = obj.getClass().getName();
    ValidationResult result = new ValidationResult(objName, null, context.name());
    // validate serialized object to XML
    if (context == Context.XML) {
      error = validateXML(serializedObject);
    }
    // TODO: be able to validate JSON

    // If there was an error message add it to validaiton result
    if (error != null && error != "") {
      result.addMessage(error, ValidationMessage.Severity.ERROR);
    }
    return result;
  }

  /**
   * Validate XML file against model object schema
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
