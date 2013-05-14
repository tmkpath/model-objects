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

import java.util.List;

import edu.berkeley.path.model_objects.jaxb.Position;
import edu.berkeley.path.model_objects.jaxb.RoadwayMarkers;
import edu.berkeley.path.model_objects.jaxb.Marker;
import edu.berkeley.path.model_objects.jaxb.NodeType;
import edu.berkeley.path.model_objects.shared.Point;
import edu.berkeley.path.model_objects.shared.CrudFlag;

import core.Monitor;

/** 
* Node class.
*
* @author Gabriel Gomes (gomes@path.berkeley.edu)
* @author Matthew Juhn	(mnjuhn@berkeley.edu)
*/
public class Node extends edu.berkeley.path.model_objects.jaxb.Node {
		   
	/** @y.exclude */ 	protected Network myNetwork;

	// network references
	/** @y.exclude */ 	protected Link [] outputLink;
	/** @y.exclude */ 	protected Link [] inputLink;

	/** @y.exclude */ 	protected int nIn;
	/** @y.exclude */ 	protected int nOut;
	/** @y.exclude */ 	protected boolean isTerminal;
	
	/**
   * Return id of node
   * 
   * @return id of node as long
   */
  @Override
  public long getId() {
    return super.getId();
  }
  
  /**
   * Set id of node
   * 
   * @param id of node as long
   */
  @Override
  public void setId(long id) {
    super.setId(id);
  }
  
  /**
   * Return type name of node
   * 
   * @return type name of node as string
   */
  public String getTypeName() {
    return getNodeType().getName();
  }
  
  /**
   * Return node type id
   * 
   * @return id of type of node as long
   */
  public long getTypeId() {
    return getNodeType().getId();
  }
  
  /**
   * Set type id and name of node
   * 
   * @param id of node type as long
   * @param Name of node type as string
   */
  public void setType(long id, String name) {
    NodeType nodeType = new NodeType();
    nodeType.setName(name);
    nodeType.setId(id);
    setNodeType(nodeType);
  }
  
	/** 
   * Get network that contains this node, only valid if node has been associated 
   * with a network by calling the populate function.
   * 
   * @return  Network node belongs to
   */	
	public Network getMyNetwork() {
		return myNetwork;
	}
	    
  /** 
   * Get Array of links exiting this node 
   * 
   * @return Array of links 
   */ 
	public Link[] getOutputLink() {
		return outputLink;
	}

  /** 
   * Get Array of links entering this node 
   * 
   * @return  Array of links 
   */ 
	public Link[] getInputLink() {
		return inputLink;
	}

  /** 
   * Get Index of link with given id in the list of input links of this node
   * 
   * @return  Index of link in input links array
   */ 
	public Integer getInputLinkIndex(long id){
		for(int i=0;i<nIn;i++){
			if(inputLink[i]!=null)
				if(inputLink[i].getId() == id)
					return i;
		}
		return -1;
	}
	
  /** 
   * Get Index of link with given id in the list of output links of this node
   * 
   * @return  Index of link in output links array
   */ 
	public int getOutputLinkIndex(long id){
		for(int i=0;i<nIn;i++){
			if(outputLink[i]!=null)
				if(outputLink[i].getId() == id)
					return i;
		}
		return -1;
	}
	
  /** 
   * Get Number of links entering this node 
   * 
   * @return  Number of links entering node
   */ 
	public Integer getInputLinkCount() {
		return nIn;
	}

  /** 
   * Get Number of links exiting this node 
   * 
   * @return Number of links exiting node
   */ 
	public int getOutputLinkCount() {
		return nOut;
	}
	
  /**
   * Gets the value of the nodeName property.
   * 
   * @return  Name of Node
   */
	@Override
  public String getNodeName() {
      return nodeName;
  }

  /**
   * Sets the value of the nodeName property.
   * 
   * @param Name of Node
   */
	@Override
  public void setNodeName(String value) {
      this.nodeName = value;
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
	public void setCrudFlagEnum(edu.berkeley.path.model_objects.shared.CrudFlag flag) {
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
   * Get all Marker Names on Node
   * 
   * @return  List of marker name(s) associated with node
   */
  public java.util.List<String> getMarkerNames() {
    java.util.ArrayList<String> markerNames = new java.util.ArrayList<String>(); 
    if ( getRoadwayMarkers() != null && getRoadwayMarkers().getMarker() != null) {
      // For each road add its name to the list  
      for (Marker marker : getRoadwayMarkers().getMarker()) {
          markerNames.add(marker.getName());
      }
    }    
    return markerNames;
  }
  
  /**
   * Add new Marker Name to Node
   * 
   * @param The marker name of node
   */
  public void addMarkerName(String markerName) {    
    Marker marker = new Marker();
    marker.setName(markerName);
    RoadwayMarkers markers = getRoadwayMarkers();
    if(markers == null) {
      markers = new RoadwayMarkers();
    }
    markers.getMarker().add(marker);
    setRoadwayMarkers(markers);
  }
	
	/**
	 * Set latitude and longitude of Node
	 * 
	 * @param Point	The latitude and longitude of node
	 */
	public void setPoint(Point point) {
		Position position = new Position();		
		// clear position list just to be sure you are only adding one point
		position.getPoint().clear();
		position.getPoint().add(point);
		setPosition(position);
	}
	
	/**
	 * Get point of node
	 * 
	 * @return Point  The point of the node
	 */
	@SuppressWarnings("unchecked")
	public Point getPoint() {
		Point point = null;
		// try and get first point, if not set return error message and null value
		if (getPosition() != null && getPosition().getPoint() != null) {
			List<Point> points =  (List<Point>)(List<?>) getPosition().getPoint();
			point = points.get(0);
		}
		else {
			Monitor.err("Node point not set.");
		}
		return point;
	}
	
	/**
	 * Returns whether node is termial or not, must have first run terminal
	 * 
	 * @return true if node is terminal, otherwise false
	 */
	public Boolean isTerminal() {
	  return isTerminal;
	}
	
	/**
   * Populates node input and output links by creating
   * references to it's input and output links.  
   * 
   * @param   Reference to Network node is on
   */   
  public void populate(Network myNetwork) {
    
    this.myNetwork = myNetwork;
    
    nOut = 0;
    if(getOutputs()!=null){
      nOut = getOutputs().getOutput().size();
      outputLink = new Link[nOut];
      for(int i=0;i<nOut;i++){
        edu.berkeley.path.model_objects.jaxb.Output output = getOutputs().getOutput().get(i);
        outputLink[i] = myNetwork.getLinkWithId(output.getLinkId());
      }
    }

    nIn = 0;
    if(getInputs()!=null){
      nIn = getInputs().getInput().size();
      inputLink = new Link[nIn];
      for(int i=0;i<nIn;i++){
        edu.berkeley.path.model_objects.jaxb.Input input = getInputs().getInput().get(i);
        inputLink[i] = myNetwork.getLinkWithId(input.getLinkId());
      }
    }
    
    isTerminal = nOut==0 || nIn==0;

      if(isTerminal)
        return;
  }
    
  /**
   * Node validation checks
   * 
   * @return True if all node validation is correct
   */ 
  public final Boolean isValid() {
    
    Boolean isValid = true;
    if(isTerminal) {
      return isValid;
    }
      
    if(outputLink!=null) {
      for(Link link : outputLink) {
        if(link==null) {
          Monitor.out("Incorrect output link id in node id=" + getId());
          isValid = false;
        }
      }
    }

    if(inputLink!=null) {
      for(Link link : inputLink) {
        if(link==null) {
          Monitor.out("Incorrect input link id in node id=" + getId());
          isValid = false;
        }
      }
    }
    
    if(nIn==0) {
      Monitor.out("No inputs into non-terminal node id=" + getId());
      isValid = false;
    }

    if(nOut==0) {
      Monitor.out("No outputs from non-terminal node id=" + getId());
      isValid = false;
    }
    
    return isValid;
    
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Node node = (Node) o;

    if (getId() != node.getId()) return false;
    if (getTypeId() != node.getTypeId()) return false;
    //TODO check primary name
    if (getPoint().getLongitude() != node.getPoint().getLongitude()) return false;
    if (getPoint().getLatitude() != node.getPoint().getLatitude()) return false;


    return true;
  }

  @Override
  public int hashCode() {
    return (isTerminal ? 1 : 0);
  }
}
