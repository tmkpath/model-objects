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

import edu.berkeley.path.model_objects.shared.CrudFlag;

import edu.berkeley.path.model_objects.jaxb.LinkReference;
import edu.berkeley.path.model_objects.jaxb.LinkReferences;

import java.util.List;

/** Route class
* @author Matthew Juhn (mnjuhn@berkeley.edu)
*/
public class RouteLink extends edu.berkeley.path.model_objects.jaxb.RouteLink {

    /**
     * Return id of route link
     *
     * @return id of route link as long
     */
    @Override
    public long getId() {
        return super.getId();
    }

    /**
     * Set id of route link
     *
     * @param id of route link
     */
    @Override
    public void setId(long id) {
        super.setId(id);
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
	 * @param  flag enumeration
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
     * @param value of database mod-stamp
     */
    @Override
    public void setModStamp(String value) {
        this.modStamp = value;
    }

    /**
     * Return order of route link
     *
     * @return order of route link as long
     */
    @Override
    public int getLinkOrder() {
        return super.getLinkOrder();
    }

  /**
   * Set order of link in route
   *
   * @param linkOrder as long
   */
  @Override
  public void setLinkOrder(int linkOrder) {
    super.setLinkOrder(linkOrder);
  }

  /**
   * Return Link ID of the of route link
   *
   * @return linkId as long
   */
  @Override
  public long getLinkId() {
    return super.getLinkId();
  }

  /**
   * Set Link ID of the route link
   *
   * @param linkId as long
   */
  @Override
  public void setLinkId(long linkId) {
    super.setLinkId(linkId);
  }

}