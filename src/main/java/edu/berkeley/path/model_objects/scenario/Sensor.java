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

import edu.berkeley.path.model_objects.jaxb.CrudFlag;
import edu.berkeley.path.model_objects.jaxb.DisplayPosition;
import edu.berkeley.path.model_objects.jaxb.Link;
import edu.berkeley.path.model_objects.jaxb.SensorType;
import edu.berkeley.path.model_objects.shared.Point;

import java.math.BigInteger;

/** Extended class for sensors. 
 *
 * @author Gabriel Gomes (gomes@path.berkeley.edu)
 * @author Sean Morris (sean.smorris@gmail.com)
 * 
 */
public class Sensor extends edu.berkeley.path.model_objects.jaxb.Sensor {
   
	//TODO: Deal with Table reference? We are waiting for feedback.
	


	/** Resolved Link Object*/
	/** @y.exclude */ protected Link link;

//	/** Sensor type. */
//	/** @y.exclude */ protected Sensor.Type type;
//
//	/** Type of sensor.
//	 *
//	 * TMC = Traffic Message Channel.
//	 * This is a static way of reporting probe measurements
//	 * employed by INRIX, Navteq, etc.
//	 */
//	public static enum Type	{
//	/** see {@link ObjectFactory#createSensor_LoopStation} 	*/
//		Loop,
//		Magnetic,
//		Radar,
//		Camera,
//		TMC
//	};
				   	   	       
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
//	public Sensor.Type getSensorType() {
//		return type;
//	}
  /**
   * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   *
   * @return CRUD Flag enumeration
   */
  @Override
  public CrudFlag getCrudFlag() {
    return super.getCrudFlag();
  }

  /**
   * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   *
   * @param flag CRUD Flag enumeration
   */
  @Override
  public void setCrudFlag(CrudFlag flag) {
    super.setCrudFlag(flag);
  }

  public long getSensorTypeId() {
    return getSensorType().getId();
  }

  public void setSensorType(long typeId, String name, String desc) {
    SensorType type = new SensorType();
    type.setId(typeId);
    type.setName(name);
    type.setDescription(desc);
    setSensorType(type);
  }

	/** Link where the sensor is located. */
	//TODO: How are we resolving the link?
	public Link getSensorLink() {
		return link;
	}
	

	/**
	 * @return the displayPosition
	 */
	public Point getSensorDisplayPosition() {
    Point result = null;

    if(super.getDisplayPosition() != null
            && super.getDisplayPosition().getPoint() != null
            && super.getDisplayPosition().getPoint().size() > 0) {

      result = (Point) super.getDisplayPosition().getPoint().get(0);
    }

    return result;
	}


	/**
	 * @param point the point of the sensor (put into a JAXB displayPosition) to set
	 */
	public void setDisplayPosition(Point point) {
    DisplayPosition dp = new DisplayPosition();
    dp.getPoint().add(point);
		super.setDisplayPosition(dp);
	}


	/**
	 * @return the linkPosition
	 */
	public Double getSensorLinkPosition() {
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
//	public LinkReference getSensorLinkReference() {
//		return (LinkReference)super.getLinkReference();
//	}


	/**
	 * @param linkReference the linkReference to set
	 */
//	public void setLinkReference(LinkReference linkReference) {
//		super.setLinkReference(linkReference);
//	}


	/**
	 * @return the parameters
	 */
//	public Parameters getSensorParameters() {
//		return (Parameters)super.getParameters();
//	}


	/**
	 * @param parameters the parameters to set
	 */
//	public void setParameters(Parameters parameters) {
//		super.setParameters(parameters);
//	}


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
		super.setLaneNumber(laneNumber);
	}

	/**
	 * @return the healthStatus
	 */
//	public Double getHealthStatus() {
//		return super.getHealthStatus();
//	}

	/**
	 * @param healthStatus the healthStatus to set
	 */
//	public void setHealthStatus(double healthStatus) {
//		super.setHealthStatus(healthStatus);
//	}
	
    /**
     * Sets the value of the dataFeedId property.
     * 
     * @param feedId
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDataFeedId(Long feedId) {
        super.setDataFeedId(feedId);
    }

	/**
	 * Sets the value of the sensor original id property.
	 * 
	 * @param entityId the entityId to set for sensorIdOriginal
	 */
	public void setSensorOriginalId(String entityId) {
		super.setSensorIdOriginal(entityId);
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
	 * Sets the value of the link id property.
	 * 
	 * @param linkId the linkId to set 
	 */
	public void setLinkId(Long linkId) {
		super.setLinkId(linkId);
	}

	/**
	 * Sets the value of the link offset property.
	 * 
	 * @param linkOffset the linkOffset to set
	 */
	public void setLinkOffset(Double linkOffset) {  
		super.setLinkOffset(linkOffset);		
	}

	/** 
	 * Sensor validation checks
	 *
	 * @return  True if all sensor validation is correct
	 */
	//TODO: Wait for writers to implement
	public final Boolean isValid() {
		boolean isValid = true;
		  
		
		return isValid;
	}


}
