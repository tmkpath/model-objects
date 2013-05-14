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

import java.util.ArrayList;
import java.util.List;

import edu.berkeley.path.model_objects.scenario.PIFProbeData;

public class PIFProbeDataSet extends edu.berkeley.path.model_objects.jaxb.PIFProbeDataSet{
    /**
     * Gets the value of the pifProbeData property.
     * 
     * @return List<PIFProbeData>
     * 
     * 
     */
    @SuppressWarnings("unchecked")
	public List<PIFProbeData> getPIFProbeDataList() {
        return (List<PIFProbeData>)(List<?>)super.getPIFProbeData();
    }
    
    /**
     * adds a PIFProbeData object to this sets list of PIFProbeData objects
     * 
     * @param PIFProbeData object to be added to list
     */
    public void setPIFProbeData(PIFProbeData data){
    	this.getPIFProbeData().add(data);
    }
    
    /**
     * adds a PIFProbeData list of objects to this method sets to the list of PIFProbeData objects
     * 
     * @param PIFProbeData object to be added to list
     */
    @SuppressWarnings("unchecked")
	public void setPIFProbeData(List<PIFProbeData> list){
    	if(this.pifProbeData == null)
    		this.pifProbeData = new ArrayList<edu.berkeley.path.model_objects.jaxb.PIFProbeData>();
    	this.pifProbeData = (List<edu.berkeley.path.model_objects.jaxb.PIFProbeData>)(List<?>)list;
    }

    /**
     * Gets the value of the lockedForEdit property.
     * 
     * @return boolean
     *     
     */
    @Override
    public boolean isLockedForEdit() {
       return super.isLockedForEdit();
    }

    /**
     * Sets the value of the lockedForEdit property.
     * 
     * @param Boolean value
     *     
     */
    @Override
    public void setLockedForEdit(Boolean value) {
    	super.setLockedForEdit(value);
    }

    /**
     * Gets the value of the lockedForHistory property.
     * 
     * @return boolean
     *     
     */
    @Override
    public boolean isLockedForHistory() {
       return super.isLockedForHistory();
    }

    /**
     * Sets the value of the lockedForHistory property.
     * 
     * @param Boolean value
     *     
     */
    @Override
    public void setLockedForHistory(Boolean value) {
    	super.setLockedForHistory(value);
    }
    
    /**
     * Used to ensure all probes are correctly instantiated
     * 
     * @return boolean
     */
    public boolean isValid(){
    	return true;
    }

}
