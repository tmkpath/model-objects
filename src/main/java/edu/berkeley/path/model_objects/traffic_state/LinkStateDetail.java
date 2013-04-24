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

package edu.berkeley.path.model_objects.traffic_state;

import edu.berkeley.path.model_objects.jaxb.AggregationType;
import edu.berkeley.path.model_objects.jaxb.ApplicationType;
import edu.berkeley.path.model_objects.jaxb.DateTime;
import edu.berkeley.path.model_objects.scenario.VehicleType;

public class LinkStateDetail extends edu.berkeley.path.model_objects.jaxb.LinkStateDetail {
  public long getApplicationTypeId() {
    return getApplicationType().getId();
  }

  public void setApplicationType(long id, String name, String desc) {
    ApplicationType type = new ApplicationType();
    type.setId(id);
    type.setName(name);
    type.setDescription(desc);
    setApplicationType(type);
  }

  public long getAggregationTypeId() {
    return getAggregationType().getId();
  }

  public void setAggregationType(long id, String name, String desc) {
    AggregationType type = new AggregationType();
    type.setId(id);
    type.setName(name);
    type.setDescription(desc);
    setAggregationType(type);
  }

  public long getVehicleTypeId() {
    return getVehicleType().getId();
  }

  public void setVehicleType(long id, String name, double size, int isStandard) {
    VehicleType type = new VehicleType();
    type.setId(id);
    type.setName(name);
    type.setSizeFactor(size);
    type.setIsStandard(isStandard);
    setVehicleType(type);
  }

  public void populate() {
    //TODO generate actual implementation
  }

  public boolean isValid() {
    //TODO generate actual implementation
    return true;
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
  public Long getNetworkId() {
    return super.getNetworkId();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setNetworkId(Long value) {
    super.setNetworkId(value);    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public Long getRunId() {
    return super.getRunId();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setRunId(Long value) {
    super.setRunId(value);    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public Long getValueTypeId() {
    return super.getValueTypeId();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setValueTypeId(Long value) {
    super.setValueTypeId(value);    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public Double getDt() {
    return super.getDt();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setDt(Double value) {
    super.setDt(value);    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public DateTime getTimestamp() {
    return super.getTimestamp();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setTimestamp(DateTime value) {
    super.setTimestamp(value);    //To change body of overridden methods use File | Settings | File Templates.
  }
}
