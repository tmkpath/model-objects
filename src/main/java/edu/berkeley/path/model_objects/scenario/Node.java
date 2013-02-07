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

import java.util.ArrayList;

import edu.berkeley.path.model_objects.jaxb.Inputs;
import edu.berkeley.path.model_objects.jaxb.Outputs;
import edu.berkeley.path.model_objects.jaxb.Position;
import edu.berkeley.path.model_objects.jaxb.RoadwayMarkers;

import core.Monitor;

/** 
* Node class.
*
* @author Gabriel Gomes (gomes@path.berkeley.edu)
*/
public final class Node extends edu.berkeley.path.model_objects.jaxb.Node {
		   
	/** @y.exclude */ 	protected Network myNetwork;

	// network references
	/** @y.exclude */ 	protected Link [] output_link;
	/** @y.exclude */ 	protected Link [] input_link;

	/** @y.exclude */ 	protected int nIn;
	/** @y.exclude */ 	protected int nOut;
	/** @y.exclude */ 	protected boolean isTerminal;
	
    
	/**
	 * Populates node input and output links by creating
	 * references to it's input and output links 
	 * 
	 * @return void
	 */ 	
	protected void populate(Network myNetwork) {
    	// Note: It is assumed that this comes *before* SplitRatioProfile.populate
		
		this.myNetwork = myNetwork;
		
		nOut = 0;
		if(getOutputs()!=null){
			nOut = getOutputs().getOutput().size();
			output_link = new Link[nOut];
			for(int i=0;i<nOut;i++){
				edu.berkeley.path.model_objects.jaxb.Output output = getOutputs().getOutput().get(i);
				output_link[i] = myNetwork.getLinkWithId(output.getLinkId());
			}
		}

		nIn = 0;
		if(getInputs()!=null){
			nIn = getInputs().getInput().size();
			input_link = new Link[nIn];
			for(int i=0;i<nIn;i++){
				edu.berkeley.path.model_objects.jaxb.Input input = getInputs().getInput().get(i);
				input_link[i] = myNetwork.getLinkWithId(input.getLinkId());
			}
		}
		
		isTerminal = nOut==0 || nIn==0;

    	if(isTerminal)
    		return;
	}
    
	/**
	 * Node validation
	 */	
	protected void validate() {
				
		if(isTerminal)
			return;
		
		if(output_link!=null)
			for(Link link : output_link)
				if(link==null)
					Monitor.out("Incorrect output link id in node id=" + getId());

		if(input_link!=null)
			for(Link link : input_link)
				if(link==null)
					Monitor.out("Incorrect input link id in node id=" + getId());
		
		if(nIn==0)
			Monitor.out("No inputs into non-terminal node id=" + getId());

		if(nOut==0)
			Monitor.out("No outputs from non-terminal node id=" + getId());
		
	}
    
	/** 
	 * network that contains this node 
	 */ 	
	public Network getMyNetwork() {
		return myNetwork;
	}
	    
    /** 
     * List of links exiting this node 
     */ 
    public Link[] getOutput_link() {
		return output_link;
	}

    /** 
     * List of links entering this node 
     */ 
	public Link[] getInput_link() {
		return input_link;
	}

    /** 
     * Index of link with given id in the list of input links of this node 
     */ 
	public int getInputLinkIndex(String id){
		for(int i=0;i<getnIn();i++){
			if(input_link[i]!=null)
				if(input_link[i].getId().equals(id))
					return i;
		}
		return -1;
	}
	
    /** 
     * Index of link with given id in the list of output links of this node 
     */ 
	public int getOutputLinkIndex(String id){
		for(int i=0;i<getnOut();i++){
			if(output_link[i]!=null)
				if(output_link[i].getId().equals(id))
					return i;
		}
		return -1;
	}
	
    /** 
     * Number of links entering this node 
     */ 
	public int getnIn() {
		return nIn;
	}

    /** 
     * Number of links exiting this node 
     */ 
	public int getnOut() {
		return nOut;
	}

}
