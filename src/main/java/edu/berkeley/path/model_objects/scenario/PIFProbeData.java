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

import edu.berkeley.path.model_objects.shared.DateTime;

public class PIFProbeData extends edu.berkeley.path.model_objects.jaxb.PIFProbeData{

    /**
     * Gets the value of the timestamp property.
     * 
     * @return DateTime
     *     
     */
	@Override
    public DateTime getTimestamp() {
        return (DateTime) super.getTimestamp();
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param DateTImevalue
     *     
     */
    public void setPIFTimestamp(DateTime value) {
        super.setTimestamp(value);
    }

    /**
     * Gets the value of the networkId property.
     * 
     */
    @Override
    public long getNetworkId() {
        return super.getNetworkId();
    }

    /**
     * Sets the value of the networkId property.
     * 
     */
    @Override
    public void setNetworkId(long value) {
        super.setNetworkId(value);
    }

    /**
     * Gets the value of the linkId property.
     * 
     */
    @Override
    public long getLinkId() {
        return super.getLinkId();
    }

    /**
     * Sets the value of the linkId property.
     * 
     */
    @Override
    public void setLinkId(long value) {
        super.setLinkId(value);
    }

    /**
     * Gets the value of the runId property.
     * 
     */
    @Override
    public long getRunId() {
        return super.getRunId();
    }

    /**
     * Sets the value of the runId property.
     * 
     */
    @Override
    public void setRunId(long value) {
        super.setRunId(value);
    }

    /**
     * Gets the value of the offset property.
     * 
     */
    @Override
    public double getOffset() {
        return super.getOffset();
    }

    /**
     * Sets the value of the offset property.
     * 
     */
    @Override
    public void setOffset(double value) {
        super.setOffset(value);
    }

    /**
     * Gets the value of the speed property.
     * 
     */
    @Override
    public double getSpeed() {
        return super.getSpeed();
    }

    /**
     * Sets the value of the speed property.
     * 
     */
    @Override
    public void setSpeed(double value) {
        super.setSpeed(value);
    }

    /**
     * Gets the value of the probability property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
    public double getProbability() {
        return super.getProbability();
    }

    /**
     * Sets the value of the probability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    @Override
    public void setProbability(Double value) {
        super.setProbability(value);
    }
    
	/**
	 * Set the mod stamp
	 * 
	 * @param modstamp the modstamp to set
	 */
	@Override
	public void setModStamp(String modstamp) {
		super.setModStamp(modstamp);
	}
	
	/**
	 * Get the mod stamp
	 * 
	 * @return the modStamp
	 */
	@Override
	public String getModStamp() {
		return super.getModStamp();
	}

}
