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

public class VehicleType extends edu.berkeley.path.model_objects.jaxb.VehicleType{
	
    /**
     * Gets the value of the id property.
     * 
     */
	@Override
    public long getId() {
        return super.getId();
    }

    /**
     * Sets the value of the id property.
     * 
     */
	@Override
    public void setId(long value) {
        super.setId(value);
    }
    
    /**
     * Gets the value of the name property.
     * 
     * @return String
     *     
     */
	@Override
    public String getName() {
        return super.getName();
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     
     */
	@Override
    public void setName(String value) {
        super.setName(value);
    }

    /**
     * Gets the value of the size_factor property.
     * 
     * @return Double
     *     
     */
	@Override
    public double getSizeFactor() {
        return super.getSizeFactor();
    }

    /**
     * Sets the value of the size_factor property.
     * 
     * @param value Double
     *     
     */
	@Override
    public void setSizeFactor(Double value) {
        super.setSizeFactor(value);
    }
    
    /**
     * Gets the value of the is_standard property.
     * 
     * @return int
     *     
     */
	@Override
    public Integer getIsStandard() {
        return super.getIsStandard();
    }

    /**
     * Sets the value of the is_standard property.
     * 
     * @param value Double
     *     
     */
	@Override
    public void setIsStandard(Integer value) {
        super.setIsStandard(value);
    }

    /**
     * Set the mod stamp
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
