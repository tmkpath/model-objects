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
	 * we find the next smaller start time of the profile and proceed to get the split ratios 
	 * up until the end time. If the end time doesn't exactly match the profile, 
	 * we again find the next smallest time in the List.
	 * 
	 * For Example, 
	 * - Interval : 5:05AM to 6:05AM
	 * - Profile StartTime: 5:00AM
	 * - Profile Sample Time: Every 4 Minutes
	 * 
	 * - Return ratios from the profile at: 5:04, 5:08 ... 6:00, 6:04
	 *     
	 * @param interval
	 * @return List of SplitRatioProfile whose splitratio only contains ratios in the Interval
	 */
  public List<SplitRatioProfile> slice(Interval interval) {
	List<SplitRatioProfile> profiles = new ArrayList<SplitRatioProfile>();
    double intervalStart = interval.getStartMillis() / 1000;
    double intervalEnd = interval.getEndMillis() / 1000;
    
    for (SplitRatioProfile profile : getListOfSplitRatioProfiles()) {
      SplitRatioProfile deepCopyProfile = profile.clone();
      double dt = profile.getDt(); 
      double t0 = profile.getStartTime();
      int numRatios = profile.getListOfSplitratios().size();
      double tEnd = t0 + (dt * (numRatios - 1));
      int nSamples = profile.getListOfSplitratios().size();
      int ratioStartIndex = 0;
      if(intervalEnd < t0)
    	  nSamples = 0;
      else if(intervalStart > tEnd)
    	  nSamples = 0;
      else if(intervalStart > t0){
    	  ratioStartIndex = ((int)(Math.abs(intervalStart - t0) / dt)) + 1;
      }          
      
      List<Splitratio> ratios = new ArrayList<Splitratio>();
      int index = ratioStartIndex;
      while(intervalEnd > (index * dt) + t0 && index < nSamples){
      	ratios.add(profile.getListOfSplitratios().get(index)); 
      	index++;
      }

      deepCopyProfile.setListOfSplitRatios(ratios);
      profiles.add(deepCopyProfile);
    
    }
    return profiles;
  }
    
  
  /**
   * Get the profile at the specified node.
   * Creates a list of SplitRatioProlies associated with the node passed in.
   * If there are no profiles associated with this node null is returned.
   * 
   * @param Node get split ratio profiles associated with the node
   * @return List<SplitRatioProfile> or null if empty
   */
  public List<SplitRatioProfile> getSplitRatioProfileAtNode(Node node) {
	  List<SplitRatioProfile> profiles = new ArrayList<SplitRatioProfile>();
	  for(SplitRatioProfile p : getListOfSplitRatioProfiles())
		  if(p.getNodeId() == node.getId())
			  profiles.add(p);
    
	  return profiles.size() != 0 ? profiles : null;
  }

  

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        super.setDescription(value);
    }

    /**
     * Gets the value of the vehicleTypeOrder property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleTypeOrder }
     *     
     */
    public VehicleTypeOrder getSplitRatioSetVehicleTypeOrder() {
        return (VehicleTypeOrder)super.getVehicleTypeOrder();
    }

    /**
     * Sets the value of the vehicleTypeOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleTypeOrder }
     *     
     */
    public void setVehicleTypeOrder(VehicleTypeOrder value) {
        super.setVehicleTypeOrder(value);
    }

    /**
     * Gets the value of the splitRatioProfile property.
     * 
     * Objects of the following type(s) are allowed in the list
     * {@link SplitRatioProfile }
     * 
     * 
     */
 	@SuppressWarnings("unchecked")
	public List<SplitRatioProfile> getListOfSplitRatioProfiles() {
		// return casted list of Nodes from JAXB base class
		return (List<SplitRatioProfile>)(List<?>)super.getSplitRatioProfile();
    }

	/**
	 * Set the split ratios profiles list. Attaches list of Split Ratio Profile Model Objects to scenario.
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
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getProjectId() {
        return super.getProjectId();
    }

    /**
     * Sets the value of the projectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProjectId(long value) {
        super.setProjectId(value);
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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return super.getName();
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        super.setName(value);
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

}
