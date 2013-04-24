package edu.berkeley.path.model_objects.traffic_state;

import edu.berkeley.path.model_objects.jaxb.TrafficDatum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkStateTest {
  public static final int AGG_ID = 1;
  public static final String AGG_NAME = "agg_name";
  public static final String AGG_DESC = "agg_desc";
  public static final int APP_ID = 2;
  public static final String APP_NAME = "app_name";
  public static final String APP_DESC = "app_desc";
  public static final int QTY_ID = 3;
  public static final String QTY_NAME = "qty_name";
  public static final String QTY_DESC = "qty_desc";
  public static final double VEHICLE_COUNT = 1.0;
  public static final double SPEED = 2.0;
  public static final double INFLOW = 3.0;
  public static final double OUTFLOW = 4.0;
  private static final double EPSILON = 0.001;

  LinkState ls;

	@Before
	public void setup() {
		ls = new LinkState();

    ls.setAggregationType(AGG_ID, AGG_NAME, AGG_DESC);
		ls.setApplicationType(APP_ID, APP_NAME, APP_DESC);
		ls.setQuantityType(QTY_ID, QTY_NAME, QTY_DESC);

    TrafficDatum td = new TrafficDatum();
    td.setVehicleCount(VEHICLE_COUNT);
    td.setSpeed(SPEED);
    td.setInflow(INFLOW);
    td.setOutflow(OUTFLOW);
    ls.setTrafficDatum(td);
	}

	@Test
	public void testAssignments() {
    assertEquals(AGG_ID, ls.getAggregationTypeId());
    assertEquals(AGG_NAME, ls.getAggregationType().getName());
    assertEquals(AGG_DESC, ls.getAggregationType().getDescription());

    assertEquals(APP_ID, ls.getApplicationTypeId());
    assertEquals(APP_NAME, ls.getApplicationType().getName());
    assertEquals(APP_DESC, ls.getApplicationType().getDescription());

    assertEquals(QTY_ID, ls.getQuantityTypeId());
    assertEquals(QTY_NAME, ls.getQuantityType().getName());
    assertEquals(QTY_DESC, ls.getQuantityType().getDescription());

    assertEquals(VEHICLE_COUNT, ls.getTrafficDatum().getVehicleCount(), EPSILON);
    assertEquals(SPEED, ls.getTrafficDatum().getSpeed(), EPSILON);
    assertEquals(INFLOW, ls.getTrafficDatum().getInflow(), EPSILON);
    assertEquals(OUTFLOW, ls.getTrafficDatum().getOutflow(), EPSILON);
	}
}
