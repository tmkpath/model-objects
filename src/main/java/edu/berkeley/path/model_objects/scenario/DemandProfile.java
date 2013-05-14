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


package edu.berkeley.path.model_objects.scenario;

import java.util.ArrayList;
import java.util.List;

import edu.berkeley.path.model_objects.scenario.Object_Parameter;
import edu.berkeley.path.model_objects.shared.DateTime;


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
	 * Set value by name
	 * @param Object_Parameter
	 * @
	 */
	public void setByName(Object_Parameter p) {
		
		if (p.name.compareToIgnoreCase("id") == 0 ) 				setId(p.intParam);
		else if (p.name.compareToIgnoreCase("demandSetId") == 0 ) 	setDemandSetId(p.intParam);
		else if (p.name.compareToIgnoreCase("knob") == 0 ) 			setKnob(p.fltParam);
		else if (p.name.compareToIgnoreCase("startTime") == 0 ) 	setStartTime(p.fltParam);
		else if (p.name.compareToIgnoreCase("SAMPLERATE") == 0 ) 	setDt(p.fltParam);
		else if (p.name.compareToIgnoreCase("orgLinkId") == 0 ) 	setOrgLinkId(p.intParam);	
		else if (p.name.compareToIgnoreCase("destinationNetworkId") == 0 ) 	setDestinationNetworkId(p.intParam);
		else if (p.name.compareToIgnoreCase("stdDevAdd") == 0 ) 	setStdDevAdd(p.fltParam);
		else if (p.name.compareToIgnoreCase("stdDevMult") == 0 ) 	setStdDevMult(p.fltParam);
		else if (p.name.compareToIgnoreCase("modStamp") == 0 ) 		setModStamp(p.strParam);
		
	}
	 
	/**
	 * Get an array of all parameters
	 * 
	 * @return
	 */
	public Object_Parameter[] getAll() {
		
		Object_Parameter[] params = new Object_Parameter[11];
		
		params[0] = new Object_Parameter("id", getId(), 0.0F, null);
		params[1] = new Object_Parameter("demandSetId", getDemandSetId(), 0.0F, null);
		params[2] = new Object_Parameter("knob", 0, knob, null);
		params[3] = new Object_Parameter("startTime", 0, startTime, null);
		params[4] = new Object_Parameter("SAMPLERATE", 0, dt, null);
		params[5] = new Object_Parameter("orgLinkId", getOrgLinkId(), 0.0F, null);
		params[6] = new Object_Parameter("destinationNetworkId", destinationNetworkId, 0.0F, null);
		params[7] = new Object_Parameter("stdDevAdd", 0, stdDevAdd, null);
		params[8] = new Object_Parameter("stdDevMult", 0, stdDevMult, null);
		params[9] = new Object_Parameter("modStamp", 0, 0.0F, modStamp);
		params[10] = new Object_Parameter("crud", getCrudFlagEnum().ordinal(), 0.0F, null);
		
		Object_Parameter.setPositions(params);
		
		return params;
	}

	/**
	 * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	 *
	 * @return CRUD Flag enumeration
	 */
	public edu.berkeley.path.model_objects.shared.CrudFlag getCrudFlagEnum() {

		edu.berkeley.path.model_objects.shared.CrudFlag flag = null;
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (super.getCrudFlag() == null) {
			setCrudFlagEnum(edu.berkeley.path.model_objects.shared.CrudFlag.NONE);
			flag = edu.berkeley.path.model_objects.shared.CrudFlag.NONE;
		}
		else {
			switch (super.getCrudFlag()) {
				case "CREATE":
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.CREATE;
					break;
				case "RETRIEVE":
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.RETRIEVE;
					break;
				case "UPDATE":
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.UPDATE;
					break;
				case "DELETE":
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.DELETE;
					break;
				default:
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.NONE;
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
	 * Gets the list of Demands
	 * 
	 * @return List<Demand> List of split ratios
	 */
 	@SuppressWarnings("unchecked")
	public List<Demand> getListOfDemands() {
		// return casted list of Demands JAXB base class
		return (List<Demand>)(List<?>)super.getDemand();
    }

	/**
	 * Set the Demand list. 
	 * 
	 * @param List<Demand>	List of extended Demands to add
	 */
	@SuppressWarnings("unchecked")
	public void setListOfDemands(List<Demand> demands) {
			List<edu.berkeley.path.model_objects.jaxb.Demand> list = getDemand();
			if ( list == null ) {
			  list = new ArrayList<edu.berkeley.path.model_objects.jaxb.Demand>();  
			}
			list.clear();
			list.addAll((List<edu.berkeley.path.model_objects.jaxb.Demand>)(List<?>)demands);
			demand = list;
	}
	
	/**
	 * returns all the Demand values in this DemandProfile that have the same vehicle type.
	 * 
	 * @param vehicle_type_id
	 * @return Double[]
	 */
	public Double[] getDemand(long vehicle_type_id){
		ArrayList<Double> values = new ArrayList<Double>();
		List<Demand> list = getListOfDemands();
		for (Demand s : list){
			if(s.getVehTypeId()== vehicle_type_id)
				values.add(Double.parseDouble(s.getContent()));
		}
		return values.toArray(new Double[0]);
	}
	
	/**
	 * returns the Demand value at the offset from the start time of this profile passed in
	 * If the offset is between sample times we return the ratio closer to the beginning of the sample
	 * 
	 * @param vehicle_type_id
	 * @param integer offset in seconds since start_time of profile
	 * @return the Demand corresponding to the parameters passed in or -1 if not found
	 */
	public double getDemand(long vehicle_type_id, long offsetTime){
		List<Demand> list = getListOfDemands();
		int offset = (int)Math.floor(offsetTime / this.getDt());
		for(Demand r : list)
		{
			if(r.getVehTypeId()== vehicle_type_id && r.getDemandOrder() == offset)
				return Double.parseDouble(list.get(offset).getContent());				
		}
		return -1;
	}	
	
	
	/**
	 * returns the Demand value at the time passed in 
	 * If the time falls between sample times we return the ratio closer to the beginning of the sample
	 *
	 * @param vehicle_type_id
	 * @param time String Format : 14:05:00
	 * @return double
	 */
	public double getDemand(long vehicle_type_id, String time){
		
		DateTime dateTime = new DateTime();
	    org.joda.time.DateTime joda = dateTime.setDateString("1970-01-01 00:00:00");
	    long milliseconds1 = joda.getMillis();
		
		DateTime dateTime2= new DateTime();
	    org.joda.time.DateTime joda2 = dateTime2.setDateString("1970-01-01 " + time);
	    long milliseconds2 = joda2.getMillis();
		
		long daySeconds = ((milliseconds2  - milliseconds1) / 1000) + 1;
		int offset = (int)Math.floor(daySeconds / this.getDt());
		
		List<Demand> list = getListOfDemands();
		for(Demand r : list)
		{
			if(r.getVehTypeId()== vehicle_type_id && r.getDemandOrder() == offset)
				return Double.parseDouble(list.get(offset).getContent());				
		}
		return -1;

	}
  
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
	public long getOrgLinkId() {
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
	public void setOrgLinkId(long value) {
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
	public long getDestinationNetworkId() {
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
	public void setDestinationNetworkId(long value) {
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
