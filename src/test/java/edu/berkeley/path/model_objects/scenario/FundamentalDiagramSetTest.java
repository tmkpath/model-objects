package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class FundamentalDiagramSetTest {
	private static final String MOD_STAMP = "01-APR-1982 23:23:12";
	FundamentalDiagramSet set;
	
	@Before
	public void setUp(){
		set = new FundamentalDiagramSet();
		set.setDescription("test set");
		set.setProjectId(2L);
		set.setId(1);
		set.setName("Test Set Name");
		set.setModStamp(MOD_STAMP);
		set.setLockedForEdit(true);
		set.setLockedForHistory(true);
		
		List<FundamentalDiagramProfile> profiles = new ArrayList<FundamentalDiagramProfile>();
		profiles.add(createFundamentalDiagramProfile(1L,3600,300));
		profiles.add(createFundamentalDiagramProfile(2L,3660,300));
		profiles.add(createFundamentalDiagramProfile(3L,3720,300));
		
		set.setListOfFundamentalDiagramProfiles(profiles);
		set.setFundamentalDiagramProfile(createFundamentalDiagramProfile(1L,3600,300));
		
	}

	@Test
	public void testGetters(){
		assertEquals("test set", set.getDescription());
		assertEquals(2, set.getProjectId());
		assertEquals(1,set.getId());
		assertEquals("Test Set Name", set.getName());
		assertEquals(MOD_STAMP, set.getModStamp());
		assertEquals(4, set.getListOfFundamentalDiagramProfiles().size());
		assertEquals(true, set.isLockedForEdit());
		assertEquals(true, set.isLockedForHistory());
	}
	
	private FundamentalDiagramProfile createFundamentalDiagramProfile(Long linkId, double dt, double startTime) {
		List<FundamentalDiagram> list = new ArrayList<FundamentalDiagram>();
		list.add(createFundamentalDiagram(10,10,10,10,10,10,10,10,10));
		list.add(createFundamentalDiagram(20,20,20,20,20,20,20,20,20));
		list.add(createFundamentalDiagram(30,30,30,30,30,30,30,30,30));

		
		FundamentalDiagramProfile p = new FundamentalDiagramProfile();
		p.setListOfFDs(list);
		p.setLinkId(linkId);
		p.setStartTime(startTime);
		p.setDt(dt);
		return p;
	}
	
	private FundamentalDiagram createFundamentalDiagram(int cap, 
			double speed, 
			double crit,
			double cong,
			double jam,
			double drop,
			double stdCong,
			double stdFree,
			double stdCap
			){
		FundamentalDiagram d = new FundamentalDiagram();
		d.setCapacity(cap);
		d.setFreeFlowSpeed(speed);
		d.setCriticalSpeed(crit);
		d.setCongestionSpeed(cong);
		d.setJamDensity(jam);
		d.setCapacityDrop(drop);
		d.setStdDevCongestionSpeed(stdCong);
		d.setStdDevFreeFlowSpeed(stdFree);
		d.setStdDevCapacity(stdCap);
		return d;
	}
}
