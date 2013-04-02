/**
 * Copyright (c) 2012 The Regents of the University of California.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

package edu.berkeley.path.model_objects.util;

import org.junit.*;
import static org.junit.Assert.*;
import edu.berkeley.path.model_objects.jaxb.Node;
import edu.berkeley.path.model_objects.network.*;
import core.*;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

public class SerializerTest {
  edu.berkeley.path.model_objects.jaxb.Node node;
  NodeExt nodeExt;
  
  /**
   * Mock class to test marshalling and unmarshalling of Extending a model objects
   */
  @XmlRootElement(name = "node")
  public static class NodeExt extends edu.berkeley.path.model_objects.network.Node {
    private int testAttr;
    
    public int getTestAttr() {
      return this.testAttr;
    }
    
    public void setTestAttr(int value) {
      this.testAttr = value;
    }
  }
  
  @Before
  public void setup() {
    // Model Object to test JAXB to test JAXB unmarshalling and marshalling fucntionality in Serializer class
    node = new Node();
    node.setId(1);
    // Extended Model Object to test JAXB unmarshalling and marshalling fucntionality in Serializer class
    nodeExt = new NodeExt();
    nodeExt.setId(1);
    nodeExt.setTestAttr(2);
  }

  @Test
  public void testMarshaller() {
    // Convert node object to XML
    String nodeXML = Serializer.objectToXml(node);
    
    String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<node id=\"1\"/>\n";
    
    // Convert node object to JSON
    String nodeJSON = Serializer.objectToJSON(node);
    String expectedJSON = "{\"node\":{\"@id\":\"1\"}}";
    // Compare expected with actual
    assertEquals(nodeXML, expectedXML);
    assertEquals(nodeJSON, expectedJSON);
    
  }
  
  @Test
  public void testUnMarshaller() {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
        "<node id=\"2\"/>\n";
    // unmarshal XML into Node object
    node = Serializer.xmlToObject(xml, node.getClass());
    assertEquals(2, node.getId());
    
    String json = "{\"node\":{\"@id\":\"3\"}}";
    // unmarshal JSON into Node object
    node = Serializer.jsonToObject(json, node.getClass());
    assertEquals(3, node.getId());
    
  }
  
  @Test
  public void testUnMarshallerExtenedApp () {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
        "<node id=\"2\"/>\n";
    // unmarshal XML into Node object
    nodeExt = Serializer.xmlToObject(xml, nodeExt.getClass());
    assertEquals(2, nodeExt.getId());
    
    String json = "{\"node\":{\"@id\":\"3\"}}";
    // unmarshal JSON into Node object
    nodeExt = Serializer.jsonToObject(json, nodeExt.getClass());
    assertEquals(3, nodeExt.getId());
  }
}