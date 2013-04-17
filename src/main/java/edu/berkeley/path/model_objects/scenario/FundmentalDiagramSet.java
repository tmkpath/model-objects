package edu.berkeley.path.model_objects.scenario;

import java.util.ArrayList;
import java.util.List;
import edu.berkeley.path.model_objects.scenario.FundamentalDiagramProfile;

public class FundmentalDiagramSet extends edu.berkeley.path.model_objects.jaxb.FundamentalDiagramSet{
	
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
     * Gets the value of the fundamentalDiagramProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fundamentalDiagramProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFundamentalDiagramProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FundamentalDiagramProfile }
     * 
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
	@SuppressWarnings("unchecked")
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
    public void setProjectId(Long value) {
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
     * Gets the value of the modStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModStamp() {
        return super.getModStamp();
    }

    /**
     * Sets the value of the modStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModStamp(String value) {
        super.setModStamp(value);
    }
}
