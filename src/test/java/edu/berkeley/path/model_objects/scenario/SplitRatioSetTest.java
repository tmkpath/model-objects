package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.Interval;
import org.junit.Before;
import org.junit.Test;

import edu.berkeley.path.model_objects.TestConfiguration;
import edu.berkeley.path.model_objects.jaxb.CrudFlag;
import edu.berkeley.path.model_objects.network.Node;

public class SplitRatioSetTest {
	SplitRatioSet set;
	
	@Before
	public void setUp(){
		set = new SplitRatioSet();
		set.setDescription("test set");
		set.setVehicleTypeOrder(new VehicleTypeOrder());
		set.setProjectId(2);
		set.setId(1);
		set.setName("Test Set Name");
		set.setModStamp("1970-01-01 00:00:00");
		
		List<SplitRatioProfile> profiles = new ArrayList<SplitRatioProfile>();
		profiles.add(TestConfiguration.createSplitRatioProfile(1,3600,300,1, CrudFlag.UPDATE));
		profiles.add(TestConfiguration.createSplitRatioProfile(2,3660,300,2, CrudFlag.UPDATE));
		profiles.add(TestConfiguration.createSplitRatioProfile(3,3720,300,3, CrudFlag.UPDATE));
		
		set.setListOfSplitRatioProfiles(profiles);
	}
	
	@Test
	public void testGetters(){
		assertEquals("test set", set.getDescription());
		assertNotNull(set.getVehicleTypeOrder());
		assertEquals(2, set.getProjectId());
		assertEquals(1,set.getId());
		assertEquals("Test Set Name", set.getName());
		assertEquals("1970-01-01 00:00:00", set.getModStamp());
		assertEquals(3, set.getListOfSplitRatioProfiles().size());
	}
	
	@Test
	public void testSlice(){
		
		//start the same  and end in middle
		Interval i = new Interval(3600000,3680000);
		List<SplitRatioProfile> profs = set.slice(i);
		List<Splitratio> ratios1 = profs.get(0).getListOfSplitratios();
		List<Splitratio> ratios2 = profs.get(1).getListOfSplitratios();
		List<Splitratio> ratios3 = profs.get(2).getListOfSplitratios();

		assertEquals(3, profs.size());
		assertEquals(2, ratios1.size());
		assertEquals(2, ratios2.size());
		assertEquals(0, ratios3.size());

		//start and start
		i = new Interval(3600000,3600000);
		profs = set.slice(i);
		ratios1 = profs.get(0).getListOfSplitratios();
		ratios2 = profs.get(1).getListOfSplitratios();
		ratios3 = profs.get(2).getListOfSplitratios();
		
		assertEquals(3, profs.size());
		assertEquals(1, ratios1.size());
		assertEquals(0, ratios2.size());
		assertEquals(0, ratios3.size());

		//end and end
		i = new Interval(4500000,4500000);
		profs = set.slice(i);
		ratios1 = profs.get(0).getListOfSplitratios();
		ratios2 = profs.get(1).getListOfSplitratios();
		ratios3 = profs.get(2).getListOfSplitratios();
		
		assertEquals(3, profs.size());
		assertEquals(1, ratios1.size());
		assertEquals(1, ratios2.size());
		assertEquals(1, ratios3.size());

		
		//start in middle and end in middle - do not cross samples
		i = new Interval(3660000,3730000);
		profs = set.slice(i);
		ratios1 = profs.get(0).getListOfSplitratios();
		ratios2 = profs.get(1).getListOfSplitratios();
		ratios3 = profs.get(2).getListOfSplitratios();
		
		assertEquals(3, profs.size());
		assertEquals(1, ratios1.size());
		assertEquals(2, ratios2.size());
		assertEquals(2, ratios3.size());

		//start in middle and end in middle but cross samples
		i = new Interval(3660000,3990000);
		profs = set.slice(i);
		ratios1 = profs.get(0).getListOfSplitratios();
		ratios2 = profs.get(1).getListOfSplitratios();
		ratios3 = profs.get(2).getListOfSplitratios();
		
		assertEquals(3, profs.size());
		assertEquals(2, ratios1.size());
		assertEquals(3, ratios2.size());
		assertEquals(2, ratios3.size());
		
		//start and end before
		i = new Interval(3200000,3500000);
		profs = set.slice(i);
		ratios1 = profs.get(0).getListOfSplitratios();
		ratios2 = profs.get(1).getListOfSplitratios();
		ratios3 = profs.get(2).getListOfSplitratios();
		
		assertEquals(3, profs.size());
		assertEquals(0, ratios1.size());
		assertEquals(0, ratios2.size());
		assertEquals(0, ratios3.size());

		//start and end after
		i = new Interval(4800000,4900000);
		profs = set.slice(i);
		ratios1 = profs.get(0).getListOfSplitratios();
		ratios2 = profs.get(1).getListOfSplitratios();
		ratios3 = profs.get(2).getListOfSplitratios();
		
		assertEquals(3, profs.size());
		assertEquals(0, ratios1.size());
		assertEquals(0, ratios2.size());
		assertEquals(0, ratios3.size());

		//start before and end after
		i = new Interval(3500000,4700000);
		profs = set.slice(i);
		ratios1 = profs.get(0).getListOfSplitratios();
		ratios2 = profs.get(1).getListOfSplitratios();
		ratios3 = profs.get(2).getListOfSplitratios();
		
		assertEquals(3, profs.size());
		assertEquals(4, ratios1.size());
		assertEquals(4, ratios2.size());
		assertEquals(4, ratios3.size());

	}
	
	public void testGetSplitRatioProfileAtNode()
	{
		Node n = new Node();
		n.setId(1);
		List<SplitRatioProfile> profiles = set.getSplitRatioProfileAtNode(n);
		assertEquals(1, profiles.size());

		profiles.add(TestConfiguration.createSplitRatioProfile(1,3720,300,3,CrudFlag.UPDATE));
		profiles = set.getSplitRatioProfileAtNode(n);
		assertEquals(2, profiles.size());

		n.setId(1111);
		profiles = set.getSplitRatioProfileAtNode(n);
		assertEquals(0, profiles.size());
	}

	
}
