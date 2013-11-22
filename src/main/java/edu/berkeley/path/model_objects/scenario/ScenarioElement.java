/**
 * Copyright (c) 2013, Regents of the University of California
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

/**
 * Model Object to house Scenario Element references
 *
 * @author mnjuhn
 */
public class ScenarioElement extends edu.berkeley.path.model_objects.jaxb.ScenarioElement {

  /**
   * @param id the id to set
   */
  @Override
  public void setId(long id) {
    super.setId(id);
  }

  /**
   * @return the id
   */
  @Override
  public long getId() {
    return super.getId();
  }

  /**
   * Get Scenario Element Type for this object
   *
   * @return ScenarioElementType  An object representing the the id, name, and
   * description for this ScenarioElementType
   */
  @Override
  public edu.berkeley.path.model_objects.jaxb.ScenarioElementType getScenarioElementType() {
    return super.getScenarioElementType();
  }

  /**
   * Convenience method for users to get Scenario Element Type Id directly
   *
   * @return long The id of the ScenarioElementType
   */
  public Long getScenarioElementTypeId() {
    if (getScenarioElementType() != null) {
      return getScenarioElementType().getId();
    }
    else {
      return null;
    }
  }

  /**
   * Set the Scenario Element Type for this object based on the parameters passed in.
   *
   * @param typeId Id of the ScenarioElementType
   * @param name Name of the ScenarioElementType
   * @param desc Description of the ScenarioElementType
   */
  public void setScenarioElementType(long typeId, String name, String desc) {
    edu.berkeley.path.model_objects.jaxb.ScenarioElementType type =
        new edu.berkeley.path.model_objects.jaxb.ScenarioElementType();
    type.setId(typeId);
    type.setName(name);
    type.setDescription(desc);
    super.setScenarioElementType(type);
  }


}
