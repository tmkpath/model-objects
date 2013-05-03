package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import edu.berkeley.path.model_objects.jaxb.CrudFlag;

public class SplitRatioProfileTest {
	private static final long ID = 1;
	private static final long NODE_ID = 10;  
	private static final long DEST_NETWORK_ID = 99999;
	private static final double DT = 300;
	private static final double START_TIME = 3600;
	private static final String MOD_STAMP = "01-APR-1982 23:23:12";
	
	private SplitRatioProfile profile;
	
	@Before
	public void setUp(){
		profile = new SplitRatioProfile();
		profile.setId(ID);
		profile.setNodeId(NODE_ID);
		profile.setStartTime(START_TIME);
		profile.setDt(DT);
		profile.setDestinationNetworkId(DEST_NETWORK_ID);
		profile.setCrudFlag(CrudFlag.CREATE);
		profile.setModStamp(MOD_STAMP);
		
		List<Splitratio> ratios = new ArrayList<Splitratio>();
		
		ratios.add(createSplitRatio(1,2,3,0.5,0));
		ratios.add(createSplitRatio(1,2,3,0.1,1));
		ratios.add(createSplitRatio(1,2,3,1,2));
		ratios.add(createSplitRatio(1,2,3,0.6,3));
		profile.setListOfSplitRatios(ratios);
	}
	
	private Splitratio createSplitRatio(int link_in, int link_out, int veh_id, double ratio, int order) {
		Splitratio r = new Splitratio();
		r.setLinkIn(link_in);
		r.setLinkOut(link_out);
		r.setVehTypeId(veh_id);
		r.setRatio(ratio);
		r.setRatioOrder(order);	
		return r;
		
	}

	@Test
	public void testGetters(){
		assertEquals(ID,profile.getId());
		assertEquals(NODE_ID,profile.getNodeId());
		assertEquals(CrudFlag.CREATE,profile.getCrudFlag());
		assertEquals(START_TIME,profile.getStartTime(), 0.0);
		assertEquals(DT,profile.getDt().doubleValue(), 0.0);
		assertEquals(DEST_NETWORK_ID, profile.getDestinationNetworkId().longValue());
		assertEquals(MOD_STAMP, profile.getModStamp());
		assertEquals(4, profile.getListOfSplitratios().size());
	}
	
	@Test
	public void testClone(){
		SplitRatioProfile copy = profile.clone();
		assertTrue(copy != profile);
		assertEquals(copy.getNodeId(), NODE_ID);
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
