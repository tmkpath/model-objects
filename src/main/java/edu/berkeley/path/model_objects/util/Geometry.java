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

/**
 * Geometry Utility wrapper around JGeometry Class
 * 
 * @author mnjuhn
 */
public class Geometry {

  public static enum GeomType { POINT, RECTANGLE, POLYGON }
  protected JGeometry geom;
  
  /**
   * Geometry Constructor, default is 8306 SRID
   * 
   * @param   List of points
   * @param   JGeometry Type
   */
  public Geometry(List<Point> coords, GeomType geomType) {
    this(coords, geomType, 8306);
  }

  /**
   * Geometry Constructor, currently just supports bounding box polygon
   * 
   * @param   List of points
   * @param   JGeometry Type
   * @param   SRID number
   */
  public Geometry(List<Point> coords, GeomType geomType, int srid) {
    switch (geomType) {
      case RECTANGLE:
        this.geom = new JGeometry(coords.get(1).getLatitude(),
            coords.get(1).getLongitude(),
            coords.get(0).getLatitude(),
            coords.get(0).getLongitude(),
            srid);
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