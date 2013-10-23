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

import edu.berkeley.path.model_objects.jaxb.DisplayPosition;
import edu.berkeley.path.model_objects.jaxb.LinkReference;
import edu.berkeley.path.model_objects.jaxb.SensorType;
import edu.berkeley.path.model_objects.shared.Parameters;
import edu.berkeley.path.model_objects.shared.Point;
import edu.berkeley.path.model_objects.shared.CrudFlag;

/** Extended class for sensors. 
 *
 * @author Gabriel Gomes (gomes@path.berkeley.edu)
 * @author Sean Morris (sean.smorris@gmail.com)
 * 
 */
public class Sensor extends edu.berkeley.path.model_objects.jaxb.Sensor {

	/**
	 * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	 *
	 * @return CRUD Flag enumeration
	 */
	public CrudFlag getCrudFlagEnum() {

		CrudFlag flag = null;
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (super.getCrudFlag() == null) {
			setCrudFlagEnum(CrudFlag.NONE);
			flag = CrudFlag.NONE;
		}
		else {
			switch (CrudFlag.valueOf(super.getCrudFlag())) {
				case CREATE:
					flag = CrudFlag.CREATE;
					break;
				case RETRIEVE:
					flag = CrudFlag.RETRIEVE;
					break;
				case UPDATE:
					flag = CrudFlag.UPDATE;
					break;
				case DELETE:
					flag = CrudFlag.DELETE;
					break;
				default:
					flag = CrudFlag.NONE;
					break;

			}
		}
		return flag;
	}

	/**
	 * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	 *
	 * @param CRUD Flag enumeration
	 */
	public void setCrudFlagEnum(edu.berkeley.path.model_objects.shared.CrudFlag flag) {
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (flag == null) {
			super.setCrudFlag("NONE");
		}
		else {
			switch (flag) {
				case CREATE:
					super.setCrudFlag("CREATE");
					break;
				case RETRIEVE:
					super.setCrudFlag("RETRIEVE");
					break;
				case UPDATE:
					super.setCrudFlag("UPDATE");
					break;
				case DELETE:
					super.setCrudFlag("DELETE");
					break;
				default:
					super.setCrudFlag("NONE");
					break;

			}
		}
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
	 * @return Parameters the parameters associated with this sensor
	 */
	@Override
	public Parameters getParameters() {
		return (Parameters)super.getParameters();
	}


	/**
	 * @param Parameters the parameters to set
	 */
	public void setSensorParameters(Parameters parameters) {
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
   * Get the original link type
   *
   * @return String the linkTypeOriginal
   */
  @Override
  public String getLinkTypeOriginal() {
    return super.getLinkTypeOriginal();
  }


  /**
   * Set the original link type
   *
   * @param LinkTypeOriginal the LinkTypeOriginal to set
   */
  @Override
  public void setLinkTypeOriginal(String linkTypeOriginal) {
    super.setLinkTypeOriginal(linkTypeOriginal);
  }


	/**
	 * Get the lane number the sensor is located in
	 * 
	 * @return int the laneNumber
	 */
	@Override
	public Integer getLaneNumber() {
		return super.getLaneNumber();
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
	 * Get the health status for this sensor
	 * 
	 * @return double the healthStatus
	 */
	@Override
	public Double getHealthStatus() {
		return super.getHealthStatus();
	}

	/**
	 * Set the health status(0 or 1) for this sensor
	 * 
	 * @param healthStatus the healthStatus to set
	 */
	@Override
	public void setHealthStatus(Double healthStatus) {
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
	   * Gets the value of the dataFeedId property.
	   * 
	   * @return Long
	   *     
	   */
	@Override
	  public Long getDataFeedId() {
	      return dataFeedId;
	  }


	    /**
	     * Gets the value of the javaClass property.
	     * 
	     * @return String
	     *     
	     */
	  	@Override
	    public String getJavaClass() {
	        return super.getJavaClass();
	    }

	    /**
	     * Sets the value of the javaClass property.
	     * 
	     * @param Sting value
	     *     
	     */
	    @Override
	    public void setJavaClass(String value) {
	     super.setJavaClass(value);
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
   * Get the Link id this sensor is attached too
   *
   * @return The link id this sensor is attached too
   */
  @Override
  public Long getLinkId() {
    return super.getLinkId();
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
    // TODO: add Validation
		boolean isValid = true;
		
		return isValid;
	}


}
