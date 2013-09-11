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

import java.util.ArrayList;
import java.util.List;

import edu.berkeley.path.model_objects.scenario.FundamentalDiagramProfile;

public class FundamentalDiagramSet extends edu.berkeley.path.model_objects.jaxb.FundamentalDiagramSet{
	
	
	/**
	 * Returns the FundamentalDiagramProfile associated with the given linkId
	 *  
	 * @param linkId the link id associated with the profile
	 * @return FundamentalDiagramProfile associated with linkId
	 */
	 public FundamentalDiagramProfile getFundamentalDiagramProfile(int linkId) {
	        for(FundamentalDiagramProfile fdp : this.getListOfFundamentalDiagramProfiles()) {
	        	if(fdp.getLinkId() == linkId) {
	        		return fdp;
            }
          }
	        return null;
	 }
	 
	 /**
	  * Returns the FundamentalDiagramProfile associated with the given sensorId
	  *  
	  * @param sensorId the sensor id associated with the profile
	  * @return FundamentalDiagramProfile associated with sensorId
	  */
	 public FundamentalDiagramProfile getFundamentalDiagramProfileBySensor(long sensorId) {
		 for(FundamentalDiagramProfile fdp : this.getListOfFundamentalDiagramProfiles()) {
			 if(fdp.getSensorId() == sensorId) {
				 return fdp;
			 }
		 }
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
     * Gets FundamentalDiagramProfiles.
     * 
     * @return List<FundamentalDiagramProfile> 
     * 
     */
    @SuppressWarnings("unchecked")
    public List<FundamentalDiagramProfile> getListOfFundamentalDiagramProfiles() {
        return (List<FundamentalDiagramProfile>)(List<?>)super.getFundamentalDiagramProfile();
    }

	/**
	 * Set the fundamental diagram profiles list. Attaches list of Fundamental Diagram Profile Model Objects to set.
	 * 
	 * @param List<FundamentalDiagramProfile>	List of extended Fundamental Diagram Profiles to add to set
	 */
	@SuppressWarnings("unchecked")
	public void setListOfFundamentalDiagramProfiles(List<FundamentalDiagramProfile> profiles) {
		List<edu.berkeley.path.model_objects.jaxb.FundamentalDiagramProfile> profs = super.getFundamentalDiagramProfile();
		if ( profs == null ) {
		  profs = new ArrayList<edu.berkeley.path.model_objects.jaxb.FundamentalDiagramProfile>();  
		}
		profs.clear();
		profs.addAll((List<edu.berkeley.path.model_objects.jaxb.FundamentalDiagramProfile>)(List<?>)profiles);
		fundamentalDiagramProfile = profs;
	}
	
	/**
	 * Add a fundamental diagram profile to the list or profiles.
	 * 
	 * @param FundamentalDiagramProfile	List of extended Fundamental Diagram Profiles to add to set
	 */
	public void setFundamentalDiagramProfile(FundamentalDiagramProfile profile) {
		List<edu.berkeley.path.model_objects.jaxb.FundamentalDiagramProfile> profs = super.getFundamentalDiagramProfile();
		if ( profs == null ) {
		  profs = new ArrayList<edu.berkeley.path.model_objects.jaxb.FundamentalDiagramProfile>();  
		}
		profs.add((edu.berkeley.path.model_objects.jaxb.FundamentalDiagramProfile)profile);
		fundamentalDiagramProfile = profs;
	}

  /**
   * Function to validate FD set.
   *
   * @return True if FD set is valid
   */
  public Boolean isValid() {
    // TODO: Implement, return true for now.
    return true;
  }
	
    /**
     * Gets the value of the projectId property.
     * 
     * @return long
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
     * Gets the value of the modStamp property.
     * 
     * @return String
     */
    @Override
    public String getModStamp() {
        return super.getModStamp();
    }

    /**
     * Sets the value of the modStamp property.
     * 
     * @param String value
     *     
     */
    @Override
    public void setModStamp(String value) {
        super.setModStamp(value);
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
}
