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
 * Model Object for Aimsun Sensor Profile.
 *
 * @author mnjuhn
 */
public class SimulatedSensorDataProfile extends edu.berkeley.path.model_objects.jaxb.SimulatedSensorDataProfile {


  /**
   * Return list of Simulated objects (i.e. the profile)
   *
   * @return simulated sensor datum list as List<SimulatedSensorDatum>
   */
  @SuppressWarnings("unchecked")
  public List<SimulatedSensorDatum> getListOfSimulatedSensorDatum() {
    List<edu.berkeley.path.model_objects.jaxb.SimulatedSensorDatum> datumList = super.getSimulatedSensorDatum();
    // return casted list of sensor datum from JAXB base class
    return (List<SimulatedSensorDatum>)(List<?>)datumList;
  }


  /**
   * Set list of Simulated Sensor objects (i.e. the profile)
   *
   * @param sensorData list as List<SimulatedSensorDatum>
   */
  public void setSimulatedSensorData(List<SimulatedSensorDatum> sensorData) {
    super.getSimulatedSensorDatum().clear();
    super.getSimulatedSensorDatum().addAll(sensorData);
  }

  /**
   * Return entity Id of the data profile
   *
   * @return Entity Id as long
   */
  @Override
  public long getEntityId() {
    return super.getEntityId();
  }

  /**
   * Set Entity Id of the data profile
   *
   * @param id as long
   */
  @Override
  public void setEntityId(long id) {
    super.setEntityId(id);
  }

}
