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

import javax.xml.datatype.XMLGregorianCalendar;

import edu.berkeley.path.model_objects.shared.DateTime;

/** 
 * Model Object PeMS Datum class.
 *  
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 */

public class PeMSDatum extends edu.berkeley.path.model_objects.jaxb.PeMSDatum{
	
	/**
	 * TODO: Getters and Setters for gFactor, densityError, flowError, funcLoopFact
	 * TODO: Validation
	 * TODO: Readers and Writers
	 * TODO: Unit Tests
	 */
	
	/**
	 * Return timestamp of datum
	 * 
	 * @return timestamp of datum as DateTime
	 */
	@Override
	public DateTime getTimestamp() {
	  return (DateTime) super.getTimestamp();
	}
	
	/**
	 * Set timestamp of datum
	 * 
	 * @param timestamp of datum as DateTime
	 */
	//@Override
	public void setTimestamp(DateTime timestamp){
		super.setTimestamp(timestamp);
	}
	
	/**
	 * Return flow value
	 * 
	 * @return flow as Double
	 */
	@Override
	public double getFlow() {
	  return super.getFlow();
	}
	
	/**
	 * Set flow value
	 * 
	 * @param flow as Double
	 */
	@Override
	public void setFlow(Double flow) {
	  super.setFlow(flow);
	}
	
	/**
	 * Return density value
	 * 
	 * @return density as Double
	 */
	@Override
	public double getDensity() {
	  return super.getDensity();
	}
	
	/**
	 * Set density value
	 * 
	 * @param density as Double
	 */
	@Override
	public void setDensity(Double density) {
	  super.setDensity(flow);
	}
	
	/**
	 * Return speed value
	 * 
	 * @return speed as Double
	 */
	@Override
	public double getSpeed() {
	  return super.getSpeed();
	}
	
	/**
	 * Set speed value
	 * 
	 * @param speed as Double
	 */
	@Override
	public void setSpeed(Double speed) {
	  super.setSpeed(speed);
	}
	
}
