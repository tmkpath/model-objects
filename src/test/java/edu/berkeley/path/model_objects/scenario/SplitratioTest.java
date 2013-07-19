package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import edu.berkeley.path.model_objects.MOException;

public class SplitratioTest {
	private static final String MOD_STAMP = "01-APR-1982 23:23:12";
	private static final long ID = 1;
	private static final long LINK_IN_ID = 2;
	private static final long LINK_OUT_ID = 3;
	private static final long VEHICLE_TYPE_ID = 4;
	private static final String RATIO = "0.1";
	
	private Splitratio ratio;

	@Before
	public void setUp() throws MOException {
		  ratio = new Splitratio();
		  ratio.setLinkIn(LINK_IN_ID);
		  ratio.setLinkOut(LINK_OUT_ID);
		  ratio.setModStamp(MOD_STAMP);
		  ratio.setRatios(RATIO);
		  ratio.setVehicleTypeId(VEHICLE_TYPE_ID);
	}
  
  @Test
  public void testEquals(){
	  assertTrue(ratio.equals(LINK_IN_ID, LINK_OUT_ID , VEHICLE_TYPE_ID));
	  assertFalse(ratio.equals(LINK_IN_ID, LINK_IN_ID, LINK_IN_ID));  
  }
  
  @Test
  public void testGetters(){
	  assertEquals(LINK_IN_ID, ratio.getLinkIn());
	  assertEquals(LINK_OUT_ID, ratio.getLinkOut());
	  assertEquals(VEHICLE_TYPE_ID, ratio.getVehicleTypeId());
	  assertEquals(RATIO, ratio.getRatiosContent());
	  assertEquals(MOD_STAMP,ratio.getModStamp());
  }
}
