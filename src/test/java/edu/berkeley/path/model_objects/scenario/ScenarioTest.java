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

/*package edu.berkeley.path.model_objects.scenario;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsError;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.compiler.PackageBuilderErrors;
import org.drools.rule.*;
import org.drools.rule.Package;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ScenarioTest {

  private static final long ID = 1;
  private static final String NAME = "Scenario Name";
  private static final String DESCRIPTION = "Scenario Name";
  private static final Long PROJECT_ID = 1L;
  private static Scenario scenario;

  private RuleBase initialiseDrools() throws IOException, DroolsParserException {
    PackageBuilder packageBuilder = readRuleFiles();
    return addRulesToWorkingMemory(packageBuilder);
  }

  private PackageBuilder readRuleFiles() throws DroolsParserException, IOException {
    PackageBuilder packageBuilder = new PackageBuilder();

    String ruleFile = "/edu/berkeley/path/model_objects/scenario/scenario.drl";
    Reader reader = getRuleFileAsReader(ruleFile);
    packageBuilder.addPackageFromDrl(reader);

    assertNoRuleErrors(packageBuilder);

    return packageBuilder;
  }

  private Reader getRuleFileAsReader(String ruleFile) {
    InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

    return new InputStreamReader(resourceAsStream);
  }

  private RuleBase addRulesToWorkingMemory(PackageBuilder packageBuilder) {
    RuleBase ruleBase = RuleBaseFactory.newRuleBase();
    Package rulesPackage = packageBuilder.getPackage();
    ruleBase.addPackage(rulesPackage);

    return ruleBase;
  }

  private void assertNoRuleErrors(PackageBuilder packageBuilder) {
    PackageBuilderErrors errors = packageBuilder.getErrors();

    if (errors.getErrors().length > 0) {
      StringBuilder errorMessages = new StringBuilder();
      errorMessages.append("Found errors in package builder\n");
      for (int i = 0; i < errors.getErrors().length; i++) {
        DroolsError errorMessage = errors.getErrors()[i];
        errorMessages.append(errorMessage);
        errorMessages.append("\n");
      }
      errorMessages.append("Could not parse knowledge");

      throw new IllegalArgumentException(errorMessages.toString());
    }
  }

  private WorkingMemory initializeScenarioObject(RuleBase ruleBase) {
    WorkingMemory workingMemory = ruleBase.newStatefulSession();

    createScenario(workingMemory);

    return workingMemory;
  }

  private void createScenario(WorkingMemory workingMemory) {
    scenario = new Scenario();
    scenario.setId(ID);
    scenario.setDescription(DESCRIPTION);
    scenario.setName(NAME);
    scenario.setProjectId(PROJECT_ID);
    workingMemory.insert(scenario);
  }

  @Test
  public void testGetters() {
    try {
      System.out.println("Initialize Drools");
      RuleBase ruleBase = initialiseDrools();
      WorkingMemory workingMemory = initializeScenarioObject(ruleBase);
      int expectedNumberOfRulesFired = 1;

      int actualNumberOfRulesFired = workingMemory.fireAllRules();

      assertEquals(actualNumberOfRulesFired, expectedNumberOfRulesFired);
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


  } */

