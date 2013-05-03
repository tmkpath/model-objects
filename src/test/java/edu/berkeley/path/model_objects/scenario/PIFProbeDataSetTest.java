package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PIFProbeDataSetTest {
	private PIFProbeDataSet set;
	
	@Before
	public void setUp(){
		set = new PIFProbeDataSet();
		ArrayList<PIFProbeData> list = new ArrayList<PIFProbeData>();
		list.add(new PIFProbeData());
		list.add(new PIFProbeData());
		set.setPIFProbeData(list);
		
		set.setPIFProbeData(new PIFProbeData());
		set.setPIFProbeData(new PIFProbeData());
		set.setLockedForEdit(true);
		set.setLockedForHistory(true);
	}
	
	@Test
	public void testGetters(){
		assertEquals(4, set.getPIFProbeData().size());
		assertEquals(true, set.isLockedForEdit());
		assertEquals(true, set.isLockedForHistory());
	}
}
