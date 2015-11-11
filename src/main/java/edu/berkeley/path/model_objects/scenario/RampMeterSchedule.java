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


public class RampMeterSchedule extends edu.berkeley.path.model_objects.jaxb.RampMeterSchedule  {


    public List<RampMeterScheduleElement> getListOfRampMeterScheduleElement() {
        return (List<RampMeterScheduleElement>)(List<?>) super.getRampMeterScheduleElement();
    }

    public void setListOfRampMeterScheduleElement(List<RampMeterScheduleElement> elements) {
        getListOfRampMeterScheduleElement().clear();
        getListOfRampMeterScheduleElement().addAll(elements);
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
    public long getPlanId() {
        return super.getPlanId();
    }

    @Override
    public void setPlanId(long value) {
        super.setPlanId(value);
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
    public void setDescription(String desc) { super.setDescription(desc); }

    @Override
    public void setTableNum(Long value) {
        super.setTableNum(value);
    }

    @Override
    public Long getTableNum() {
        return super.getTableNum();
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

    /**
     * Override Jaxb getters for children to manage Json serialization
     */
    @Override
    @JsonIgnore
    public List<edu.berkeley.path.model_objects.jaxb.RampMeterScheduleElement> getRampMeterScheduleElement() {
        if (rampMeterScheduleElement == null) {
            rampMeterScheduleElement = new ArrayList<edu.berkeley.path.model_objects.jaxb.RampMeterScheduleElement>();
        }
        return this.rampMeterScheduleElement;
    }

}