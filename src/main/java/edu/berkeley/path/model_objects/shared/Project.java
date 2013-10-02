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

import edu.berkeley.path.model_objects.jaxb.*;

/**
 * Project class which is used to group scenario's and sets under a project.
 */
public class Project extends edu.berkeley.path.model_objects.jaxb.Project {

  /**
   * Return id of project
   *
   * @return id of Project as long
   */
  @Override
  public long getId() {
    return super.getId();
  }

  /**
   * Set id of Project
   *
   * @param id of Project as long
   */
  @Override
  public void setId(long id) {
    super.setId(id);
  }

  /**
   * Return name of Project
   *
   * @return name of Project as string
   */
  @Override
  public String getName() {
    return super.getName();
  }

  /**
   * Set name of Project
   *
   * @param name of Project as string
   */
  @Override
  public void setName(String name) {
    super.setName(name);
  }

  /**
   * Return description of Project
   *
   * @return description of Project as string
   */
  @Override
  public String getDescription() {
    return super.getDescription();
  }

  /**
   * Set name of description
   *
   * @param description of Project as string
   */
  @Override
  public void setDescription(String description) {
    super.setDescription(description);
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
}
