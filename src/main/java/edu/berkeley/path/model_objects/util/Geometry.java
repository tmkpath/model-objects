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

import java.util.List;
import oracle.spatial.geometry.JGeometry;
import oracle.spatial.util.WKT;

import core.Monitor;
import edu.berkeley.path.model_objects.shared.Point;
import edu.berkeley.path.model_objects.MOException;

/**
 * Geometry Utility wrapper around JGeometry Class
 * 
 * @author mnjuhn
 */
public class Geometry {

  public static enum GeomType { POINT, RECTANGLE, POLYGON, MULTIPOINT }
  protected JGeometry geom;
  
  /**
   * Geometry Constructor, default is SRID 8307
   * 
   * @param   List of points
   * @param   JGeometry Type
   */
  public Geometry(List<Point> points, GeomType geomType) throws MOException {
    // default to SRID of 8307
    this(points, geomType, 8307);
  }

  /**
   * Geometry Constructor, currently just supports bounding box polygon
   * 
   * @param   List of points 
   * @param   JGeometry Type
   * @param   SRID number
   */
  public Geometry(List<Point> points, GeomType geomType, int srid) throws MOException {
    // create array of coordinates which is the size of the list points times 2 (lats and longs)
    int coordLength = points.size() * 2;
    Double[] coords = new Double[coordLength];
    int i = 0;
    // unpack points into array of doubles, order based on SRID
    if (srid == 8307) {
      // For each point add longitude and latitude in that order
      for (i=0; i < points.size(); i++) {
        coords[i*2] = points.get(i).getLongitude();
        coords[i*2 + 1] = points.get(i).getLatitude();
      }
    }
    // Currently this class only supports SRID 8307 so output error message
    else {
      throw new MOException(null, "Error invalid SRID, the Geometry class only supports SRID 8307.");
    }
    switch (geomType) {
      // Rectangles must have top left and bottom right lat and long coordinates
      case RECTANGLE:
        this.geom = new JGeometry(
            points.get(1).getLatitude(),
            points.get(1).getLongitude(),
            points.get(0).getLatitude(),
            points.get(0).getLongitude(),
            srid);
        break;
      // Creates 2D multi-point JGeometry structure
      case MULTIPOINT:
        this.geom = JGeometry.createMultiPoint(coords, 2, srid);  
      // Creates 2d single point JGeometry structure
      case POINT:
        // check to ensure there is only 2 coordinates passed in (longitude, latitude)
        if (coords.length != 2) {
          throw new MOException(null, "Error more than one point passed in when trying to create Point JGeometry");
        }
        // get first coordinate point and use it as point and pass it in as array of double
        double[] coord = new double[2];
        coord[0] = coords[0];
        coord[1] = coords[1];
        this.geom = JGeometry.createPoint(coord, 2, srid);
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
      // try to get WTK from geometry set in constructor
      text = wkt.fromJGeometry(this.geom);
    }
    catch (Exception e) {
      Monitor.err("Error converting geometry to WKT");
      return null;
    }
    return new String(text);
  }
}