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


package edu.berkeley.path.model_objects.dynamic;

import core.Monitor;
import edu.berkeley.path.model_objects.MOException;
import edu.berkeley.path.model_objects.scenario.Demand;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.shared.DateTime;

import java.util.ArrayList;
import java.util.List;


/**
 * Model Object DemandProfile class.
 *
 * @author Alexey Goder (alexey@goder.com)
 */
public class DynamicDemandProfile extends edu.berkeley.path.model_objects.jaxb.DynamicDemandProfile {

  /**
   * DemandProfile validation
   *
   * @return true if network is valid
   */
  public final Boolean isValid() { return true; }

  /**
   * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   *
   * @return CRUD Flag enumeration
   */
  public CrudFlag getCrudFlagEnum() {

    CrudFlag flag;
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
   * @param flag Flag enumeration
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
   * Gets the list of Demands
   *
   * @return List<Demand> List of demands
   */
  @SuppressWarnings("unchecked")
  public List<Demand> getListOfDemands() {
    // return casted list of Demands JAXB base class
    return (List<Demand>)(List<?>)super.getDynamicDemand();
  }

  /**
   * Set the Demand list.
   *
   * @param demands	List of extended Demands to add
   */
  @SuppressWarnings("unchecked")
  public void setListOfDemands(List<Demand> demands) {
    List<edu.berkeley.path.model_objects.jaxb.DynamicDemand> list = getDynamicDemand();
    if ( list == null ) {
      list = new ArrayList<edu.berkeley.path.model_objects.jaxb.DynamicDemand>();
    }
    list.clear();
    list.addAll((List<edu.berkeley.path.model_objects.jaxb.DynamicDemand>)(List<?>)demands);
    dynamicDemand = list;
  }

  /**
   * returns all the Demand values in this DemandProfile that have the same vehicle type.
   *
   * @param vehicle_type_id vehicle type
   * @return Double[]
   */
  public Double[] getDemand(long vehicle_type_id){
    List<Demand> list = getListOfDemands();
    for (Demand d : list) {
      if(d.equals(vehicle_type_id)) {
        try {
          // Copy demands arraylist to primative array of doubles
          Double[] demandValues = new Double[d.getDemandSize()];
          for (int i = 0; i < d.getDemandSize(); i++) {
            demandValues[i] = d.getDemand(i);
          }
          return demandValues;
        } catch(MOException exc) {
          Monitor.err("Error, cannot find demand for vehicle type id " + vehicle_type_id + ". "
                  + exc.getMessage());
        }
      }
    }

    // otherwise none were found so return empty array
    return new Double[0];
  }

  /**
   * returns the Demand value at the offset from the start time of this profile passed in
   * If the offset is between sample times we return the ratio closer to the beginning of the sample
   *
   * @param vehicle_type_id vehicle type
   * @param offsetTime offset in seconds since start_time of profile
   * @return the Demand corresponding to the parameters passed in or -1 if not found
   */
  public Double getDemand(long vehicle_type_id, long offsetTime){
    List<Demand> list = getListOfDemands();
    int offset = (int)Math.floor(offsetTime / this.getDt());
    for(Demand d : list) {
      if(d.equals(vehicle_type_id)) {
        try {
          // get all demand values with same vehicle type id - indexed by dt
          // check if demand exists for offset
          if (d.getDemandSize() > offset) {
            return d.getDemand(offset);
          }
        } catch(MOException exc) {
          Monitor.err("Error, cannot find demand for vehicle type id " + vehicle_type_id + " and offset "
                  + offsetTime + ". " + exc.getMessage());
        }
      }
    }
    return -1D;
  }


  /**
   * returns the Demand value at the time passed in
   * If the time falls between sample times we return the ratio closer to the beginning of the sample
   *
   * @param vehicle_type_id vehicle type
   * @param time String Format : 14:05:00
   * @return double
   */
  public Double getDemand(long vehicle_type_id, String time){

    DateTime dateTime = new DateTime();
    org.joda.time.DateTime joda = dateTime.setDateString("1970-01-01 00:00:00");
    long milliseconds1 = joda.getMillis();

    DateTime dateTime2= new DateTime();
    org.joda.time.DateTime joda2 = dateTime2.setDateString("1970-01-01 " + time);
    long milliseconds2 = joda2.getMillis();

    long daySeconds = ((milliseconds2  - milliseconds1) / 1000) + 1;
    int offset = (int)Math.floor(daySeconds / this.getDt());

    List<Demand> list = getListOfDemands();
    for(Demand d : list)
    {
      if(d.equals(vehicle_type_id)) {
        try {
          // get all demand values with same vehicle type id - indexed by dt
          // check if demand exists for offset
          if (d.getDemandSize() > offset) {
            return d.getDemand(offset);
          }
        } catch(MOException exc) {
          Monitor.err("Error, cannot find demand for vehicle type id " + vehicle_type_id + " and time "
                  + time + ". " + exc.getMessage());
        }
      }
    }
    return -1D;

  }

  /**
   * Gets the value of the knob property.
   *
   * @return
   *     possible object is
   *     {@link Double }
   *
   */
  @Override
  public double getKnob() {
    if (knob == null) {
      return  1.0D;
    } else {
      return knob;
    }
  }

  /**
   * Sets the value of the knob property.
   *
   * @param value
   *     allowed object is
   *     {@link Double }
   *
   */
  @Override
  public void setKnob(Double value) {
    this.knob = value;
  }

  /**
   * Gets the value of the startTime property.
   *
   * @return
   *     possible object is
   *     {@link Double }
   *
   */
  @Override
  public double getStartTime() {
    if (startTime == null) {
      return  0.0D;
    } else {
      return startTime;
    }
  }

  /**
   * Sets the value of the startTime property.
   *
   * @param value
   *     allowed object is
   *     {@link Double }
   *
   */
  @Override
  public void setStartTime(Double value) {
    this.startTime = value;
  }

  /**
   * Gets the value of the dt property.
   *
   * @return
   *     possible object is
   *     {@link Double }
   *
   */
  @Override
  public Double getDt() {
    return dt;
  }

  /**
   * Sets the value of the dt property.
   *
   * @param value
   *     allowed object is
   *     {@link Double }
   *
   */
  @Override
  public void setDt(Double value) {
    this.dt = value;
  }

  /**
   * Gets the value of the orgLinkId property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  @Override
  public long getLinkIdOrg() {
    return super.getLinkIdOrg();
  }

  /**
   * Sets the value of the orgLinkId property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  @Override
  public void setLinkIdOrg(long value) {
    super.setLinkIdOrg(value);
  }

  /**
   * Gets the value of the id property.
   *
   */
  @Override
  public long getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   */
  @Override
  public void setId(long value) {
    this.id = value;
  }

  /**
   * Gets the value of the destinationNetworkId property.
   *
   * @return
   *     possible object is
   *     {@link Long }
   *
   */
  @Override
  public Long getDestinationNetworkId() {
    return destinationNetworkId;
  }

  /**
   * Sets the value of the destinationNetworkId property.
   *
   * @param value
   *     allowed object is
   *     {@link Long }
   *
   */
  @Override
  public void setDestinationNetworkId(Long value) {
    this.destinationNetworkId = value;
  }

  /**
   * Gets the value of the stdDevAdd property.
   *
   * @return
   *     possible object is
   *     {@link Double }
   *
   */
  @Override
  public Double getStdDevAdd() {
    return stdDevAdd;
  }

  /**
   * Sets the value of the stdDevAdd property.
   *
   * @param value
   *     allowed object is
   *     {@link Double }
   *
   */
  @Override
  public void setStdDevAdd(Double value) {
    this.stdDevAdd = value;
  }

  /**
   * Gets the value of the stdDevMult property.
   *
   * @return
   *     possible object is
   *     {@link Double }
   *
   */
  @Override
  public Double getStdDevMult() {
    return stdDevMult;
  }

  /**
   * Sets the value of the stdDevMult property.
   *
   * @param value
   *     allowed object is
   *     {@link Double }
   *
   */
  @Override
  public void setStdDevMult(Double value) {
    this.stdDevMult = value;
  }

  /**
   * Gets the value of the modStamp property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  @Override
  public String getModStamp() {
    return modStamp;
  }

  /**
   * Sets the value of the modStamp property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  @Override
  public void setModStamp(String value) {
    this.modStamp = value;
  }

}
