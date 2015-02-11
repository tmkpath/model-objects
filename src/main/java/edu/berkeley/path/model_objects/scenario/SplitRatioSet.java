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

public class SplitRatioSet extends edu.berkeley.path.model_objects.jaxb.SplitRatioSet {

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
		getSplitRatioProfile().clear();
		getSplitRatioProfile().addAll((List<edu.berkeley.path.model_objects.jaxb.SplitRatioProfile>)(List<?>)ratios);
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
     * Get Network ID associated with profile
     *
     * @return network ID
     */
    @Override
    public long getNetworkId() {
        return super.getNetworkId();
    }

    /**
     * Set Network ID associated with profile
     *
     * @param id of network to associate profile with
     */
    @Override
    public void setNetworkId(long id) {
        super.setNetworkId(id);
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
	 * @return True if valid
	 */
	public boolean isValid(){
    // TODO - validation logic
		return true;
	}


}
