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
import edu.berkeley.path.model_objects.jaxb.QuantityType;
import edu.berkeley.path.model_objects.shared.DateTime;

public class LinkStateDebug extends edu.berkeley.path.model_objects.jaxb.LinkStateDebug {

  /** @y.exclude */  private double density;

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

	public long getQuantityTypeId() {
		return getQuantityType().getId();
	}

	public void setQuantityType(long id, String name, String desc) {
		QuantityType type = new QuantityType();
		type.setId(id);
		type.setName(name);
		type.setDescription(desc);
    setQuantityType(type);
	}

	public void populate() {
		//TODO generate actual implementation
	}

	public boolean isValid() {
		//TODO generate actual implementation
		return true;
	}

  /**
   * Return the density of the link. DENSITY = VEHICLE_COUNT / LINK_LENGTH
   * Link length value should be in SI
   * @return  density value in SI for link
   */
  public double getDensity() {
    return density;
  }

  /**
   * Sets the density of the link. DENSITY = VEHICLE_COUNT / LINK_LENGTH
   * Link length value should be in SI
   * @param density density value in SI for link
   */
  public void setDensity(double density) {
    this.density = density;
  }

  @Override
	public DateTime getTimestamp() {
		return  new DateTime(super.getTimestamp().getMilliseconds());
	}

	public void setTimestamp(DateTime value) {
		super.setTimestamp(value);
	}

	@Override
	public long getId() {
		return super.getId();
	}

	@Override
	public void setId(long value) {
		super.setId(value);
	}

	@Override
	public Long getNetworkId() {
		return super.getNetworkId();
	}

	@Override
	public void setNetworkId(Long value) {
		super.setNetworkId(value);
	}

	@Override
	public Long getRunId() {
		return super.getRunId();
	}

	@Override
	public void setRunId(Long value) {
		super.setRunId(value);
	}

	@Override
	public Double getDt() {
		return super.getDt();
	}

	@Override
	public void setDt(Double value) {
		super.setDt(value);
	}

	@Override
	public Double getFfSpeed() {
		return super.getFfSpeed();
	}

	@Override
	public void setFfSpeed(Double value) {
		super.setFfSpeed(value);
	}

	@Override
	public Double getCritSpeed() {
		return super.getCritSpeed();
	}

	@Override
	public void setCritSpeed(Double value) {
		super.setCritSpeed(value);
	}

	@Override
	public Double getCapacity() {
		return super.getCapacity();
	}

	@Override
	public void setCapacity(Double value) {
		super.setCapacity(value);
	}

  @Override
  public long getParticleId() {
    return super.getParticleId();
  }

  @Override
  public void setParticleId(Long value) {
    super.setParticleId(value);
  }
}
