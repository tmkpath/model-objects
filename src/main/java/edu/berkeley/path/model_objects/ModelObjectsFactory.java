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

package edu.berkeley.path.model_objects;

import edu.berkeley.path.model_objects.jaxb.ObjectFactory;
import edu.berkeley.path.model_objects.measurements.PIFProbeData;
import edu.berkeley.path.model_objects.measurements.PIFProbeDataSet;
import edu.berkeley.path.model_objects.network.Link;
import edu.berkeley.path.model_objects.network.Network;
import edu.berkeley.path.model_objects.network.NetworkFactory;
import edu.berkeley.path.model_objects.network.Node;
import edu.berkeley.path.model_objects.scenario.*;
import edu.berkeley.path.model_objects.shared.Point;
import edu.berkeley.path.model_objects.shared.Position;
import edu.berkeley.path.model_objects.shared.Project;
import edu.berkeley.path.model_objects.shared.SharedObjectFactory;

/**
 * This factory is intended to load a whole scenario from JSON/XML
 * Grouping all existing factories we can get a full model-objects representation instead of some jaxb-based elements
 */
public class ModelObjectsFactory extends ObjectFactory {
  private ScenarioFactory scenarioFactory = new ScenarioFactory();
  private NetworkFactory networkFactory = new NetworkFactory();
  private SharedObjectFactory sharedFactory = new SharedObjectFactory();

  @Override
  public Actuator createActuator() {
    return new Actuator();
  }

  @Override
  public ActuatorSet createActuatorSet() {
    return new ActuatorSet();
  }

  @Override
  public Sensor createSensor() {
    return scenarioFactory.createSensor();
  }

  @Override
  public SensorSet createSensorSet() {
    return scenarioFactory.createSensorSet();
  }

  @Override
  public Density createDensity() {
    return scenarioFactory.createDensity();
  }

  @Override
  public InitialDensitySet createInitialDensitySet() {
    return scenarioFactory.createInitialDensitySet();
  }

  @Override
  public DemandSet createDemandSet() {
    return scenarioFactory.createDemandSet();
  }

  @Override
  public DemandProfile createDemandProfile() {
    return scenarioFactory.createDemandProfile();
  }

  @Override
  public FundamentalDiagramSet createFundamentalDiagramSet() {
    return scenarioFactory.createFundamentalDiagramSet();
  }

  @Override
  public FundamentalDiagramType createFundamentalDiagramType() {
    return scenarioFactory.createFundamentalDiagramType();
  }

  @Override
  public Splitratio createSplitratio() {
    return scenarioFactory.createSplitratio();
  }

  @Override
  public SplitRatioProfile createSplitRatioProfile() {
    return scenarioFactory.createSplitRatioProfile();
  }

  @Override
  public Demand createDemand() {
    return scenarioFactory.createDemand();
  }

  @Override
  public Scenario createScenario() {
    return scenarioFactory.createScenario();
  }

  @Override
  public SplitRatioSet createSplitRatioSet() {
    return scenarioFactory.createSplitRatioSet();
  }

  @Override
  public PIFProbeData createPIFProbeData() {
    return scenarioFactory.createPIFProbeData();
  }

  @Override
  public PIFProbeDataSet createPIFProbeDataSet() {
    return scenarioFactory.createPIFProbeDataSet();
  }

  @Override
  public Route createRoute() {
    return scenarioFactory.createRoute();
  }

  @Override
  public RouteLink createRouteLink() {
    return scenarioFactory.createRouteLink();
  }

  @Override
  public CalibrationAlgorithmType createCalibrationAlgorithmType() {
    return scenarioFactory.createCalibrationAlgorithmType();
  }

  @Override
  public Network createNetwork() {
    return networkFactory.createNetwork();
  }

  @Override
  public Link createLink() {
    return networkFactory.createLink();
  }

  @Override
  public Node createNode() {
    return networkFactory.createNode();
  }

  @Override
  public Point createPoint() {
    return sharedFactory.createPoint();
  }

  @Override
  public Position createPosition() {
    return sharedFactory.createPosition();
  }

  @Override
  public Project createProject(){
    return sharedFactory.createProject();
  }

  @Override
  public FundamentalDiagramProfile createFundamentalDiagramProfile() {
    return scenarioFactory.createFundamentalDiagramProfile();
  }

  @Override
  public FundamentalDiagram createFundamentalDiagram() {
    return scenarioFactory.createFundamentalDiagram();
  }

}
