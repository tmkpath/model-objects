/*
 * Copyright (c) 2013, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package edu.berkeley.path.model_objects.traffic_state;

import edu.berkeley.path.model_objects.jaxb.TrafficDatum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkStateDebugTest {
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
  public static final long PARTICLE_ID = 10L;

  LinkStateDebug ls;

	@Before
	public void setup() {
		ls = new LinkStateDebug();

    ls.setAggregationType(AGG_ID, AGG_NAME, AGG_DESC);
		ls.setApplicationType(APP_ID, APP_NAME, APP_DESC);
		ls.setQuantityType(QTY_ID, QTY_NAME, QTY_DESC);

    TrafficDatum td = new TrafficDatum();
    td.setVehicleCount(VEHICLE_COUNT);
    td.setSpeed(SPEED);
    td.setInflow(INFLOW);
    td.setOutflow(OUTFLOW);
    ls.setTrafficDatum(td);

    ls.setParticleId(PARTICLE_ID);
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

    assertEquals(PARTICLE_ID, ls.getParticleId());
	}
}
