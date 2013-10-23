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


import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.shared.Parameters;
import edu.berkeley.path.model_objects.shared.Point;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

  private static final long ID = 1;
  private static final String NAME = "Controller Name";
  private static final long NETWORK_ID = 1;
  private static final double LNG = 33.3;
  private static final double LAT = 22.2;;
  private static final long ELEMENT_ID = 1;
  private static final String ELEMENT_NAME = "Link";
  private static final String ELEMENT_DESC = "Link Desc";
  private static final int ACT_TYPE_ID = 1;
  private static final String ACT_TYPE_NAME = "On Ramp";
  private static final String ACT_TYPE_DESC = "On Ramp Desc";
  private static final double EPSILON = 0.005;
  private static final String MOD_STAMP = "01-APR-2008 00:00:00";
  private static Controller controller;

  @Before
  public void setUp() {
    controller = new Controller();
    controller.setId(ID);
    controller.setName(NAME);
    controller.setCrudFlagEnum(CrudFlag.NONE);

    //controller type
    controller.setControllerType(ACT_TYPE_ID, ACT_TYPE_NAME, ACT_TYPE_DESC);

    //display position
    Point p = new Point();
    p.setLongitude(LNG);
    p.setLatitude(LAT);

    controller.setModStamp(MOD_STAMP);
    controller.setParameters(new Parameters());
  }

  @Test
  public void testGetters() {
    assertEquals(CrudFlag.NONE, controller.getCrudFlagEnum());
    assertEquals(MOD_STAMP, controller.getModStamp());
    assertNotNull(controller.getParameters());

    assertEquals(ACT_TYPE_ID, controller.getControllerType().getId());
  }
}
