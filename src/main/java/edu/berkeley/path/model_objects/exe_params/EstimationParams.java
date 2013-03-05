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

package edu.berkeley.path.model_objects.exe_params;

import edu.berkeley.path.model_objects.shared.*;
import core.Monitor;

import java.util.List;
import java.util.ArrayList;


/** 
 * EstimationParams - Run configuration for estimation
 *
 * @author Matthew Juhn (mnjuhn@berkeley.edu)
 */
public class EstimationParams extends edu.berkeley.path.model_objects.jaxb.EstimationParams {

  /**
   *  Return EnKF configuration Parameters
   *
   *  @return  EnKFConfig parameters
   */
  @Override
  public EnKFConfig getEnKFConfig() {
    return (EnKFConfig)super.getEnKFConfig();
  }
  
  /**
   *  Returns DateTime parameters
   *
   *  @return Model Object DateTime object 
   */
  @Override
  public edu.berkeley.path.model_objects.shared.DateTime getTimeBegin() {
    return (edu.berkeley.path.model_objects.shared.DateTime) (super.getTimeBegin());
  }
 
}