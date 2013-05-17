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

/** Measurement Model Object Factory that can be used to create instances of Measurement Objects. This
 * factory can be extended, it's methods overridden and then passed into the model database access layer
 * to return application specific extended model objects.
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 *
 */
public class MeasurementObjectFactory extends edu.berkeley.path.model_objects.jaxb.ObjectFactory {
	
	public MeasurementObjectFactory(){
	}
	
	/** 
	 * Create an instance of PeMSDatum object
	 * @return PeMSDatum object
	 */
	public PeMSDatum createPeMSDatum(){
		return new PeMSDatum();
	}
	
	/** 
	 * Create an instance of PeMSStationAggregate object
	 * @return PeMSStationAggregate object
	 */
	public PeMSStationAggregate createPeMSStationAggregate(){
		return new PeMSStationAggregate();
	}
	
	/** 
	 * Create an instance of PeMSDataSet object
	 * @return PeMSDataSet object
	 */
	public PeMSDataSet createPeMSDataSet(){
		return new PeMSDataSet();
	}
	
	/** 
	 * Create an instance of PeMSDataProfile object
	 * @return PeMSDataProfile object
	 */
	public PeMSDataProfile createPeMSDataProfile(){
		return new PeMSDataProfile();
	}
	
	/** 
	 * Create an instance of PeMSAggregate object
	 * @return PeMSAggregate object
	 */
	public PeMSAggregate createPeMSAggregate(){
		return new PeMSAggregate();
	}
	
	/** 
	 * Create an instance of VDS object
	 * @return PeMSDatum object
	 */
	public VDS createVDS(){
		return new VDS();
	}
	
}
