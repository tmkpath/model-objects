package edu.berkeley.path.model_objects.shared;

import java.util.ArrayList;
import java.util.List;


public class Parameters extends edu.berkeley.path.model_objects.jaxb.Parameters{

	/**
	 * Gets the value of the parameters property.
     * 
	 * @return ArrayList<Parameter> the list of parameters
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Parameter> getParameters() {
		return (ArrayList<Parameter>)(ArrayList<?>) super.getParameter();
	}	
	
	
	/**
	 * Set the parameters list. Attaches list of Parameter Model Objects to scenario.
	 * 
	 * @param List<Parameter>	List of extended Parameters to add
	 */
	public void setParameters(List<Parameter> parameters) {
		 List<edu.berkeley.path.model_objects.jaxb.Parameter> pSet = (ArrayList<edu.berkeley.path.model_objects.jaxb.Parameter>)parameter;
		 if ( pSet == null ) 
			  pSet = new ArrayList<edu.berkeley.path.model_objects.jaxb.Parameter>();  
		
		pSet.clear();
		pSet.addAll(parameters);
		parameter = pSet;
	}
	
	/**
	 *  Add the parameter to the parameters list.
	 *  
	 * 
	 * @param Parameter	Parameter to add
	 */
	public void setParameter(Parameter p) {
		getParameters().add(p);
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
     * Format: DD-MON-YYYY HH:MM:SS
     * 
     * @param String value
     *     
     */
	@Override
    public void setModStamp(String value) {
        super.setModStamp(value);
    }
	
}