package edu.berkeley.path.model_objects.scenario;

import java.util.ArrayList;
import java.util.List;

/** Extended class for SplitratioEvent. 
*
* @author Sean Morris (sean.smorris@gmail.com)
* 
*/
public class SplitratioEvent extends edu.berkeley.path.model_objects.jaxb.SplitratioEvent{
	
	/** @y.exclude */ protected VehicleTypeOrder vehicleTypeOrder;
	/** @y.exclude */ protected List<Splitratio> splitratio;

	 /**
	  * Gets the value of the vehicleTypeOrder property.
	  * 
	  * @return
	  *     possible object is
	  *     {@link VehicleTypeOrder }
	  *     
	  */
	 public VehicleTypeOrder getSplitVehicleTypeOrder() {
	     return vehicleTypeOrder;
	 }
	
	 /**
	  * Sets the value of the vehicleTypeOrder property.
	  * 
	  * @param value
	  *     allowed object is
	  *     {@link VehicleTypeOrder }
	  *     
	  */
	 public void setVehicleTypeOrder(VehicleTypeOrder value) {
	     this.vehicleTypeOrder = value;
	 }
	
	 /**
	  * Gets the value of the splitratio property.
	  * 
	  * <p>
	  * Objects of the following type(s) are allowed in the list
	  * {@link Splitratio } 
	  * 
	  */
	 public List<Splitratio> getSplitratioList() {
	     if (splitratio == null) {
	         splitratio = new ArrayList<Splitratio>();
	     }
	     return this.splitratio;
	 }
	 
	 /**
	  * Sets the value of the splitratio list property.
	  * 
	  *	@param value
	  *     allowed object is
	  *     {@link Splitratio }
	  * 
	  */
	 public void setSplitratioList(ArrayList<Splitratio> ratios) {
	    this.splitratio = ratios;
	 }

}
