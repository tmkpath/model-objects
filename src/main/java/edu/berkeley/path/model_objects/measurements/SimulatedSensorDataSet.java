/**
 * Copyright (c) 2014, Regents of the University of California
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

package edu.berkeley.path.model_objects.measurements;

import java.util.List;

/**
 * Model Object for Simulated Sensor Set class.
 *
 * @author mnjuhn
 */
public class SimulatedSensorDataSet extends edu.berkeley.path.model_objects.jaxb.SimulatedSensorDataSet{

  /**
   * Return Set of Simulated Sensor
   *
   * @return simulated sensor set as a List<SimulatedSensorDataProfile>
   */
  @SuppressWarnings("unchecked")
  public List<SimulatedSensorDataProfile> getListOfSimulatedSensorProfiles() {
    List<edu.berkeley.path.model_objects.jaxb.SimulatedSensorDataProfile> profileList = super.getSimulatedSensorDataProfile();
    // return casted list of sensor profiles from JAXB base class
    return (List<SimulatedSensorDataProfile>)(List<?>)profileList;
  }

  /**
   * Set Simulated Sensor Set as a list of SimulatedSensorDataProfile objects
   *
   * @param sensorSet as List<SimulatedSensorDataProfile>
   */
  public void setSimulatedSensorProfiles(List<SimulatedSensorDataProfile> sensorSet) {
    super.getSimulatedSensorDataProfile().clear();
    super.getSimulatedSensorDataProfile().addAll(sensorSet);
  }

}

