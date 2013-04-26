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

import java.util.ArrayList;

import core.Monitor;

import edu.berkeley.path.model_objects.jaxb.Begin;
import edu.berkeley.path.model_objects.jaxb.CrudFlag;
import edu.berkeley.path.model_objects.jaxb.End;
import edu.berkeley.path.model_objects.jaxb.Road;
import edu.berkeley.path.model_objects.jaxb.Roads;
import edu.berkeley.path.model_objects.jaxb.LinkType;
import edu.berkeley.path.model_objects.shared.Point;

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
	 * @return id of link as long
	 */
	@Override
	public long getId() {
	  return super.getId();
	}
	
	/**
	 * Set id of link
	 * 
	 * @param id of link as long
	 */
	@Override
	public void setId(long id) {
	  super.setId(id);
	}
	
	/**
   * Return number of lanes of link
   * 
   * @return number of lanes 
   */
  @Override
  public double getLanes() {
    return super.getLanes();
  }
  
  /**
   * Set number of lanes of link
   * 
   * @param number lanes of link 
   */
  @Override
  public void setLanes(double lanes) {
    super.setLanes(lanes);
  }
  
  /**
   * Return speed Limit of link
   * 
   * @return number of s
   */
  @Override
  public double getSpeedLimit() {
    return super.getSpeedLimit();
  }
  
  /**
   * Set speed limit of link
   * 
   * @param number lanes of link 
   */
  @Override
  public void setSpeedLimit(double speed) {
    super.setSpeedLimit(speed);
  }

  /**
   * Return lane offset of link
   * 
   * @return number of lanes 
   */
  @Override
  public double getLaneOffset() {
    return super.getLaneOffset();
  }
  
  /**
   * Set lane offset of link
   * 
   * @param number lanes of link 
   */
  @Override
  public void setLaneOffset(Double laneOffset) {
    super.setLaneOffset(laneOffset);
  }
	
  /**
   * Return length of link in SI
   * 
   * @return length of link in SI 
   */
  @Override
  public double getLength() {
    // TODO: Should we be returning a Measurement object (value, unit) pair? 
    return super.getLength();
  }
  
  /**
   * Set length of link in SI
   * 
   * @param length of link in SI
   */
  @Override
  public void setLength(double length) {
    // TODO: Should we be passing in a Measurements object (value, unit) pair?
    super.setLength(length);
  }
  
  /**
   * Return type name of link
   * 
   * @return type name of link as string
   */
  public String getTypeName() {
    return getLinkType().getName();
  }
  
  /**
   * Return link type id
   * 
   * @return id of type of link as long
   */
  public long getTypeId() {
    return getLinkType().getId();
  }
  
  /**
   * Set type id and name of link
   * 
   * @param id of link type as long
   * @param Name of link type as string
   */
  public void setType(long id, String name) {
    LinkType linkType = new LinkType();
    linkType.setName(name);
    linkType.setId(id);
    setLinkType(linkType);
  }
    
  /**
   * Gets the value of the linkName property.
   * 
   * @return  Name of Link
   */
  @Override
  public String getLinkName() {
      return linkName;
  }

  /**
   * Sets the value of the linkName property.
   * 
   * @param Link of Node
   */
  @Override
  public void setLinkName(String value) {
      this.linkName = value;
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
   * @param   long representation of the id of end node 
   */
  public long getBeginNodeId() {
    return getBegin().getNodeId();
  }

  /** 
   * Get downstream (end) node of this link
   * 
   *  @param  long representation of the id of begin node
   */
  public long getEndNodeId() {
    return getEnd().getNodeId();
  }
  
  /**
   * Set upstream (begin) node of this link
   * 
   * @param   The node to set as begin node of link
   */
  public void setBeginNodeId(Long nodeId) {   
    setBegin(new Begin());
    getBegin().setNodeId(nodeId);
  }
  
  /**
   * Set downstream (end) node of this link
   * 
   * @param  The node to set as end node of link
   */
  public void setEndNodeId(Long nodeId) {
    setEnd(new End());
    getEnd().setNodeId(nodeId);
  } 
  
  /**
   * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   * 
   * @return CRUD Flag enumeration
   */
  @Override
  public CrudFlag getCrudFlag() {
    return super.getCrudFlag();
  }
  
  /**
   * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   * 
   * @param CRUD Flag enumeration
   */
  @Override
  public void setCrudFlag(CrudFlag flag) {
    super.setCrudFlag(flag);
  }
  
  /**
   * Get Links first Road Name
   * 
   * @return  The road name of link
   */
  public String getFirstRoadName() {
    if ( getRoads() != null && getRoads().getRoad() != null) {
        return getRoads().getRoad().get(0).getName();
    }
    // otherwise return empty string
    else {
      return "";
    }
  }

  /**
   * Get all Road Names on link
   * 
   * @return  List of road name(s) associated with
   */
  public java.util.List<String> getRoadNames() {
    java.util.ArrayList<String> roadNames = new java.util.ArrayList<String>(); 
    if ( getRoads() != null && getRoads().getRoad() != null) {
      // For each road add its name to the list  
      for (Road road : getRoads().getRoad()) {
          roadNames.add(road.getName());
      }
    }
    
    return roadNames;
  }
  
  /**
   * Add new Road Name to Link
   * 
   * @param The road name of link
   */
  public void addRoadName(String roadName) {    
    Road road = new Road();
    road.setName(roadName);
    Roads roads = new Roads();
    roads.getRoad().add(road);
    setRoads(roads);
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
    if (this.points == null) {
      this.points = new ArrayList<Point>();
    }
    return this.points;
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
	public void populate(Network myNetwork) {

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
	public final Boolean isValid() {
		
	  Boolean isValid = true;
	  
		if(!isSource && beginNode==null) {
		  isValid = false;
		  Monitor.out("Incorrect begin node id=" + getBegin().getNodeId() + " in link id=" + getId() + ".");
		}
			
		if(!isSink && endNode==null) {
		  isValid = false;
			Monitor.out("Incorrect end node id=" + getEnd().getNodeId() + " in link id=" + getId() + ".");
		}
		
		if(getLength() <= 0) {
		  isValid = false;
			Monitor.out("Non-positive length in link id=" + getId() + ".");
		}
		
		if(getLanes() <= 0) {
		  isValid = false;
			Monitor.out("Non-positive number of lanes in link id=" + getId() + ".");	
		}
		
		return isValid;
	}

	
}
