/**
 * Copyright (c) 2012, Regents of the University of California
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

import java.io.StringReader;
import java.io.StringWriter;

import core.Exceptions;
import core.Monitor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;

import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamReader;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


/**
 * Class to unmarshall and marshall JAXB base model object classes.
 * Supports both XML and JSON
 *
 * @author mnjuhn
 */
@SuppressWarnings("restriction")
public class Serializer {
  
  /**
   * Method to convert/unmarshall XML to JAXB model object
   * 
   * @param xml String representation of JAXB XML
   * @param jaxbClass JAXB model object class to create from XML
   * @return  JAXB class to create from XML
   */
  public static <T> T xmlToObject(String xml, Class<T>  jaxbClass) {
    StringBuffer xmlStr = new StringBuffer(xml);
    // Generic Object to be created as jaxbClass
    Object o = null;
    try {
      // Create JAXB context object which tell the unmarshaller which JAXB class to create
      // is expected to be created
      JAXBContext context = JAXBContext.newInstance(jaxbClass);
      Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
      o = jaxbUnmarshaller.unmarshal( new StreamSource( new StringReader(xmlStr.toString()) ) );
    } 
    catch (JAXBException exc) {
      Monitor.err("Error unmarshalling object from XML");
    }
    // Cast from generic object to specified JAXB Class
    return jaxbClass.cast(o);
  }
 
  /**
   * Method to serialize/marshall JAXB base model object class to XML
   * 
   * @param jaxbObject JAXB model object class to serialize
   * @return  XML generated from JAXB model object
   */
  public static <T> String objectToXml(Object  jaxbObject) {
    String xml = null;
    StringWriter result = new StringWriter();
    try {
      // Create JAXB context object which tell the marshaller which JAXB class was specified
      // to be converted from XML
      JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
      Marshaller jaxbMarshaller = context.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(jaxbObject, result);    
      // get XML string
      xml = result.toString();
    } 
    catch (JAXBException exc) {
      Monitor.err("Error marshalling object to XML");
    }
    return xml;
  }
  
  /**
   * Method to convert/unmarshall JSON to JAXB model object
   * 
   * @param json String representation of JAXB JSON
   * @param jaxbClass JAXB model object class to create from JSON
   * @return  JAXB class to create from JSON
   */
  public static <T> T jsonToObject(String json, Class<T>  jaxbClass) {    
    // Generic object to created as a JAXB class
    Object o = null;
    try {
      JSONObject jsonStr = new JSONObject(json);
      // Create JAXB context object which tell the unmarshaller which JAXB class to create
      // is expected to be created
      JAXBContext context = JAXBContext.newInstance(jaxbClass);
      org.codehaus.jettison.mapped.Configuration config = new org.codehaus.jettison.mapped.Configuration();
      XMLStreamReader xmlsr = new MappedXMLStreamReader(jsonStr, new MappedNamespaceConvention(config));
      Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
      o = jaxbUnmarshaller.unmarshal(xmlsr);
    } 
    catch (JAXBException exc) {
      Monitor.err("Error unmarshalling object from JSON");
    }
    catch (JSONException exc) {
      Monitor.err("Error Reading in JSON");
    }
    catch (XMLStreamException exc) {
      Monitor.err("Error Binding JSON to JAXB XML Stream");
    }
    // Cast from generic object to specified JAXB Class
    return jaxbClass.cast( o );
  }
  
  /**
   * Method to serialize/marshall JAXB base model object class to JSON
   * 
   * @param jaxbObject JAXB model object class to serialize
   * @return  JSON generated from JAXB model object
   */
  public static <T> String objectToJSON(Object  jaxbObject) {
    String json = null;
    StringWriter result = new StringWriter();
    try {
      // Create JAXB context object which tell the marshaller which JAXB class was specified
      // to be converted from JSON
      JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
      org.codehaus.jettison.mapped.Configuration config = new org.codehaus.jettison.mapped.Configuration();
      XMLStreamWriter xmlsw = new MappedXMLStreamWriter(new MappedNamespaceConvention(config), result);
      Marshaller jaxbMarshaller = context.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(jaxbObject, xmlsw);    
      // get XML string
      json = result.toString();
    } 
    catch (JAXBException exc) {
      Monitor.err("Error marshalling object to JSON");
    }
    return json;
  }
  
}
