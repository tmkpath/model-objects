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

public class ControllerSetTest {

  private static final int A1_ID = 10;
  private static final int A2_ID = 20;
  private static final String DESCRIPTION = "Controller Set Description";
  private static final String MOD_STAMP = "18-JAN-2008 02:51:00";
  private static final String NAME = "Controller Set Name";
  private static final long PROJECT_ID = 1;


  private ControllerSet controllerSet;

  @Before
  public void setUp(){
    controllerSet = new ControllerSet();
    controllerSet.setDescription(DESCRIPTION);
    controllerSet.setId(A1_ID);
    controllerSet.setModStamp(MOD_STAMP);
    controllerSet.setName(NAME);
    controllerSet.setProjectId(PROJECT_ID);
    controllerSet.setLockedForEdit(true);
    controllerSet.setLockedForHistory(true);

  }

  @Test
  public void testGetters(){
    assertEquals(DESCRIPTION,controllerSet.getDescription());
    assertEquals(A1_ID, controllerSet.getId());
    assertEquals(MOD_STAMP, controllerSet.getModStamp());
    assertEquals(NAME, controllerSet.getName());
    assertEquals(PROJECT_ID, controllerSet.getProjectId());
    assertEquals(true, controllerSet.isLockedForEdit());
    assertEquals(true, controllerSet.isLockedForHistory());
  }


  @Test
  public void testIsValid(){
    assertTrue(controllerSet.isValid());
  }

  @Test
  public void testControllerList() {
    // Create List of two controllers, add it to controller set
    List<Controller> controllers = new ArrayList<Controller>();
    Controller a1 = new Controller();
    a1.setId(A1_ID);
    controllers.add(a1);
    Controller a2 = new Controller();
    a2.setId(A2_ID);
    controllers.add(a2);

    ControllerSet controllerSet = new ControllerSet();
    controllerSet.setControllers(controllers);

    List<Controller> controllerList = controllerSet.getControllers();
    assertEquals(2, controllerList.size());
    assertEquals(A1_ID, controllerList.get(0).getId());
    assertEquals(A2_ID, controllerList.get(1).getId());
  }
}
