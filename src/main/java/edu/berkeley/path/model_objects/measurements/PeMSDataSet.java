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

import java.util.List;

import edu.berkeley.path.model_objects.measurements.PeMSDataProfile;

/** 
 * Model Object PeMS Data Set class.
 *  
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 */
public class PeMSDataSet extends edu.berkeley.path.model_objects.jaxb.PeMSDataSet{
	
	/**
	 * TODO: Validation
	 * TODO: Readers and Writers
	 * TODO: Unit Tests
	 */
	
	/**
	 * Return list of PeMSDatum objects (i.e. the profile)
	 * 
	 * @return peMSDatum list as List<PeMSDatum>
	 */
	@SuppressWarnings("unchecked")
	public List<PeMSDataProfile> getListOfProfiles() {
	  List<edu.berkeley.path.model_objects.jaxb.PeMSDataProfile> profileList = super.getPeMSDataProfile();
	  // return casted list of Nodes from JAXB base class
      return (List<PeMSDataProfile>)(List<?>)profileList;
    }
	
	/**
	 * Set list of PeMSDataProfile objects (i.e. the data set)
	 * 
	 * @param PeMSDataProfile list as List<PeMSDataProfile>
	 */
	public void setPeMSDataProfile(List<PeMSDataProfile> peMSDataSet) {
	  getPeMSDataProfile().clear();
	  getPeMSDataProfile().addAll(peMSDataSet);
	}

}
