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

import java.util.List;

import edu.berkeley.path.model_objects.jaxb.FundamentalDiagram;
import edu.berkeley.path.model_objects.jaxb.PeMSDatum;

/** 
 * Model Object Fundamental Diagram Profile class.
 *  
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 */
public class FundamentalDiagramProfile extends edu.berkeley.path.model_objects.jaxb.FundamentalDiagramProfile{
	
	/**
	 * Return list of FundamentalDiagram objects (i.e. the profile)
	 * 
	 * @return peMSDatum list as List<PeMSDatum>
	 */
	@Override
	public List<FundamentalDiagram> getFundamentalDiagram() {
	  return super.getFundamentalDiagram();
	}
	
	/**
	 * Set list of FundamentalDiagram objects (i.e. the profile)
	 * 
	 * @param FundamentalDiagram list as List<FundamentalDiagram>
	 */
	public void setFundamentalDiagram(List<FundamentalDiagram> FundamentalDiagram) {
		getFundamentalDiagram().clear();
		getFundamentalDiagram().addAll(FundamentalDiagram);
	}
	
	/**
	 * Return Link ID of the FD profile
	 * 
	 * @return linkId as long
	 */
	@Override
	public long getLinkId() {
	  return super.getLinkId();
	}
	
	/**
	 * Set Link ID of the FD profile
	 * 
	 * @param linkId as long
	 */
	@Override
	public void setLinkId(long linkId) {
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
	
	
	
	

}
