package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SplitratioTest {

	Splitratio ratio;

	@Before
	public void setUp() {
		  ratio = new Splitratio();
		  ratio.setId(0);
		  ratio.setLinkIn(1);
		  ratio.setLinkOut(2);
		  ratio.setRatioOrder(4);
		  ratio.setModStamp("1970-01-01 00:00:00");
		  ratio.setContent("0.1");
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
	  assertEquals("0.1",ratio.getContent());
	  assertEquals("1970-01-01 00:00:00",ratio.getModStamp());
  }
}
