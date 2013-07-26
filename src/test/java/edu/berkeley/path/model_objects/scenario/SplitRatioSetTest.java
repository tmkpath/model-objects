package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.berkeley.path.model_objects.TestConfiguration;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.network.Node;
import edu.berkeley.path.model_objects.MOException;

public class SplitRatioSetTest {
	private static final long ID = 1;
	private static final long PROJECT_ID = 10;  
	private static final String DESCRIPTION = "Test Set";
	private static final String NAME = "Test Set Name";
	private static final String MOD_STAMP = "01-APR-1982 23:23:12";
	
	private SplitRatioSet set;
	
	@Before
	public void setUp() throws MOException {
		set = new SplitRatioSet();
		set.setDescription(DESCRIPTION);
		set.setProjectId(PROJECT_ID);
		set.setId(ID);
		set.setName(NAME);
		set.setModStamp(MOD_STAMP);
		set.setLockedForEdit(true);
		set.setLockedForHistory(true);
		
		List<SplitRatioProfile> profiles = new ArrayList<SplitRatioProfile>();
		profiles.add(TestConfiguration.createSplitRatioProfile(1,3600,300,1, CrudFlag.UPDATE));
		profiles.add(TestConfiguration.createSplitRatioProfile(2,3660,300,2, CrudFlag.UPDATE));
		profiles.add(TestConfiguration.createSplitRatioProfile(3,3720,300,3, CrudFlag.UPDATE));
		
		set.setListOfSplitRatioProfiles(profiles);
	}
	
	@Test
	public void testGetters(){
		assertEquals(DESCRIPTION, set.getDescription());
		assertEquals(PROJECT_ID, set.getProjectId());
		assertEquals(ID,set.getId());
		assertEquals(NAME, set.getName());
		assertEquals(MOD_STAMP, set.getModStamp());
		assertEquals(true, set.isLockedForEdit());
		assertEquals(true, set.isLockedForHistory());
		assertEquals(3, set.getListOfSplitRatioProfiles().size());
	}

  @Test
	public void testGetSplitRatioProfileAtNode() throws MOException
	{
		Node n = new Node();
		n.setId(ID);
		SplitRatioProfile profile = set.getSplitRatioProfileAtNode(n.getId());
		assertEquals(ID, profile.getNodeId());

		n.setId(1111);
		profile = set.getSplitRatioProfileAtNode(n.getId());
		assertNull(profile);
	}

	
}
