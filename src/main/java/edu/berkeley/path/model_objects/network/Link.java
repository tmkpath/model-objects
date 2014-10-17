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
import java.util.List;

import core.Monitor;

import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.jaxb.Road;
import edu.berkeley.path.model_objects.jaxb.Roads;
import edu.berkeley.path.model_objects.jaxb.Position;
import edu.berkeley.path.model_objects.jaxb.End;
import edu.berkeley.path.model_objects.jaxb.Begin;
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
	
	/** @y.exclude */  protected Boolean isSource;
	/** @y.exclude */  protected Boolean isSink;
	/** @y.exclude */  protected String wkt;
	
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
	 * Return WKT Representation of the Link(LINESTRING)
	 * 
	 * @return wkt WKT Representation of the Link(LINESTRING)
	 */
	public String getWKT() {
	  return this.wkt;
	}
	
	/**
	 * Set WKT Representation of the Link(LINESTRING)
	 * 
	 * @param wkt WKT Representation of the Link(LINESTRING)
	 */
	public void setWKT(String wkt) {
	  this.wkt = wkt;
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
  public Double getSpeedLimit() {
    return super.getSpeedLimit();
  }
  
  /**
   * Set speed limit of link
   * 
   * @param number lanes of link 
   */
  @Override
  public void setSpeedLimit(Double speed) {
    super.setSpeedLimit(speed);
  }

  /**
   * Return detail level of link. Returns 0 if detail level is null.
   *
   * @return Detail Level The integer representing the detail level
   *         of the link. (0 - 5)
   */
  @Override
  public Integer getDetailLevel() {
      if (null == super.getDetailLevel()) return 0;

      return super.getDetailLevel();
    }

  /**
   * Set Detail Level of the link.  Sets to 0 if dLevel is null.
   *
   * @param dLevel The detail level for the link
   */
  @Override
  public void setDetailLevel(Integer dLevel) {
      if (null == dLevel) {
          super.setDetailLevel(0);
      } else {
          super.setDetailLevel(dLevel);
      }
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
   * Return type name of link, if not set returns null
   * 
   * @return type name of link as string
   */
  public String getTypeName() {
		if (getLinkType() != null) {
			return getLinkType().getName();
		} else {
			return null;
		}
  }
  
  /**
   * Return link type id, if not set returns 0
   * 
   * @return id of type of link as long
   */
  public long getTypeId() {
		if (getLinkType() != null) {
    	return getLinkType().getId();
		} else {
			return 0;
		}
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
  public CrudFlag getCrudFlagEnum() {

		CrudFlag flag = null;
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (super.getCrudFlag() == null) {
			setCrudFlagEnum(CrudFlag.NONE);
			flag = CrudFlag.NONE;
		}
		else {
			switch (CrudFlag.valueOf(super.getCrudFlag())) {
				case CREATE:
					flag = CrudFlag.CREATE;
					break;
				case RETRIEVE:
					flag = CrudFlag.RETRIEVE;
					break;
				case UPDATE:
					flag = CrudFlag.UPDATE;
					break;
				case DELETE:
					flag = CrudFlag.DELETE;
					break;
				default:
					flag = CrudFlag.NONE;
					break;

			}
		}
		return flag;
  }
  
  /**
   * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   * 
   * @param CRUD Flag enumeration
   */
  public void setCrudFlagEnum(CrudFlag flag) {
		// Check if CRUDFlag is null, if so return NONE enumeration
		if (flag == null) {
			super.setCrudFlag("NONE");
		}
		else {
			switch (flag) {
				case CREATE:
					super.setCrudFlag("CREATE");
					break;
				case RETRIEVE:
					super.setCrudFlag("RETRIEVE");
					break;
				case UPDATE:
					super.setCrudFlag("UPDATE");
					break;
				case DELETE:
					super.setCrudFlag("DELETE");
					break;
				default:
					super.setCrudFlag("NONE");
					break;

			}
		}
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
		// try and get points, if not set return new empty list of points
		if (getPosition() != null && getPosition().getPoint() != null) {
			return (List<Point>)(List<?>)getPosition().getPoint();
		}
		else {
			Position position = new Position();
			return (List<Point>)(List<?>)position.getPoint();
		}
  }

	/**
	 * Point to add to link Geom
	 *
	 * @param   point Point to add to link geom
	 */
	public void addPoint(Point point) {
		// If we have at least 1 point in list set points linestring
		if (point != null) {

			// if position does not exist create new position class to house list of bounding box points
			if (getPosition() == null) {
				Position position = new Position();
				setPosition(position);
			}
			// add the point
			getPosition().getPoint().add(point);
		}
		// Otherwise output error message
		else {
			Monitor.err("Error could not add null point, to link geom.");
		}
	}

  /**
   * Sets a list of Points to represent link Geometry
   * 
   * @param   List of points
   */
  public void setPoints(java.util.List<Point> points) {
		// If we have at least 1 point in list set points linestring
		if (points != null && points.size() > 0) {
			// create new position class to house list of bounding box points
			Position position = new Position();
			position.getPoint().clear();
			position.getPoint().addAll(points);

			setPosition(position);
		}
		// Otherwise output error message
		else {
			Monitor.err("Error could not set link geometry points, no points found.");
		}
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
		return true;
		/*  TODO: Figure out validation
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
		
		return isValid;*/
	}

	
}
