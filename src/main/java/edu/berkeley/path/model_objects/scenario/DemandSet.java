/**
 * Copyright (c) 2013 The Regents of the University of California.
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
 * 3. Neither the name of the University nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
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

import edu.berkeley.path.model_objects.shared.CrudFlag;

public class DemandSet extends edu.berkeley.path.model_objects.jaxb.DemandSet {

	 /**
	  * Get modstamp
	  * @return
	  */
	@Override
	public String getModStamp() {
        return modStamp;
    }
	
	/**
	 * Set modstamp
	 * @param value
	 */
	@Override
    public void setModStamp(String value) {
        this.modStamp = value;
    }
	
	/**
	 * Set value by name
	 * @param Object_Parameter
	 * @
	 */
	public void setByName(Object_Parameter p) {
		
		if (p.name.compareToIgnoreCase("id") == 0 ) setId(p.intParam);
		else if (p.name.compareToIgnoreCase("description") == 0 ) setDescription(p.strParam);
		else if (p.name.compareToIgnoreCase("projectId") == 0 ) setProjectId(p.intParam);
		else if (p.name.compareToIgnoreCase("name") == 0 ) setName(p.strParam);	
		else if (p.name.compareToIgnoreCase("ModStamp") == 0 ) setModStamp(p.strParam);	
	}
	
	/**
	 * Get an array of all parameters
	 * 
	 * @return Object_Parameter array
	 */
	public Object_Parameter[] getAll() {
		
		Object_Parameter[] params = new Object_Parameter[6];
		
		params[0] = new Object_Parameter("id", getId(), 0.0F, null);
		params[1] = new Object_Parameter("description", 0, 0.0F, description);
		params[2] = new Object_Parameter("projectId", getProjectId(), 0.0F, null);
		params[3] = new Object_Parameter("name", 0, 0.0F, getName());
		params[4] = new Object_Parameter("ModStamp", 0, 0.0F, getModStamp());
		params[5] = new Object_Parameter("crud", getCrudFlagEnum().ordinal(), 0.0F, null);
		
		Object_Parameter.setPositions(params);
		
		return params;

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
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
	@Override
	public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @Override
    public void setDescription(String value) {
        this.description = value;
    }

	/**
	 * Get DemandProfile list
	 * @return DemandProfile list
	 */
    @SuppressWarnings("unchecked")
    public List<DemandProfile> getDemandProfileList() {
    	
        if (demandProfile == null) {
        	
        	demandProfile = new ArrayList<edu.berkeley.path.model_objects.jaxb.DemandProfile>();
        }
        return (List<DemandProfile>)(List<?>)this.demandProfile;
    }

    /**
     * Set DemandProfile list
     * @param DemandProfile list
     */
	@SuppressWarnings("unchecked")
	public void setDemandProfileList(List<DemandProfile> dpList) {

		if ( demandProfile == null ) {
			
		  demandProfile = new ArrayList<edu.berkeley.path.model_objects.jaxb.DemandProfile>();  
		}
		demandProfile.clear();
		demandProfile.addAll((List<edu.berkeley.path.model_objects.jaxb.DemandProfile>)(List<?>)dpList);
	}
	  
    /**
     * Gets the value of the projectId property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    @Override
    public long getProjectId() {
            return projectId;
    }

    /**
     * Sets the value of the projectId property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    @Override
    public void setProjectId(long value) {
        this.projectId = value;
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
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    @Override
    public String getName() {
        if (name == null) {
            return "";
        } else {
            return name;
        }
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @Override
    public void setName(String value) {
        this.name = value;
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

  /**
   * Gets the value of the demandProfile property.
   *
   *
   * @return List<DemandProfile>
   *
   *
   */
  @SuppressWarnings("unchecked")
  public List<DemandProfile> getListOfDemandProfiles() {
    // return casted list of Nodes from JAXB base class
    return (List<DemandProfile>)(List<?>)super.getDemandProfile();
  }

  /**
   * Set the demands profiles list. Attaches list of Demand Profile Model Objects to set.
   *
   * @param List<Demand>	List of extended Demand Profiles to add
   */
  @SuppressWarnings("unchecked")
  public void setListOfDemandProfiles(List<DemandProfile> demands) {
    List<edu.berkeley.path.model_objects.jaxb.DemandProfile> profiles = super.getDemandProfile();
    if ( profiles == null ) {
      profiles = new ArrayList<edu.berkeley.path.model_objects.jaxb.DemandProfile>();
    }
    profiles.clear();
    profiles.addAll((List<edu.berkeley.path.model_objects.jaxb.DemandProfile>)(List<?>)demands);
    super.demandProfile = profiles;
  }


  /**
   * Get the profile at the specified link.
   * Returns DemandProfile associated with link id passed in.
   * If there are no profiles associated with this link id null is returned.
   *
   * @param linkId get demand profile associated with the link id
   * @return DemandProfile or null if not found
   */
  public DemandProfile getDemandProfileAtLink(long linkId) {

    for(DemandProfile p : getListOfDemandProfiles()) {
      if(p.getLinkIdOrg() == linkId) {
        return p;
      }
    }
    // Otherwise not found so return null
    return null;
  }
    
}
