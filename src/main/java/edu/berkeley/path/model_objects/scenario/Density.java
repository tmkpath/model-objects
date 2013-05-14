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

import edu.berkeley.path.model_objects.shared.CrudFlag;

public class Density extends edu.berkeley.path.model_objects.jaxb.Density {

  public boolean isValid() {
    //TODO generate actual implementation
    return true;
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

	/**
	 * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	 *
	 * @return CRUD Flag enumeration
	 */
	public CrudFlag getCrudFlagEnum() {

		CrudFlag flag = null;
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (super.getCrudFlag() == null) {
			setCrudFlagEnum(CrudFlag.NONE);
			flag = CrudFlag.NONE;
		}
		else {
			switch (CrudFlag.valueOf(super.getCrudFlag())) {
				case CREATE:
					flag = CrudFlag.CREATE;
					break;
				case RETRIEVE:
					flag = CrudFlag.RETRIEVE;
					break;
				case UPDATE:
					flag = CrudFlag.UPDATE;
					break;
				case DELETE:
					flag = CrudFlag.DELETE;
					break;
				default:
					flag = CrudFlag.NONE;
					break;

			}
		}
		return flag;
	}

	/**
	 * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	 *
	 * @param CRUD Flag enumeration
	 */
	public void setCrudFlagEnum(edu.berkeley.path.model_objects.shared.CrudFlag flag) {
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (flag == null) {
			super.setCrudFlag("NONE");
		}
		else {
			switch (flag) {
				case CREATE:
					super.setCrudFlag("CREATE");
					break;
				case RETRIEVE:
					super.setCrudFlag("RETRIEVE");
					break;
				case UPDATE:
					super.setCrudFlag("UPDATE");
					break;
				case DELETE:
					super.setCrudFlag("DELETE");
					break;
				default:
					super.setCrudFlag("NONE");
					break;

			}
		}
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
  public long getId() {
    return super.getId();    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void setId(long value) {
    super.setId(value);    //To change body of overridden methods use File | Settings | File Templates.
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
  public long getDestinationNetworkId() {
    return super.getDestinationNetworkId();
  }

  @Override
  public void setDestinationNetworkId(long value) {
    super.setDestinationNetworkId(value);
  }

  @Override
  public double getDensity() {
    return super.getDensity();
  }

  @Override
  public void setDensity(double value) {
    super.setDensity(value);
  }
}
