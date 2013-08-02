package edu.berkeley.path.model_objects.measurements;

import static org.junit.Assert.assertEquals;

import edu.berkeley.path.model_objects.measurements.PIFProbeData;
import org.junit.Before;
import org.junit.Test;

import edu.berkeley.path.model_objects.shared.DateTime;

public class PIFProbeDataTest {
	PIFProbeData data;
	
	@Before
	public void setUp(){
		data = new PIFProbeData();
		data.setTimestamp(new DateTime(100));
		data.setNetworkId(1);
		data.setLinkId(2);
		data.setRunId(3);
		data.setSpeed(65);
		data.setProbability(0.1);
	}
	
	@Test
	public void testGetters(){
		assertEquals(100, data.getTimestamp().getMilliseconds());
		assertEquals(1, data.getNetworkId());
		assertEquals(2,data.getLinkId());
		assertEquals(3, data.getRunId());
		assertEquals(65, data.getSpeed(),0.0);
		assertEquals(0.1, data.getProbability(), 0.0);
	}
}
