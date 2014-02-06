/**
 * Copyright (c) 2014, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *   Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
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
 **/
package edu.berkeley.path.model_objects.measurements;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;

public class SimulatedSensorSetTest {

  // Node Constants for test values
  private static long APP_RUN_ID = 1;
  private static double DENSITY_ERROR = 0.9;
  private static double DENSITY = 0.1;
  private static double SPEED_ERROR = 0.3;
  private static double SPEED = 11.0;
  private static double FLOW = 2.0;
  private static long VDS_ID = 9900000;
  private static double EPSILON = 0.0005;

  @Test
  public void testSimulatedSensorSet() {
    // construct simulated sensor datum
    SimulatedSensorDatum sensor = new SimulatedSensorDatum();
    sensor.setAppRunId(APP_RUN_ID);
    sensor.setDensityError(DENSITY_ERROR);
    sensor.setDensity(DENSITY);
    sensor.setSpeedError(SPEED_ERROR);
    sensor.setSpeed(SPEED);
    sensor.setFlow(FLOW);
    sensor.setDensity(DENSITY);
    sensor.setDensityError(DENSITY_ERROR);
    sensor.setVdsId(VDS_ID);

    ArrayList<SimulatedSensorDatum> sensorList = new ArrayList<SimulatedSensorDatum>();
    sensorList.add(sensor);

    // add sensor datum to a profile
    SimulatedSensorDataProfile sensorProfile = new SimulatedSensorDataProfile();
    sensorProfile.setVdsId(VDS_ID);
    sensorProfile.setSimulatedSensorData(sensorList);

    ArrayList<SimulatedSensorDataProfile> sensorProfileList = new ArrayList<SimulatedSensorDataProfile>();
    sensorProfileList.add(sensorProfile);

    // add sensor profile to Set
    SimulatedSensorDataSet sensorSet = new SimulatedSensorDataSet();
    sensorSet.setSimulatedSensorProfiles(sensorProfileList);

    // Transverse sensor set, check that there is one profile under it
    assertEquals(sensorSet.getListOfSimulatedSensorProfiles().size(), 1);
    SimulatedSensorDataProfile sensorProfile2 = sensorSet.getListOfSimulatedSensorProfiles().get(0);

    // Transverse sensor profile, check that there is one sensor under it
    assertEquals(sensorProfile2.getVdsId(), VDS_ID);
    assertEquals(sensorProfile2.getListOfSimulatedSensorDatum().size(), 1);
    SimulatedSensorDatum sensor2 = sensorProfile2.getListOfSimulatedSensorDatum().get(0);

    // Check that sensors attributes are correctly set
    assertEquals(sensor2.getVdsId(), VDS_ID);
    assertEquals(sensor2.getAppRunId(), APP_RUN_ID);
    assertEquals(sensor2.getDensity(), DENSITY, EPSILON);
    assertEquals(sensor2.getDensityError(), DENSITY_ERROR, EPSILON);
    assertEquals(sensor2.getFlow(), FLOW, EPSILON);
    assertEquals(sensor2.getSpeed(), SPEED, EPSILON);
    assertEquals(sensor2.getSpeedError(), SPEED_ERROR, EPSILON);
  }
}
