/**
 * Copyright (c) 2012 The Regents of the University of California.
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
import core.Monitor;
import edu.berkeley.path.model_objects.shared.DateTime;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.MOException;

public class SplitRatioProfile extends edu.berkeley.path.model_objects.jaxb.SplitRatioProfile {

	/**
	 * returns all the split ratios values in this SplitRatioProfile that have the same in and out link.
	 * 
	 * @param link_in_id
	 * @param link_out_id
	 * @param vehicle_type_id
	 * @return Double[]
	 */
	public Double[] getSplitRatio(long link_in_id, long link_out_id, long vehicle_type_id) {
		List<Splitratio> ratios = getListOfSplitratios();
		for (Splitratio s : ratios){
			if(s.equals(link_in_id, link_out_id, vehicle_type_id)) {
        try {
          // Copy ratios arraylist to primative array of doubles
          Double[] ratioValues = new Double[s.getRatioSize()];
          for (int i = 0; i < s.getRatioSize(); i++) {
            ratioValues[i] = s.getRatio(i);
          }
          return ratioValues;
        } catch(MOException exc) {
            Monitor.err("Error, cannot find ratio for link-in " + link_in_id + " and link-out "
                + link_out_id + " and vehicle type id " + vehicle_type_id + ". " + exc.getMessage());
          }
      }
		}
    // otherwise none were found so return empty array
    return new Double[0];
	}
	
	/**
	 * returns the split ratio value at the time passed in with this in and out link
	 * If the time falls between sample times we return the ratio closer to the beginning of the sample
	 *
	 * 
	 * @param link_in_id
	 * @param link_out_id
	 * @param vehicle_type_id
	 * @param time String Format : 14:05:00
	 * @return double
	 */
	public Double getSplitRatio(long link_in_id, long link_out_id, long vehicle_type_id, String time){
		
		DateTime dateTime = new DateTime();
	    org.joda.time.DateTime joda = dateTime.setDateString("1970-01-01 00:00:00");
	    long milliseconds1 = joda.getMillis();
		
		DateTime dateTime2= new DateTime();
	    org.joda.time.DateTime joda2 = dateTime2.setDateString("1970-01-01 " + time);
	    long milliseconds2 = joda2.getMillis();
		
		long daySeconds = ((milliseconds2  - milliseconds1) / 1000) + 1;
    // consider profile start time
    daySeconds -= this.getStartTime();
		int offset = (int)Math.floor(daySeconds / this.getDt());
		
		List<Splitratio> ratios = getListOfSplitratios();
		for(Splitratio r : ratios) {
			if(r.equals(link_in_id, link_out_id, vehicle_type_id)) {
        try {
          // get all ratios values for link in, link out and vehicle type id - indexed by dt
          // check if ratio exists for offset
          if (r.getRatioSize() > offset) {
            return r.getRatio(offset);
          }
        } catch(MOException exc) {
          Monitor.err("Error, cannot find ratio for link-in " + link_in_id + " and link-out "
              + link_out_id + " and vehicle type id " + vehicle_type_id + " and time "
              + time + ". " + exc.getMessage());
        }
      }
		}
		return -1D;

	}
	

	/**
	 * returns the split ratio value at the offset from the start time of this profile passed in with this in and out link
	 * If the offset is between sample times we return the ratio closer to the beginning of the sample
	 * 
	 * @param link_in_id
	 * @param link_out_id
	 * @param vehicle_type_id
	 * @param long offset in seconds since start_time of profile
	 * @return the split ratio corresponding to the parameters passed in or -1 if not found
	 */
	public Double getSplitRatio(long link_in_id, long link_out_id, long vehicle_type_id, long offsetTime) {
		List<Splitratio> ratios = getListOfSplitratios();
		int offset = (int)Math.floor(offsetTime / this.getDt());
		for(Splitratio r : ratios) {
      if(r.equals(link_in_id, link_out_id, vehicle_type_id)) {
        try {
          // get all ratios values for link in, link out and vehicle type id - indexed by dt
          // check if ratio exists for offset
          if (r.getRatioSize() > offset) {
            return r.getRatio(offset);
          }
        } catch(MOException exc) {
          Monitor.err("Error, cannot find ratio for link-in " + link_in_id + " and link-out "
              + link_out_id + " and vehicle type id " + vehicle_type_id + " at offset "
              + offset + ". " + exc.getMessage());
        }
      }
		}
		return -1D;
	}

	/**
	 * Gets the list of Split Ratios
	 * 
	 * @return List<Splitratio> List of split ratios
	 */
 	@SuppressWarnings("unchecked")
	public List<Splitratio> getListOfSplitratios() {
		// return casted list of Nodes from JAXB base class
		return (List<Splitratio>)(List<?>)super.getSplitratio();
    }

	/**
	 * Set the split ratios list. Attaches list of Split Ratio Model Objects to scenario.
	 * 
	 * @param List<Splitratio>	List of extended Split Ratios to add
	 */
	@SuppressWarnings("unchecked")
	public void setListOfSplitRatios(List<Splitratio> ratios) {
			List<edu.berkeley.path.model_objects.jaxb.Splitratio> splits = getSplitratio();
			if ( splits == null ) {
			  splits = new ArrayList<edu.berkeley.path.model_objects.jaxb.Splitratio>();  
			}
			splits.clear();
			splits.addAll((List<edu.berkeley.path.model_objects.jaxb.Splitratio>)(List<?>)ratios);
			splitratio = splits;
	}
	
	
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
     * Gets the value of the nodeId property.
     * 
     * @return long
     * 
     */
    @Override
    public long getNodeId() {
        return super.getNodeId();
    }

    /**
     * Sets the value of the nodeId property.
     * 
     * @param long
     * 
     */
    @Override
    public void setNodeId(long value) {
        super.setNodeId(value);
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return double
     * 
     */
    @Override
    public double getStartTime() {
        return super.getStartTime();
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param Double value
     *     
     */
    @Override
    public void setStartTime(Double value) {
        super.setStartTime(value);
    }

    /**
     * Gets the value of the dt property.
     * 
     * @return Double
     *     
     */
    @Override
    public Double getDt() {
        return super.getDt();
    }

    /**
     * Sets the value of the dt property.
     * 
     * @param Double value
     *     
     */
    @Override
    public void setDt(Double value) {
        super.setDt(value);
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
	 * @return SplitRatioProfile. The deep copy of the this objecgt
	 */
    @Override
	public SplitRatioProfile clone(){
		SplitRatioProfile prof = new SplitRatioProfile();
		prof.setId(this.getId());
		prof.setNodeId(this.getNodeId());
		prof.setStartTime(this.getStartTime());
		prof.setDt(this.getDt());
		prof.setModStamp(this.getModStamp());
		prof.setListOfSplitRatios(this.getListOfSplitratios());
		return prof;
	}
	
}
