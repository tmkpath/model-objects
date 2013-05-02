package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SplitratioTest {
	private static final String MOD_STAMP = "01-APR-1982 23:23:12";
	Splitratio ratio;

	@Before
	public void setUp() {
		  ratio = new Splitratio();
		  ratio.setId(0);
		  ratio.setLinkIn(1);
		  ratio.setLinkOut(2);
		  ratio.setRatioOrder(4);
		  ratio.setModStamp(MOD_STAMP);
		  ratio.setRatio(0.1);
		  ratio.setVehTypeId(3);
	}
  
  @Test
  public void testEquals(){
	  assertTrue(ratio.equals(1, 2, 3));
	  assertFalse(ratio.equals(1, 1, 1));  
  }
  
  @Test
  public void testGetters(){
	  assertEquals(0,ratio.getId());
	  assertEquals(1,ratio.getLinkIn());
	  assertEquals(2,ratio.getLinkOut());
	  assertEquals(3,ratio.getVehTypeId());
	  assertEquals(4,ratio.getRatioOrder());
	  assertEquals(0.1,ratio.getRatio(), 0.0);
	  assertEquals(MOD_STAMP,ratio.getModStamp());
  }
}
