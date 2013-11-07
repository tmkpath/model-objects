/**
 * Copyright (c) 2013, Regents of the University of California
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

package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.shared.CrudFlag;

/**
 * Model Object Feedback Sensor class.
 *
 * @author mnjuhn
 */
public class FeedbackSensor extends edu.berkeley.path.model_objects.jaxb.FeedbackSensor {

  /**
   * Check to make sure feedback sensor is valid
   *
   * @return boolean
   */
  public boolean isValid() {
    // TODO: implement validation logic
    return true;
  }

  /**
   * @param id the id to set
   */
  @Override
  public void setId(Long id) {
    super.setId(id);
  }

  /**
   * @return the id
   */
  @Override
  public Long getId() {
    return super.getId();
  }

  /**
   * @param id the id to set
   */
  @Override
  public void setSensorIdOriginal(String id) {
    super.setSensorIdOriginal(id);
  }

  /**
   * @return the id
   */
  @Override
  public String getSensorIdOriginal() {
    return super.getSensorIdOriginal();
  }

  /**
   * Get Usage Type for this Sensor Reference
   *
   * @return UsageType  An object representing the the id, name, and
   * description for this UsageType
   */
  @Override
  public edu.berkeley.path.model_objects.jaxb.UsageType getUsageType() {
    return super.getUsageType();
  }

  /**
   * Convenience method for users to get Usage Type Id directly
   *
   * @return Integer The id of the Usage Type
   */
  public Integer getUsageTypeId() {
    if (getUsageType() != null) {
      return getUsageType().getId();
    }
    else {
      return null;
    }
  }

  /**
   * Set the Usage Type for this Sensor based on the parameters passed in.
   *
   * @param typeId Id of the UsageType
   * @param name Name of the UsageType
   * @param desc Description of the UsageType
   */
  public void setUsageType(Integer typeId, String name, String desc) {
    edu.berkeley.path.model_objects.jaxb.UsageType type =
        new edu.berkeley.path.model_objects.jaxb.UsageType();
    type.setId(typeId);
    type.setName(name);
    type.setDescription(desc);
    super.setUsageType(type);
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

}
