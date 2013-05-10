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

package edu.berkeley.path.model_objects.shared;

import java.util.ArrayList;
import java.util.List;


/** 
 * Model Object Position class
 * 
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 * @author mnjuhn
 */
public class Position extends edu.berkeley.path.model_objects.jaxb.Position{
	
	/**
	 * TODO: Validation
	 * TODO: Unit Tests
	 */

	/**
	 * Return list of points in position
	 *
	 * @return list of points
	 */
	public List<Point> getPoints() {
		// Return list of model object Points in position object
		// Note the setPosition method must have been used since it passes in
		// a list of model object extended points
		return (List<Point>) (List<?>) super.getPoint();
	}

	/**
	 * Sets position to have list of points
	 *
	 * @param points list of points
	 */
	public void setPoints(List<Point> points) {
		// clear all position points currently set and add list
		if (super.getPoint() != null ) {
			super.getPoint().clear();
		}
		super.getPoint().addAll(points);
	}


}
