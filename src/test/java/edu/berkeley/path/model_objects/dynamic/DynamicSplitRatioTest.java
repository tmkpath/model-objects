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
package edu.berkeley.path.model_objects.dynamic;

import edu.berkeley.path.model_objects.shared.CrudFlag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import edu.berkeley.path.model_objects.MOException;

public class DynamicSplitRatioTest {
  private static final String MOD_STAMP = "01-APR-1982 23:23:12";
  private static final long ID1 = 1;
  private static final long ID2 = 2;
  private static final long ID3 = 3;
  private static final long LINK_IN_ID = 2;
  private static final long LINK_OUT_ID = 3;
  private static final long VEHICLE_TYPE_ID = 4;
  private static final double RATIO1 = 0.1;
  private static final double RATIO2 = 0.4;
  private static final double RATIO3 = 0.5;
  private static final int OFFSET1 = 0;
  private static final int OFFSET2 = 1;
  private static final int OFFSET3 = 2;
  private static final double EPSILON = 0.001;

  private DynamicSplitRatio ratio;

  @Before
  public void setUp() throws MOException {
    ratio = new DynamicSplitRatio();
    ratio.setLinkIn(LINK_IN_ID);
    ratio.setLinkOut(LINK_OUT_ID);
    // add ratios for offset 1 and 3
    ratio.setRatio(OFFSET1, RATIO1, ID1,  MOD_STAMP, CrudFlag.CREATE);
    ratio.setRatio(OFFSET2, RATIO2, ID2,  MOD_STAMP, CrudFlag.CREATE);
    ratio.setRatio(OFFSET3, RATIO3, ID3,  MOD_STAMP, CrudFlag.CREATE);
    ratio.setVehicleTypeId(VEHICLE_TYPE_ID);
  }

  @Test
  public void testEquals(){
    assertTrue(ratio.equals(LINK_IN_ID, LINK_OUT_ID , VEHICLE_TYPE_ID));
    assertFalse(ratio.equals(LINK_IN_ID, LINK_IN_ID, 11111));
  }

  @Test
  public void testGetters() {
    try {
      assertEquals(LINK_IN_ID, ratio.getLinkIn());
      assertEquals(LINK_OUT_ID, ratio.getLinkOut());
      assertEquals(VEHICLE_TYPE_ID, ratio.getVehicleTypeId());
      // ratios were added for offset 1 and 3,
      assertEquals(RATIO1, ratio.getRatio(OFFSET1), EPSILON);
      assertEquals(RATIO2, ratio.getRatio(OFFSET2), EPSILON);
      assertEquals(RATIO3, ratio.getRatio(OFFSET3), EPSILON);
      // ratio ids were added for offset 1 and 3, offset 2 should be null
      assertEquals(ID1, ratio.getId(OFFSET1), EPSILON);
      assertEquals(ID2, ratio.getId(OFFSET2), EPSILON);
      assertEquals(ID3, ratio.getId(OFFSET3), EPSILON);
      // check modstamps
      assertEquals(MOD_STAMP,ratio.getModStamp(OFFSET1));
      // check crudFlag
      assertEquals(CrudFlag.CREATE, ratio.getCrudFlag(OFFSET1));
    } catch (Exception e) {
      e.printStackTrace();
      // assert fails if exception is thrown
      fail();
    }
  }
}
