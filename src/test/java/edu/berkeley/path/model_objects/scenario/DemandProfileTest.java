package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import edu.berkeley.path.model_objects.TestConfiguration;
import org.junit.Before;
import org.junit.Test;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.MOException;

public class DemandProfileTest {
  private static final long ID = 1;
  private static final long LINK_ID = 10;
  private static final long DEST_NETWORK_ID = 99999;
  private static final double DT = 300;
  private static final double START_TIME = 3600;
  private static final String MOD_STAMP = "01-APR-1982 23:23:12";
  private static final double EPSILON = 0.0001;

  private DemandProfile profile;

  @Before
  public void setUp() throws MOException {
    profile = new DemandProfile();
    profile.setId(ID);
    profile.setLinkIdOrg(LINK_ID);
    profile.setStartTime(START_TIME);
    profile.setDt(DT);
    profile.setDestinationNetworkId(DEST_NETWORK_ID);
    profile.setCrudFlagEnum(CrudFlag.CREATE);
    profile.setModStamp(MOD_STAMP);

    List<Demand> demands = new ArrayList<Demand>();

    demands.add(TestConfiguration.createDemand(1, "0.5,0.1,1,0.6"));
    demands.add(TestConfiguration.createDemand(2, "0.5,0.1,1,0.6"));
    demands.add(TestConfiguration.createDemand(3, "0.5,0.1,1,0.6"));
    profile.setListOfDemands(demands);
  }

  @Test
  public void testGetters(){
    assertEquals(ID,profile.getId());
    assertEquals(LINK_ID,profile.getLinkIdOrg());
    assertEquals(CrudFlag.CREATE,profile.getCrudFlagEnum());
    assertEquals(START_TIME,profile.getStartTime(), 0.0);
    assertEquals(DT,profile.getDt().doubleValue(), 0.0);
    assertEquals(DEST_NETWORK_ID, profile.getDestinationNetworkId().longValue());
    assertEquals(MOD_STAMP, profile.getModStamp());
    assertEquals(3, profile.getListOfDemands().size());
  }

  @Test
  public void testGetDemandNoTime(){
    Double[] demands = profile.getDemand(1);
    assertEquals(4,demands.length);
    assertEquals(demands[0], 0.5D, EPSILON);
  }

  @Test
  public void testDemandStringTime(){
    double demand = profile.getDemand(1,"00:00:00");
    assertEquals(demand, 0.5, 0.0);

    double demand2 = profile.getDemand(1,"00:05:00");
    assertEquals(demand2, 0.1, 0.0);

    double demand3 = profile.getDemand(1,"00:04:00");
    assertEquals(demand3, 0.5, 0.0);

    double ratio4 = profile.getDemand(1,"00:10:00");
    assertEquals(ratio4, 1, 0.0);
  }

  @Test
  public void testGetSplitRatioOffset(){
    double demand = profile.getDemand(1, 0);
    assertEquals(demand, 0.5, 0.0);

    double demand2 = profile.getDemand(1, 300);
    assertEquals(demand2, 0.1, 0.0);

    double demand3 = profile.getDemand(1, 400);
    assertEquals(demand3, 0.1, 0.0);

    double demand4 = profile.getDemand(1,  600);
    assertEquals(demand4, 1, 0.0);
  }


}
