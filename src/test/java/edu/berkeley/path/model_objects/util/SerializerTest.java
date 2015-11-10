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

import edu.berkeley.path.model_objects.ModelObjectsFactory;
import org.junit.*;
import static org.junit.Assert.*;
import edu.berkeley.path.model_objects.jaxb.Node;
import edu.berkeley.path.model_objects.network.*;
import edu.berkeley.path.model_objects.scenario.Sensor;
import edu.berkeley.path.model_objects.scenario.SensorSet;
import edu.berkeley.path.model_objects.shared.Point;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

public class SerializerTest {
  edu.berkeley.path.model_objects.jaxb.Node node;
  NodeExt nodeExt;
  
  /**
   * Mock class to test marshalling and unmarshalling of Extending a model objects
   */
  public static class NodeExt extends edu.berkeley.path.model_objects.network.Node {
    private Integer testAttr;

    public Integer getTestAttr() {
      return this.testAttr;
    }

    public void setTestAttr(Integer value) {
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
    nodeExt.setTestAttr(3);
  }

  @Test
  public void testMarshaller() throws Exception {
    // Convert node object to XML
    String nodeXML = Serializer.objectToXml(node);
    
    String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<node id=\"1\"/>\n";
    
    // Convert node object to JSON
    String nodeJSON = Serializer.objectToJSON(node);
    String expectedJSON = "{\"node\":{\"@id\":\"1\"}}";
    // Compare expected with actual
    assertEquals(expectedXML, nodeXML);
    assertEquals(expectedJSON, expectedJSON);
    
  }
  
  @Test
  public void testUnMarshaller() throws Exception {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
        "<node id=\"2\"/>\n";
    // unmarshal XML into Node object
    node = Serializer.xmlToObject(xml, node.getClass(), null);
    assertEquals(2, node.getId());

    String json = "{\"node\":{\"@id\":\"3\"}}";
    // unmarshal JSON into Node object
    node = Serializer.jsonToObject(json, node.getClass(), null);
    assertEquals(3, node.getId());
    
  }

  @Test
  public void testBadlyFormattedXMLUnMarshaller() throws Exception {
      String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<node name=\"test\" name=\"test\" id=\"2\"/>\n";
      // unmarshal XML into Node object
      try {
        node = Serializer.xmlToObject(xml, node.getClass(), null);
      }catch(Exception e){
        String expM = "Unable to convert XML to edu.berkeley.path.model_objects.jaxb.Node Model Object. ";
        expM += "Attribute \"name\" was already specified for element \"node\".";
        assertEquals(expM, e.getMessage());
      }

  }

  @Test
  public void testMarshallerExtendedApp() throws Exception {
    // Convert nodeExt object to XML
    String nodeExtXML = Serializer.objectToXml(nodeExt);
    String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
        "<node id=\"1\"/>\n";
    
    // Convert nodeExt object to JSON
    String nodeExtJSON = Serializer.objectToJSON(nodeExt);
    String expectedJSON = "{\"node\":{\"id\":\"1\"}}";
    
    // Compare expected with actual results
    assertEquals(expectedXML, nodeExtXML);
    assertEquals(expectedJSON, nodeExtJSON);
  }
  
  @Test
  public void testSensorSetMarshall() throws Exception {
	  	SensorSet set = new SensorSet();
		
	  	Sensor sensor = new Sensor();

	  	ArrayList<Sensor> sensors = new ArrayList<Sensor>();
		
	  	Long id = 2L;
		Double latitude = 37.0;
		Double longitude = -122.0;
		Integer laneCount = 2;
		sensor.setSensorIdOriginal(id + "");
		Point p = new Point();
		p.setLatitude(latitude);
		p.setLongitude(longitude);
		sensor.setDisplayPosition(p);
		sensor.setLaneNumber(laneCount);
		sensor.setLinkTypeOriginal("ML ");
		// set sensor type to default of loop since we are bringing in PeMS data
		sensor.setSensorType(1, "LOOP", "");
		sensors.add(sensor);
		set.setSensors(sensors);
		String xml =  Serializer.objectToXml(set);
		assertNotNull(xml);
  }
  
  @Test
  public void testUnMarshallerExtendedApp() throws Exception {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
        "<node id=\"2\"/>\n";
    // unmarshal XML into Node object
    nodeExt = Serializer.xmlToObject(xml, nodeExt.getClass(), null);
    assertEquals(2, nodeExt.getId());
    
    String json = "{\"node\":{\"@id\":\"3\"}}";
    // unmarshal JSON into Node object
    nodeExt = Serializer.jsonToObject(json, nodeExt.getClass(), null);
    assertEquals(3, nodeExt.getId());
  }

	@Test
	public void testUnMarshallerNetwork () throws Exception {
		String inputXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
				"   <network project_id=\"1\">\n" +
				"      <description/>\n" +
				"      <position>\n" +
				"        <point lat=\"37.8705\" lng=\"-122.29919999999998\" elevation=\"0\"/>\n" +
				"      </position>\n" +
				"      <NodeList>\n" +
				"        <node id=\"9999\">\n" +
				"          <position>\n" +
				"            <point lat=\"37.87119153073403\" lng=\"-122.29870384788512\" elevation=\"NaN\"/>\n" +
				"          </position>\n" +
                "          <node_type id=\"6\" name=\"terminal\" />" +
				"        </node>\n" +
				"        <node id=\"10000\">\n" +
				"          <position>\n" +
				"            <point lat=\"37.8617218741896\" lng=\"-122.29564635581971\" elevation=\"0\"/>\n" +
				"          </position>\n" +
				"        </node>\n" +
				"        <node id=\"10001\">\n" +
				"          <position>\n" +
				"            <point lat=\"37.84636611153011\" lng=\"-122.29136822090146\" elevation=\"0\"/>\n" +
				"          </position>\n" +
                "          <node_type id=\"6\" name=\"terminal\" />" +
				"        </node>\n" +
				"        <node id=\"10002\">\n" +
				"          <position>\n" +
				"            <point lat=\"37.868030000000005\" lng=\"-122.29771000000001\" elevation=\"0\"/>\n" +
				"          </position>\n" +
				"        </node>\n" +
				"      </NodeList>\n" +
				"      <LinkList>\n" +
				"        <link lanes=\"1\" lane_offset=\"0\" length=\"1916.4512171408285\" id=\"9999\" in_sync=\"true\">\n" +
				"          <begin node_id=\"10001\"/>\n" +
				"          <end node_id=\"10000\"/>\n" +
                "          <link_type id=\"15\" name=\"Source\" />" +
                "        </link>\n" +
				"        <link lanes=\"1\" lane_offset=\"0\" length=\"724.8395315693305\" id=\"10000\" source_link_id=\"22\" detail_level=\"3\" in_sync=\"true\">\n" +
				"          <begin node_id=\"10000\"/>\n" +
				"          <end node_id=\"10002\"/>\n" +
                "          <link_type id=\"1\" name=\"Freeway\" />" +
                "        </link>\n" +
				"        <link lanes=\"1\" lane_offset=\"0\" length=\"366.7504885192787\" id=\"10001\" in_sync=\"true\">\n" +
				"          <begin node_id=\"10002\"/>\n" +
				"          <end node_id=\"9999\"/>\n" +
                "          <link_type id=\"16\" name=\"Sink\" />" +
				"        </link>\n" +
				"      </LinkList>\n" +
				"    </network>";


		// unmarshal XML into Network object
		Network network = new Network();
		network = Serializer.xmlToObject(inputXML, network.getClass(), new ModelObjectsFactory());
        try {
            network.setInputOutputLinks();
            network.populate();
            // Check a substantial part of the network object that was deserialized
            // Network properties
            assertEquals(1, network.getProjectId());
            assertEquals(37.8705, network.getBoundingPolygon().get(0).getLat(), 0.0001);

            // Node properties
            assertEquals(4, network.getListOfNodes().size());

            assertEquals(9999, network.getListOfNodes().get(0).getId());
            assertEquals(-122.298704, network.getListOfNodes().get(0).getPoint().getLongitude(), 0.000001);
            assertEquals(6, network.getListOfNodes().get(0).getNodeType().getId());

            assertEquals(10000, network.getListOfNodes().get(1).getId());
            assertEquals(-122.295646, network.getListOfNodes().get(1).getPoint().getLongitude(), 0.000001);

            assertEquals(10001, network.getListOfNodes().get(2).getId());
            assertEquals(-122.291368, network.getListOfNodes().get(2).getPoint().getLongitude(), 0.000001);

            assertEquals(10002, network.getListOfNodes().get(3).getId());
            assertEquals(-122.297710, network.getListOfNodes().get(3).getPoint().getLongitude(), 0.000001);

            // Link properties
            assertEquals(3, network.getListOfLinks().size());

            assertEquals(9999, network.getListOfLinks().get(0).getId());
            assertEquals(10000, network.getListOfLinks().get(0).getEndNodeId());
            assertEquals(10001, network.getListOfLinks().get(0).getBeginNodeId());
            assertEquals(1916.45121, network.getListOfLinks().get(0).getLength(), 0.00001);
            assertEquals(1.0, network.getListOfLinks().get(0).getLanes(), 0.001);
            assertEquals(0.0, network.getListOfLinks().get(0).getLaneOffset(),0.001);
            assertEquals(15, network.getListOfLinks().get(0).getLinkType().getId());

            assertEquals(10000, network.getListOfLinks().get(1).getId());
            assertEquals(10002, network.getListOfLinks().get(1).getEndNodeId());
            assertEquals(10000, network.getListOfLinks().get(1).getBeginNodeId());
            assertEquals(724.83953, network.getListOfLinks().get(1).getLength(), 0.00001);
            assertEquals(22, network.getListOfLinks().get(1).getSourceLinkId().longValue());
            assertEquals(3, network.getListOfLinks().get(1).getDetailLevel().longValue());
            assertEquals(1.0, network.getListOfLinks().get(1).getLanes(), 0.001);
            assertEquals(0.0, network.getListOfLinks().get(1).getLaneOffset(),0.001);
            assertEquals(1, network.getListOfLinks().get(1).getLinkType().getId());

            assertEquals(10001, network.getListOfLinks().get(2).getId());
            assertEquals(9999, network.getListOfLinks().get(2).getEndNodeId());
            assertEquals(10002, network.getListOfLinks().get(2).getBeginNodeId());
            assertEquals(366.75048, network.getListOfLinks().get(2).getLength(), 0.00001);
            assertEquals(1.0, network.getListOfLinks().get(2).getLanes(), 0.01);
            assertEquals(16, network.getListOfLinks().get(2).getLinkType().getId());

        } catch (Exception e) {
            fail(e.getMessage());
        }

//		String afterXML = Serializer.objectToXml(network);
//
//		// Compare XML string results stripped of all whitespace
//		assertEquals(expectedXML.replaceAll("\\s",""), afterXML.replaceAll("\\s",""));
	}

  @Test
  public void testUnMarshallSensor() throws Exception {

    try {
    String beforeXML=
        "<SensorSet id=\"767\" project_id=\"1\" name=\"test Sensor Set\" description=\"test Sensor Set\" mod_stamp=\"21-NOV-2013 12:36:15.930437\" lockedForEdit=\"false\" lockedForHistory=\"false\"><sensor id=\"4843\" link_id=\"0\" sensor_id_original=\"400060\" link_type_original=\"ML\" data_feed_id=\"0\" lane_number=\"5\" link_offset=\"0\" mod_stamp=\"21-NOV-2013 12:36:15.967107\" health_status=\"0\"><display_position><point lat=\"37.870977\" lng=\"-122.305289\" elevation=\"0\"/></display_position><parameters/><sensor_type id=\"1\" name=\"Loop\" description=\"\"/></sensor><sensor id=\"4844\" link_id=\"0\" sensor_id_original=\"400612\" link_type_original=\"ML\" data_feed_id=\"0\" lane_number=\"5\" link_offset=\"0\" mod_stamp=\"21-NOV-2013 12:36:15.970105\" health_status=\"0\"><display_position><point lat=\"37.871027\" lng=\"-122.304954\" elevation=\"0\"/></display_position><parameters/><sensor_type id=\"1\" name=\"Loop\" description=\"\"/></sensor><sensor id=\"4842\" link_id=\"0\" sensor_id_original=\"400728\" link_type_original=\"ML\" data_feed_id=\"0\" lane_number=\"5\" link_offset=\"0\" mod_stamp=\"21-NOV-2013 12:36:15.964024\" health_status=\"0\"><display_position><point lat=\"37.866567\" lng=\"-122.303586\" elevation=\"0\"/></display_position><parameters/><sensor_type id=\"1\" name=\"Loop\" description=\"\"/></sensor><sensor id=\"4841\" link_id=\"0\" sensor_id_original=\"400176\" link_type_original=\"ML\" data_feed_id=\"0\" lane_number=\"5\" link_offset=\"0\" mod_stamp=\"21-NOV-2013 12:36:15.951450\" health_status=\"0\"><display_position><point lat=\"37.866548\" lng=\"-122.30386\" elevation=\"0\"/></display_position><parameters/><sensor_type id=\"1\" name=\"Loop\" description=\"\"/>" +
            "</sensor><sensor crudFlag=\"CREATE\" id=\"1\"><display_position><point lat=\"37.87099149875574\" lng=\"-122.29731559753418\" elevation=\"0\"/></display_position><parameters/><sensor_type id=\"1\" name=\"Loop\" description=\"\"/></sensor></SensorSet>";

    // unmarshal XML into Sensor object
    SensorSet sensorSet = new SensorSet();
    sensorSet = Serializer.xmlToObject(beforeXML, sensorSet.getClass(), new ModelObjectsFactory());
    String afterXML = Serializer.objectToXml(sensorSet);


    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }

  }
}