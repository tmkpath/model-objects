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
import edu.berkeley.path.model_objects.shared.DateTime;

public class SplitRatioProfile extends edu.berkeley.path.model_objects.jaxb.SplitRatioProfile {

	/**
	 * returns all the split ratios values in this SplitRatioProfile that have the same in and out link.
	 * 
	 * @param link_in_id
	 * @param link_out_id
	 * @param vehicle_type_id
	 * @return Double[]
	 */
	public Double[] getSplitRatio(long link_in_id, long link_out_id, long vehicle_type_id){
		ArrayList<Double> values = new ArrayList<Double>();
		List<Splitratio> ratios = getListOfSplitratios();
		for (Splitratio s : ratios){
			if(s.equals(link_in_id, link_out_id, vehicle_type_id))
				values.add(Double.parseDouble(s.getContent()));
		}
		return values.toArray(new Double[0]);
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
	public double getSplitRatio(long link_in_id, long link_out_id, long vehicle_type_id, String time){
		
		DateTime dateTime = new DateTime();
	    org.joda.time.DateTime joda = dateTime.setDateString("1970-01-01 00:00:00");
	    long milliseconds1 = joda.getMillis();
		
		DateTime dateTime2= new DateTime();
	    org.joda.time.DateTime joda2 = dateTime2.setDateString("1970-01-01 " + time);
	    long milliseconds2 = joda2.getMillis();
		
		long daySeconds = ((milliseconds2  - milliseconds1) / 1000) + 1;
		int offset = (int)Math.floor(daySeconds / this.getDt());
		
		List<Splitratio> ratios = getListOfSplitratios();
		for(Splitratio r : ratios)
		{
			if(r.equals(link_in_id, link_out_id, vehicle_type_id) && r.getRatioOrder() == offset)
				return Double.parseDouble(ratios.get(offset).getContent());				
		}
		return -1;

	}
	

	/**
	 * returns the split ratio value at the offset from the start time of this profile passed in with this in and out link
	 * If the offset is between sample times we return the ratio closer to the beginning of the sample
	 * 
	 * @param link_in_id
	 * @param link_out_id
	 * @param vehicle_type_id
	 * @param integer offset in seconds since start_time of profile
	 * @return the split ratio corresponding to the parameters passed in or -1 if not found
	 */
	public double getSplitRatio(long link_in_id, long link_out_id, long vehicle_type_id, long offsetTime){
		List<Splitratio> ratios = getListOfSplitratios();
		int offset = (int)Math.floor(offsetTime / this.getDt());
		for(Splitratio r : ratios)
		{
			if(r.equals(link_in_id, link_out_id, vehicle_type_id) && r.getRatioOrder() == offset)
				return Double.parseDouble(ratios.get(offset).getContent());				
		}
		return -1;
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
    public long getId() {
        return super.getId();
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        super.setId(value);
    }
    
    /**
     * Gets the value of the nodeId property.
     * 
     */
    public long getNodeId() {
        return super.getNodeId();
    }

    /**
     * Sets the value of the nodeId property.
     * 
     */
    public void setNodeId(long value) {
        super.setNodeId(value);
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getStartTime() {
        return super.getStartTime();
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setStartTime(double value) {
        super.setStartTime(value);
    }

    /**
     * Gets the value of the dt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDt() {
        return super.getDt();
    }

    /**
     * Sets the value of the dt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDt(double value) {
        super.setDt(value);
    }

    /**
     * Gets the value of the destinationNetworkId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDestinationNetworkId() {
        return super.getDestinationNetworkId();
    }

    /**
     * Sets the value of the destinationNetworkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDestinationNetworkId(long value) {
    	 super.setDestinationNetworkId(value);
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
	
	/**
	 * 
	 */
	public SplitRatioProfile clone(){
		SplitRatioProfile prof = new SplitRatioProfile();
		prof.setId(this.getId());
		prof.setNodeId(this.getNodeId());
		prof.setStartTime(this.getStartTime());
		prof.setDt(this.getDt());
		prof.setDestinationNetworkId(this.getDestinationNetworkId());
		prof.setModStamp(this.getModStamp());
		prof.setListOfSplitRatios(this.getListOfSplitratios());
		return prof;
	}
}
