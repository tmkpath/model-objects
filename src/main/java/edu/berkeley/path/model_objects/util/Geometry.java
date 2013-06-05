/**
 * Copyright (c) 2012, Regents of the University of California
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

package edu.berkeley.path.model_objects.util;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import oracle.spatial.geometry.JGeometry;
import oracle.spatial.util.WKT;
import oracle.sql.STRUCT;

import core.Monitor;
import edu.berkeley.path.model_objects.shared.Point;
import edu.berkeley.path.model_objects.MOException;

/**
 * Geometry Utility wrapper around JGeometry Class
 * 
 * @author mnjuhn
 */
public class Geometry {

  protected JGeometry geom;
  public static enum GeomType { POINT, POLYGON, RECTANGLE, LINESTRING }
  public final static int defaultSRID = 8307; // default to SRID of 8307
  
  /**
   * Geometry Constructor, default is SRID 8307
   * 
   * @param   List of points
   * @param   JGeometry Type
   */
  public Geometry(List<Point> points, GeomType geomType) throws MOException {
    this(points, geomType, defaultSRID);
  }

  /**
   * Geometry Constructor, currently just supports rectangle, polygon and point and SRID of 8307
   * 
   * @param   List of points 
   * @param   JGeometry Type
   * @param   SRID number
   */
  public Geometry(List<Point> points, GeomType geomType, int srid) throws MOException {
    // create array of coordinates which is the size of the list points times 2 (lats and longs)
    int coordLength = points.size() * 2;
    double[] coords; 
    int i = 0;
    
    // Currently this class only supports SRID 8307 so output error message
    if (srid != defaultSRID) { 
      throw new MOException(null, "Error invalid SRID, the Geometry class only supports SRID " + defaultSRID);
    }
    switch (geomType) {
      
      // Rectangles must have top left and bottom right lat and long coordinates
      // SRID 8307 long then lat
      case RECTANGLE:
        
        if (points.size() != 2) {
          throw new MOException(null, "Error only two points should be passed in when trying to create a Rectangular JGeometry");
        }
        // create new list of points, essentially convert rectangle from (top y, left x), (bottom y, right x) 
        // to polygon object with 5 points  
        // (top y, left x) 
        coords = new double[10];
        coords[0] = points.get(0).getLongitude();
        coords[1] = points.get(0).getLatitude();
        // (top y, right x) 
        coords[2] = points.get(0).getLongitude();
        coords[3] = points.get(1).getLatitude();
        // (bottom y, right x) 
        coords[4] = points.get(1).getLongitude();
        coords[5] = points.get(1).getLatitude();
        // (bottom y, left x) 
        coords[6] = points.get(1).getLongitude();
        coords[7] = points.get(0).getLatitude();
        // (top y, left x) - back to starting point
        coords[8] = points.get(0).getLongitude();
        coords[9] = points.get(0).getLatitude();
        this.geom = JGeometryExt.createLinearPolygon(coords, 2, srid);
        break;
        
      // Creates 2D multi-point JGeometry structure
      case LINESTRING:
        // check to ensure there are at least 3 coordinates passed in (longitude, latitude)
        if (points.size() < 2) {
          throw new MOException(null, "Error at least 2 points should be passed in when trying to create Linear Line String JGeometry");
        }
        // unpack points into array of doubles, order based on SRID
        // For each point add longitude and latitude in that order
        coords = new double[coordLength];
        for (i=0; i < points.size(); i++) {
          coords[i*2] = (double)points.get(i).getLongitude();
          coords[i*2 + 1] = (double)points.get(i).getLatitude();
        }
        this.geom = JGeometryExt.createLinearLineString(coords, 2, srid);
        break;
      // Creates 2D polygon JGeometry structure
      case POLYGON:
        // check to ensure there are at least 3 coordinates passed in (longitude, latitude)
        if (points.size() < 3) {
          throw new MOException(null, "Error at least three points should be passed in when trying to create Polygon JGeometry");
        }
        // unpack points into array of doubles, order based on SRID
        // For each point add longitude and latitude in that order
        coords = new double[coordLength];
        for (i=0; i < points.size(); i++) {
          coords[i*2] = (double)points.get(i).getLongitude();
          coords[i*2 + 1] = (double)points.get(i).getLatitude();
        }
        this.geom = JGeometryExt.createLinearPolygon(coords, 2, srid);
        break;
        
      // Creates 2d single point JGeometry structure
      case POINT:
        // check to ensure there is only 2 coordinates passed in (longitude, latitude)
        if (points.size() != 1) {
          throw new MOException(null, "Error only one point should be passed in when trying to create Point JGeometry");
        }
        // unpack points into array of doubles, order based on SRID
        // For each point add longitude and latitude in that order
        coords = new double[coordLength];
        for (i=0; i < points.size(); i++) {
          coords[i*2] = (double)points.get(i).getLongitude();
          coords[i*2 + 1] = (double)points.get(i).getLatitude();
        }
        this.geom = JGeometryExt.createPoint(coords, 2, srid);
        break;
        
      default:
        break;
    }
  }
  
  /**
   * Get Well Known Text (WKT) representation of geometry
   * 
   * @return WKT String
   */
  public String getWKT() {
    WKT wkt = new WKT();
    byte[] text;
    try {
      // try to get WKT from geometry set in constructor
      text = wkt.fromJGeometry(this.geom);
    }
    catch (Exception e) {
      Monitor.err("Error converting geometry to WKT");
      return null;
    }
    return new String(text);
  }
  
  /**
   * Returns oracle STRUCT object of current geometry.  Used so that Oracle SDO geoms 
   * can be passed into Stored Procedures
   * 
   * @param  Connection to Oracle database
   * @return Oracle STRUCT object
   */
  public STRUCT getOracleStruct(java.sql.Connection conn) throws MOException {
    STRUCT struct;
    try {
      JGeometryExt.clearDBDescriptors();
      struct = JGeometryExt.store(this.geom, conn);
    } catch (SQLException e) {
      throw new MOException(e, "Unable to process node SDO geometry on network " + e.getMessage());
    }
    return struct;
  }
  
  /**
   * Converts a two point rectangle (top left, bottom right) to a list of points which represent
   * a closed polygon
   * 
   * @param  List<Point> representing rectangle
   * @return List<Point> representing polygon
   */
  public static List<Point> convertRectToPoly(List<Point> rectangle) throws MOException {
    if (rectangle.size() != 2) {
      throw new MOException(null, "Error only two points should be passed in when trying to convert a Rectangle to a Polygon");
    }
    // create new list of points, essentially convert rectangle from (top y, left x), (bottom y, right x) 
    // to polygon object with 5 points  
    
    ArrayList<Point> polygon = new ArrayList<Point>();
    Point p1 = new Point();
    Point p2 = new Point();
    Point p3 = new Point();
    Point p4 = new Point();
    // (top y, left x) 
    polygon.add(rectangle.get(0));
    // (top y, right x) 
    p1.setLongitude(rectangle.get(0).getLongitude());
    p1.setLatitude(rectangle.get(1).getLatitude());
    polygon.add(p1);
    // (bottom y, right x) 
    p2.setLongitude(rectangle.get(1).getLongitude());
    p2.setLatitude(rectangle.get(1).getLatitude());
    polygon.add(p2);
    // (bottom y, left x) 
    p3.setLongitude(rectangle.get(1).getLongitude());
    p3.setLatitude(rectangle.get(0).getLatitude());
    polygon.add(p3);
    // (top y, left x) - back to starting point
    p4.setLongitude(rectangle.get(0).getLongitude());
    p4.setLatitude(rectangle.get(0).getLatitude());
    polygon.add(p4);
    
    return polygon;
  }
}