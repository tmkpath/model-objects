package edu.berkeley.path.model_objects.dynamic;

import edu.berkeley.path.model_objects.MOException;
import edu.berkeley.path.model_objects.TestConfiguration;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DynamicDemandProfileTest {
  private static final long ID = 1;
  private static final long LINK_ID = 10;
  private static final long DEST_NETWORK_ID = 99999;
  private static final double DT = 300;
  private static final double START_TIME = 3600;
  private static final String MOD_STAMP = "01-APR-1982 23:23:12";
  private static final double EPSILON = 0.0001;

  private DynamicDemandProfile dynamicDemandProfile;

  @Before
  public void setUp() throws MOException {
    dynamicDemandProfile = new DynamicDemandProfile();
    dynamicDemandProfile.setId(ID);
    dynamicDemandProfile.setLinkIdOrg(LINK_ID);
    dynamicDemandProfile.setStartTime(START_TIME);
    dynamicDemandProfile.setDt(DT);
    dynamicDemandProfile.setDestinationNetworkId(DEST_NETWORK_ID);
    dynamicDemandProfile.setCrudFlagEnum(CrudFlag.CREATE);
    dynamicDemandProfile.setModStamp(MOD_STAMP);

    List<DynamicDemand> demands = new ArrayList<DynamicDemand>();

    demands.add(TestConfiguration.createDynamicDemand(1, "0.5,0.1,1,0.6"));
    demands.add(TestConfiguration.createDynamicDemand(2, "0.5,0.1,1,0.6"));
    demands.add(TestConfiguration.createDynamicDemand(3, "0.5,0.1,1,0.6"));
    dynamicDemandProfile.setListOfDemands(demands);
  }

  @Test
  public void testGetters(){
    assertEquals(ID, dynamicDemandProfile.getId());
    assertEquals(LINK_ID, dynamicDemandProfile.getLinkIdOrg());
    assertEquals(CrudFlag.CREATE, dynamicDemandProfile.getCrudFlagEnum());
    assertEquals(START_TIME, dynamicDemandProfile.getStartTime(), 0.0);
    assertEquals(DT, dynamicDemandProfile.getDt().doubleValue(), 0.0);
    assertEquals(DEST_NETWORK_ID, dynamicDemandProfile.getDestinationNetworkId().longValue());
    assertEquals(MOD_STAMP, dynamicDemandProfile.getModStamp());
    assertEquals(3, dynamicDemandProfile.getListOfDemands().size());
  }

  @Test
  public void testGetDemandNoTime(){
    Double[] demands = dynamicDemandProfile.getDemand(1);
    assertEquals(4,demands.length);
    assertEquals(demands[0], 0.5D, EPSILON);
  }

  @Test
  public void testDemandStringTime(){
    double demand = dynamicDemandProfile.getDemand(1,"00:00:00");
    assertEquals(demand, 0.5, 0.0);

    double demand2 = dynamicDemandProfile.getDemand(1,"00:05:00");
    assertEquals(demand2, 0.1, 0.0);

    double demand3 = dynamicDemandProfile.getDemand(1,"00:04:00");
    assertEquals(demand3, 0.5, 0.0);

    double ratio4 = dynamicDemandProfile.getDemand(1,"00:10:00");
    assertEquals(ratio4, 1, 0.0);
  }

  @Test
  public void testGetSplitRatioOffset(){
    double demand = dynamicDemandProfile.getDemand(1, 0);
    assertEquals(demand, 0.5, 0.0);

    double demand2 = dynamicDemandProfile.getDemand(1, 300);
    assertEquals(demand2, 0.1, 0.0);

    double demand3 = dynamicDemandProfile.getDemand(1, 400);
    assertEquals(demand3, 0.1, 0.0);

    double demand4 = dynamicDemandProfile.getDemand(1,  600);
    assertEquals(demand4, 1, 0.0);
  }


}
