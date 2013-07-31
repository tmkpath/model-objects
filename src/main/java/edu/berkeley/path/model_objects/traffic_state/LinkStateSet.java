package edu.berkeley.path.model_objects.traffic_state;

import java.util.List;

/**
 * Extend LinkStateSet to allow setting the list of link states
 * (needed for faster serialization and bulk insertion)
 */
public class LinkStateSet extends edu.berkeley.path.model_objects.jaxb.LinkStateSet {

	public void setLinkStateList(List<LinkState> linkStateList) {
		this.linkState = (List<edu.berkeley.path.model_objects.jaxb.LinkState>)(List<?>)linkStateList;
	}
}
