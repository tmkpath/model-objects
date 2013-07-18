/**
 * Copyright (c) 2012, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *   Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 **/

package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.MOException;
import edu.berkeley.path.model_objects.shared.CrudFlag;

public class Splitratio extends edu.berkeley.path.model_objects.jaxb.Splitratio {

  // array of ratios derived from comma separated content string
  /** @y.exclude */ private Double[] ratios;
    
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
	 * @param split ratio(s) content String as comma separated double string values
   *  otherwise throws exception
   * @throws MOException
   *
	 */
	public void setRatios(String content) throws MOException {

    // Create array representation of split rations indexed by dt
    try {
      String[] contentArray = content.split(",");
      ratios = new Double[contentArray.length];
      // For each value separated by a comma, add it to ratios array
      for (int i = 0; i < contentArray.length; i++) {
        ratios[i] = Double.valueOf(contentArray[i]);
      }
    }
    catch (Exception ex) {
      throw new MOException(ex,
          "Invalid split ratio content string. Should be a comma separated string of double values.");
    }

    // set ratio content string
    super.setContent(content);
	}
	
	/**
	 * @return the split ratio(s) content String as a comma separated values
	 */
	public String getRatiosContent() {
		return super.getContent();
	}

  /**
   * @return the split ratio(s) as a array of doubles indexed by dt
   */
  public Double[] getRatiosArray() {
    return ratios;
  }

	  
	/**
	 * @param id the vehicle type id for this ratio
	 */
	@Override
	public void setVehicleTypeId(long id) {
		super.setVehicleTypeId(id);
	}
	
	/**
	 * @return the vehicle type id for this ratio
	 */
	@Override
	public long getVehicleTypeId() {
		return super.getVehicleTypeId();
	}

	
	/**
	 * Returns true if the linkInId, linkOutId, and vehTypeId all match
	 * the corresponding fields of this object
	 * 
	 * @return boolean 
	 */
	public boolean equals(long linkInId, long linkOutId,long vehTypeId){
		return linkInId == this.getLinkIn() && linkOutId == this.getLinkOut() && vehTypeId == this.getVehicleTypeId();
	}
	
	/**
	 * Checks to make sure the object is correct
	 * @return boolean
	 */
	public boolean isValid(){
		return true;
	}

	/**
	 * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	 *
	 * @return CRUD Flag enumeration
	 */
	public CrudFlag getCrudFlagEnum() {

		CrudFlag flag = null;
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (super.getCrudFlag() == null) {
			setCrudFlagEnum(CrudFlag.NONE);
			flag = CrudFlag.NONE;
		}
		else {
			switch (CrudFlag.valueOf(super.getCrudFlag())) {
				case CREATE:
					flag = CrudFlag.CREATE;
					break;
				case RETRIEVE:
					flag = CrudFlag.RETRIEVE;
					break;
				case UPDATE:
					flag = CrudFlag.UPDATE;
					break;
				case DELETE:
					flag = CrudFlag.DELETE;
					break;
				default:
					flag = CrudFlag.NONE;
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
