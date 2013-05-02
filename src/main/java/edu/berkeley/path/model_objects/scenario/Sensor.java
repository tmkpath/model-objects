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
import edu.berkeley.path.model_objects.shared.Parameters;
import edu.berkeley.path.model_objects.shared.Point;

/** Extended class for sensors. 
 *
 * @author Gabriel Gomes (gomes@path.berkeley.edu)
 * @author Sean Morris (sean.smorris@gmail.com)
 * 
 */
public class Sensor extends edu.berkeley.path.model_objects.jaxb.Sensor {
   
	//Resolved Link Object
	protected Link link;


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

  /**
   * Get SensorType for this object
   *
   * @return SensorType  An object representing the the id, name, and 
   * description for this SensorType 
   */
  @Override
  public SensorType getSensorType() {
		return super.getSensorType();
  }

  /**
   * Convenience method for users to get SensorTypeId directly
   * 
   * @return long The id of the SensorType
   */
  public long getSensorTypeId() {
    return getSensorType().getId();
  }

  /**
   * Set the SensorType for this object based on the parameters passed in.
   * 
   * @param typeId Id of the SensorType
   * @param name Name of the SensorType
   * @param desc Description of the SensorType
   */
  public void setSensorType(long typeId, String name, String desc) {
    SensorType type = new SensorType();
    type.setId(typeId);
    type.setName(name);
    type.setDescription(desc);
    setSensorType(type);
  }

	/**
	 * This method returns the link the Sensor is attached too
	 * 
	 *  @return Link Reference to the link where the sensor is located. 
	 *  
	 */
	public Link getSensorLink() {
		return link;
	}
	

	/**
	 * Return the Display position as a Point object. 
	 * 
	 * @return Point the displayPosition as Point Object; null if not set
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
	 * This is the percentage of the length of the link from the begin node 
	 * where this sensor resides.
	 * 
	 * @return Double the linkPosition as percent from the the begin node
	 */
	@Override
	public Double getLinkPosition() {
		return super.getLinkPosition();
	}


	/**
	 * Set the link position for this sensor
	 * 
	 * @param linkPosition percent away from beginning of link
	 */
	@Override
	public void setLinkPosition(Double linkPosition) {
		super.setLinkPosition(linkPosition);
	}

	
	/**
	 * Get the Link object this sensor is attached too
	 * 
	 * @return LinkReference The link object this sensor is attached too
	 */
	@Override
	public LinkReference getLinkReference() {
		return (LinkReference)super.getLinkReference();
	}


	/**
	 * Sets the link object for this sensor
	 * 
	 * @param linkReference the linkReference to set
	 */
	public void setLinkReference(LinkReference linkReference) {
		super.setLinkReference(linkReference);
	}


	/**
	 * @return Parameters the parameters associated with this sensor
	 */
	@Override
	public Parameters getParameters() {
		return (Parameters)super.getParameters();
	}


	/**
	 * @param Parameters the parameters to set
	 */
	public void setParameters(Parameters parameters) {
		super.setParameters(parameters);
	}


	/**
	 * Get this sensors id
	 * 
	 * @return long the id
	 */
	@Override
	public long getId() {
		return super.getId();
	}


	/**
	 * Set the id for this sensor
	 * 
	 * @param id the id to set
	 */
	@Override
	public void setId(long id) {
		super.setId(id);
	}


	/**
	 * Get the original sensor id
	 * 
	 * @return String the sensorIdOriginal
	 */
	@Override
	public String getSensorIdOriginal() {
		return super.getSensorIdOriginal();
	}


	/**
	 * Set the original sensor id
	 * 
	 * @param sensorIdOriginal the sensorIdOriginal to set
	 */
	@Override
	public void setSensorIdOriginal(String sensorIdOriginal) {
		super.setSensorIdOriginal(sensorIdOriginal);
	}


	/**
	 * Get the lane number the sensor is located in
	 * 
	 * @return int the laneNumber
	 */
	@Override
	public Integer getLaneNumber() {
		return super.getLaneNumber().intValue();
	}


	/**
	 * Set the lane number the sensor is in
	 * 
	 * @param laneNumber the laneNumber to set
	 */
	@Override
	public void setLaneNumber(Integer laneNumber) {
		super.setLaneNumber(laneNumber);
	}

	/**
	 * Get the health status(0 or 1) for this sensor
	 * 
	 * @return int the healthStatus
	 */
	@Override
	public Integer getHealthStatus() {
		return super.getHealthStatus().intValue();
	}

	/**
	 * Set the health status(0 or 1) for this sensor
	 * 
	 * @param healthStatus the healthStatus to set
	 */
	@Override
	public void setHealthStatus(Integer healthStatus) {
		super.setHealthStatus(healthStatus);
	}
	
    /**
     * Sets the value of the dataFeedId property.
     * 
     * @param feedId A long representing the data feed id
     *     
     */
	@Override
    public void setDataFeedId(Long feedId) {
        super.setDataFeedId(feedId);
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
	
	/**
	 * Sets the value of the link id property.
	 * 
	 * @param linkId the linkId to set 
	 */
	@Override
	public void setLinkId(Long linkId) {
		super.setLinkId(linkId);
	}

	/**
	 * Sets the value of the link offset property.
	 * 
	 * @param linkOffset the linkOffset to set
	 */
	@Override
	public void setLinkOffset(Double linkOffset) {  
		super.setLinkOffset(linkOffset);		
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


}
