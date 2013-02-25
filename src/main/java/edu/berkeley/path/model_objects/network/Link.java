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

package edu.berkeley.path.model_objects.network;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import core.Monitor;

import edu.berkeley.path.model_objects.jaxb.Begin;
import edu.berkeley.path.model_objects.jaxb.Dynamics;
import edu.berkeley.path.model_objects.jaxb.End;
import edu.berkeley.path.model_objects.jaxb.Road;
import edu.berkeley.path.model_objects.jaxb.Roads;

/** 
 * Model Object Link class.
 *  
 * @author Gabriel Gomes (gomes@path.berkeley.edu)
 * @author Matthew Juhn (mnjuhn@berkeley.edu)
 */
public class Link extends edu.berkeley.path.model_objects.jaxb.Link { 
	
	/** @y.exclude */  protected Network myNetwork;
	/** @y.exclude */  protected Node beginNode;
	/** @y.exclude */  protected Node endNode;
	/** @y.exclude */  protected String roadName;
	/** @y.exclude */  protected java.util.List<Point> points;
	
	/** @y.exclude */  protected Boolean isSource;
	/** @y.exclude */  protected Boolean isSink;
	
	/**
	 * Return id of link
	 * 
	 * @return id of link as string
	 */
	@Override
	public String getId() {
	  return super.getId();
	}
	
	/**
	 * Set id of link
	 * 
	 * @param id of link as string
	 */
	@Override
	public void setId(String id) {
	  super.setId(id);
	}
	
	/**
   * Return number of lanes of link
   * 
   * @return number of lanes 
   */
  @Override
  public BigDecimal getLanes() {
    return super.getLanes();
  }
  
  /**
   * Set number of lanes of link
   * 
   * @param number lanes of link 
   */
  @Override
  public void setLanes(BigDecimal lanes) {
    super.setLanes(lanes);
  }

  /**
   * Return lane offset of link
   * 
   * @return number of lanes 
   */
  @Override
  public BigDecimal getLaneOffset() {
    return super.getLaneOffset();
  }
  
  /**
   * Set lane offset of link
   * 
   * @param number lanes of link 
   */
  @Override
  public void setLaneOffset(BigDecimal laneOffset) {
    super.setLaneOffset(laneOffset);
  }
	
  /**
   * Return length of link in SI
   * 
   * @return length of link in SI 
   */
  @Override
  public BigDecimal getLength() {
    // TODO: Should we be returning a Measurement object (value, unit) pair? 
    return super.getLength();
  }
  
  /**
   * Set length of link in SI
   * 
   * @param length of link in SI
   */
  @Override
  public void setLength(BigDecimal length) {
    // TODO: Should we be passing in a Measurements object (value, unit) pair?
    super.setLength(length);
  }
  
  /**
   * Return type of link
   * 
   * @return type of link as string
   */
  @Override
  public String getType() {
    // TODO: This should be changed to return Type object (id, string) mappings
    return super.getType();
  }
  
  /**
   * Set type of link
   * 
   * @param type of link as string
   */
  @Override
  public void setType(String type) {
    // TODO: This should be changed to take in Type object (id, string)
    super.setType(type);
  }
  
	/**
   * Parses String Id of link to long
   * 
   * @return id of link as long
   */
  public Long getLongId() {
    return Long.parseLong(getId().toString());
  }
    
  /** 
   * Get network that contains this link, only valid if link has been associated 
   * with a network by calling the populate function.
   * 
   * @return  Network link belongs to
   */
  public Network getMyNetwork() {
    return myNetwork;
  }

  /** 
   * Get upstream (begin) node of this link
   * 
   * @return  Begin Node Model object
   */
  public Node getBeginNode() {
    return beginNode;
  }

  /** 
   * Get downstream (end) node of this link 
   * 
   * @return  End Node Model object
   */
  public Node getEndNode() {
    return endNode;
  }
  
  /**
   * Set upstream (begin) node of this link
   * 
   * @param   The node to set as begin node of link
   */
  public void setBeginNode(Node node) {
    this.endNode = node;
    if (node != null) {
      setBegin(new Begin());
      getBegin().setNodeId(node.getId());
    }
  }
  
  /**
   * Set downstream (end) node of this link
   * 
   * @param   The node to set as end node of link
   */
  public void setEndNode(Node node) {
    this.endNode = node;
    if (node != null) {
      setEnd(new End());
      getEnd().setNodeId(node.getId());
    }
  }
  
  /** 
   * Get Upstream (begin) node of this link  
   * 
   * @param   String representation of the id of end node 
   */
  public String getBeginNodeId() {
    return beginNode.getId();
  }

  /** 
   * Get downstream (end) node of this link
   * 
   *  @param  String representation of the id of begin node
   */
  public String getEndNodeId() {
    return endNode.getId();
  }
  
  /**
   * Set upstream (begin) node of this link
   * 
   * @param   The node to set as begin node of link
   */
  public void setBeginId(Long nodeId) {
    
    //TODO: Change schema to represent ID's as long not strings?  
    // This way no conversion necessary
    String nodeIdStr = nodeId.toString();
    setBegin(new Begin());
    getBegin().setNodeId(nodeIdStr);
  }
  
  /**
   * Set downstream (end) node of this link
   * 
   * @param  The node to set as end node of link
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
   * @return  The road name of link
   */
  public String getFirstRoadName() {
    if ( getRoads().getRoad().size() > 0 ) {
      return getRoads().getRoad().get(0).getName();
    }
    else {
      return null;
    }
  }

  /**
   * Set link to have Road Name
   * 
   * @param The road name of link
   */
  public void setRoadName(String roadName) {    
    Road road = new Road();
    road.setName(roadName);
    Roads roads = new Roads();
    roads.getRoad().add(road);
  }
  
  /** 
   * Returns <code>true</code> if this link is a source of demand into the network 
   */
  public Boolean isSource() {
    return isSource;
  }

  /** 
   * Returns <code>true</code> if this link is a sink of demand from the network 
   */
  public Boolean isSink() {
    return isSink;
  }
  
  /**
   * Returns list of Points representing link Geometry
   * 
   * @return  list of points
   */
  public java.util.List<Point> getPoints() {
    return points;
  }

  /**
   * Sets a list of Points to represent link Geometry
   * 
   * @param   List of points
   */
  public void setPoints(java.util.List<Point> points) {
    this.points = points;
  }
	
	/**
	 * Populates link by creating references for begin and end node
	 * 
	 * @param    Network link is associated with
	 */
	protected void populate(Network myNetwork) {

    this.myNetwork = myNetwork;
        
		// make network connections
		beginNode = myNetwork.getNodeWithId(getBegin().getNodeId());
		endNode = myNetwork.getNodeWithId(getEnd().getNodeId());
        
		// nodes must populate before links
		if(beginNode!=null)
			isSource = beginNode.isTerminal;
		if(endNode!=null)
			isSink = endNode.isTerminal;
	}

	/** 
	 * Link validation checks
	 *
	 * @return  True if all link validation is correct
	 */
	protected Boolean isValid() {
		
	  Boolean isValid = true;
	  
		if(!isSource && beginNode==null) {
		  isValid = false;
		  Monitor.out("Incorrect begin node id=" + getBegin().getNodeId() + " in link id=" + getId() + ".");
		}
			
		if(!isSink && endNode==null) {
		  isValid = false;
			Monitor.out("Incorrect end node id=" + getEnd().getNodeId() + " in link id=" + getId() + ".");
		}
		
		if(getLength().intValue() <= 0) {
		  isValid = false;
			Monitor.out("Non-positive length in link id=" + getId() + ".");
		}
		
		if(getLanes().intValue() <= 0) {
		  isValid = false;
			Monitor.out("Non-positive number of lanes in link id=" + getId() + ".");	
		}
		
		return isValid;
	}

	
}
