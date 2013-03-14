package edu.berkeley.path.model_objects.shared;

import java.util.ArrayList;


public class Parameters extends edu.berkeley.path.model_objects.jaxb.Parameters{
	/** @y.exclude */ protected ArrayList<Parameter> parameter = new ArrayList<Parameter>();

	/**
	 * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the model object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parameter }
     * 
	 * @return the list of parameters
	 */
	public ArrayList<Parameter> getParameters() {
		return parameter;
	}	
}