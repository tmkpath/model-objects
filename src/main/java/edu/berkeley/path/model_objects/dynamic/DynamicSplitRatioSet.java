/**
 * Copyright (c) 2012 The Regents of the University of California.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

package edu.berkeley.path.model_objects.dynamic;

import java.util.List;

import edu.berkeley.path.model_objects.dynamic.DynamicSplitRatioProfile;
import edu.berkeley.path.model_objects.shared.DateTime;

public class DynamicSplitRatioSet extends edu.berkeley.path.model_objects.jaxb.DynamicSplitRatioSet {

  /**
   * Get the profile at the specified node.
   * Return Split Ratio Profile associated with the node passed in.
   * If there are no profiles associated with this node null is returned.
   *
   * @param nodeId get split ratio profile associated with the node
   * @return DynamicSplitRatioProfile or null if not found
   */
  public DynamicSplitRatioProfile getSplitRatioProfileAtNode(long nodeId) {

    for(DynamicSplitRatioProfile p : getListOfSplitRatioProfiles()) {
      if(p.getNodeId() == nodeId) {
        return p;
      }
    }
    // Otherwise not found so return null
    return null;
  }


  /**
   * Get App run id
   *
   * @return app run id
   */
  @Override
  public long getAppRunId() {
    return this.appRunId;
  }

  /**
   * Set App run id
   *
   * @param value representing app run id
   */
  @Override
  public void setAppRunId(long value) {
    this.appRunId = value;
  }

  /**
   * Get Estimation timestamp as represented as Model Object DateTime object
   *
   * @return date time object
   */
  public DateTime getEstimationTstamp() {
    return (DateTime) this.estTstamp;
  }

  /**
   * Set Estimation timestamp as represented as Model Object DateTime object
   *
   * @param value representing date time object
   */
  public void setEstimationTstamp(DateTime value) {
    this.estTstamp = value;
  }

  /**
   * Gets the value of the description property.
   *
   * @return String
   *
   */
  @Override
  public String getDescription() {
    return super.getDescription();
  }

  /**
   * Sets the value of the description property.
   *
   * @param String value
   *
   */
  @Override
  public void setDescription(String value) {
    super.setDescription(value);
  }

  /**
   * Gets the value of the splitRatioProfile property.
   *
   *
   * @return List<DynamicSplitRatioProfile>
   *
   *
   */
  @SuppressWarnings("unchecked")
  public List<DynamicSplitRatioProfile> getListOfSplitRatioProfiles() {
    // return casted list of Nodes from JAXB base class
    return (List<DynamicSplitRatioProfile>)(List<?>)super.getDynamicSplitRatioProfile();
  }

  /**
   * Set the split ratios profiles list. Attaches list of Split Ratio Profile Model Objects to set.
   *
   * @param List<DynamicSplitRatioProfile>	List of extended Split Ratio Profiles to add
   */
  @SuppressWarnings("unchecked")
  public void setListOfSplitRatioProfiles(List<DynamicSplitRatioProfile> ratios) {
    getDynamicSplitRatioProfile().clear();
    getDynamicSplitRatioProfile().addAll((List<edu.berkeley.path.model_objects.jaxb.DynamicSplitRatioProfile>)(List<?>)ratios);
  }

  /**
   * Gets the value of the id property.
   *
   * @return long
   */
  @Override
  public long getId() {
    return super.getId();
  }

  /**
   * Sets the value of the id property.
   *
   * @param long
   *
   */
  @Override
  public void setId(long value) {
    super.setId(value);
  }

  /**
   * Gets the value of the name property.
   *
   * @return String
   *
   */
  @Override
  public String getName() {
    return super.getName();
  }

  /**
   * Sets the value of the name property.
   *
   * @param String value
   *
   */
  @Override
  public void setName(String value) {
    super.setName(value);
  }

  /**
   * @param modstamp the modstamp to set
   */
  @Override
  public void setModStamp(String modstamp) {
    super.setModStamp(modstamp);
  }

  /**
   * @return the modStamp
   */
  @Override
  public String getModStamp() {
    return super.getModStamp();
  }

  /**
   * Gets the value of the lockedForEdit property.
   *
   * @return boolean
   *
   */
  @Override
  public boolean isLockedForEdit() {
    return super.isLockedForEdit();
  }

  /**
   * Sets the value of the lockedForEdit property.
   *
   * @param Boolean value
   *
   */
  @Override
  public void setLockedForEdit(Boolean value) {
    super.setLockedForEdit(value);
  }

  /**
   * Gets the value of the lockedForHistory property.
   *
   * @return boolean
   *
   */
  @Override
  public boolean isLockedForHistory() {
    return super.isLockedForHistory();
  }

  /**
   * Sets the value of the lockedForHistory property.
   *
   * @param Boolean value
   *
   */
  @Override
  public void setLockedForHistory(Boolean value) {
    super.setLockedForHistory(value);
  }

  /**
   * Ensures all required fields are set
   *
   * @return True if valid
   */
  public boolean isValid(){
    // TODO - validation logic
    return true;
  }


}
