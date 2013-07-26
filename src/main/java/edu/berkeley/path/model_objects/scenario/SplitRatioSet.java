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
import org.joda.time.Interval;

import edu.berkeley.path.model_objects.network.Node;


public class SplitRatioSet extends edu.berkeley.path.model_objects.jaxb.SplitRatioSet {

	/**
	 * This method returns the SplitRatioProfiles with the splitratio field only containing splitratios
	 * occurring within the interval specified. If the interval start time is before the start time of
	 * profile we return none of the ratios.
	 *
	 * If the interval does not match exactly with the start time of the SplitRatioProfile,
	 * we find the next larger start time of the profile and proceed to get the split ratios
	 * up until the end time. If the end time doesn't exactly match end time of the profile,
	 * we again find the next largest time int the profile.
	 *
	 * For Example,
	 * - Interval : 5:05AM to 6:05AM
	 * - Profile StartTime: 5:00AM
	 * - Profile Sample Time: Every 4 Minutes
	 *
	 * - Return ratios from the profile at: 5:08, 5:12 ... 6:00, 6:04
	 *
	 * @param interval
	 * @return List of SplitRatioProfile whose splitratio only contains ratios in the Interval
	 */
  /*public List<SplitRatioProfile> slice(Interval interval) {
	List<SplitRatioProfile> profiles = new ArrayList<SplitRatioProfile>();

    for (SplitRatioProfile profile : getListOfSplitRatioProfiles()) {
      double intervalStart = interval.getStartMillis() / 1000;
      double intervalEnd = interval.getEndMillis() / 1000;

      SplitRatioProfile deepCopyProfile = profile.clone();
      double dt = profile.getDt();
      double t0 = profile.getStartTime();
      int numRatios = profile.getListOfSplitratios().size();

      boolean noSamples = false;

      double tEnd = t0 + (dt * (numRatios - 1));
      int ratioStartIndex = 0;
      //test to see if the interval is completely outside the sample
      if(intervalEnd < t0)
    	  noSamples = true;
      else if(intervalStart > tEnd)
    	  noSamples = true;
      else {
    	  //adjust intervalStart and intervalEnd to multiples of
    	  //samples (t0 + dt * number of sample)
    	  if(intervalStart > t0){
    		  int startSample = (int)t0;
    		  while(startSample < intervalStart){
    			  ratioStartIndex++;
    			  startSample += (int)dt;
    		  }

    		  intervalStart = startSample;
    	  } else if (intervalStart < t0)
      		  intervalStart = t0;


    	  if(intervalEnd > tEnd)
    		  intervalEnd = (int)tEnd;
    	  else if (intervalEnd < tEnd){
    		int endSample = (int)t0;
    		while(endSample < intervalEnd){
  			  endSample += (int)dt;
  		  	}
		  	intervalEnd = endSample;
		  }
      }

      List<Splitratio> ratios = new ArrayList<Splitratio>();
      int index = ratioStartIndex;
      while(intervalStart <= intervalEnd && noSamples == false){
      	ratios.add(profile.getListOfSplitratios().get(index));
      	intervalStart += (int)dt;
      	index++;
      }

      deepCopyProfile.setListOfSplitRatios(ratios);
      profiles.add(deepCopyProfile);

    }
    return profiles;
  } */


  /**
   * Get the profile at the specified node.
   * Return Split Ratio Profile associated with the node passed in.
   * If there are no profiles associated with this node null is returned.
   * 
   * @param nodeId get split ratio profile associated with the node
   * @return SplitRatioProfile or null if not found
   */
  public SplitRatioProfile getSplitRatioProfileAtNode(long nodeId) {

	  for(SplitRatioProfile p : getListOfSplitRatioProfiles()) {
		  if(p.getNodeId() == nodeId) {
			  return p;
      }
    }
    // Otherwise not found so return null
	  return null;
  }

  
    /**
     * Gets the value of the description property.
     * 
     * @return String
     *     
     */
	@Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * Sets the value of the description property.
     * 
     * @param String value
     * 
     */
	@Override
    public void setDescription(String value) {
        super.setDescription(value);
    }

    /**
     * Gets the value of the splitRatioProfile property.
     * 
     * 
     * @return List<SplitRatioProfile>
     * 
     * 
     */
 	@SuppressWarnings("unchecked")
	public List<SplitRatioProfile> getListOfSplitRatioProfiles() {
		// return casted list of Nodes from JAXB base class
		return (List<SplitRatioProfile>)(List<?>)super.getSplitRatioProfile();
    }

	/**
	 * Set the split ratios profiles list. Attaches list of Split Ratio Profile Model Objects to set.
	 * 
	 * @param List<SplitRatioProfile>	List of extended Split Ratio Profiles to add
	 */
	@SuppressWarnings("unchecked")
	public void setListOfSplitRatioProfiles(List<SplitRatioProfile> ratios) {
		List<edu.berkeley.path.model_objects.jaxb.SplitRatioProfile> splits = super.getSplitRatioProfile();
		if ( splits == null ) {
		  splits = new ArrayList<edu.berkeley.path.model_objects.jaxb.SplitRatioProfile>();  
		}
		splits.clear();
		splits.addAll((List<edu.berkeley.path.model_objects.jaxb.SplitRatioProfile>)(List<?>)ratios);
		splitRatioProfile = splits;
	}
	
    /**
     * Gets the value of the projectId property.
     * 
     * @return String
     *     
     */
	@Override
    public long getProjectId() {
        return super.getProjectId();
    }

    /**
     * Sets the value of the projectId property.
     * 
     * @param Long value
     *     
     */
	@Override
    public void setProjectId(long value) {
        super.setProjectId(value);
    }

    /**
     * Gets the value of the id property.
     * 
     * @return long
     */
	@Override
    public long getId() {
        return super.getId();
    }

    /**
     * Sets the value of the id property.
     * 
     * @param long
     * 
     */
	@Override
    public void setId(long value) {
        super.setId(value);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return String
     *     
     */
	@Override
    public String getName() {
        return super.getName();
    }

    /**
     * Sets the value of the name property.
     * 
     * @param String value
     *     
     */
	@Override
    public void setName(String value) {
        super.setName(value);
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
	 * Ensures all required fields are set
	 * 
	 * @return boolean
	 */
	public boolean isValid(){
		return true;
	}


}
