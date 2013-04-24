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
 * 3. Neither the name of the University nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
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

package edu.berkeley.path.model_objects;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Model Object Exception class, thrown when Model object error occurs
 * @author mnjuhn
 */
@SuppressWarnings("serial")
public class MOException extends Exception {
  
   /**
    * MOException constructor 
    * @param cause A root exception
    * @param causeStr A description of the exception.
    */
   public MOException( Throwable cause, String causeStr) {
       super( MOException.makeMessage( cause, causeStr), cause );
   }

   /**
    * This is here only to get around the rule that the super call must be the
    * first thing in a constructor in Java.
    * @param cause A root exception
    * @param causeStr A description of the exception.
    */
   private static String makeMessage(  Throwable cause, String causeStr) {
       StringBuilder sb = new StringBuilder();

       sb.append("CAUSE: ").append( causeStr ).append("\n");

       // If in debug mode show stack traces
       if (System.getProperty("debug")  == "true") {
         sb.append("STACKTRACE: ").append( getStackTrace(cause) ).append("\n");
       }

       return sb.toString();
   }
   
   /**
    * This function returns a string representation of a stack trace
    * 
    * @param cause A root exception
    * @return String representation of exceptions stacktrace
    */
   private static String getStackTrace (Throwable cause) {
     // If exception cause is not null try and get is stack trace
     if (cause != null) {
       // need to use string writer class hold string representation of stack trace
       StringWriter sw = new StringWriter();
       cause.printStackTrace(new PrintWriter(sw));
       return sw.toString();
     } else {
       return null;
     }
   }
     
}
