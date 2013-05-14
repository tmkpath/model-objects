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

/**
 * Model Object Fundamental Diagram class.
 *  
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 */
public class FundamentalDiagram extends edu.berkeley.path.model_objects.jaxb.FundamentalDiagram{
	
	/**
	 * Return capacity as double
	 * 
	 * @return capacity as double
	 */
	@Override
	public double getCapacity() {
	  return super.getCapacity();
	}
	
	/**
	 * Set capacity as double
	 * 
	 * @param capacity as double
	 */
	@Override
	public void setCapacity(double cap) {
	  super.setCapacity(cap);
	}
	
	/**
	 * Return free flow speed as double
	 * 
	 * @return free flow speed as double
	 */
	@Override
	public double getFreeFlowSpeed() {
	  return super.getFreeFlowSpeed();
	}
	
	/**
	 * Set free flow speed as double
	 * 
	 * @param free flow speed as double
	 */
	@Override
	public void setFreeFlowSpeed(double vf) {
	  super.setFreeFlowSpeed(vf);
	}
	
	/**
	 * Return congestion speed as double
	 * 
	 * @return congestion speed as double
	 */
	@Override
	public double getCongestionSpeed() {
	  return super.getCongestionSpeed();
	}
	
	/**
	 * Set congestion speed as double
	 * 
	 * @param congestion speed as double
	 */
	@Override
	public void setCongestionSpeed(double w) {
	  super.setCongestionSpeed(w);
	}
	
	/**
	 * Return critical speed as double
	 * 
	 * @return critical speed as double
	 */
	@Override
	public Double getCriticalSpeed() {
	  return super.getCriticalSpeed();
	}
	
	/**
	 * Set critical speed as double
	 * 
	 * @param critical speed as double
	 */
	@Override
	public void setCriticalSpeed(Double speed) {
	  super.setCriticalSpeed(speed);
	}
	
	/**
	 * Return jam density as double
	 * 
	 * @return jam density as double
	 */
	@Override
	public Double getJamDensity() {
	  return super.getJamDensity();
	}
	
	/**
	 * Set jam density as double
	 * 
	 * @param jam density as double
	 */
	@Override
	public void setJamDensity(Double d) {
	  super.setJamDensity(d);
	}
	
	/**
	 * Return capacity drop as double
	 * 
	 * @return capacity drop as double
	 */
	@Override
	public double getCapacityDrop() {
	  return super.getCapacityDrop();
	}
	
	/**
	 * Set capacity drop as Double
	 * 
	 * @param capacity drop as Double
	 */
	@Override
	public void setCapacityDrop(Double d) {
	  super.setCapacityDrop(d);
	}
	
	/**
	 * Return capacity standard deviation as Double
	 * 
	 * @return capacity standard deviation as Double
	 */
	@Override
	public Double getStdDevCapacity() {
	  return super.getStdDevCapacity();
	}
	
	/**
	 * Set capacity standard deviation as Double
	 * 
	 * @param capacity standard deviation as Double
	 */
	@Override
	public void setStdDevCapacity(Double d) {
	  super.setStdDevCapacity(d);
	}
	
	/**
	 * Return free flow speed standard deviation as Double
	 * 
	 * @return free flow speed standard deviation as Double
	 */
	@Override
	public Double getStdDevFreeFlowSpeed() {
	  return super.getStdDevFreeFlowSpeed();
	}
	
	/**
	 * Set free flow speed standard deviation as Double
	 * 
	 * @param free flow speed standard deviation as Double
	 */
	@Override
	public void setStdDevFreeFlowSpeed(Double d) {
	  super.setStdDevFreeFlowSpeed(d);
	}
	
	/**
	 * Return congestion speed standard deviation as Double
	 * 
	 * @return congestion speed standard deviation as Double
	 */
	@Override
	public Double getStdDevCongestionSpeed() {
	  return super.getStdDevCongestionSpeed();
	}
	
	/**
	 * Set congestion speed standard deviation as Double
	 * 
	 * @param congestion speed standard deviation as Double
	 */
	@Override
	public void setStdDevCongestionSpeed(Double d) {
	  super.setStdDevCongestionSpeed(d);
	}	
	
	/**
	 * Return FD id as long
	 * 
	 * @return FD id as long
	 */
	@Override
	public long getId() {
	  return super.getId();
	}
	
	/**
	 * Set FD id as long
	 * 
	 * @param FD id
	 */
	@Override
	public void setId(long l) {
	  super.setId(l);
	}	
	
	/**
	 * Return FD order as int
	 * 
	 * @return FD order
	 */
	@Override
	public int getOrder() {
	  return super.getOrder();
	}
	
	/**
	 * Set FD order as int
	 * 
	 * @param FD order
	 */
	@Override
	public void setOrder(int i) {
	  super.setOrder(i);
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

    /**
     * Set the mod stamp
     *
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
