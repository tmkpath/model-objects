package edu.berkeley.path.model_objects.scenario;

import java.util.ArrayList;
import java.util.List;

import edu.berkeley.path.model_objects.scenario.FundamentalDiagramType;
import edu.berkeley.path.model_objects.scenario.FundamentalDiagramProfile;

public class FundamentalDiagramSet extends edu.berkeley.path.model_objects.jaxb.FundamentalDiagramSet{
	
	
	/**
	 * get the FundamentalDiagramProfile who link if matches the parameter
	 *  
	 * @param linkId the link id associated with the profile
	 * @return FundamentalDiagramProfile associated with linkId
	 */
	 public FundamentalDiagramProfile getFundamentalDiagramProfile(int linkId) {
	        for(FundamentalDiagramProfile fdp : this.getListOfFundamentalDiagramProfiles())
	        	if(fdp.getLinkId() == linkId)
	        		return fdp;
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
    public void setProjectId(Long value) {
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
     * Gets the value of the fundamentalDiagramType property.
     * 
     * @return FundamentalDiagramType
     *     
     */
	@Override
    public FundamentalDiagramType getFundamentalDiagramType() {
        return (FundamentalDiagramType)super.getFundamentalDiagramType();
    }

    /**
     * Sets the value of the fundamentalDiagramType property.
     * 
     * @param FundamentalDiagramType value
     *     
     */
    public void setFundamentalDiagramType(FundamentalDiagramType value) {
        super.setFundamentalDiagramType(value);
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
