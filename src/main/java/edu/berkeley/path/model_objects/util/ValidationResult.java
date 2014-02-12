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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import core.Monitor;

/**
 * Class to store results of validation process.
 *
 * @author mnjuhn
 */
public class ValidationResult {

  private int numOfRulesFired;
  private final String object; // Object generating validation message
  private final Long objectId; // Id of Object generating validation message
  private final String context;  // Context Object was being evaluated in
  // Hashmap of validation messages indexed by severity
  private final Map<ValidationMessage.Severity, List<ValidationMessage>> messages;

  /**
   * Constructor the create Validation Result Object.
   *
   * @param object    Object being validated
   * @param objectId  Id of Object being validated
   * @param context   Context object is validated within
   */
  public ValidationResult(String object, Long objectId, String context) {
    this.object = object;
    this.objectId = objectId;
    this.context = context;
    this.messages = new HashMap<ValidationMessage.Severity, List<ValidationMessage>>();
  }

  /**
   * Add message to validation result map
   *
   * @param message   Error or Warning message
   * @param severity  Severity of message (ie. Error or Warning)
   */
  public void addMessage(String message, ValidationMessage.Severity severity) {

    // Create new Validation message
    ValidationMessage validationMessage = new ValidationMessage(message, severity);

    // add message list for given severity to Map since one does not exists
    if (this.messages.get(severity) == null) {
      ArrayList<ValidationMessage> messageList = new ArrayList<ValidationMessage>();
      this.messages.put(severity, messageList);
    }
    // Add message to Hash Map by severity as key
    List<ValidationMessage> messageList;
    messageList = this.messages.get(severity);

    messageList.add(validationMessage);
  }

  /**
   * Get Messages by severity, each formatted on a new line.
   * Returns null if any.
   *
   * @param severity  Severity type of messages to get.
   *
   * @return Error and Warning messages.
   */
  public String getMessages(ValidationMessage.Severity severity) {
    String messagesStr = "";
    List<ValidationMessage> messageList = this.messages.get(severity);
    if (messageList != null) {
      // add each message of given severity to message String
      for (ValidationMessage message : messageList) {
        messagesStr = messagesStr + severity.name() + " : " + message.getMessage() + "\n";
      }
    }
    return messagesStr;
  }

  /**
   * Returns whether or not evaluation of object and in context was valid or not.
   * Valid means there where no errors thrown, but there possibly might be warnings.
   *
   * @return true if validation produced no errors, otherwise false.
   */
  public boolean isValid() {
    if (this.messages.get(ValidationMessage.Severity.ERROR) == null) {
      return true;
    } else {
      return false;
    }
  }

  public int getNumOfRulesFired() {
    return this.numOfRulesFired;
  }

  public void setNumOfRulesFired(int numOfRules) {
    this.numOfRulesFired = numOfRules;
  }

  public int getNumOfErrors() {
    return this.messages.get(ValidationMessage.Severity.ERROR).size();
  }

  public int getNumOfWarnings() {
    return this.messages.get(ValidationMessage.Severity.WARNING).size();
  }


}
