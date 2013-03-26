package edu.berkeley.path.model_objects.scenario;

import java.util.ArrayList;
import java.util.List;

public class VehicleTypeOrder extends edu.berkeley.path.model_objects.jaxb.VehicleTypeOrder {
	/**
	 * Gets the list of Vehicle Types
	 * 
	 * @return List<VehicleType> List of vehicle types
	 */
 	@SuppressWarnings("unchecked")
	public List<VehicleType> getListOfVehicleType() {
		// return casted list of Vehicle types from JAXB base class
		return (List<VehicleType>)(List<?>)super.getVehicleType();
    }

	/**
	 * Set the vehicletypes list. Attaches list of VehicleType Model Objects to scenario.
	 * 
	 * @param List<VehilceType>	List of extended Vehicle Types to add
	 */
	@SuppressWarnings("unchecked")
	public void setListOfVehicleType(List<VehicleType> types) {
			List<edu.berkeley.path.model_objects.jaxb.VehicleType> vehs = super.getVehicleType();
			if ( vehs == null ) {
			  vehs = new ArrayList<edu.berkeley.path.model_objects.jaxb.VehicleType>();  
			}
			vehs.clear();
			vehs.addAll((List<edu.berkeley.path.model_objects.jaxb.VehicleType>)(List<?>)types);
			vehicleType = vehs;
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
