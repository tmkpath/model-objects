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

package edu.berkeley.path.model_objects.shared;

import core.Monitor;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimeFormatter;

/**
 * DateTime class model object which utilizes joda time functionality
 * 
 * @author mnjuhn
 */
public class DateTime extends edu.berkeley.path.model_objects.jaxb.DateTime {

  /** 
   * List of valid datetime parsing patterns
   * DateTime parsing symbols can be found here: 
   * http://joda-time.sourceforge.net/apidocs/org/joda/time/format/DateTimeFormat.html
   */ 
  private final DateTimeParser[] parsers = { 
        DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss.SS").getParser(),
        DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss" ).getParser()
      };
  
  /**
   * DateTime format builder used based on parsing patterns defined above
   */
  private DateTimeFormatter formatter = 
      new DateTimeFormatterBuilder().append( null, parsers ).toFormatter();
  
  /**
   * Constructor takes in milliseconds
   *
   * @param milliseconds Time in milliseconds since 1970 UTC
   */
  public DateTime(long milliseconds) {
    setMilliseconds(milliseconds);
  }
 
  /**
   * Constructor sets to midnight 1970 UTC
   *
   */
  public DateTime() {
    setMilliseconds(0);
  }
 
  /**
   * Convert Datetime object representation to Jodadate time object
   * 
   * @return Joda datetime object
   */
  public org.joda.time.DateTime toJoda() {
    return new org.joda.time.DateTime(getMilliseconds());
  }
  
  /**
   * Update Datetime object by parsing date string and return Joda datetime object
   * 
   * @return Joda datetime object
   */
  public org.joda.time.DateTime setDateString(String date) {
    org.joda.time.DateTime joda = null;
    try {
      joda =  this.formatter.parseDateTime(date);
      // get milliseconds from to set
      setMilliseconds(joda.getMillis());
    } catch (Exception e) {
      Monitor.debug("Error Setting date string to joda time: " + date);
    }
    return joda;
  }
  
  /**
   * Create new Datetime model object from Joda DateTime
   * 
   * @return  New Datetime model object
   */
  public static DateTime fromJoda(org.joda.time.DateTime joda) {
    return new DateTime(joda.getMillis());
  }
  
}