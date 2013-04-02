/**
 * Copyright (c) 2013, Regents of the University of California
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


package edu.berkeley.path.model_objects.network;


/** 
 * Model Object DemandProfile class.
 *  
 * @author Alexey Goder (alexey@goder.com)
 */
public class DemandProfile extends edu.berkeley.path.model_objects.jaxb.DemandProfile {

	/**
	   * DemandProfile validation
	   * 
	   * @return true if network is valid
	   */
	 public final Boolean isValid() { return true; }
	
    /**
     * Gets the value of the demandSetId property.
     * 
     */
	@Override
	public long getDemandSetId() {
        return demandSetId;
    }

    /**
     * Sets the value of the demandSetId property.
     * 
     */
	@Override
	public void setDemandSetId(long value) {
        this.demandSetId = value;
    }

    /**
     * Gets the value of the knob property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
	@Override
	public double getKnob() {
        if (knob == null) {
            return  1.0D;
        } else {
            return knob;
        }
    }

    /**
     * Sets the value of the knob property.
     *  
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
	@Override
	public void setKnob(Double value) {
        this.knob = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
	@Override
	public double getStartTime() {
        if (startTime == null) {
            return  0.0D;
        } else {
            return startTime;
        }
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
	@Override
	public void setStartTime(Double value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the dt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
	@Override
	public Double getDt() {
        return dt;
    }

    /**
     * Sets the value of the dt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
	@Override
	public void setDt(Double value) {
        this.dt = value;
    }

    /**
     * Gets the value of the orgLinkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	@Override
	public String getOrgLinkId() {
        return orgLinkId;
    }

    /**
     * Sets the value of the orgLinkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	@Override
	public void setOrgLinkId(String value) {
        this.orgLinkId = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
	@Override
	public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
	@Override
	public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the destinationNetworkId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
	@Override
	public Long getDestinationNetworkId() {
        return destinationNetworkId;
    }

    /**
     * Sets the value of the destinationNetworkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
	@Override
	public void setDestinationNetworkId(Long value) {
        this.destinationNetworkId = value;
    }

    /**
     * Gets the value of the stdDevAdd property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
	@Override
	public Double getStdDevAdd() {
        return stdDevAdd;
    }

    /**
     * Sets the value of the stdDevAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
	@Override
	public void setStdDevAdd(Double value) {
        this.stdDevAdd = value;
    }

    /**
     * Gets the value of the stdDevMult property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
	@Override
	public Double getStdDevMult() {
        return stdDevMult;
    }

    /**
     * Sets the value of the stdDevMult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
	@Override
	public void setStdDevMult(Double value) {
        this.stdDevMult = value;
    }

    /**
     * Gets the value of the modStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	@Override
	public String getModStamp() {
        return modStamp;
    }

    /**
     * Sets the value of the modStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	@Override
	public void setModStamp(String value) {
        this.modStamp = value;
    }
		
}
