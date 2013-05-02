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

package edu.berkeley.path.model_objects.scenario;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SensorSetTest {

  private static final int S1_ID = 10;
  private static final int S2_ID = 20;
  private static final String DESCRIPTION = "Sensor Set Description";
  private static final String MOD_STAMP = "18-JAN-2008 02:51:00";
  private static final String NAME = "Sensor Set Name";
  private static final long PROJECT_ID = 1;

  
  private SensorSet sensorSet;
  
  @Before
  public void setUp(){
	  sensorSet = new SensorSet();
	  sensorSet.setDescription(DESCRIPTION);
	  sensorSet.setId(S1_ID);
	  sensorSet.setModStamp(MOD_STAMP);
	  sensorSet.setName(NAME);
	  sensorSet.setProjectId(PROJECT_ID);
  }
  
  @Test
  public void testGetters(){
	assertEquals(DESCRIPTION,sensorSet.getDescription());
	assertEquals(S1_ID, sensorSet.getId());
	assertEquals(MOD_STAMP, sensorSet.getModStamp());
	assertEquals(NAME, sensorSet.getName());
	assertEquals(PROJECT_ID, sensorSet.getProjectId());
  }
  
  
  @Test
  public void testIsValid(){
	  assertTrue(sensorSet.isValid());
  }
  
  @Test
  public void testSensorList() {
    List<Sensor> sensors = new ArrayList<Sensor>();
    Sensor s1 = new Sensor();
    s1.setId(S1_ID);
    sensors.add(s1);
    Sensor s2 = new Sensor();
    s2.setId(S2_ID);
    sensors.add(s2);

    SensorSet sensorSet = new SensorSet();
    sensorSet.setSensors(sensors);

    List<Sensor> sensorList = sensorSet.getSensors();
    assertEquals(2, sensorList.size());
    assertEquals(S1_ID, sensorList.get(0).getId());
    assertEquals(S2_ID, sensorList.get(1).getId());
  }
}
