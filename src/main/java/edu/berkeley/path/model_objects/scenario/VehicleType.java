package edu.berkeley.path.model_objects.scenario;

public class VehicleType extends edu.berkeley.path.model_objects.jaxb.VehicleType{
	
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
     * Gets the value of the size_factor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSizeFactor() {
        return super.getSizeFactor();
    }

    /**
     * Sets the value of the size_factor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSizeFactor(Double value) {
        super.setSizeFactor(value);
    }
    
    /**
     * Gets the value of the is_standard property.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public Integer getIsStandard() {
        return super.getIsStandard();
    }

    /**
     * Sets the value of the is_standard property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIsStandard(Integer value) {
        super.setIsStandard(value);
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
