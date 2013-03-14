package edu.berkeley.path.model_objects.shared;

import java.util.ArrayList;


public class DisplayPosition extends edu.berkeley.path.model_objects.jaxb.DisplayPosition{
	/** @y.exclude */ protected ArrayList<Point> point = new ArrayList<Point>();

    /**
     * Gets the value of the point property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the point property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoints().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Point }
     * 
     * 
     */
	public ArrayList<Point> getPoints() {
		return point;
	}
}
