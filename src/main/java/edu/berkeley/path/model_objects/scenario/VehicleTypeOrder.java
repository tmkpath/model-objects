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

public class VehicleTypeOrder extends edu.berkeley.path.model_objects.jaxb.VehicleTypeOrder {
	/**
	 * Gets the list of Vehicle Types
	 * 
	 * @return List<VehicleType> List of vehicle types
	 */
 	@SuppressWarnings("unchecked")
	public List<VehicleType> getListOfVehicleType() {
		// return casted list of Vehicle types from JAXB base class
		return (List<VehicleType>)(List<?>)super.getVehicleType();
    }

	/**
	 * Set the vehicletypes list. Attaches list of VehicleType Model Objects to scenario.
	 * 
	 * @param List<VehilceType>	List of extended Vehicle Types to add
	 */
	@SuppressWarnings("unchecked")
	public void setListOfVehicleType(List<VehicleType> types) {
			List<edu.berkeley.path.model_objects.jaxb.VehicleType> vehs = super.getVehicleType();
			if ( vehs == null ) {
			  vehs = new ArrayList<edu.berkeley.path.model_objects.jaxb.VehicleType>();  
			}
			vehs.clear();
			vehs.addAll((List<edu.berkeley.path.model_objects.jaxb.VehicleType>)(List<?>)types);
			vehicleType = vehs;
	}
	
	/**
	 * @param modstamp the modstamp to set
	 */
	public void setModStamp(String modstamp) {
		super.setModStamp(modstamp);
	}
	
	/**
	 * @return the modStamp
	 */
	public String getModStamp() {
		return super.getModStamp();
	}
}
