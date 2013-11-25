/**
 * Copyright (c) 2012 The Regents of the University of California.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package edu.berkeley.path.model_objects.dynamic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import edu.berkeley.path.model_objects.TestConfiguration;
import org.junit.Before;
import org.junit.Test;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.MOException;

public class DynamicSplitRatioProfileTest {
  private static final long ID = 1;
  private static final long NODE_ID = 10;
  private static final long DEST_NETWORK_ID = 99999;
  private static final double DT = 300;
  private static final double START_TIME = 3600;
  private static final String MOD_STAMP = "01-APR-1982 23:23:12";

  private DynamicSplitRatioProfile profile;

  @Before
  public void setUp() throws MOException {
    profile = new DynamicSplitRatioProfile();
    profile.setId(ID);
    profile.setNodeId(NODE_ID);
    profile.setStartTime(START_TIME);
    profile.setDt(DT);
    profile.setDestinationNetworkId(DEST_NETWORK_ID);
    profile.setCrudFlagEnum(CrudFlag.CREATE);
    profile.setModStamp(MOD_STAMP);

    List<DynamicSplitRatio> ratios = new ArrayList<DynamicSplitRatio>();

    ratios.add(TestConfiguration.createDynamicSplitRatio(1, 2, 3, "0.5,0.1,1,0.6"));
    profile.setListOfSplitRatios(ratios);
  }

  @Test
  public void testGetters(){
    assertEquals(ID,profile.getId());
    assertEquals(NODE_ID,profile.getNodeId());
    assertEquals(CrudFlag.CREATE,profile.getCrudFlagEnum());
    assertEquals(START_TIME,profile.getStartTime(), 0.0);
    assertEquals(DT,profile.getDt().doubleValue(), 0.0);
    assertEquals(DEST_NETWORK_ID, profile.getDestinationNetworkId().longValue());
    assertEquals(MOD_STAMP, profile.getModStamp());
    assertEquals(1, profile.getListOfSplitRatios().size());
  }

  @Test
  public void testClone(){
    DynamicSplitRatioProfile copy = profile.clone();
    assertTrue(copy != profile);
    assertEquals(copy.getNodeId(), NODE_ID);
  }

  @Test
  public void testGetSplitRatioNoTime(){
    Double[] ratios = profile.getSplitRatio(1,2,3);
    assertEquals(4,ratios.length);
  }

  @Test
  public void testGetSplitRatioStringTime(){
    double ratio = profile.getSplitRatio(1,2,3,"01:00:00");
    assertEquals(ratio, 0.5, 0.0);

    double ratio2 = profile.getSplitRatio(1,2,3,"01:05:00");
    assertEquals(ratio2, 0.1, 0.0);

    double ratio3 = profile.getSplitRatio(1,2,3,"01:04:00");
    assertEquals(ratio3, 0.5, 0.0);

    double ratio4 = profile.getSplitRatio(1,2,3,"01:10:00");
    assertEquals(ratio4, 1, 0.0);

    // get undefined ratio, so return -1
    double ratio5 = profile.getSplitRatio(1,2,3,"23:10:00");
    assertEquals(ratio5, -1, 0.0);
  }

  @Test
  public void testGetSplitRatioOffset(){
    double ratio = profile.getSplitRatio(1,2,3,0);
    assertEquals(ratio, 0.5, 0.0);

    double ratio2 = profile.getSplitRatio(1,2,3, 300);
    assertEquals(ratio2, 0.1, 0.0);

    double ratio3 = profile.getSplitRatio(1,2,3, 400);
    assertEquals(ratio3, 0.1, 0.0);

    double ratio4 = profile.getSplitRatio(1,2,3, 600);
    assertEquals(ratio4, 1, 0.0);

    // get undefined ratio, so return -1
    double ratio5 = profile.getSplitRatio(1,2,3, 100000);
    assertEquals(ratio5, -1, 0.0);
  }


}
