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

import javax.xml.datatype.XMLGregorianCalendar;

import edu.berkeley.path.model_objects.measurements.PeMSDatum;


/** 
 * Model Object PeMS Data Profile class.
 *  
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 */
public class PeMSDataProfile extends edu.berkeley.path.model_objects.jaxb.PeMSDataProfile{
	
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
	public List<PeMSDatum> getListOfPeMSDatum() {
	  List<edu.berkeley.path.model_objects.jaxb.PeMSDatum> datumList = super.getPeMSDatum();
	  // return casted list of Nodes from JAXB base class
      return (List<PeMSDatum>)(List<?>)datumList;
    }
	
	
	/**
	 * Set list of PeMSDatum objects (i.e. the profile)
	 * 
	 * @param peMSDatum list as List<PeMSDatum>
	 */
	public void setPeMSDatum(List<PeMSDatum> peMSData) {
	  getPeMSDatum().clear();
	  getPeMSDatum().addAll(peMSData);
	}
	
	/**
	 * Return vdsId of the data profile
	 * 
	 * @return vdsId as long
	 */
	@Override
	public long getVdsId() {
	  return super.getVdsId();
	}
	
	/**
	 * Set vdsId of the data profile
	 * 
	 * @param vdsId as long
	 */
	@Override
	public void setVdsId(long vdsId) {
	  super.setVdsId(vdsId);
	}

}
