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
import java.util.ArrayList;
import java.util.List;

import core.Monitor;

import edu.berkeley.path.model_objects.jaxb.Begin;
import edu.berkeley.path.model_objects.jaxb.Dynamics;
import edu.berkeley.path.model_objects.jaxb.End;
import edu.berkeley.path.model_objects.jaxb.Road;
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
	/** @y.exclude */	protected String roadName;
	/** @y.exclude */	protected java.util.List<Point> points;

	// link type
	protected Link.Type myType;
	/** Type of link. */
	public static enum Type	{Freeway,HOV,HOT,onramp,offramp,freeway_connector,street,intersection_approach,heavy_vehicle,electric_toll};
	
	
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
	 * Parses String Id of link to long
	 * @return	Long  id of link
	 */
	public Long getLongId() {
		return Long.parseLong(getId().toString());
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
	 * upstream node of this link  
	 * 
	 * @param String representation of the id of end node 
	 */
	public String getBeginNodeId() {
		return beginNode.getId();
	}

	/** 
	 * downstream node of this link
	 * 
	 *  @param String 	representation of the id of begin node
	 */
	public String getEndNodeId() {
		return endNode.getId();
	}
	
	/**
	 * Set upstream node of this link
	 * 
	 * @param node  the node to set as begin node of link
	 */
	public void setBeginId(Long nodeId) {
		
		//TODO: Change schema to represent ID's as long not strings?  
		// This way no conversion necessary
		String nodeIdStr = nodeId.toString();
		setBegin(new Begin());
		getBegin().setNodeId(nodeIdStr);
	}
	
	/**
	 * Set downstream node of this link
	 * 
	 * @param node  the node to set as end node of link
	 */
	public void setEndId(Long nodeId) {
		
		//TODO: Change schema to represent ID's as long not strings?  
		// This way no conversion necessary
		String nodeIdStr = nodeId.toString();
		setEnd(new End());
		getEnd().setNodeId(nodeIdStr);
	}
	
	/**
	 * Get Links first Road Name
	 * 
	 * @return String	the road name of link
	 */
	public String getFirstRoadName() {
		return getRoads().getRoad().get(0).getName(); 
	}

	/**
	 * Set link to have Road Name
	 * 
	 * @param String	the road name of link
	 */
	public void setRoadName(String roadName) {		
		Road road = new Road();
		road.setName(roadName);
		Roads roads = new Roads();
		roads.getRoad().add(road);
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
	
	/**
	 * Gets the value of the 'points' field.
	 */
	public java.util.List<Point> getPoints() {
		return points;
	}

	/**
	 * Sets the value of the 'points' field.
	 * @param value the value to set.
	 */
	public void setPoints(java.util.List<Point> value) {
		this.points = value;
	}

	/**
	 * Set the points. Same as setPoints(), but works with a list of Point.
	 */
	@SuppressWarnings("unchecked")
	public void setPointList(List<Point> value) {
		setPoints((List<Point>)(List<?>)value);
	}
	  
	/**
	 * Get the points. Same as getPoints(), but works with a list of Point.
	 * Never returns null (creates the list if it doesn't exist).
	 */
	@SuppressWarnings("unchecked")
	public List<Point> getPointList() {
		if (null == getPoints()) {
			setPoints(new ArrayList<Point>());
		}
	    return (List<Point>)(List<?>)getPoints();
	}
}
