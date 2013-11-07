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

import core.Monitor;
import edu.berkeley.path.model_objects.jaxb.Position;
import edu.berkeley.path.model_objects.shared.Point;
import edu.berkeley.path.model_objects.MOException;

import java.util.List;
import java.util.ArrayList;

/** Network class
* @author Gabriel Gomes (gomes@path.berkeley.edu)
* @author Matthew Juhn (mnjuhn@berkeley.edu)
*/
public class Network extends edu.berkeley.path.model_objects.jaxb.Network {

  /** @y.exclude */ protected boolean isempty;
  /** @y.exclude */ protected Point center; 
	
  /**
   * Return id of network
   * 
   * @return id of network as long
   */
  @Override
  public long getId() {
    return super.getId();
  }
  
  /**
   * Set id of network
   * 
   * @param id of network as long
   */
  @Override
  public void setId(long id) {
    super.setId(id);
  }
  
  /**
   * Return name of network
   * 
   * @return name of network as string
   */
  @Override
  public String getName() {
    return super.getName();
  }
  
  /**
   * Set name of network
   * 
   * @param name of network as string
   */
  @Override
  public void setName(String name) {
    super.setName(name);
  }
  
  /**
   * Return description of network
   * 
   * @return description of network as string
   */
  @Override
  public String getDescription() {
    return super.getDescription();
  }
  
  /**
   * Set name of description
   * 
   * @param description of network as string
   */
  @Override
  public void setDescription(String description) {
    super.setDescription(description);
  }
  
  /**
   * Return whether network is locked for edit
   * 
   * @return true if locked for edit, false if not
   */
  @Override
  public boolean isLockedForEdit() {
    return super.isLockedForEdit();
  }
  
  /**
   * Set whether network is locked for edit or not
   * 
   * @param locked is true if locked, false if not locked
   */
  @Override
  public void setLockedForEdit(Boolean locked) {
    super.setLockedForEdit(locked);
  }
  
  /**
   * Return whether network is locked historically.  
   * 
   * @return true if locked for edit, false if not
   */
  @Override
  public boolean isLockedForHistory() {
    return super.isLockedForHistory();
  }
  
  /**
   * Set whether network is locked historically. This should be set
   * when simulation is run on a network and output needs to reference 
   * the network state for historical/reproducible purposes.
   * 
   * @param locked is true if locked, false if locked
   */
  @Override
  public void setLockedForHistory(Boolean locked) {
    super.setLockedForHistory(locked);
  }
  
  /**
   * Gets the value of the modStamp property.
   * 
   * @return String representation of mod-stamp
   */
  @Override
  public String getModStamp() {
      return super.getModStamp();
  }

  /**
   * Sets the value of the modStamp property.
   * 
   * @param String value of database mod-stamp
   */
  @Override
  public void setModStamp(String value) {
      this.modStamp = value;
  }
  
  /**
   * Get Center Position of network, which is an average of
   * 
   * @return Center Point of Network in Degrees
   */
	public Point getCenter() {
	  return center;
	}
	
	/**
   * Get Bounding box around network
   * 
   * @return Bounding Box of Network in Degrees
   */
	@SuppressWarnings("unchecked")
  public List<Point> getBoundingPolygon() {
    // try and get bounding polygon not set, return null and error message
    if (getPosition() != null && getPosition().getPoint() != null) {
      return (List<Point>)(List<?>)getPosition().getPoint();
    }
    else {
      Monitor.err("Bounding Box not set.");
      return null;
    }
  }
	
	/**
   * Sets Bounding box around network from given list of points
   * 
   * @params List of points in degrees which represent Bounding Box
   */
  @SuppressWarnings("unchecked")
  public void setBoundingPolygon(List<Point> points) {
    // If we have at least 1 point in list set bounding polygon
		if (points != null && points.size() > 0) {
			// create new position class to house list of bounding box points
			Position position = new Position();
			position.getPoint().clear();
			position.getPoint().addAll(points);

			setPosition(position);
		}
		// Otherwise output error message
		else {
		  Monitor.err("Error could not set network bounding polygon, no points found.");
		}
  }
  
	/** 
	 * Returns whether network has a node(s) and link(s) after it has been populated
	 * 
	 * @return true if Node list or Link list is empty
	 */
	public Boolean isEmpty() {
		return isempty;
	}

	/** 
	 * Get link with given id.
	 * @param id of the link as a long.
	 * @return Link object.
	 */
	public Link getLinkWithId(long id){
		if(isempty)
			return null;
		for(edu.berkeley.path.model_objects.jaxb.Link link : getLinkList().getLink()){
			if(link.getId() == id)
				return (Link) link;
		}
		return null;
	}

	/** 
	 * Get node with given id.
	 * @param id of the node as long
	 * @return Node object.
	 */
	public Node getNodeWithId(long id){
		if(isempty)
			return null;
		for(edu.berkeley.path.model_objects.jaxb.Node node : getNodeList().getNode()){
			if(node.getId() == id)
				return (Node) node;
		}
		return null;
	}

	/** 
	 * Get the list of nodes in this network.
	 * 
	 * @return List of all nodes as Node Model Objects. 
	 */
	@SuppressWarnings("unchecked")
	public List<Node> getListOfNodes() {
	  edu.berkeley.path.model_objects.jaxb.NodeList nodeList = getNodeList();
	  // check if node list exists, if not create it and add empty list of nodes
    if ( nodeList == null ) {
      nodeList = new edu.berkeley.path.model_objects.jaxb.NodeList();  
      nodeList.getNode().clear();
      // set newly created node list object to network class, so a Nodelist now exists
      setNodeList(nodeList);
    }
    // return casted list of Nodes from JAXB base class
    return (List<Node>)(List<?>)nodeList.getNode();
  }

	/** 
	 * Get the list of links in this network.
	 * 
	 * @return List of all links as Link model objects. 
	 */
  @SuppressWarnings("unchecked")
	public List<Link> getListOfLinks() {
	  edu.berkeley.path.model_objects.jaxb.LinkList linkList = getLinkList();
    // check if links list exists, if not create it and add empty list of links
    if ( linkList == null ) {
      linkList = new edu.berkeley.path.model_objects.jaxb.LinkList();  
      linkList.getLink().clear();
      // set newly created link list object to network class, so a Linklist now exists
      setLinkList(linkList);
    }
    // return casted list of Links from JAXB base class
    return (List<Link>)(List<?>)linkList.getLink();	
	}
	
	/**
	 * Set the nodes. Attaches list of Node Model Objects to network.
	 * 
	 * @param List<Node>	List of extended Nodes to add
	 */
	@SuppressWarnings("unchecked")
	public void setListOfNodes(List<Node> nodes) {
	  edu.berkeley.path.model_objects.jaxb.NodeList nodeList = getNodeList();
		if ( nodeList == null ) {
		  nodeList = new edu.berkeley.path.model_objects.jaxb.NodeList();  
		}
		nodeList.getNode().clear();
		nodeList.getNode().addAll((List<edu.berkeley.path.model_objects.jaxb.Node>)(List<?>)nodes);
		setNodeList(nodeList);
	}
	  
	/**
	 * Set the links. Attaches list of Link Model Objects to network.
	 * 
	 * @param List<Link>  List of extended Links to add
	 */
	@SuppressWarnings("unchecked")
	public void setListOfLinks(List<Link> links) {
	  edu.berkeley.path.model_objects.jaxb.LinkList linkList = getLinkList();
    if ( linkList == null ) {
      linkList = new edu.berkeley.path.model_objects.jaxb.LinkList();  
    }
    linkList.getLink().clear();
    linkList.getLink().addAll((List<edu.berkeley.path.model_objects.jaxb.Link>)(List<?>)links);
    setLinkList(linkList);
	}

  /**
   * Based on the begin and end nodes of links, this sets the input and output links of all
   * nodes in the network.  This method assumes all links begin and end node are correctly set.
   *
   * NOTE: This method should be called before populate when reading from the database (since input and output links
   * are not stored in the DB) or when unmarshalling from XML or JSON which doesnot define input/output links.
   *
   * @return void
   * @throws MOException
   */
  @SuppressWarnings("unchecked")
  public void setInputOutputLinks() throws MOException {

    // cycle through lise of links and for each node add input/output links
    for (Link link : getListOfLinks()) {

        // get begin and end nodes based on id
        Node beginNode = getNodeWithId(link.getBeginNodeId());
        Node endNode = getNodeWithId(link.getEndNodeId());
        if (beginNode == null) {
          throw new MOException(null, "Invalid begin node id value for Link id " + link.getId());
        }
        if (endNode == null) {
          throw new MOException(null, "Invalid end node id value for Link id \" + link.getId()");
        }
        // add link as output link to begin node and input link to end node
        beginNode.addOutputLink(link.getId());
        endNode.addInputLink(link.getId());
    }
  }
	
	/**
   * Populates all network dependencies by moving along it's node list
   * and creating references to it's input and output links and moving 
   * along it's links list and creating references for begin and end node
   * 
   * @return void
   */
  public void populate() {
    
    this.isempty = getNodeList()==null || getLinkList()==null;
    
    if(isempty) 
      return;
  
    for (edu.berkeley.path.model_objects.jaxb.Node node : getNodeList().getNode())
      ((Node) node).populate(this);
  
    for (edu.berkeley.path.model_objects.jaxb.Link link : getLinkList().getLink())
      ((Link) link).populate(this);   
  }
  
  /**
   * Network wide validation for insertion into DB
   * 
   * @return true if network is valid
   */
  public final Boolean isValid() {
    // TODO: Validate Network for insertion to DB, return true for now
    return true;
    /*
    Boolean validLinks = true;
    Boolean validNodes = true;
    // Check if network is empty  
    if(isempty) {
      Monitor.err("Invalid Network. Network is empty.");
      return false;
    }

    // node list validation
    for (edu.berkeley.path.model_objects.jaxb.Node node : getNodeList().getNode()) { 
      validNodes = ((Node)node).isValid();
    }
    // link list validation
    for (edu.berkeley.path.model_objects.jaxb.Link link : getLinkList().getLink()) {
      validLinks = ((Link)link).isValid();
    }
    
    // return true if nodelist and linklist is valid, otherwise false
    if (validLinks && validNodes) {
      return true;
    }
    else {
      return false;
    }*/
  }
  
  /**
   * Calculates bounding box by finding the min and max, lat and long
   * of all nodes
   * 
   * @return  List of points representing rectangular Bounding Box of network
   */
  public List<Point> calculateBoundingBox() throws MOException {
    List<Node> nodes = getListOfNodes();
    // set all values to null
    Double minLat = null;
    Double maxLat = null;
    Double minLong = null;
    Double maxLong = null;
    if ( nodes != null && nodes.size() > 0) {
      for (Node node : nodes) {
        // if latitude is not set or is less than current min, set a new minimum latitude 
        if (minLat == null || minLat > ((Point) node.getPoint()).getLatitude() ){
          minLat = ((Point) node.getPoint()).getLatitude();
        }
        // if longitude is not set or is less than current min, set a new minimum longitude 
        if (minLong== null || minLong > ((Point) node.getPoint()).getLongitude() ){
          minLong = ((Point) node.getPoint()).getLongitude();
        }
        // if latitude is not set or is greater than current max, set a new maximum latitude 
        if (maxLat == null || maxLat < ((Point) node.getPoint()).getLatitude() ){
          maxLat = ((Point) node.getPoint()).getLatitude();
        }
        // if longitude is not set or is greater than current max, set a new maximum longitude 
        if (maxLong== null || maxLong < ((Point) node.getPoint()).getLongitude() ){
          maxLong = ((Point) node.getPoint()).getLongitude();
        }
      } 
      
      // Set list of points which are top left and bottom right of bounding box
      ArrayList<Point> points = new ArrayList<Point>();
      Point max = new Point();
			// TODO : Figure out why oracles is valid geometry returns false when creating a polygon
			// on a bounding box with maxLat, maxLong and minLat, minLong points.
      max.setLatitude(maxLat);
      max.setLongitude(minLong);
      
      Point min = new Point();
      min.setLatitude(minLat);
      min.setLongitude(maxLong);
      
      points.add(max);
      points.add(min);
      
      return points;
    }
    else {
      throw new MOException(null, "Could not calculate Bounding Box. No Nodes set in network.");
    }
    
  }
  
  /**
   * Calculate Center Position of network, which is an average of all positions
   * 
   * @return Center Point of Network in Degrees
   */
  public void calculateCenter() throws MOException {
    List<Node> nodes = getListOfNodes();
    Double avgLat = 0.0d;
    Double avgLong = 0.0d;
    if ( nodes != null && nodes.size() > 0) {
      for (Node node : nodes) {
        avgLat += ((Point) node.getPoint()).getLatitude();
        avgLong += ((Point) node.getPoint()).getLongitude();
      }
      // set network center point
      center.setLatitude(avgLat/nodes.size());
      center.setLongitude(avgLong/nodes.size());
    }
    else {
      throw new MOException(null, "Could not calculate Bounding Box. No Nodes set in network.");
    }
  }
}
