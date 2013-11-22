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


import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.shared.DateTime;

import java.util.List;

/** 
 * Model Object Fundamental Diagram Profile class.
 *  
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 */
public class FundamentalDiagramProfile extends edu.berkeley.path.model_objects.jaxb.FundamentalDiagramProfile{
	
	/**
	 * Return list of FD objects
	 * 
	 * @return FD list as List<FundamentalDiagram>
	 */
	@SuppressWarnings("unchecked")
	public List<FundamentalDiagram> getListOfFDs() {
	  List<edu.berkeley.path.model_objects.jaxb.FundamentalDiagram> fdList = super.getFundamentalDiagram();
	  // return casted list of Nodes from JAXB base class
      return (List<FundamentalDiagram>)(List<?>)fdList;
    }

	/**
	 * Set list of FD objects
	 * 
	 */
	public void setListOfFDs(List<FundamentalDiagram> fdList) {
		getFundamentalDiagram().clear();
		getFundamentalDiagram().addAll(fdList);
	}
	
	/**
	 * Return Link ID of the FD profile
	 * 
	 * @return linkId as long
	 */
	@Override
	public Long getLinkId() {
	  return super.getLinkId();
	}
	
	/**
	 * Set Link ID of the FD profile
	 * 
	 * @param linkId as long
	 */
	@Override
	public void setLinkId(Long linkId) {
	  super.setLinkId(linkId);
	}
	
	/**
	 * Return start time of the FD profile
	 * 
	 * @return startTime as double
	 */
	@Override
	public double getStartTime() {
	  return super.getStartTime();
	}
	
	/**
	 * Set start time of the FD profile
	 * 
	 * @param startTime as double
	 */
	@Override
	public void setStartTime(Double startTime) {
	  super.setStartTime(startTime);
	}
	
	/**
	 * Return dt of the FD profile
	 * 
	 * @return dt as double
	 */
	@Override
	public Double getDt() {
	  return super.getDt();
	}
	
	/**
	 * Set dt of the FD profile
	 * 
	 * @param dt as double
	 */
	@Override
	public void setDt(Double dt) {
	  super.setDt(dt);
	}
	
	/**
	 * Return FDProfile id as long
	 * 
	 * @return FD id as long
	 */
	@Override
	public long getId() {
	  return super.getId();
	}
	
	/**
	 * Set FDProfile id as long
	 * 
	 * @param l FD id
	 */
	@Override
	public void setId(long l) {
	  super.setId(l);
	}
	
	/**
	 * Return Calibration Algorithm Type id as CalibrationAlgorithmType
	 * 
	 * @return Calibration Algorithm Type id as CalibrationAlgorithmType
	 */
	@Override
	public CalibrationAlgorithmType getCalibrationAlgorithmType() {
	  return (CalibrationAlgorithmType)super.getCalibrationAlgorithmType();
	}
	
	/**
	 * Set Calibration Algorithm Type id as Integer
	 * 
	 * @param type Calibration Algorithm Type id
	 */
	public void setCalibrationAlgorithmType(CalibrationAlgorithmType type) {
	  super.setCalibrationAlgorithmType(type);
	}
	
	/**
	 * Return Aggregation Run id as Long
	 * 
	 * @return Aggregation Run id as Long
	 */
	@Override
	public Long getAggRunId() {
	  return super.getAggRunId();
	}
	
	/**
	 * Set Aggregation Run id as Long
	 * 
	 * @param l Aggregation Run id as Long
	 */
	@Override
	public void setAggRunId(Long l) {
	  super.setAggRunId(l);
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
	 * @param flag CRUD Flag enumeration
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

    /**
     * Set the fundamental Diagram Type
     *
     * @param type Fundamental Diagram Type
     */
    public void setFundamentalDiagramType(FundamentalDiagramType type) {
      super.setFundamentalDiagramType(type);
    }

    /**
     * Get the fundamental Diagram Type
     *
     * @return Fundamental Diagram Type object
     */
    @Override
    public FundamentalDiagramType getFundamentalDiagramType() {
      return (FundamentalDiagramType)super.getFundamentalDiagramType();
    }


	public FundamentalDiagram getFD(String time) {
		DateTime dateTime = new DateTime();
		org.joda.time.DateTime joda = dateTime.setDateString("1970-01-01 00:00:00");
		long milliseconds1 = joda.getMillis();

		DateTime dateTime2= new DateTime();
		org.joda.time.DateTime joda2 = dateTime2.setDateString("1970-01-01 " + time);
		long milliseconds2 = joda2.getMillis();

		long daySeconds = ((milliseconds2  - milliseconds1) / 1000) + 1;
		int offset = (int)Math.floor(daySeconds / this.getDt());

		if(getListOfFDs().size() > offset) {
			return getListOfFDs().get(offset);
		} else {
			throw new IllegalStateException("Error, cannot find fundamental diagram for time " + time + " (offset " + offset + ").");
		}
	}

	public FundamentalDiagram getFD(long offsetTime) {
		int offset = (int)Math.floor(offsetTime / this.getDt());

		if(getListOfFDs().size() > offset) {
			return getListOfFDs().get(offset);
		} else {
			throw new IllegalStateException("Error, cannot find fundamental diagram for offset time " + offsetTime + " (offset " + offset + ").");
		}
	}
}
