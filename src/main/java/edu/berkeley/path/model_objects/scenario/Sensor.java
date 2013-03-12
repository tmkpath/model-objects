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

import edu.berkeley.path.model_objects.jaxb.Link;
import edu.berkeley.path.model_objects.shared.DisplayPosition;
import edu.berkeley.path.model_objects.shared.Parameters;

import java.math.BigInteger;

/** Base class for sensors. 
 *
 * @author Gabriel Gomes (gomes@path.berkeley.edu)
 * @author Sean Morris (sean.smorris@gmail.com)
 * 
 */
public class Sensor extends edu.berkeley.path.model_objects.jaxb.Sensor {
   		
	/** Current link where the sensor is located. */
	/** @y.exclude */ protected Link link = null;

	/** Sensor type. */
	/** @y.exclude */ protected Sensor.Type type;
	
	/** Current display position where the sensor is located. */
	/** @y.exclude */ protected DisplayPosition displayPosition;

	/** Current link id for this sensor. */
	/** @y.exclude */ protected LinkReference linkReference; 
	
	/** A collection of name-value pairs associated with the sensor */
	/** @y.exclude */ protected Parameters parameters;

	/** A collection of column names and rows for generic data */
	/** @y.exclude */ protected Table table;
	
	/** Type of sensor.
	 *
	 * TMC = Traffic Message Channel.
	 * This is a static way of reporting probe measurements
	 * employed by INRIX, Navteq, etc.
	 */
	public static enum Type	{  
	/** see {@link ObjectFactory#createSensor_LoopStation} 	*/	
		Loop,
		Magnetic,
		Radar,
		Camera,
		TMC
	};
				   	   	       
	/////////////////////////////////////////////////////////////////////
	// protected default constructor
	/////////////////////////////////////////////////////////////////////

	/** @y.exclude */
	public Sensor(){
	}		  

	
	/////////////////////////////////////////////////////////////////////
	// API
	/////////////////////////////////////////////////////////////////////

	/** Sensor type. */
	public Sensor.Type getSensorType() {
		return type;
	}

	/** Link where the sensor is located. */
	public Link getSensorLink() {
		return link;
	}
	

	/**
	 * @return the displayPosition
	 */
	public DisplayPosition getSensorDisplayPosition() {
		return displayPosition;
	}


	/**
	 * @param displayPosition the displayPosition to set
	 */
	public void setDisplayPosition(DisplayPosition displayPosition) {
		this.displayPosition = displayPosition;
	}


	/**
	 * @return the linkPosition
	 */
	public double getSensorLinkPosition() {
		return super.getLinkPosition();
	}


	/**
	 * @param linkPosition the linkPosition to set
	 */
	public void setLinkPosition(double linkPosition) {
		super.setLinkPosition(linkPosition);
	}

	
	/**
	 * @return the linkReference
	 */
	public LinkReference getSensorLinkReference() {
		return linkReference;
	}


	/**
	 * @param linkReference the linkReference to set
	 */
	public void setLinkReference(LinkReference linkReference) {
		this.linkReference = linkReference;
	}


	/**
	 * @return the parameters
	 */
	public Parameters getSensorParameters() {
		return parameters;
	}


	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return super.getId();
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		super.setId(id);
	}


	/**
	 * @return the sensorIdOriginal
	 */
	public String getSensorIdOriginal() {
		return super.getSensorIdOriginal();
	}


	/**
	 * @param sensorIdOriginal the sensorIdOriginal to set
	 */
	public void setSensorIdOriginal(String sensorIdOriginal) {
		super.setSensorIdOriginal(sensorIdOriginal);
	}


	/**
	 * @return the laneNumber
	 */
	public int getSensorLaneNumber() {
		return super.getLaneNumber().intValue();
	}


	/**
	 * @param laneNumber the laneNumber to set
	 */
	public void setLaneNumber(int laneNumber) {
		super.setLaneNumber(new BigInteger(laneNumber + ""));
	}


	/**
	 * @return the healthStatus
	 */
	public Double getHealthStatus() {
		return super.getHealthStatus();
	}


	/**
	 * @param healthStatus the healthStatus to set
	 */
	public void setHealthStatus(double healthStatus) {
		super.setHealthStatus(healthStatus);
	}
	
	/** 
	 * Sensor validation checks
	 *
	 * @return  True if all sensor validation is correct
	 */
	public final Boolean isValid() {
		boolean isValid = true;
		  
		
		return isValid;
	}
	
	public void reset(){
		
	}
	
	public void update(){
	}

}
