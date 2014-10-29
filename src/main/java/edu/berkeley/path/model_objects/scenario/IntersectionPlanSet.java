/**
 * Copyright (c) 2013 The Regents of the University of California.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the University nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.shared.CrudFlag;

import java.util.ArrayList;
import java.util.List;


public class IntersectionPlanSet extends edu.berkeley.path.model_objects.jaxb.IntersectionPlanSet {
    public List<SignalPlanSet> getListOfSignalPlanSets() {
        return (List<SignalPlanSet>)(List<?>) super.getSignalPlanSet();
    }

    public void setListOfSignalPlanSets(List<SignalPlanSet> plans) {
        getListOfSignalPlanSets().clear();
        getListOfSignalPlanSets().addAll(plans);
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
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setDescription(String value) {
        super.setDescription(value);
    }


    @Override
    public long getProjectId() { return super.getProjectId(); }

    @Override
    public void setProjectId(long value) {
        super.setProjectId(value);
    }


    @Override
    public long getId() { return  super.getId(); }

    @Override
    public void setId(long value) {
        super.setId(value);
    }


    @Override
    public String getName() {  return super.getName();  }

    @Override
    public void setName(String name) {   super.setName(name); }


    /**
     * Ensures all required fields are set
     *
     * @return True if valid
     */
    public boolean isValid(){
        // TODO - validation logic
        return true;
    }

}
