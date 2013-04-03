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

import java.util.ArrayList;
import java.util.List;

import edu.berkeley.path.model_objects.scenario.DemandProfile;
import edu.berkeley.path.model_objects.jaxb.VehicleTypeOrder;

public class DemandSet extends edu.berkeley.path.model_objects.jaxb.DemandSet {
	
	
	public Boolean isValid() { return true; }
	
	/**
	 * Get value by name
	 * @param name
	 * @return
	 */
	public Object_Parameter getByName(String name) {
		
		if (name.compareToIgnoreCase("id") == 0 ) {
			return new Object_Parameter("id", id, 0.0F, null);
		} else if (name.compareToIgnoreCase("description") == 0 ) {
			return new Object_Parameter("description", 0, 0.0F, getDescription());
		} else if (name.compareToIgnoreCase("project_id") == 0 ) {
			return new Object_Parameter("project_id", projectId, 0.0F, null);
		} else if (name.compareToIgnoreCase("name") == 0 ) {
			return new Object_Parameter("name", 0, 0.0F, getName());
		} 
		
		return new Object_Parameter(null, 0, 0.0F, null);
	}
	
	/**
	 * Get an array of all parameters
	 * 
	 * @return
	 */
	public Object_Parameter[] getAll() {
		
		Object_Parameter[] params = new Object_Parameter[4];
		
		params[0] = new Object_Parameter("id", id, 0.0F, null);
		params[1] = new Object_Parameter("description", 0, 0.0F, getDescription());
		params[2] = new Object_Parameter("project_id", projectId, 0.0F, null);
		params[3] = new Object_Parameter("name", 0, 0.0F, getName());
		
		Object_Parameter.setPositions(params);
		
		return params;
	}
	   /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	@Override
	public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the vehicleTypeOrder property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleTypeOrder }
     *     
     */
    @Override
    public VehicleTypeOrder getVehicleTypeOrder() {
        return vehicleTypeOrder;
    }

    /**
     * Sets the value of the vehicleTypeOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleTypeOrder }
     *     
     */
    @Override
    public void setVehicleTypeOrder(VehicleTypeOrder value) {
        this.vehicleTypeOrder = value;
    }

    /**
     * Gets the value of the demandProfile property.
     * 
     * This accessory method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * For example, to add a new item, do as follows:
     *    getDemandProfile().add(newItem);
     */
    @SuppressWarnings("unchecked")
    public List<DemandProfile> getDemandProfileList() {
    	
        if (demandProfile == null) {
        	
        	demandProfile = new ArrayList<edu.berkeley.path.model_objects.jaxb.DemandProfile>();
        }
        return (List<DemandProfile>)(List<?>)this.demandProfile;
    }

	@SuppressWarnings("unchecked")
	public void setDemandProfileList(List<DemandProfile> dpList) {

		if ( demandProfile == null ) {
			
		  demandProfile = new ArrayList<edu.berkeley.path.model_objects.jaxb.DemandProfile>();  
		}
		demandProfile.clear();
		demandProfile.addAll((List<edu.berkeley.path.model_objects.jaxb.DemandProfile>)(List<?>)dpList);
	}
	  
    /**
     * Gets the value of the projectId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Override
    public long getProjectId() {
        if (projectId == null) {
            return  0L;
        } else {
            return projectId;
        }
    }

    /**
     * Sets the value of the projectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Override
    public void setProjectId(Long value) {
        this.projectId = value;
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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getName() {
        if (name == null) {
            return "";
        } else {
            return name;
        }
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setName(String value) {
        this.name = value;
    }
}
