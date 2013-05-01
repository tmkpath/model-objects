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

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class InitialDensitySetTest {

  public static final int LINK_ID = 555;
  public static final int DEST_NETWORK_ID = 666;
  public static final double DENSITY = 1.0;
  private static final double EPSILON = 0.001;
  public static final long VEH_TYPE = 1;
  public static final String VEH_NAME = "General";
  private static final double VEH_SIZE = 1.0;
  private static final int VEH_STD = 1;

  @Test
  public void testAssignments() {
    InitialDensitySet initialDensitySet = new InitialDensitySet();

    List<Density> densityList = new ArrayList<Density>();

    Density density = new Density();
    density.setLinkId(LINK_ID);
    density.setDestinationNetworkId(DEST_NETWORK_ID);
    density.setDensity(DENSITY);
    density.setVehicleType(VEH_TYPE, VEH_NAME, VEH_SIZE, VEH_STD);
    densityList.add(density);


    initialDensitySet.setListOfDensities(densityList);

    List<Density> densities = initialDensitySet.getListOfDensities();

    assertNotNull(densities);
    assertEquals(1, densities.size());
    assertEquals(LINK_ID, densities.get(0).getLinkId());
    assertEquals(DEST_NETWORK_ID, densities.get(0).getDestinationNetworkId());
    assertEquals(DENSITY, densities.get(0).getDensity(), EPSILON);
    assertEquals(VEH_TYPE, densities.get(0).getVehicleTypeId());
  }
}
