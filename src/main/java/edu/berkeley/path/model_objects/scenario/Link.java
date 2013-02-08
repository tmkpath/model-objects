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

import java.math.BigDecimal;
import core.Monitor;

import edu.berkeley.path.model_objects.jaxb.Begin;
import edu.berkeley.path.model_objects.jaxb.Dynamics;
import edu.berkeley.path.model_objects.jaxb.End;
import edu.berkeley.path.model_objects.jaxb.Roads;

/** Link class.
* 
* @author Gabriel Gomes (gomes@path.berkeley.edu)
* @author Matthew Juhn (mnjuhn@berkeley.edu)
*/
public final class Link extends edu.berkeley.path.model_objects.jaxb.Link { 
	
	/** @y.exclude */ 	protected Network myNetwork;
	/** @y.exclude */ 	protected Node beginNode;
	/** @y.exclude */ 	protected Node endNode;

	// link type
	protected Link.Type myType;
	/** Type of link. */
	public static enum Type	{freeway,HOV,HOT,onramp,offramp,freeway_connector,street,intersection_approach,heavy_vehicle,electric_toll};
	
	
	/** @y.exclude */ 	protected boolean isSource; 				// [boolean]
	/** @y.exclude */ 	protected boolean isSink;     				// [boolean]
	
	/*
	 * Populates by creating references for begin and end node
	 */
	protected void populate(Network myNetwork) {

        this.myNetwork = myNetwork;
        
        // link type
        this.myType = Link.Type.valueOf(getType());
        
		// make network connections
		beginNode = myNetwork.getNodeWithId(getBegin().getNodeId());
		endNode = myNetwork.getNodeWithId(getEnd().getNodeId());
        
		// nodes must populate before links
		if(beginNode!=null)
			isSource = beginNode.isTerminal;
		if(endNode!=null)
			isSink = endNode.isTerminal;
	}

	/* 
	 * Node validation
	 */
	protected void validate() {
		
		if(!isSource && beginNode==null)
			Monitor.out("Incorrect begin node id=" + getBegin().getNodeId() + " in link id=" + getId() + ".");

		if(!isSink && endNode==null)
			Monitor.out("Incorrect end node id=" + getEnd().getNodeId() + " in link id=" + getId() + ".");
		
		if(getLength().intValue() <= 0)
			Monitor.out("Non-positive length in link id=" + getId() + ".");
		
		if(getLanes().intValue() <= 0)
			Monitor.out("Non-positive number of lanes in link id=" + getId() + ".");		
	}

	/** 
	 * network that contains this link 
	 */
	public Network getMyNetwork() {
		return myNetwork;
	}

	/** 
	 * upstream node of this link  
	 */
	public Node getBeginNode() {
		return beginNode;
	}

	/** 
	 * downstream node of this link 
	 */
	public Node getEndNode() {
		return endNode;
	}
	
	/**
	 * Set upstream node of this link
	 * 
	 * @param node  the node to set as begin node of link
	 */
	public void setBeginNode(Node node) {
		this.endNode = node;
		if (node != null) {
			setBegin(new Begin());
			getBegin().setNodeId(node.getId());
		}
	}
	
	/**
	 * Set downstream node of this link
	 * 
	 * @param node  the node to set as end node of link
	 */
	public void setEndNode(Node node) {
		this.endNode = node;
		if (node != null) {
			setEnd(new End());
			getEnd().setNodeId(node.getId());
		}
	}

	/** 
	 * <code>true</code> if this link is a source of demand into the network 
	 */
	public boolean isSource() {
		return isSource;
	}

	/** 
	 * <code>true</code> if this link is a sink of demand from the network 
	 */
	public boolean isSink() {
		return isSink;
	}

}
