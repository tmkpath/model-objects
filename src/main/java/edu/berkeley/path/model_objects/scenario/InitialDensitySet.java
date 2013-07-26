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

import java.util.List;

public class InitialDensitySet extends edu.berkeley.path.model_objects.jaxb.InitialDensitySet {

  /**
   * Get the list of densities in the InitialDensitySet.
   *
   * @return List of all sensors as Sensor Model Objects.
   */
  public List<Density> getListOfDensities() {
    return (List<Density>) (List<?>) getDensity();
  }

  /**
   * Set the densities list. Attaches list of Density Model Objects to InitialDensitySet.
   *
   * @param densities	List of extended Densities to add
   */
  public void setListOfDensities(List<Density> densities) {
    getDensity().clear();
    getDensity().addAll(densities);
  }


  public void populate() {
    //TODO generate actual implementation
  }

  public boolean isValid() {
    //TODO generate actual implementation
    return true;
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
  public long getProjectId() {
    return super.getProjectId();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setProjectId(long value) {
    super.setProjectId(value);    //To change body of overridden methods use File | Settings | File Templates.
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
