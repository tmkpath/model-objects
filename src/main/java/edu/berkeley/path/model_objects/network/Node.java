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
import java.math.BigDecimal;

import edu.berkeley.path.model_objects.jaxb.Inputs;
import edu.berkeley.path.model_objects.jaxb.Outputs;
import edu.berkeley.path.model_objects.jaxb.Position;
import edu.berkeley.path.model_objects.jaxb.RoadwayMarkers;
import edu.berkeley.path.model_objects.jaxb.Marker;
import edu.berkeley.path.model_objects.jaxb.Point;

import core.Monitor;

/** 
* Node class.
*
* @author Gabriel Gomes (gomes@path.berkeley.edu)
* @author Matthew Juhn	(mnjuhn@berkeley.edu)
*/
public final class Node extends edu.berkeley.path.model_objects.jaxb.Node {
		   
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
   * @return id of node as string
   */
  @Override
  public String getId() {
    return getId();
  }
  
  /**
   * Set id of node
   * 
   * @param id of node as string
   */
  @Override
  public void setId(String id) {
    setId(id);
  }
  
  /**
   * Return type of node
   * 
   * @return type of node as string
   */
  @Override
  public String getType() {
    // TODO: This should be changed to return Type object (id, string) mappings
    return getType();
  }
  
  /**
   * Set type of node
   * 
   * @param type of node as string
   */
  @Override
  public void setType(String type) {
    // TODO: This should be changed to take in Type object (id, string)
    setType(type);
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
	public Integer getInputLinkIndex(String id){
		for(int i=0;i<nIn;i++){
			if(inputLink[i]!=null)
				if(inputLink[i].getId().equals(id))
					return i;
		}
		return -1;
	}
	
  /** 
   * Get Index of link with given id in the list of output links of this node
   * 
   * @return  Index of link in output links array
   */ 
	public int getOutputLinkIndex(String id){
		for(int i=0;i<nIn;i++){
			if(outputLink[i]!=null)
				if(outputLink[i].getId().equals(id))
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
	 * Get First Name roadway marker name of node
	 * 
	 * @return	String  The name of the first roadway marker of the node
	 */
	public String getName() {
		List<Marker> markers = getRoadwayMarkers().getMarker();
		String name = null;
		if (!markers.isEmpty()) {
			name = markers.get(0).toString();
		}
		return name;
	}
	
	/**
	 * Adds roadway marker name to node
	 * 
	 * @param  String	Name of roadway marker to add to node
	 */
	public void setName(String name) {
		Marker marker = new Marker();
		marker.setName(name);
		
		// Try and get list of roadway markers
		RoadwayMarkers markers = getRoadwayMarkers();
		if (markers == null) {
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
	public Point getPoint() {
		List<Point> points =  this.position.getPoint();
		Point point = null;
		if (!points.isEmpty()) {
			points.get(0);
		}
		return point;
	}
	
	/**
   * Populates node input and output links by creating
   * references to it's input and output links.  
   * 
   * @param   Reference to Network node is on
   */   
  protected void populate(Network myNetwork) {
    
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
  protected Boolean isValid() {
    
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
    

}
