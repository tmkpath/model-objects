package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.shared.CrudFlag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import edu.berkeley.path.model_objects.MOException;

public class SplitratioTest {
	private static final String MOD_STAMP = "01-APR-1982 23:23:12";
	private static final long ID1 = 1;
  private static final long ID2 = 2;
  private static final long ID3 = 3;
	private static final long LINK_IN_ID = 2;
	private static final long LINK_OUT_ID = 3;
	private static final long VEHICLE_TYPE_ID = 4;
	private static final double RATIO1 = 0.1;
  private static final double RATIO2 = 0.4;
  private static final double RATIO3 = 0.5;
  private static final int OFFSET1 = 0;
  private static final int OFFSET2 = 1;
  private static final int OFFSET3 = 2;
  private static final double EPSILON = 0.001;
	
	private Splitratio ratio;

	@Before
	public void setUp() throws MOException {
		  ratio = new Splitratio();
		  ratio.setLinkIn(LINK_IN_ID);
		  ratio.setLinkOut(LINK_OUT_ID);
      // add ratios for offset 1 and 3
		  ratio.setRatio(OFFSET1, RATIO1, ID1,  MOD_STAMP, CrudFlag.CREATE);
      ratio.setRatio(OFFSET2, RATIO2, ID2,  MOD_STAMP, CrudFlag.CREATE);
      ratio.setRatio(OFFSET3, RATIO3, ID3,  MOD_STAMP, CrudFlag.CREATE);
		  ratio.setVehicleTypeId(VEHICLE_TYPE_ID);
	}
  
  @Test
  public void testEquals(){
	  assertTrue(ratio.equals(LINK_IN_ID, LINK_OUT_ID , VEHICLE_TYPE_ID));
	  assertFalse(ratio.equals(LINK_IN_ID, LINK_IN_ID, 11111));
  }
  
  @Test
  public void testGetters() {
    try {
      assertEquals(LINK_IN_ID, ratio.getLinkIn());
      assertEquals(LINK_OUT_ID, ratio.getLinkOut());
      assertEquals(VEHICLE_TYPE_ID, ratio.getVehicleTypeId());
      // ratios were added for offset 1 and 3,
      assertEquals(RATIO1, ratio.getRatio(OFFSET1), EPSILON);
      assertEquals(RATIO2, ratio.getRatio(OFFSET2), EPSILON);
      assertEquals(RATIO3, ratio.getRatio(OFFSET3), EPSILON);
      // ratio ids were added for offset 1 and 3, offset 2 should be null
      assertEquals(ID1, ratio.getId(OFFSET1), EPSILON);
      assertEquals(ID2, ratio.getId(OFFSET2), EPSILON);
      assertEquals(ID3, ratio.getId(OFFSET3), EPSILON);
      // check modstamps
      assertEquals(MOD_STAMP,ratio.getModStamp(OFFSET1));
      // check crudFlag
      assertEquals(CrudFlag.CREATE, ratio.getCrudFlag(OFFSET1));
    } catch (Exception e) {
      e.printStackTrace();
      // assert fails if exception is thrown
      fail();
    }
  }
}
