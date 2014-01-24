/*
 * Copyright (c) 2013, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
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
 */

package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.util.ValidationMessage;
import edu.berkeley.path.model_objects.util.Validation;
import edu.berkeley.path.model_objects.util.ValidationResult;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ScenarioTest {

  private static final long ID = 1;
  private static final String NAME = "Scenario Name";
  private static final String DESCRIPTION = "Scenario Name";
  private static final Long PROJECT_ID = 0L;
  private static Scenario scenario;



  private Scenario createScenario() {
    scenario = new Scenario();
    scenario.setId(ID);
    scenario.setDescription(DESCRIPTION);
    scenario.setName(NAME);
    scenario.setProjectId(PROJECT_ID);
    return scenario;
  }

  @Test
  public void testGetters() {
    Scenario scenario = createScenario();

    try {
      Validation validation = new Validation();
      Validation.Context context = Validation.Context.DATABASE;
      ValidationResult result = validation.validate(scenario, scenario.getId(), context );
      System.out.println(result.getMessages(ValidationMessage.Severity.ERROR));

//      System.out.println("Initialize Drools");
//      RuleBase ruleBase = initialiseDrools();
//      WorkingMemory workingMemory = initializeScenarioObject(ruleBase);
//      int expectedNumberOfRulesFired = 1;
//
//      int actualNumberOfRulesFired = workingMemory.fireAllRules();
//
//      assertEquals(actualNumberOfRulesFired, expectedNumberOfRulesFired);
    } catch (Exception e ) {
      e.printStackTrace();
      Assert.fail();
    }
  }

  /*@Test
  public void testScenarioXMLFile() {
    try {
      file
    } catch (Exception e ) {
      e.printStackTrace();
      Assert.fail();
    }


  }*/

}

