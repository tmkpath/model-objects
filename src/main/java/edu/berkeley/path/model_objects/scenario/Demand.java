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

import edu.berkeley.path.model_objects.jaxb.CrudFlag;

/** 
 * Model Object Demand class.
 *  
 * @author Alexey Goder (alexey@goder.com)
 */
public class Demand extends edu.berkeley.path.model_objects.jaxb.Demand {
	
	/**
	 * Set value by name
	 * @param Object_Parameter
	 * @
	 */
	public void setByName(Object_Parameter p) {
		
		if (p.name.compareToIgnoreCase("id") == 0 ) 				setId(p.intParam);
		else if (p.name.compareToIgnoreCase("demandProfId") == 0 ) 	setDemandProfId(p.intParam);
		else if (p.name.compareToIgnoreCase("flow") == 0 ) 		setContent(String.valueOf(p.fltParam));
		else if (p.name.compareToIgnoreCase("vehTypeId") == 0 ) 	setVehTypeId(p.intParam);	
		else if (p.name.compareToIgnoreCase("demandOrder") == 0 ) 	setDemandOrder(p.intParam);
		else if (p.name.compareToIgnoreCase("modStamp") == 0 ) 		setModStamp(p.strParam);
		
	}

	
	/**
	 * Get an array of all parameters
	 * 
	 * @return
	 */
	public Object_Parameter[] getAll() {
		
		Object_Parameter[] params = new Object_Parameter[7];
		
		params[0] = new Object_Parameter("id", id, 0.0F, null);
		params[1] = new Object_Parameter("demandProfId", demandProfId, 0.0F, null);
		params[2] = new Object_Parameter("flow", 0, Double.parseDouble(getContent()), null);
		params[3] = new Object_Parameter("vehTypeId", vehTypeId, 0.0F, null);
		params[4] = new Object_Parameter("demandOrder", demandOrder, 0.0F, null);
		params[5] = new Object_Parameter("modStamp", 0, 0.0F, modStamp);
		params[6] = new Object_Parameter("crud", getCrudFlag().ordinal(), 0.0F, null);
		
		Object_Parameter.setPositions(params);
		
		return params;
		
		
		
	}
		
	  /**
	   * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	   * 
	   * @return CRUD Flag enumeration
	   */
	  @Override
	  public CrudFlag getCrudFlag() {
          // Check if CRUDFlag is null, if so return NONE enumeration
          if (super.getCrudFlag() == null) {
              return CrudFlag.NONE;
          }
          return super.getCrudFlag();
	  }
	  
	  /**
	   * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
	   * 
	   * @param CRUD Flag enumeration
	   */
	  @Override
	  public void setCrudFlag(CrudFlag flag) {
	    super.setCrudFlag(flag);
	  }
	  
	  
	  /**
     * Gets the value of the id property.
     * 
     */
	@Override
	public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
	@Override
	public void setId(long value) {
        this.id = value;
    }	
	
	  /**
     * Gets the value of the DemandProfId property.
     * 
     */
	@Override
	public long getDemandProfId() {
        return demandProfId;
    }

    /**
     * Sets the value of the DemandProfId property.
     * 
     */
	@Override
	public void setDemandProfId(long value) {
        this.demandProfId = value;
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
	 * @param content the content to set
	 */
	@Override
	public void setContent(String content) {
		super.setContent(content);
	}
	
	/**
	 * @return the content
	 */
	@Override
	public String getContent() {
		return super.getContent();
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
	public void setDemandOrder(long offset) {
		super.setDemandOrder(offset);
	}
	
	/**
	 * @return the vehicle type id for this ratio
	 */
	@Override
	public long getDemandOrder() {
		return super.getDemandOrder();
	}

}
