package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SplitRatioProfileTest {
	
	SplitRatioProfile profile;
	
	@Before
	public void setUp(){
		profile = new SplitRatioProfile();
		profile.setNodeId(1);
		profile.setStartTime(3600);
		profile.setDt(300);
		profile.setDestinationNetworkId(3);
		profile.setModStamp("1970-01-01 00:00:00");
		
		List<Splitratio> ratios = new ArrayList<Splitratio>();
		
		ratios.add(createSplitRatio(1,2,3,0.5,0));
		ratios.add(createSplitRatio(1,2,3,0.1,1));
		ratios.add(createSplitRatio(1,2,3,1,2));
		ratios.add(createSplitRatio(1,2,3,0.6,3));
		profile.setListOfSplitRatios(ratios);
	}
	
	public static Splitratio createSplitRatio(int link_in, int link_out, int veh_id, double ratio, int order) {
		Splitratio r = new Splitratio();
		r.setLinkIn(link_in);
		r.setLinkOut(link_out);
		r.setVehTypeId(veh_id);
		r.setContent(ratio + "");
		r.setRatioOrder(order);	
		return r;
		
	}

	@Test
	public void testGetters(){
		assertEquals(1,profile.getNodeId());
		assertEquals(3600,profile.getStartTime(), 0.0);
		assertEquals(300,profile.getDt().doubleValue(), 0.0);
		assertEquals(3, profile.getDestinationNetworkId().longValue());
		assertEquals("1970-01-01 00:00:00", profile.getModStamp());
		assertEquals(4, profile.getListOfSplitratios().size());
	}
	
	@Test
	public void testClone(){
		SplitRatioProfile copy = profile.clone();
		assertTrue(copy != profile);
		assertEquals(copy.getNodeId(), 1);
	}
	
	@Test
	public void testGetSplitRatioNoTime(){
		Double[] ratios = profile.getSplitRatio(1,2,3);
		assertEquals(4,ratios.length);
	}

	@Test
	public void testGetSplitRatioStringTime(){
		double ratio = profile.getSplitRatio(1,2,3,"00:00:00");
		assertEquals(ratio, 0.5, 0.0);

		double ratio2 = profile.getSplitRatio(1,2,3,"00:05:00");
		assertEquals(ratio2, 0.1, 0.0);

		double ratio3 = profile.getSplitRatio(1,2,3,"00:04:00");
		assertEquals(ratio3, 0.5, 0.0);

		double ratio4 = profile.getSplitRatio(1,2,3,"00:10:00");
		assertEquals(ratio4, 1, 0.0);
	}
	
	@Test
	public void testGetSplitRatioOffset(){
		double ratio = profile.getSplitRatio(1,2,3,0);
		assertEquals(ratio, 0.5, 0.0);

		double ratio2 = profile.getSplitRatio(1,2,3, 300);
		assertEquals(ratio2, 0.1, 0.0);

		double ratio3 = profile.getSplitRatio(1,2,3, 400);
		assertEquals(ratio3, 0.1, 0.0);

		double ratio4 = profile.getSplitRatio(1,2,3, 600);
		assertEquals(ratio4, 1, 0.0);
	}

	
}
