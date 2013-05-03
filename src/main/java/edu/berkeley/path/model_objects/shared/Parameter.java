package edu.berkeley.path.model_objects.shared;

public class Parameter extends edu.berkeley.path.model_objects.jaxb.Parameter {

    /**
     * Gets the value of the name property.
     * 
     * @return String name
     *     
     */
	@Override
    public String getName() {
        return super.getName();
    }

    /**
     * Sets the value of the name property.
     * 
     * @param String name
     *     
     */
	@Override
    public void setName(String value) {
        super.setName(value);
    }

    /**
     * Gets the value of the value property.
     * 
     * @return String associated with name
     *     
     */
	@Override
    public String getValue() {
        return super.getValue();
    }

    /**
     * Sets the value associated with name
     * 
     * @param value
     *     
     */
	@Override
    public void setValue(String value) {
        super.setValue(value);
    }
	
	
    /**
     * Gets the value of the modStamp property.
     * 
     * @return String
     *     
     */
	@Override
    public String getModStamp() {
        return super.getModStamp();
    }

    /**
     * Sets the value of the modStamp property.
     * Format: DD-MON-YYYY HH24:MI:SS.FF6
     * 
     * @param String value
     *     
     */
	@Override
    public void setModStamp(String value) {
        super.setModStamp(value);
    }
}
