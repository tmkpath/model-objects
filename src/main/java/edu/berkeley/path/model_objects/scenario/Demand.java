/**
 * Copyright (c) 2013, Regents of the University of California
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

/** 
 * Model Object Demand class.
 *  
 * @author Alexey Goder (alexey@goder.com)
 */
public class Demand extends edu.berkeley.path.model_objects.jaxb.Demand {

  // array of demands derived from comma separated content string
  /** @y.exclude */ private Double[] demands;

	/**
	 * Set value by name
	 * @param Object_Parameter
	 * @
	 */
	public void setByName(Object_Parameter p) {

		if (p.name.compareToIgnoreCase("flow") == 0 ) 		setContent(String.valueOf(p.fltParam));
		else if (p.name.compareToIgnoreCase("vehTypeId") == 0 ) 	setVehicleTypeId(p.intParam);
		else if (p.name.compareToIgnoreCase("modStamp") == 0 ) 		setModStamp(p.strParam);
		
	}

	
	/**
	 * Get an array of all parameters
	 * 
	 * @return
	 */
	public Object_Parameter[] getAll() {
		
		Object_Parameter[] params = new Object_Parameter[7];

		params[0] = new Object_Parameter("flow", 0, Double.parseDouble(getContent()), null);
		params[1] = new Object_Parameter("vehTypeId", vehicleTypeId, 0.0F, null);
		params[2] = new Object_Parameter("modStamp", 0, 0.0F, modStamp);
		params[3] = new Object_Parameter("crud", getCrudFlagEnum().ordinal(), 0.0F, null);
		
		Object_Parameter.setPositions(params);
		
		return params;
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
   * @param demand(s) content String as comma separated double string values
   *  otherwise throws exception
   * @throws MOException
   *
   */
  public void setDemands(String content) throws MOException {

    // Create array representation of demands indexed by dt
    try {
      String[] contentArray = content.split(",");
      demands = new Double[contentArray.length];
      // For each value separated by a comma, add it to ratios array
      for (int i = 0; i < contentArray.length; i++) {
        demands[i] = Double.valueOf(contentArray[i]);
      }
    }
    catch (Exception ex) {
      throw new MOException(ex,
          "Invalid demand content string. Should be a comma separated string of double values.");
    }

    // set ratio content string
    super.setContent(content);
  }

  /**
   * @return the demand(s) content String as a comma separated values
   */
  public String getDemandsContent() {
    return super.getContent();
  }

  /**
   * @return the demand(s) as a array of doubles indexed by dt
   */
  public Double[] getDemandsArray() {
    return demands;
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
}
