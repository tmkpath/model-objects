package edu.berkeley.path.model_objects.scenario;


public class Splitratio extends edu.berkeley.path.model_objects.jaxb.Splitratio implements Comparable<Splitratio>{
	
	
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
	 * @return the split ratio's link in
	 */
	@Override
	public long getLinkIn() {
		return super.getLinkIn();
	}
	
	/**
	 * @param linkIn set the split ratio's link in
	 */
	@Override
	public void setLinkIn(long linkIn) {
		super.setLinkIn(linkIn);
	}
	
	/**
	 * @return the split ratio's link out
	 */
	@Override
	public long getLinkOut() {
		return super.getLinkOut();
	}
	
	/**
	 * @param linkOut set the split ratio's link out
	 */
	@Override
	public void setLinkOut(long linkOut) {
		super.setLinkOut(linkOut);
	}
	
	/**
	 * @param modstamp the modstamp to set
	 */
	@Override
	public void setModStamp(String modstamp) {
		super.setModStamp(modstamp);
	}
	
	/**
	 * @return the modStamp
	 */
	@Override
	public String getModStamp() {
		return super.getModStamp();
	}
	
	/**
	 * @param ratio the ratio of this object
	 */
	public void setRatio(double ratio) {
		super.setContent(ratio + "");
	}
	
	/**
	 * @return the ratio as a double
	 */
	public double getRatio() {
		return Double.parseDouble(super.getContent());
	}

	  
	/**
	 * @param id the vehicle type id for this ratio
	 */
	@Override
	public void setVehTypeId(long id) {
		super.setVehTypeId(id);
	}
	
	/**
	 * @return the vehicle type id for this ratio
	 */
	@Override
	public long getVehTypeId() {
		return super.getVehTypeId();
	}
	
	/**
	 * @param offset the order in the set of ratios
	 */
	@Override
	public void setRatioOrder(int offset) {
		super.setRatioOrder(offset);
	}
	
	/**
	 * @return the vehicle type id for this ratio
	 */
	@Override
	public int getRatioOrder() {
		return super.getRatioOrder();
	}
	
	/**
	 * Returns true if the linkInId, linkOutId, and vehTypeId all match
	 * the corresponding fields of this object
	 * 
	 * @return boolean 
	 */
	public boolean equals(long linkInId, long linkOutId,long vehTypeId){
		return linkInId == this.getLinkIn() && linkOutId == this.getLinkOut() && vehTypeId == this.getVehTypeId();
	}
	
	/**
	 * Checks to make sure the object is correct
	 * @return boolean
	 */
	public boolean isValid(){
		return true;
	}
	
	/**
	 * This method is used in testing to sort the ratios by id.
	 * 
	 * @return int
	 */
	public int compareTo(Splitratio other){
		return (int)(this.getId() - other.getId());
	}

	/**
	 * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	 *
	 * @return CRUD Flag enumeration
	 */
	public edu.berkeley.path.model_objects.shared.CrudFlag getCrudFlagEnum() {

		edu.berkeley.path.model_objects.shared.CrudFlag flag = null;
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (super.getCrudFlag() == null) {
			setCrudFlagEnum(edu.berkeley.path.model_objects.shared.CrudFlag.NONE);
			flag = edu.berkeley.path.model_objects.shared.CrudFlag.NONE;
		}
		else {
			switch (super.getCrudFlag()) {
				case "CREATE":
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.CREATE;
					break;
				case "RETRIEVE":
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.RETRIEVE;
					break;
				case "UPDATE":
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.UPDATE;
					break;
				case "DELETE":
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.DELETE;
					break;
				default:
					flag = edu.berkeley.path.model_objects.shared.CrudFlag.NONE;
					break;

			}
		}
		return flag;
	}

	/**
	 * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	 *
	 * @param CRUD Flag enumeration
	 */
	public void setCrudFlagEnum(edu.berkeley.path.model_objects.shared.CrudFlag flag) {
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (flag == null) {
			super.setCrudFlag("NONE");
		}
		else {
			switch (flag) {
				case CREATE:
					super.setCrudFlag("CREATE");
					break;
				case RETRIEVE:
					super.setCrudFlag("RETRIEVE");
					break;
				case UPDATE:
					super.setCrudFlag("UPDATE");
					break;
				case DELETE:
					super.setCrudFlag("DELETE");
					break;
				default:
					super.setCrudFlag("NONE");
					break;

			}
		}
	}
}
