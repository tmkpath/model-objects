/**
 * Copyright (c) 2012, Regents of the University of California
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Model Object Ramp Meter Plan class
 *
 * Created by mauricemanning on 10/17/14.
 */
public class RampMeterPlan extends edu.berkeley.path.model_objects.jaxb.RampMeterPlan  {


    public List<RampMeterHoliday> getListOfRampMeterHoliday() {
        return (List<RampMeterHoliday>)(List<?>) super.getRampMeterHoliday();
    }

    public void setListOfRampMeterHoliday(List<RampMeterHoliday> plans) {
        getRampMeterHoliday().clear();
        getRampMeterHoliday().addAll(plans);
    }


    public List<RampMeterRamValue> getListOfRampMeterRamValue() {
        return (List<RampMeterRamValue>)(List<?>) super.getRampMeterRamValue();
    }

    public void setListOfRampMeterRamValue(List<RampMeterRamValue> plans) {
        getListOfRampMeterRamValue().clear();
        getListOfRampMeterRamValue().addAll(plans);
    }


    public List<RampMeterLsdValue> getListOfRampMeterLsdValue() {
        return (List<RampMeterLsdValue>)(List<?>) super.getRampMeterLsdValue();
    }

    public void setListOfRampMeterLsdValue(List<RampMeterLsdValue> plans) {
        getListOfRampMeterLsdValue().clear();
        getListOfRampMeterLsdValue().addAll(plans);
    }


    public List<RampMeterSchedule> getListOfRampMeterSchedule() {
        return (List<RampMeterSchedule>)(List<?>) super.getRampMeterSchedule();
    }

    public void setListOfRampMeterSchedule(List<RampMeterSchedule> plans) {
        getListOfRampMeterSchedule().clear();
        getListOfRampMeterSchedule().addAll(plans);
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public long getId() {
        return super.getId();
    }


    @Override
    public void setControllerId(long value) {
        super.setControllerId(value);
    }

    @Override
    public long getControllerId() {
        return super.getControllerId();
    }


    @Override
    public String getName() {  return super.getName();  }

    @Override
    public void setName(String name) {   super.setName(name); }


    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setDescription(String desc) {
        super.setDescription(desc);

    }

    @Override
    public String getModStamp() {
        return super.getModStamp();
    }

    @Override
    public void setModStamp(String value) {
        super.setModStamp(value);
    }


    @Override
    public String getCrudFlag() {
        return super.getCrudFlag();
    }

    @Override
    public void setCrudFlag(String value) {
        super.setCrudFlag(value);
    }


    @Override
    @JsonIgnore
    public List<edu.berkeley.path.model_objects.jaxb.RampMeterHoliday> getRampMeterHoliday() {
        if (rampMeterHoliday == null) {
            rampMeterHoliday = new ArrayList<edu.berkeley.path.model_objects.jaxb.RampMeterHoliday>();
        }
        return this.rampMeterHoliday;
    }

    @Override
    @JsonIgnore
    public List<edu.berkeley.path.model_objects.jaxb.RampMeterRamValue> getRampMeterRamValue() {
        if (rampMeterRamValue == null) {
            rampMeterRamValue = new ArrayList<edu.berkeley.path.model_objects.jaxb.RampMeterRamValue>();
        }
        return this.rampMeterRamValue;
    }

    @Override
    @JsonIgnore
    public List<edu.berkeley.path.model_objects.jaxb.RampMeterLsdValue> getRampMeterLsdValue() {
        if (rampMeterLsdValue == null) {
            rampMeterLsdValue = new ArrayList<edu.berkeley.path.model_objects.jaxb.RampMeterLsdValue>();
        }
        return this.rampMeterLsdValue;
    }

    /**
     * Override Jaxb getters for children to manage Json serialization
     */
    @Override
    @JsonIgnore
    public List<edu.berkeley.path.model_objects.jaxb.RampMeterSchedule> getRampMeterSchedule() {
        if (rampMeterSchedule == null) {
            rampMeterSchedule = new ArrayList<edu.berkeley.path.model_objects.jaxb.RampMeterSchedule>();
        }
        return this.rampMeterSchedule;
    }


}
