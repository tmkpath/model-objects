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

import edu.berkeley.path.model_objects.jaxb.ObjectFactory;
import java.io.StringReader;
import java.io.StringWriter;

import edu.berkeley.path.model_objects.MOException;
import core.Exceptions;
import core.Monitor;

import javax.xml.bind.*;
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
   * Method to convert/unmarshall XML to JAXB model object.
   * 
   * Note: XML must represent what is in the base JAXB base layer (ie. what
   * is defined in the XSD schema ).  Additional attributes such as those
   * added in the extended classes will cause an error and a null object will 
   * returned.
   * 
   * @param xml String representation of JAXB XML
   * @param jaxbClass JAXB model object class to create from XML
	 * @param factory Optional Model Object Factory of extended Model Objects to instantiate
	 *
   * @return  JAXB or JAXB extended object created from XML, depending on object factory passed in
   */
  public static <T> T xmlToObject(String xml, Class<T> jaxbClass, ObjectFactory factory) throws MOException {
    StringBuffer xmlStr = new StringBuffer(xml);
    // Generic Object to be created as jaxbClass
    Object obj = null;
    try {
      // Create JAXB context object which tell the unmarshaller which JAXB class to create
      // is expected to be created
      JAXBContext context = JAXBContext.newInstance(jaxbClass);
      Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
			// If Factory is passed in can create extended objects from serialization
			if (factory != null) {
				// This is ugly but necessary since JAXB changed the property name across versions
				try {
					jaxbUnmarshaller.setProperty("com.sun.xml.bind.ObjectFactory", factory);
				}
				catch (PropertyException exc) {
					jaxbUnmarshaller.setProperty("com.sun.xml.internal.bind.ObjectFactory", factory);
				}
			}
      obj = jaxbUnmarshaller.unmarshal( new StreamSource( new StringReader(xmlStr.toString()) ), jaxbClass ).getValue();
    }
    catch (JAXBException exc) {
      Monitor.err("Error unmarshalling object " + jaxbClass.getName() + " from XML");
      throw new MOException(exc, "Unable to convert XML to " + jaxbClass.getName() + " Model Object. "
          + exc.getMessage());
    }
    // catch all other exceptions since JAXB unmarshaller can throw unchecked exceptions, for
    // example
    catch (Exception exc) {
      Monitor.err("Error unmarshalling object " + jaxbClass.getName() + " from XML");
      throw new MOException(exc, "Unable to convert XML to " + jaxbClass.getName() + " Model Object. "
          + exc.getMessage());
    }

    // Cast from generic object to specified JAXB Class
    return jaxbClass.cast(obj);
  }
 
  /**
   * Method to serialize/marshall JAXB base model object class to XML
   * 
   * Note: The XML returned only contains attributes in JAXB base layer ( those 
   * defined in the XSD schema ).  Additional attributes defined in the extended layer
   * are ignored.
   * 
   * @param jaxbObject JAXB model object or extended class to serialize
   * @return  XML generated from JAXB model object
   */
  public static <T> String objectToXml(Object jaxbObject) throws MOException {
    String xml = null;
    StringWriter result = new StringWriter();
    try {
      // Create JAXB context object which tell the marshaller which JAXB class was specified
      // to be converted from XML
      JAXBContext context = JAXBContext.newInstance("edu.berkeley.path.model_objects.jaxb");
      Marshaller jaxbMarshaller = context.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(jaxbObject, result);    
      // get XML string
      xml = result.toString();
    } 
    catch (JAXBException exc) {
      Monitor.err("Error marshalling object " + jaxbObject.getClass().getName() + " to XML");
			throw new MOException(exc, "Unable to convert XML to " + jaxbObject.getClass().getName() + " Model Object. "
          + exc.getMessage());
    }
    return xml;
  }
  
  /**
   * Method to convert/unmarshall JSON to JAXB model object.
   * 
   * Note: JSON must represent what is in the base JAXB base layer (ie. what
   * is defined in the XSD schema ).  Additional attributes such as those
   * added in the extended classes will cause an error and a null object will 
   * returned.
   * 
   * @param json String representation of JAXB JSON
   * @param jaxbClass JAXB model object class to create from JSON
	 * @param factory Optional Model Object Factory of extended Model Objects to instantiate
	 *
   * @return  JAXB or JAXB extended object created from JSON
   */
  public static <T> T jsonToObject(String json, Class<T> jaxbClass, ObjectFactory factory) throws MOException {
    // Generic object to created as a JAXB class
    Object obj = null;
    try {
      JSONObject jsonStr = new JSONObject(json);
      // Create JAXB context object which tell the unmarshaller which JAXB class to create
      // is expected to be created
      JAXBContext context = JAXBContext.newInstance(jaxbClass);

			org.codehaus.jettison.mapped.Configuration config = new org.codehaus.jettison.mapped.Configuration();
			XMLStreamReader xmlsr = new MappedXMLStreamReader(jsonStr, new MappedNamespaceConvention(config));
			Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

			// If Factory is passed in can create extended objects from serialization
			if (factory != null) {
				// This is ugly but necessary since JAXB changed the property name across versions
				try {
					jaxbUnmarshaller.setProperty("com.sun.xml.bind.ObjectFactory", factory);
				}
				catch (PropertyException exc) {
					jaxbUnmarshaller.setProperty("com.sun.xml.internal.bind.ObjectFactory", factory);
				}
			}

      obj = jaxbUnmarshaller.unmarshal(xmlsr, jaxbClass ).getValue();
    } 
    catch (JAXBException exc) {
      Monitor.err("Error unmarshalling object " + jaxbClass.getName() + " from JSON");
			throw new MOException(exc, "Unable to convert JSON to " + jaxbClass.getName() + " Model Object. "
          + exc.getMessage());
    }
    catch (JSONException exc) {
      Monitor.err("Error Reading in JSON for " + jaxbClass.getName() );
			throw new MOException(exc, "Unable to convert JSON to " + jaxbClass.getName() + " Model Object. "
          + exc.getMessage());
    }
    catch (XMLStreamException exc) {
      Monitor.err("Error Binding JSON to JAXB XML Stream " + jaxbClass.getName() );
			throw new MOException(exc, "Unable to convert JSON to " + jaxbClass.getName() + " Model Object."
          + exc.getMessage());
    }
    // catch all other exceptions since JAXB unmarshaller can throw unchecked exceptions, for
    // example
    catch (Exception exc) {
      Monitor.err("Error unmarshalling object " + jaxbClass.getName() + " from SJON");
      throw new MOException(exc, "Unable to convert JSON to " + jaxbClass.getName() + " Model Object. "
          + exc.getMessage());
    }
    // Cast from generic object to specified JAXB Class
    return jaxbClass.cast( obj );
  }
  
  /**
   * Method to serialize/marshall JAXB base model object class to JSON
   * 
   * Note: The JSON returned only contains attributes in JAXB base layer ( those 
   * defined in the XSD schema ).  Additional attributes defined in the extended layer
   * are ignored.
   * 
   * @param jaxbObject JAXB model object or extended class to serialize
   * @return  JSON generated from JAXB model object
   */
  public static <T> String objectToJSON(Object jaxbObject) throws MOException {
    String json = null;
    StringWriter result = new StringWriter();
    try {
      // Create JAXB context object which tell the marshaller which JAXB class was specified
      // to be converted from JSON
      JAXBContext context = JAXBContext.newInstance("edu.berkeley.path.model_objects.jaxb");
      org.codehaus.jettison.mapped.Configuration config = new org.codehaus.jettison.mapped.Configuration();
      XMLStreamWriter xmlsw = new MappedXMLStreamWriter(new MappedNamespaceConvention(config), result);
      Marshaller jaxbMarshaller = context.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(jaxbObject, xmlsw);    
      // get XML string
      json = result.toString();
    } 
    catch (JAXBException exc) {
      Monitor.err("Error marshalling object " + jaxbObject.getClass().getName() + "to JSON ");
			throw new MOException(exc, "Unable to convert JSON to " + jaxbObject.getClass().getName() + " Model Object."
          + exc.getMessage());
    }
    return json;
  }
  
}
