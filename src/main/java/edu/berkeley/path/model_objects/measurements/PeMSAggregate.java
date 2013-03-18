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

import java.math.BigInteger;
import java.util.List;

import edu.berkeley.path.model_objects.jaxb.PeMSDataProfile;

/** 
 * Model Object PeMS Aggregate class.
 *  
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 */
public class PeMSAggregate extends edu.berkeley.path.model_objects.jaxb.PeMSAggregate{
	
	/**
	 * TODO: Validation
	 * TODO: Readers and Writers
	 * TODO: Unit Tests
	 */
	
	/**
	 * Passed to reader methods to select which degree of aggregation.
	 * The value of the enum is a string which references a table.
	 */
	public enum AggregationLevel {
	    PEMS_5MIN ("PEMS_5MIN"),
	    PEMS_1HOUR("PEMS_1HOUR"),
	    PEMS_1DAY ("PEMS_1DAY");

	    public final String table;

	    private AggregationLevel(String table) {
	      this.table = table;
	    }
	}
	
	/**
	 * Return number of lanes
	 * 
	 * @return number of lanes as BigInteger
	 */
	@Override
	public BigInteger getLane() {
	  return super.getLane();
	}
	
	/**
	 * Set number of lanes
	 * 
	 * @param number of lanes as BigInteger
	 */
	@Override
	public void setLane(BigInteger lane) {
	  super.setLane(lane);
	}
	
	/**
	 * Return number of samples
	 * 
	 * @return number of samples as Long
	 */
	@Override
	public long getSamples() {
	  return super.getSamples();
	}
	
	/**
	 * Set number of samples
	 * 
	 * @param number of samples as Long
	 */
	@Override
	public void setSamples(Long samples) {
	  super.setSamples(samples);
	}
	
	/**
	 * Return total flow
	 * 
	 * @return total flow as double
	 */
	@Override
	public double getFlow() {
	  return super.getFlow();
	}
	
	/**
	 * Set total flow
	 * 
	 * @param total flow as double
	 */
	@Override
	public void setFlow(Double flow) {
	  super.setFlow(flow);
	}
	
	/**
	 * Return average occupancy
	 * 
	 * @return average occupancy as double
	 */
	@Override
	public double getAvgOccupancy() {
	  return super.getAvgOccupancy();
	}
	
	/**
	 * Set average occupancy
	 * 
	 * @param average occupancy as double
	 */
	@Override
	public void setAvgOccupancy(Double avgOccupancy) {
	  super.setAvgOccupancy(avgOccupancy);
	}
	
	/**
	 * Return average speed
	 * 
	 * @return average speed as double
	 */
	@Override
	public double getAvgSpeed() {
	  return super.getAvgSpeed();
	}
	
	/**
	 * Set average speed
	 * 
	 * @param average speed as double
	 */
	@Override
	public void setAvgSpeed(Double avgSpeed) {
	  super.setAvgSpeed(avgSpeed);
	}
	
	/**
	 * Return observed percentage
	 * 
	 * @return observed percentage as double
	 */
	@Override
	public double getObserved() {
	  return super.getObserved();
	}
	
	/**
	 * Set observed percentage
	 * 
	 * @param observed percentage as double
	 */
	@Override
	public void setObserved(Double observed) {
	  super.setObserved(observed);
	}

}
