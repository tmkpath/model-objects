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

public class SensorSet extends edu.berkeley.path.model_objects.jaxb.SensorSet  {
	
	/**
	 * Check to make sure all the Sensors are valid
	 * 
	 * @return boolean 
	 */
	protected boolean isValid() {
		for(Sensor s : getSensors()){
			if(!s.isValid())
				return false;
		}
		return true;
	}
	
	/**
	 * @return the projectId
	 */
	@Override
	public long getProjectId() {
		return super.getProjectId();
	}

	/**
	 * @param projectId the projectId to set
	 */
	 @Override
	public void setProjectId(Long projectId) {
		 super.setProjectId(projectId);
	}

	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(long id) {
		super.setId(id);	
	}

	/**
	 * @return the id
	 */
	@Override
	public long getId() {
		return super.getId();
	}

	/**
	 * @param name the name to set
	 */
	@Override
	public void setName(String name) {
		super.setName(name);
	}



	/**
	 * @param modstamp the modstamp to set
	 */
	@Override
	public void setModStamp(String modstamp) {
		super.setModStamp(modstamp);
	}


	/**
	 * @return the modStamp
	 */
	@Override
	public String getModStamp() {
		return super.getModStamp();
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return super.getName();
	}

	/**
	 * @return the description
	 */
	@Override
	public String getDescription() {
		return super.getDescription();
	}
	
	/**
	 * @param description the description to set
	 */
	@Override
	public void setDescription(String desc) {
		super.setDescription(desc);
		
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
	 * Set the sensors list. Attaches list of Sensor Model Objects to scenario.
	 * 
	 * @param List<Sensor>	List of extended Sensors to add
	 */
	@SuppressWarnings("unchecked")
	public void setSensors(List<Sensor> sensors) {

			List<edu.berkeley.path.model_objects.jaxb.Sensor> sensorSet = getSensor();
			if ( sensorSet == null ) {
			  sensorSet = new ArrayList<edu.berkeley.path.model_objects.jaxb.Sensor>();  
			}
			sensorSet.clear();
			sensorSet.addAll((List<edu.berkeley.path.model_objects.jaxb.Sensor>)(List<?>)sensors);
			sensor = sensorSet;
	}
	
	/** 
	 * Get the list of sensors in the scenario.
	 * 
	 * @return List of all sensors as Sensor Model Objects. 
	 */
	@SuppressWarnings("unchecked")
	public List<Sensor> getSensors() {
		// return casted list of Sensors from JAXB base class
		return (List<Sensor>)(List<?>)super.getSensor();
	}

}
