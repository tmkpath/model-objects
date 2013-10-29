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
import core.Monitor;

public class DynamicDensity extends edu.berkeley.path.model_objects.jaxb.DynamicDensity {

  // density value from content string
  /** @y.exclude */ private Double density;

  public boolean isValid() {
    //TODO generate actual implementation
    return true;
  }

  @Override
  public long getLinkId() {
    return super.getLinkId();
  }

  @Override
  public void setLinkId(long value) {
    super.setLinkId(value);
  }

  @Override
  public Long getDestinationNetworkId() {
    return super.getDestinationNetworkId();
  }

  @Override
  public void setDestinationNetworkId(Long value) {
    super.setDestinationNetworkId(value);
  }

  /*
   * Get the density value as a Content String
   *
   * @return String of density value
   */
  @Override
  public String getContent() {
    return super.getContent();
  }

  /*
   * Set the density value from Content String
   *
   * @param value String value of content string
   */
  @Override
  public void setContent(String value) {
    super.setContent(value);
    try {
      this.density = Double.valueOf(value);
    } catch (Exception ex) {
      Monitor.err("Error setting density, invalid content string.");
    }
  }

  /*
   * Get the density value as a Double
   *
   * @return DynamicDensity
   */
  public Double getDensity() {
    if (this.density == null) {
      try {
        this.density = Double.valueOf(super.getContent());
      } catch (Exception ex) {
        Monitor.err("Error getting dynamic density, invalid content string.");
      }
    }
    return this.density;
  }

  /*
   * Set the density value and content string
   *
   * @param value DynamicDensity as a Double
   */
  public void setDensity(Double value) {
    this.density = value;

    try {
      super.setContent(value.toString());
    } catch (Exception ex) {
      Monitor.err("Error setting dynamic density, invalid content string.");
    }

  }

}
