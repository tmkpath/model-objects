/*
 * Copyright (c) 2014, Regents of the University of California
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

import java.util.List;

public class RouteSet extends edu.berkeley.path.model_objects.jaxb.RouteSet {
  /**
   * Return id of routeSet
   *
   * @return id of routeSet as long
   */
  @Override
  public long getId() {
    return super.getId();
  }

  /**
   * Set id of routeSet
   *
   * @param id of routeSet
   */
  @Override
  public void setId(long id) {
    super.setId(id);
  }

  /**
   * Return name of routeSet
   *
   * @return name of routeSet as string
   */
  @Override
  public String getName() {
    return super.getName();
  }

  /**
   * Set name of routeSet
   *
   * @param name of routeSet as string
   */
  @Override
  public void setName(String name) {
    super.setName(name);
  }

  /**
   * Gets the value of the modStamp property.
   *
   * @return String representation of mod-stamp
   */
  @Override
  public String getModStamp() {
    return super.getModStamp();
  }

  /**
   * Sets the value of the modStamp property.
   *
   * @param value value of database mod-stamp
   */
  @Override
  public void setModStamp(String value) {
    this.modStamp = value;
  }

  /**
   * Get the list of routes in this routeSet.
   *
   * @return List of all routes in routeSet.
   */
  @SuppressWarnings("unchecked")
  public List<Route> getListOfRoutes() {
    // return casted list of Routes from JAXB base class
    return (List<Route>) (List<?>) getRoute();
  }

  /**
   * Set the Routes. Attaches list of Route Model Objects to RouteSet.
   *
   * @param routes List of extended Routes to add
   */
  @SuppressWarnings("unchecked")
  public void setListOfRoutes(List<Route> routes) {
    // clear all routes and add new list of them
    getRoute().clear();
    getRoute().addAll((List<edu.berkeley.path.model_objects.jaxb.Route>) (List<?>) routes);
  }

  /**
   * TODO: Route Validation, return true for now
   */
  public boolean isValid() {
    return true;
  }
}
