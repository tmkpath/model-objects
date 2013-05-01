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


import edu.berkeley.path.model_objects.jaxb.CrudFlag;
import edu.berkeley.path.model_objects.shared.Parameters;
import edu.berkeley.path.model_objects.shared.Point;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SensorTest {

  private static final double LNG = 33.3;
  private static final double LAT = 22.2;
  private static final double LINK_POSTION = 0.1;
  private static final int TYPE_ID = 1;
  private static final String ENTITY_ID = "2";
  private static final String TYPE_NAME = "Loop";
  private static final String TYPE_DESC = "Loop Desc";
  private static final double EPSILON = 0.005;
  private static final String MOD_STAMP = "01-APR-2008 00:00:00";
  private static Sensor sensor; 
  
	@Before
	public void setUp() {
		sensor = new Sensor();
		sensor.setId(0);
		sensor.setCrudFlag(CrudFlag.NONE);
		
		//sensor type
	    sensor.setSensorType(TYPE_ID, TYPE_NAME, TYPE_DESC);
		
	    //display position
	    Point p = new Point();
	    p.setLongitude(LNG);
	    p.setLatitude(LAT);
	    sensor.setDisplayPosition(p);

		sensor.setModStamp(MOD_STAMP);
		sensor.setLinkPosition(LINK_POSTION);
		sensor.setLinkReference(new LinkReference());
		sensor.setParameters(new Parameters());
		sensor.setSensorIdOriginal(ENTITY_ID);
		sensor.setLaneNumber(3);
		sensor.setHealthStatus(0);
		sensor.setDataFeedId(2L);
		sensor.setLinkId(3L);
		sensor.setLinkOffset(10.0);
	}

  @Test
  public void testGetters() {
    assertNotNull(sensor.getSensorDisplayPosition());
    assertEquals(LNG, sensor.getSensorDisplayPosition().getLng(), EPSILON);
    assertEquals(LAT, sensor.getSensorDisplayPosition().getLat(), EPSILON);

    assertEquals(TYPE_ID, sensor.getSensorTypeId());
  }
}
