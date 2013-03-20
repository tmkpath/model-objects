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

package edu.berkeley.path.model_objects.measurements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.berkeley.path.model_objects.jaxb.Parameters;
import edu.berkeley.path.model_objects.jaxb.PeMSAggregate;
import edu.berkeley.path.model_objects.jaxb.Position;
import edu.berkeley.path.model_objects.shared.DateTime;

/** 
 * Model Object PeMS Station class, comprises the absolute information 
 * corresponding to a PeMS Vehicle Detection Stations (VDS)
 *  
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 */
public class VDS extends edu.berkeley.path.model_objects.jaxb.VDS{
	
	/**
	 * TODO: Validation
	 * TODO: Readers and Writers
	 * TODO: Unit Tests
	 */
	
	/** @y.exclude */ protected String detectorType;
	/** @y.exclude */ protected String detectorName;
	/** @y.exclude */ protected ArrayList<String> userId;
	
	/**
	 * Return type of VDS as String
	 * 
	 * @return type of VDS as String
	 */
	public String getDetectorType() {
		return detectorType;
	}
	
	/**
	 * Set type of VDS as String
	 * 
	 * @param type of VDS as String
	 */
	public void setDetectorType(String detectorType) {
		this.detectorType = detectorType;
	}
	
	/**
	 * Return name of VDS as String
	 * 
	 * @return name of VDS as String
	 */
	public String getDetectorName() {
		return detectorName;
	}

	/**
	 * Set name of VDS as String
	 * 
	 * @param name of VDS as String
	 */
	public void setDetectorName(String detectorName) {
		this.detectorName = detectorName;
	}

	/**
	 * Return user IDs accesing the VDS as ArrayList
	 * 
	 * @return user IDs accesing the VDS as ArrayList
	 */
	public ArrayList<String> getUserId() {
		return userId;
	}

	/**
	 * Set user IDs accesing the VDS as ArrayList
	 * 
	 * @param user IDs accesing the VDS as ArrayList
	 */
	public void setUserId(ArrayList<String> userId) {
		this.userId = userId;
	}


	/**
	 * Return position of VDS
	 * 
	 * @return Position of VDS
	 */
	@Override
	public Position getPosition() {
	  return super.getPosition();
	}
	
	/**
	 * Set position of VDS
	 * 
	 * @param Position of VDS
	 */
	@Override
	public void setPosition(Position position) {
	  super.setPosition(position);
	}
	
	/**
	 * Return parameters of VDS
	 * 
	 * @return parameters of VDS
	 */
	@Override
	public Parameters getParameters() {
	  return super.getParameters();
	}
	
	/**
	 * Set parameters of VDS
	 * 
	 * @param parameters of VDS
	 */
	@Override
	public void setParameters(Parameters parameters) {
	  super.setParameters(parameters);
	}
	
	/**
	 * Return id of VDS as long
	 * 
	 * @return id of VDS as long
	 */
	@Override
	public long getId() {
	  return super.getId();
	}
	
	/**
	 * Set id of VDS as long
	 * 
	 * @param id of VDS as long
	 */
	@Override
	public void setId(long id) {
	  super.setId(id);
	}
	
	/**
	 * Return freeway number of VDS as int
	 * 
	 * @return freeway number of VDS as int
	 */
	@Override
	public int getFreewayNum() {
	  return super.getFreewayNum();
	}
	
	/**
	 * Set freeway number of VDS as int
	 * 
	 * @param freeway number of VDS as int
	 */
	@Override
	public void setFreewayNum(int freewayNum) {
	  super.setFreewayNum(freewayNum);
	}
	
	/**
	 * Return direction of VDS as String
	 * 
	 * @return direction of VDS as String
	 */
	@Override
	public String getDirection() {
	  return super.getDirection();
	}
	
	/**
	 * Set direction of VDS as String
	 * 
	 * @param direction of VDS as String
	 */
	@Override
	public void setDirection(String direction) {
	  super.setDirection(direction);
	}
	
	/**
	 * Return number of lanes of VDS as int
	 * 
	 * @return number of lanes of VDS as int
	 */
	@Override
	public int getLaneCount() {
	  return super.getLaneCount();
	}
	
	/**
	 * Set number of lanes of VDS as int
	 * 
	 * @param number of lanes of VDS as int
	 */
	@Override
	public void setLaneCount(int laneCount) {
	  super.setLaneCount(laneCount);
	}
	
	/**
	 * Return district of VDS as int
	 * 
	 * @return district of VDS as int
	 */
	@Override
	public int getDistrict() {
	  return super.getDistrict();
	}
	
	/**
	 * Set district of VDS as int
	 * 
	 * @param district of VDS as int
	 */
	@Override
	public void setDistrict(int district) {
	  super.setDistrict(district);
	}
	
	/**
	 * Return county of VDS as String
	 * 
	 * @return county of VDS as String
	 */
	@Override
	public String getCounty() {
	  return super.getCounty();
	}
	
	/**
	 * Set county of VDS as String
	 * 
	 * @param county of VDS as String
	 */
	@Override
	public void setCounty(String county) {
	  super.setCounty(county);
	}
	
	/**
	 * Return city of VDS as String
	 * 
	 * @return city of VDS as String
	 */
	@Override
	public String getCity() {
	  return super.getCity();
	}
	
	/**
	 * Set city of VDS as String
	 * 
	 * @param city of VDS as String
	 */
	@Override
	public void setCity(String city) {
	  super.setCity(city);
	}
	
	/**
	 * Return state post mile of VDS as double
	 * 
	 * @return state post mile of VDS as double
	 */
	@Override
	public double getStatePostmile() {
	  return super.getStatePostmile();
	}
	
	/**
	 * Set state post mile of VDS as double
	 * 
	 * @param state post mile of VDS as double
	 */
	@Override
	public void setStatePostmile(double statePM) {
	  super.setStatePostmile(statePM);
	}
	
	/**
	 * Return absolute post mile of VDS as double
	 * 
	 * @return absolute post mile of VDS as double
	 */
	@Override
	public double getAbsolutePostmile() {
	  return super.getAbsolutePostmile();
	}
	
	/**
	 * Set absolute post mile of VDS as double
	 * 
	 * @param absolute post mile of VDS as double
	 */
	@Override
	public void setAbsolutePostmile(double absPM) {
	  super.setAbsolutePostmile(absPM);
	}
	
	/**
	 * Return detector length of VDS as double
	 * 
	 * @return detector length mile of VDS as double
	 */
	@Override
	public double getDetectorLength() {
	  return super.getDetectorLength();
	}
	
	/**
	 * Set detector length of VDS as Double
	 * 
	 * @param detector length mile of VDS as Double
	 */
	@Override
	public void setDetectorLength(Double length) {
	  super.setDetectorLength(length);
	}
	
}
