package edu.berkeley.path.model_objects.scenario;


public class Splitratio extends edu.berkeley.path.model_objects.jaxb.Splitratio{
	
	
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
	 * @return the split ratio's link in
	 */
	public long getLinkIn() {
		return super.getLinkIn();
	}
	/**
	 * @param linkIn set the split ratio's link in
	 */
	public void setLinkIn(long linkIn) {
		super.setLinkIn(linkIn);
	}
	/**
	 * @return the split ratio's link out
	 */
	public long getLinkOut() {
		return super.getLinkOut();
	}
	/**
	 * @param linkOut set the split ratio's link out
	 */
	public void setLinkOut(long linkOut) {
		super.setLinkOut(linkOut);
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
	 * @param content the content to set
	 */
	public void setContent(String content) {
		super.setContent(content);
	}
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return super.getContent();
	}

	  
	/**
	 * @param id the vehicle type id for this ratio
	 */
	public void setVehTypeId(long id) {
		super.setVehTypeId(id);
	}
	
	/**
	 * @return the vehicle type id for this ratio
	 */
	public long getVehTypeId() {
		return super.getVehTypeId();
	}
	
	/**
	 * @param offset the order in the set of ratios
	 */
	public void setRatioOrder(int offset) {
		super.setRatioOrder(offset);
	}
	
	/**
	 * @return the vehicle type id for this ratio
	 */
	public int getRatioOrder() {
		return super.getRatioOrder();
	}
	
	public boolean equals(long linkInId, long linkOutId,long vehTypeId){
		return linkInId == this.getLinkIn() && linkOutId == this.getLinkOut() && vehTypeId == this.getVehTypeId();
	}
}
