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

public class ActuatorSetTest {

  private static final int A1_ID = 10;
  private static final int A2_ID = 20;
  private static final String DESCRIPTION = "Actuator Set Description";
  private static final String MOD_STAMP = "18-JAN-2008 02:51:00";
  private static final String NAME = "Actuator Set Name";
  private static final long PROJECT_ID = 1;


  private ActuatorSet actuatorSet;

  @Before
  public void setUp(){
    actuatorSet = new ActuatorSet();
    actuatorSet.setDescription(DESCRIPTION);
    actuatorSet.setId(A1_ID);
    actuatorSet.setModStamp(MOD_STAMP);
    actuatorSet.setName(NAME);
    actuatorSet.setProjectId(PROJECT_ID);
    actuatorSet.setLockedForEdit(true);
    actuatorSet.setLockedForHistory(true);

  }

  @Test
  public void testGetters(){
    assertEquals(DESCRIPTION,actuatorSet.getDescription());
    assertEquals(A1_ID, actuatorSet.getId());
    assertEquals(MOD_STAMP, actuatorSet.getModStamp());
    assertEquals(NAME, actuatorSet.getName());
    assertEquals(PROJECT_ID, actuatorSet.getProjectId());
    assertEquals(true, actuatorSet.isLockedForEdit());
    assertEquals(true, actuatorSet.isLockedForHistory());
  }


  @Test
  public void testIsValid(){
    assertTrue(actuatorSet.isValid());
  }

  @Test
  public void testActuatorList() {
    // Create List of two actuators, add it to actuator set
    List<Actuator> actuators = new ArrayList<Actuator>();
    Actuator a1 = new Actuator();
    a1.setId(A1_ID);
    actuators.add(a1);
    Actuator a2 = new Actuator();
    a2.setId(A2_ID);
    actuators.add(a2);

    ActuatorSet actuatorSet = new ActuatorSet();
    actuatorSet.setActuators(actuators);

    List<Actuator> actuatorList = actuatorSet.getActuators();
    assertEquals(2, actuatorList.size());
    assertEquals(A1_ID, actuatorList.get(0).getId());
    assertEquals(A2_ID, actuatorList.get(1).getId());
  }
}
