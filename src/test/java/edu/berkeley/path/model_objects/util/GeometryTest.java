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

package edu.berkeley.path.model_objects.util;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;
import oracle.sql.STRUCT;

import edu.berkeley.path.model_objects.shared.*;

public class GeometryTest {
  
  ArrayList<Point> multipoint = new ArrayList<Point>();
  ArrayList<Point> polygon = new ArrayList<Point>();
  ArrayList<Point> point = new ArrayList<Point>();
  Geometry geom;
  
  @Before
  public void setup() {
    
    // points
    Point p1 = new Point();
    p1.setLatitude(10.0);
    p1.setLongitude(10.0);
    Point p2 = new Point();
    p2.setLatitude(20.0);
    p2.setLongitude(20.0);
    Point p3 = new Point();
    p3.setLatitude(10.0);
    p3.setLongitude(10.0);
    
    // point setup
    point.add(p1);
    
    // multi point setup
    multipoint.add(p1);
    multipoint.add(p2);
    
    // polygon setup
    polygon.add(p1);
    polygon.add(p2);
    polygon.add(p3);
    
  }

  @Test
  public void testPoint() {
    try {
      geom = new Geometry(point, Geometry.GeomType.POINT);
      String wkt = geom.getWKT();
      
      assertEquals(wkt, "POINT (10.0 10.0)");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testMultiPoint() {
    try {
      geom = new Geometry(multipoint, Geometry.GeomType.LINESTRING);
      String wkt = geom.getWKT();
      
      assertEquals(wkt, "LINESTRING (10.0 10.0, 20.0 20.0)");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testPolygon() {
    try {
      geom = new Geometry(polygon, Geometry.GeomType.POLYGON);
      String wkt = geom.getWKT();
      
      assertEquals(wkt, "POLYGON ((10.0 10.0, 20.0 20.0, 10.0 10.0))");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}