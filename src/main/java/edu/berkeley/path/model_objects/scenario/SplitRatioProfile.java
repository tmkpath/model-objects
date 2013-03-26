/**
 * Copyright (c) 2012 The Regents of the University of California.
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

import java.util.ArrayList;
import java.util.List;

public class SplitRatioProfile extends edu.berkeley.path.model_objects.jaxb.SplitRatioProfile {
	//TODO: Look at SplitRatioProfile ModelElements. I did not implement any of SplitRatioMap functionality. 

	/**
	 * Gets the list of Split Ratios
	 * 
	 * @return List<Splitratio> List of split ratios
	 */
 	@SuppressWarnings("unchecked")
	public List<Splitratio> getListofSplitratio() {
		// return casted list of Nodes from JAXB base class
		return (List<Splitratio>)(List<?>)super.getSplitratio();
    }

	/**
	 * Set the split ratios list. Attaches list of Split Ratio Model Objects to scenario.
	 * 
	 * @param List<Splitratio>	List of extended Split Ratios to add
	 */
	@SuppressWarnings("unchecked")
	public void setListOfSplitRatios(List<Splitratio> ratios) {
			List<edu.berkeley.path.model_objects.jaxb.Splitratio> splits = getSplitratio();
			if ( splits == null ) {
			  splits = new ArrayList<edu.berkeley.path.model_objects.jaxb.Splitratio>();  
			}
			splits.clear();
			splits.addAll((List<edu.berkeley.path.model_objects.jaxb.Splitratio>)(List<?>)ratios);
			splitratio = splits;
	}
	
    /**
     * Gets the value of the nodeId property.
     * 
     */
    public long getNodeId() {
        return super.getNodeId();
    }

    /**
     * Sets the value of the nodeId property.
     * 
     */
    public void setNodeId(long value) {
        super.setNodeId(value);
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getStartTime() {
        return super.getStartTime();
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setStartTime(Double value) {
        super.setStartTime(value);
    }

    /**
     * Gets the value of the dt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDt() {
        return super.getDt();
    }

    /**
     * Sets the value of the dt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDt(Double value) {
        super.setDt(value);
    }

    /**
     * Gets the value of the destinationNetworkId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDestinationNetworkId() {
        return super.getDestinationNetworkId();
    }

    /**
     * Sets the value of the destinationNetworkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDestinationNetworkId(Long value) {
    	 super.setDestinationNetworkId(value);
    }
}
