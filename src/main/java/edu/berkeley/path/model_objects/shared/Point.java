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

package edu.berkeley.path.model_objects.shared;

import java.math.BigDecimal;

public class Point extends edu.berkeley.path.model_objects.jaxb.Point {
  
  /**
   * Returns the Latitude of Point
   * 
   * @return  Latitude of Point      
   */
  public BigDecimal getLatitude() {
      return getLat();
  }

  /**
   * Sets the Latitude of Point
   * 
   * @param   Latitude  
   */
  public void setLatitude(BigDecimal lat) {
      setLat(lat);
  }

  /**
   * Returns the Longitude of Point
   * 
   * @return  Longitude of Point  
   */
  public BigDecimal getLongitude() {
      return getLng();
  }

  /**
   * Sets the Longitude of Point
   * 
   * @param   Longitude
   */
  public void setLongitude(BigDecimal lng) {
      setLng(lng);
  }

  /**
   * Returns the Elevation of Point
   * 
   * @return  Elevation of Point   
   */
  @Override
  public BigDecimal getElevation() {
      return super.getElevation();
  }

  /**
   * Sets the Elevation of point.
   * 
   * @param Elevation
   */
  @Override
  public void setElevation(BigDecimal elevation) {
      super.setElevation(elevation);
  }
}