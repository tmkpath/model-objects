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
package edu.berkeley.path.model_objects.util;

/**
 * Class to store Validation Messages and their severity (Error, Warning, etc).
 *
 * @author mnjuhn
 */
public class ValidationMessage {

  /**
   * Classification of Validation Message Severity
   */
  public static enum Severity {
    /**
     * Labels message an error (program execution should be stopped)
     */
    ERROR,
    /**
     * Labels message a warning (program execution continues but message should be displayed to user)
     */
    WARNING
  }

  private final String object; // Object generating validation message
  private final String objectId; // Id of Object generating validation message
  private final String message; // Validation message
  private final String context;  // Context Object was being evaluated in
  private final Severity severity; // Severity of message

  /**
   * Contructor the create Validation Message Object
   *
   * @param object    Object being validated
   * @param objectId  Id of Object being validated
   * @param message   Validation Message
   * @param context   Context object is validated within
   */
  public ValidationMessage(String object, String objectId, String message, String context, Severity severity) {
    this.object = object;
    this.objectId = objectId;
    this.message = message;
    this.context = context;
    this.severity = severity;
  }

  public String getMessage() {
    return this.message;
  }


}
