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

import java.util.List;

public class SignalPhase extends edu.berkeley.path.model_objects.jaxb.SignalPhase {
    @Override
    public SignalPhaseMovement getSignalPhaseMovement() {
        return (SignalPhaseMovement) super.getSignalPhaseMovement();
    }

    public void setSignalPhaseMovement(SignalPhaseMovement value) {
        super.setSignalPhaseMovement(value);
    }

    public List<SignalPhaseElement> getListOfSignalPhaseElements() {
        return (List<SignalPhaseElement>)(List<?>) super.getSignalPhaseElement();
    }

    public void setListOfSignalPhaseElements(List<SignalPhaseElement> elements) {
        getListOfSignalPhaseElements().clear();
        getListOfSignalPhaseElements().addAll(elements);
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
    public long getPlanId() {
        return super.getPlanId();
    }

    @Override
    public void setPlanId(long value) {
        super.setPlanId(value);
    }

    @Override
    public int getPhaseNumber() {
        return super.getPhaseNumber();
    }

    @Override
    public void setPhaseNumber(int value) {
        super.setPhaseNumber(value);
    }

    @Override
    public int getInUse() {
        return super.getInUse();
    }

    @Override
    public void setInUse(int value) {
        super.setInUse(value);
    }
}
