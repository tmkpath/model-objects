package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.MOException;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import edu.berkeley.path.model_objects.MOException;

public class DemandTest {
  private static final String MOD_STAMP = "01-APR-1982 23:23:12";
  private static final long ID1 = 1;
  private static final long ID2 = 2;
  private static final long ID3 = 3;
  private static final long VEHICLE_TYPE_ID = 4;
  private static final double DEMAND1 = 0.1;
  private static final double DEMAND2 = 0.4;
  private static final double DEMAND3 = 0.5;
  private static final int OFFSET1 = 0;
  private static final int OFFSET2 = 1;
  private static final int OFFSET3 = 2;
  private static final double EPSILON = 0.001;

  private Demand demand;

  @Before
  public void setUp() throws MOException {
    demand = new Demand();
    // add demands for offset 1 and 3
    demand.setDemand(OFFSET1, DEMAND1, ID1,  MOD_STAMP, CrudFlag.CREATE);
    demand.setDemand(OFFSET2, DEMAND2, ID2,  MOD_STAMP, CrudFlag.CREATE);
    demand.setDemand(OFFSET3, DEMAND3, ID3,  MOD_STAMP, CrudFlag.CREATE);
    demand.setVehicleTypeId(VEHICLE_TYPE_ID);
  }

  @Test
  public void testEquals(){
    assertTrue(demand.equals(VEHICLE_TYPE_ID));
    assertFalse(demand.equals(11111));
  }

  @Test
  public void testGetters() {
    try {
      assertEquals(VEHICLE_TYPE_ID, demand.getVehicleTypeId());
      // demands were added for offset 1 and 3,
      assertEquals(DEMAND1, demand.getDemand(OFFSET1), EPSILON);
      assertEquals(DEMAND2, demand.getDemand(OFFSET2), EPSILON);
      assertEquals(DEMAND3, demand.getDemand(OFFSET3), EPSILON);
      // demand ids were added for offset 1 and 3, offset 2 should be null
      assertEquals(ID1, demand.getId(OFFSET1), EPSILON);
      assertEquals(ID2, demand.getId(OFFSET2), EPSILON);
      assertEquals(ID3, demand.getId(OFFSET3), EPSILON);
      // check modstamps
      assertEquals(MOD_STAMP, demand.getModStamp(OFFSET1));
      // check crudFlag
      assertEquals(CrudFlag.CREATE, demand.getCrudFlag(OFFSET1));
    } catch (Exception e) {
      e.printStackTrace();
      // assert fails if exception is thrown
      fail();
    }
  }
}
