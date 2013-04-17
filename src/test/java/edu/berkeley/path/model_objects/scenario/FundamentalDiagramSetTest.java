package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.berkeley.path.model_objects.scenario.FundamentalDiagramSet;

public class FundamentalDiagramSetTest {
	FundamentalDiagramSet set;
	
	@Before
	public void setUp(){
		set = new FundamentalDiagramSet();
		set.setDescription("test set");
		set.setProjectId(2);
		set.setId(1);
		set.setName("Test Set Name");
		set.setModStamp("1970-01-01 00:00:00");
		
		List<FundamentalDiagramProfile> profiles = new ArrayList<FundamentalDiagramProfile>();
		profiles.add(createFundamentalDiagramProfile(1,3600,300,1));
		profiles.add(createFundamentalDiagramProfile(2,3660,300,2));
		profiles.add(createFundamentalDiagramProfile(3,3720,300,3));
		
		set.setListOfFundamentalDiagramProfiles(profiles);
		set.setFundamentalDiagramProfile(createFundamentalDiagramProfile(1,3600,300,1));
		
	}

	@Test
	public void testGetters(){
		assertEquals("test set", set.getDescription());
		assertEquals(2, set.getProjectId());
		assertEquals(1,set.getId());
		assertEquals("Test Set Name", set.getName());
		assertEquals("1970-01-01 00:00:00", set.getModStamp());
		assertEquals(4, set.getListOfFundamentalDiagramProfiles().size());
	}
	
	private Object createFundamentalDiagramProfile(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		return null;
	}
