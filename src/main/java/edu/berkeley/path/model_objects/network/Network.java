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

import java.util.List;


/** Network class
* @author Gabriel Gomes (gomes@path.berkeley.edu)
* @author Matthew Juhn (mnjuhn@berkeley.edu)
*/
public class Network extends edu.berkeley.path.model_objects.jaxb.Network {

  /** @y.exclude */  protected boolean isempty;
	
  /**
   * Return id of network
   * 
   * @return id of network as string
   */
  @Override
  public String getId() {
    return super.getId();
  }
  
  /**
   * Set id of network
   * 
   * @param id of network as string
   */
  @Override
  public void setId(String id) {
    super.setId(id);
  }
  
  /**
   * Return name of network
   * 
   * @return id of link as string
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
	 * Returns whether network has a node(s) and link(s) after it has been populated
	 * 
	 * @return true if Node list or Link list is empty
	 */
	public Boolean isEmpty() {
		return isempty;
	}

	/** 
	 * Get link with given id.
	 * @param id String id of the link.
	 * @return Link object.
	 */
	public Link getLinkWithId(String id){
		if(isempty)
			return null;
		id.replaceAll("\\s","");
		for(edu.berkeley.path.model_objects.jaxb.Link link : getLinkList().getLink()){
			if(link.getId().equals(id))
				return (Link) link;
		}
		return null;
	}

	/** 
	 * Get node with given id.
	 * @param id String id of the node.
	 * @return Node object.
	 */
	public Node getNodeWithId(String id){
		if(isempty)
			return null;
		id.replaceAll("\\s","");
		for(edu.berkeley.path.model_objects.jaxb.Node node : getNodeList().getNode()){
			if(node.getId().equals(id))
				return (Node) node;
		}
		return null;
	}

	/** 
	 * Get the list of nodes in this network.
	 * @return List of all nodes as jaxb objects. 
	 * Each of these may be cast to a {@link Node}.
	 */
	public List<edu.berkeley.path.model_objects.jaxb.Node> getListOfNodes() {
		if(isempty)
			return null;
		if(getNodeList().getNode()==null)
			return null;
		return getNodeList().getNode();
	}

	/** 
	 * Get the list of links in this network.
	 * @return List of all links as jaxb objects. 
	 * Each of these may be cast to a {@link Link}.
	 */
	public List<edu.berkeley.path.model_objects.jaxb.Link> getListOfLinks() {
		if(isempty)
			return null;
		if(getLinkList().getLink()==null)
			return null;
		return getLinkList().getLink();	
	}
	
	/**
	 * Set the nodes. Same as setNodeList(), but works with a list of Node.
	 * 
	 * @param List<Node>	List of extended Nodes to add
	 */
	@SuppressWarnings("unchecked")
	public void setExtendedNodeList(List<Node> value) {
	  edu.berkeley.path.model_objects.jaxb.NodeList nodeList = getNodeList();
		if ( nodeList == null ) {
		  nodeList = new edu.berkeley.path.model_objects.jaxb.NodeList();  
		}
		
		nodeList.getNode().addAll((List<edu.berkeley.path.model_objects.jaxb.Node>)(List<?>)value);
		setNodeList(nodeList);
	}
	  
	/**
	 * Set the links. Same as setLinkList(), but works with a list of Link.
	 * 
	 * @param List<Link>  List of extended Links to add
	 */
	@SuppressWarnings("unchecked")
	public void setExtendedLinkList(List<Link> value) {
	  edu.berkeley.path.model_objects.jaxb.LinkList linkList = getLinkList();
    if ( linkList == null ) {
      linkList = new edu.berkeley.path.model_objects.jaxb.LinkList();  
    }
    
    linkList.getLink().addAll((List<edu.berkeley.path.model_objects.jaxb.Link>)(List<?>)value);
    setLinkList(linkList);
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
   * Network wide validation
   * 
   * @return true if network is valid
   */
  protected Boolean isValid() {

    Boolean validLinks = true;
    Boolean validNodes = true;
    // Check if network is empty  
    if(isempty) {
      Monitor.out("Invalid Network. Network is empty.");
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
    }
  }
  
}
