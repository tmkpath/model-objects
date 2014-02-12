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

  private final String message; // Validation message
  private final Severity severity; // Severity of message

  /**
   * Contructor the create Validation Message Object
   *
   * @param message   Validation Message
   * @param severity  Severity of message
   */
  public ValidationMessage(String message, Severity severity) {
    this.message = message;
    this.severity = severity;
  }

  /**
   * Returns Validation message
   *
   * @return message
   */
  public String getMessage() {
    return this.message;
  }

  /**
   * Returns Validaiton Message Severity
   * @return severity
   */
  public Severity getSeverity() {
    return this.severity;
  }


}
