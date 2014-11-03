/*
 * Copyright (c) 2014, Regents of the University of California
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

import edu.berkeley.path.model_objects.shared.DateTime;

public class SignalPlanScheduleElement extends edu.berkeley.path.model_objects.jaxb.SignalPlanScheduleElement {
    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long value) {
        super.setId(value);
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
    public long getScheduleId() {
        return super.getScheduleId();
    }

    @Override
    public void setScheduleId(long value) {
        super.setScheduleId(value);
    }

    @Override
    public DateTime getStartTime() { return (DateTime) super.getStartTime();  }

    //@Override
    public void setStartTime(DateTime value) { super.setStartTime(value ); }

    @Override
    public long getActionType() {
        return super.getActionType();
    }

    @Override
    public void setActionType(long value) {
        super.setActionType(value);
    }

    @Override
    public String getActionItem() {
        return super.getActionItem();
    }

    @Override
    public void setActionItem(String value) {
        super.setActionItem(value);
    }

    @Override
    public boolean isSaturday() {
        return super.isSaturday();
    }

    @Override
    public void setSaturday(boolean value) {
        super.setSaturday(value);
    }

    @Override
    public boolean isSunday() {
        return super.isSunday();
    }

    @Override
    public void setSunday(boolean value) {
        super.setSunday(value);
    }

    @Override
    public boolean isMonday() {
        return super.isMonday();
    }

    @Override
    public void setMonday(boolean value) {
        super.setMonday(value);
    }

    @Override
    public boolean isTuesday() {
        return super.isTuesday();
    }

    @Override
    public void setTuesday(boolean value) {
        super.setTuesday(value);
    }

    @Override
    public boolean isWednesday() {
        return super.isWednesday();
    }

    @Override
    public void setWednesday(boolean value) {
        super.setWednesday(value);
    }

    @Override
    public boolean isThursday() {
        return super.isThursday();
    }

    @Override
    public void setThursday(boolean value) {
        super.setThursday(value);
    }

    @Override
    public boolean isFriday() {
        return super.isFriday();
    }

    @Override
    public void setFriday(boolean value) {
        super.setFriday(value);
    }
}
