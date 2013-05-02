package edu.berkeley.path.model_objects.scenario;

public class VehicleType extends edu.berkeley.path.model_objects.jaxb.VehicleType{
	
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
     * @param value
     *     
     */
	@Override
    public void setName(String value) {
        super.setName(value);
    }

    /**
     * Gets the value of the size_factor property.
     * 
     * @return Double
     *     
     */
	@Override
    public Double getSizeFactor() {
        return super.getSizeFactor();
    }

    /**
     * Sets the value of the size_factor property.
     * 
     * @param value Double
     *     
     */
	@Override
    public void setSizeFactor(Double value) {
        super.setSizeFactor(value);
    }
    
    /**
     * Gets the value of the is_standard property.
     * 
     * @return int
     *     
     */
	@Override
    public Integer getIsStandard() {
        return super.getIsStandard();
    }

    /**
     * Sets the value of the is_standard property.
     * 
     * @param value Double
     *     
     */
	@Override
    public void setIsStandard(Integer value) {
        super.setIsStandard(value);
    }

    /**
     * Set the mod stamp
	 * @param modstamp the modstamp to set
	 */
	@Override
	public void setModStamp(String modstamp) {
		super.setModStamp(modstamp);
	}
	
	/**
	 * Get the mod stamp
	 * 
	 * @return the modStamp
	 */
	@Override
	public String getModStamp() {
		return super.getModStamp();
	}
}
