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
    public void setRampMeterPlanSetId(long value) {
        super.setRampMeterPlanSetId(value);
    }

    @Override
    public long getRampMeterPlanSetId() {
        return super.getRampMeterPlanSetId();
    }


    @Override
    public String getName() {
        if (name == null) {
            return "";
        } else {
            return name;
        }
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }


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
        return modStamp;
    }

    @Override
    public void setModStamp(String value) {
        this.modStamp = value;
    }


    @Override
    public String getCrudFlag() {
        return super.getCrudFlag();
    }

    @Override
    public void setCrudFlag(String value) {
        super.setCrudFlag(value);
    }
}
