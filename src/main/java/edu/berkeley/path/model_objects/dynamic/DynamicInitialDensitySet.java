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

import edu.berkeley.path.model_objects.shared.DateTime;

import java.util.List;

public class DynamicInitialDensitySet extends edu.berkeley.path.model_objects.jaxb.DynamicInitialDensitySet {

  /**
   * Get the list of densities in the DynamicInitialDensitySet.
   *
   * @return List of all sensors as Sensor Model Objects.
   */
  public List<DynamicDensity> getListOfDensities() {
    return (List<DynamicDensity>) (List<?>) getDynamicDensity();
  }

  /**
   * Set the densities list. Attaches list of Density Model Objects to DynamicInitialDensitySet.
   *
   * @param densities	List of extended Densities to add
   */
  public void setListOfDensities(List<DynamicDensity> densities) {
    getDynamicDensity().clear();
    getDynamicDensity().addAll(densities);
  }

  public boolean isValid() {
    //TODO generate actual implementation
    return true;
  }

  /**
   * Get App run id
   *
   * @return app run id
   */
  @Override
  public long getAppRunId() {
    return this.appRunId;
  }

  /**
   * Set App run id
   *
   * @param value representing app run id
   */
  @Override
  public void setAppRunId(long value) {
    this.appRunId = value;
  }

  /**
   * Get Estimation timestamp as represented as Model Object DateTime object
   *
   * @return date time object
   */
  public DateTime getEstimationTstamp() {
    return (DateTime) this.estTstamp;
  }

  /**
   * Set Estimation timestamp as represented as Model Object DateTime object
   *
   * @param value representing date time object
   */
  public void setEstimationTstamp(DateTime value) {
    this.estTstamp = value;
  }

  /**
   * @param modstamp the modstamp to set
   */
  @Override
  public void setModStamp(String modstamp) {
    super.setModStamp(modstamp);
  }

  /**
   * @return the modStamp
   */
  @Override
  public String getModStamp() {
    return super.getModStamp();
  }

  @Override
  public String getDescription() {
    return super.getDescription();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setDescription(String value) {
    super.setDescription(value);    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public long getId() {
    return super.getId();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setId(long value) {
    super.setId(value);    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public String getName() {
    return super.getName();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setName(String value) {
    super.setName(value);    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public double getTstamp() {
    return super.getTstamp();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setTstamp(Double value) {
    super.setTstamp(value);    //To change body of overridden methods use File | Settings | File Templates.
  }
}
