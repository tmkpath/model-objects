package edu.berkeley.path.model_objects.traffic_state;

import java.util.List;

/**
 * Extend LinkStateDebugSet to allow setting the list of link states
 * (needed for faster serialization and bulk insertion)
 */
public class LinkStateDebugSet extends edu.berkeley.path.model_objects.jaxb.LinkStateDebugSet {

	public void setLinkStateDebugList(List<LinkState> linkStateList) {
		this.linkStateDebug = (List<edu.berkeley.path.model_objects.jaxb.LinkStateDebug>)(List<?>)linkStateList;
	}

}
