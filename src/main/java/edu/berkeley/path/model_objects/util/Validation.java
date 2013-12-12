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

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import core.Monitor;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

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
   * Validate XML file against model object schema
   *
   * @param   fileName xml file to validate
   * @return  List of errors, will be null if none exist
   */
  public String validateXML(File xmlFile) {
    String errorMsg = "";
    File schemaFile = new File(this.schemaFileName);
    Source xmlSourceFile = new StreamSource(xmlFile);
    SchemaFactory schemaFactory =
        SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    try {
      Schema schema = schemaFactory.newSchema(schemaFile);
      Validator validator = schema.newValidator();
      validator.validate(xmlSourceFile);
      Monitor.out(xmlFile.getName() + " is valid");
      errorMsg = "Valid";
    } catch (SAXException e) {
      Monitor.out(xmlFile.getName() + " is NOT valid");
      errorMsg = "Invalid XML file: " + e.getLocalizedMessage();
    } catch (IOException e) {
      Monitor.out("Error Reading " + xmlFile.getName());
      errorMsg = "Error reading XML file: " + e.getLocalizedMessage();
    }

    return errorMsg;
  }

}
