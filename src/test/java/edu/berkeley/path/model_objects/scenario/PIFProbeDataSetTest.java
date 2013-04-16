package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PIFProbeDataSetTest {
	PIFProbeDataSet set;
	
	@Before
	public void setUp(){
		set = new PIFProbeDataSet();
		set.setPIFProbeData(new PIFProbeData());
		set.setPIFProbeData(new PIFProbeData());
	}
	
	@Test
	public void testGetters(){
		assertEquals(2, set.getPIFProbeData().size());
	}
}
