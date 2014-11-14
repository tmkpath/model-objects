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
import edu.berkeley.path.model_objects.jaxb.ActivationIntervals;
import edu.berkeley.path.model_objects.jaxb.Interval;


import java.util.ArrayList;
import java.util.List;

/**
 * Model Object Controller Set class.
 *
 * @author mnjuhn
 */
public class Controller extends edu.berkeley.path.model_objects.jaxb.Controller {

  // Store internal set ID for controller components
  /** @y.exclude */  private Long actuatorSetId;
  /** @y.exclude */  private Long sensorSetId;
  /** @y.exclude */  private Long parametersId;
  /** @y.exclude */  private Long queueControllerId;
  /** @y.exclude */  private Long tableParametersId;
  /** @y.exclude */  private Long subNetworkId;

  /**
   * Check to make sure all controller is valid
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
  public void setId(long id) {
    super.setId(id);
  }

  /**
   * @return the id
   */
  @Override
  public long getId() {
    return super.getId();
  }

  /**
   * @param name the name to set
   */
  @Override
  public void setName(String name) {
    super.setName(name);
  }

  /**
   * @return the name
   */
  @Override
  public String getName() {
    return super.getName();
  }

  /**
   * @param value to set as DT
   */
  @Override
  public void setDt(double value) {
    super.setDt(value);
  }

  /**
   * @return the DT
   */
  @Override
  public double getDt() {
    return super.getDt();
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

  /**
   * Get Controller Type for this object
   *
   * @return ControllerType  An object representing the the id, name, and
   * description for this ControllerType
   */
  @Override
  public edu.berkeley.path.model_objects.jaxb.ControllerType getControllerType() {
    return super.getControllerType();
  }

  /**
   * Convenience method for users to get Controller Type Id directly
   *
   * @return Integer The id of the Controller Type
   */
  public Integer getControllerTypeId() {
    if (getControllerType() != null) {
      return getControllerType().getId();
    }
    else {
      return null;
    }
  }

  /**
   * Set the Controller Type for this object based on the parameters passed in.
   *
   * @param typeId Id of the ControllerType
   * @param name Name of the ControllerType
   * @param desc Description of the ControllerType
   */
  public void setControllerType(Integer typeId, String name, String desc) {
    edu.berkeley.path.model_objects.jaxb.ControllerType type =
        new edu.berkeley.path.model_objects.jaxb.ControllerType();
    type.setId(typeId);
    type.setName(name);
    type.setDescription(desc);
    super.setControllerType(type);
  }

  /**
   * Get Activation Start time
   *
   * @returns the activation start time in seconds
   */
  public Double getActivationStartTime () {
    if (getActivationIntervals() != null &&
        getActivationIntervals().getInterval() != null &&
        getActivationIntervals().getInterval().size() > 0) {
      return getActivationIntervals().getInterval().get(0).getStartTime();
    }
    else {
      return null;
    }
  }

  /**
   * Set Activation Start time
   *
   * @param Activation start time in seconds
   */
  public void setActivationStartTime (Double seconds) {
    // If the activation interval exists, change start time
    if (getActivationIntervals() != null &&
        getActivationIntervals().getInterval() != null &&
        getActivationIntervals().getInterval().size() > 0) {
      // get the existing activation interval and set it's start time
      getActivationIntervals().getInterval().get(0).setStartTime(seconds);

    } else {
      // otherwise create new interval
      Interval interval = new Interval();
      interval.setStartTime(seconds);
      ActivationIntervals activationIntervals = new ActivationIntervals();
      activationIntervals.getInterval().add(interval);
      setActivationIntervals(activationIntervals);
    }

  }

  /**
   * Get Activation End time
   *
   * @returns the activation end time in seconds
   */
  public Double getActivationEndTime () {
    if (getActivationIntervals() != null &&
        getActivationIntervals().getInterval() != null &&
        getActivationIntervals().getInterval().size() > 0) {
      return getActivationIntervals().getInterval().get(0).getEndTime();
    }
    else {
      return null;
    }
  }

  /**
   * Set Activation end time
   *
   * @param Activation end time in seconds
   */
  public void setActivationEndTime (Double seconds) {
    // If the activation interval exists, change end time
    if (getActivationIntervals() != null &&
        getActivationIntervals().getInterval() != null &&
        getActivationIntervals().getInterval().size() > 0) {
      // get the existing activation interval and set it's end time
      getActivationIntervals().getInterval().get(0).setEndTime(seconds);

    } else {
      // otherwise create new interval
      Interval interval = new Interval();
      interval.setEndTime(seconds);
      ActivationIntervals activationIntervals = new ActivationIntervals();
      activationIntervals.getInterval().add(interval);
      setActivationIntervals(activationIntervals);
    }

  }

  /**
   * Get Controller Parameters
   *
   * @return Parameters the parameters associated with this actuator
   */
  @Override
  public edu.berkeley.path.model_objects.shared.Parameters getParameters() {
    return (edu.berkeley.path.model_objects.shared.Parameters)super.getParameters();
  }


  /**
   * Set Controller Parameters
   *
   * @param Parameters the parameters to set the actuator
   */
  public void setParameters(edu.berkeley.path.model_objects.shared.Parameters parameters) {
    super.setParameters(parameters);
  }

    public SignalPlanSet getSignalPlanSet() {
        return (SignalPlanSet) super.getSignalPlanSet();
    }

    public void setSignalPlanSet(SignalPlanSet value) {
        super.setSignalPlanSet(value);
    }

    public RampMeterPlan getRampMeterPlan() {
        return (RampMeterPlan) super.getRampMeterPlan();
    }

    public void setRampMeterPlan(RampMeterPlan value) {
        super.setRampMeterPlan(value);
    }


    /**
   * Get the list of Target Actuators Attached to Controller.
   *
   * @return List of Target Actuator Model Objects.
   */
  @SuppressWarnings("unchecked")
  public List<TargetActuator> getListOfTargetActuators() {
    edu.berkeley.path.model_objects.jaxb.TargetActuators actuatorList = getTargetActuators();
    // check if actuator exists, if not create it and add list of actuators
    if ( actuatorList == null ) {
      actuatorList = new edu.berkeley.path.model_objects.jaxb.TargetActuators();
      actuatorList.getTargetActuator().clear();
      // set newly created actuator list object to controller class, so a Actuatorlist now exists
      setTargetActuators(actuatorList);
    }
    // return casted list of Actuators from JAXB base class
    return (List<TargetActuator>)(List<?>)actuatorList.getTargetActuator();
  }

  /**
   * Set the target actuators. Attaches list of Actuator Model Objects to Controller.
   *
   * @param List<TargetActuator>	List of extended Target Actuators to add
   */
  @SuppressWarnings("unchecked")
  public void setListOfTargetActuators(List<TargetActuator> actuators) {
    edu.berkeley.path.model_objects.jaxb.TargetActuators actuatorList = getTargetActuators();
    if ( actuatorList == null ) {
      actuatorList = new edu.berkeley.path.model_objects.jaxb.TargetActuators();
    }
    actuatorList.getTargetActuator().clear();
    actuatorList.getTargetActuator().addAll((List<edu.berkeley.path.model_objects.jaxb.TargetActuator>)(List<?>)actuators);
    setTargetActuators(actuatorList);
  }

  /**
   * Get the list of Feedback Sensors Attached to Controller.
   *
   * @return List of Feedback Sensor Model Objects.
   */
  @SuppressWarnings("unchecked")
  public List<FeedbackSensor> getListOfFeedbackSensors() {
    edu.berkeley.path.model_objects.jaxb.FeedbackSensors sensorList = getFeedbackSensors();
    // check if sensor exists, if not create it and add list of sensors
    if ( sensorList == null ) {
      sensorList = new edu.berkeley.path.model_objects.jaxb.FeedbackSensors();
      sensorList.getFeedbackSensor().clear();
      // set newly created sensor list object to controller class, so a Sensorlist now exists
      setFeedbackSensors(sensorList);
    }
    // return casted list of Sensors from JAXB base class
    return (List<FeedbackSensor>)(List<?>)sensorList.getFeedbackSensor();
  }

  /**
   * Set the feedback sensors. Attaches list of Sensor Model Objects to Controller.
   *
   * @param List<FeedbackSensor>	List of extended Feedback Sensors to add
   */
  @SuppressWarnings("unchecked")
  public void setListOfFeedbackSensors(List<FeedbackSensor> sensors) {
    edu.berkeley.path.model_objects.jaxb.FeedbackSensors sensorList = getFeedbackSensors();
    if ( sensorList == null ) {
      sensorList = new edu.berkeley.path.model_objects.jaxb.FeedbackSensors();
    }
    sensorList.getFeedbackSensor().clear();
    sensorList.getFeedbackSensor().addAll((List<edu.berkeley.path.model_objects.jaxb.FeedbackSensor>)(List<?>)sensors);
    setFeedbackSensors(sensorList);
  }

  /**
   * Get the Actuator set id associated to this controller
   *
   * @return Actuator set id
   */
  public Long getActuatorSetId() {
    return actuatorSetId;
  }

  /**
   * Set the Actuator set id associated with this controller
   *
   * @param actuatorSetId Id of the Actuator set
   */
  public void setActuatorSetId(Long actuatorSetId) {
    this.actuatorSetId = actuatorSetId;
  }

  /**
   * Get the Sensor set id associated to this controller
   *
   * @return Sensor set id
   */
  public Long getSensorSetId() {
    return sensorSetId;
  }

  /**
   * Set the Sensor set id associated with this controller
   *
   * @param sensorSetId Id of the Sensor set
   */
  public void setSensorSetId(Long sensorSetId) {
    this.sensorSetId = sensorSetId;
  }

  /**
   * Get the parameters config id associated with this controller
   *
   * @return parameters config id
   */
  public Long getParametersId() {
    return parametersId;
  }

  /**
   * Set the parameters config id associated with this controller
   *
   * @param parametersId of its controller parameters
   */
  public void setParametersId(Long parametersId) {
    this.parametersId = parametersId;
  }

  /**
   * Get the queue controller id associated with this controller
   *
   * @return queue controller id
   */
  public Long getQueueControllerId() {
    return queueControllerId;
  }

  /**
   * Set the queue controller id associated with this controller
   *
   * @param queueControllerId of this controller
   */
  public void setQueueControllerId(Long queueControllerId) {
    this.queueControllerId = queueControllerId;
  }

  /**
   * Get the table parameters id associated with this controller
   *
   * @return table parameters id
   */
  public Long getTableParametersId() {
    return tableParametersId;
  }

  /**
   * Set the table parameters id associated with this controller
   *
   * @param tableParametersId of this controller
   */
  public void setTableParametersId(Long tableParametersId) {
    this.tableParametersId = tableParametersId;
  }

  /**
   * Get sub-network id associated with this controller
   *
   * @return sub-network id
   */
  public Long getSubNetworkId() {
    return subNetworkId;
  }

  /**
   * Set the sub-network id associated with this controller
   *
   * @param subNetworkId of this controller
   */
  public void setSubNetworkId(Long subNetworkId) {
    this.subNetworkId = subNetworkId;
  }


}
