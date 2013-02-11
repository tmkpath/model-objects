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

import java.util.List;


/** Network class
* @author Gabriel Gomes (gomes@path.berkeley.edu)
* @author Matthew Juhn (mnjuhn@berkeley.edu)
*/
public final class Network extends edu.berkeley.path.model_objects.jaxb.Network {

	protected boolean isempty;
	
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
	 * Returns whether network has a node(s) and link(s)
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return isempty;
	}

	/**
	 * Network wide validation
	 */
	protected void validate() {

		if(isempty)
			return;
		
		// node list
		for (edu.berkeley.path.model_objects.jaxb.Node node : getNodeList().getNode())
			((Node)node).validate();

		// link list
		for (edu.berkeley.path.model_objects.jaxb.Link link : getLinkList().getLink())
			((Link)link).validate();
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
		List<edu.berkeley.path.model_objects.jaxb.Node> nodeList = getNodeList().getNode();
		nodeList = (List<edu.berkeley.path.model_objects.jaxb.Node>)(List<?>)value;
	}
	  
	/**
	 * Set the links. Same as setLinkList(), but works with a list of Link.
	 */
	@SuppressWarnings("unchecked")
	public void setExtendedLinkList(List<Link> value) {
		List<edu.berkeley.path.model_objects.jaxb.Link> linkList = getLinkList().getLink();
		linkList = (List<edu.berkeley.path.model_objects.jaxb.Link>)(List<?>)value;
	}
	

}
