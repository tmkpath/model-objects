package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.jaxb.*;

public class Scenario extends edu.berkeley.path.model_objects.jaxb.Scenario {
  // Store internal set ID for scenario components
  /** @y.exclude */  private long splitRatioSetId;
  /** @y.exclude */  private long demandSetId;
  /** @y.exclude */  private long fdSetId;
  /** @y.exclude */  private long sensorSetId;

  @Override
  public String getDescription() {
    return super.getDescription();
  }

  @Override
  public void setDescription(String value) {
    super.setDescription(value);
  }

  //TODO Settings?
  @Override
  public Settings getSettings() {
    return super.getSettings();
  }

  @Override
  public void setSettings(Settings value) {
    super.setSettings(value);
  }

  //TODO Needs NetworkSE MO
  @Override
  public NetworkSet getNetworkSet() {
    return super.getNetworkSet();
  }

  @Override
  public void setNetworkSet(NetworkSet value) {
    super.setNetworkSet(value);
  }

  //TODO Needs VehicleTypeSetMO
  @Override
  public VehicleTypeSet getVehicleTypeSet() {
    return super.getVehicleTypeSet();
  }

  @Override
  public void setVehicleTypeSet(VehicleTypeSet value) {
    super.setVehicleTypeSet(value);
  }

  //TODO Needs SignalSet MO
  @Override
  public SignalSet getSignalSet() {
    return super.getSignalSet();
  }

  @Override
  public void setSignalSet(SignalSet value) {
    super.setSignalSet(value);
  }

  @Override
  public SensorSet getSensorSet() {
    return (SensorSet) super.getSensorSet();
  }


  public void setSensorSet(SensorSet value) {
    super.setSensorSet(value);
  }

  @Override
  public InitialDensitySet getInitialDensitySet() {
    return (InitialDensitySet) super.getInitialDensitySet();
  }

  public void setInitialDensitySet(InitialDensitySet value) {
    super.setInitialDensitySet(value);
  }

  //TODO Needs WeavingFactorSet MO
  @Override
  public WeavingFactorSet getWeavingFactorSet() {
    return super.getWeavingFactorSet();
  }

  @Override
  public void setWeavingFactorSet(WeavingFactorSet value) {
    super.setWeavingFactorSet(value);
  }

  @Override
  public SplitRatioSet getSplitRatioSet() {
    return (SplitRatioSet) super.getSplitRatioSet();
  }


  public void setSplitRatioSet(SplitRatioSet value) {
    super.setSplitRatioSet(value);
  }

  //TODO Needs CapacitySet MO
  @Override
  public DownstreamBoundaryCapacitySet getDownstreamBoundaryCapacitySet() {
    return super.getDownstreamBoundaryCapacitySet();
  }

  @Override
  public void setDownstreamBoundaryCapacitySet(DownstreamBoundaryCapacitySet value) {
    super.setDownstreamBoundaryCapacitySet(value);
  }

  //TODO Needs EvenSet MO
  @Override
  public EventSet getEventSet() {
    return super.getEventSet();
  }

  @Override
  public void setEventSet(EventSet value) {
    super.setEventSet(value);
  }

  @Override
  public DemandSet getDemandSet() {
    return (DemandSet) super.getDemandSet();
  }


  public void setDemandSet(DemandSet value) {
    super.setDemandSet(value);
  }

  //TODO Needs ControllerSet MO
  @Override
  public ControllerSet getControllerSet() {
    return super.getControllerSet();
  }

  @Override
  public void setControllerSet(ControllerSet value) {
    super.setControllerSet(value);
  }

  @Override
  public FundamentalDiagramSet getFundamentalDiagramSet() {
    return (FundamentalDiagramSet) super.getFundamentalDiagramSet();
  }


  public void setFundamentalDiagramSet(FundamentalDiagramSet value) {
    super.setFundamentalDiagramSet(value);
  }

  //TODO Needs NetworkConnection MO???
  @Override
  public NetworkConnections getNetworkConnections() {
    return super.getNetworkConnections();
  }

  @Override
  public void setNetworkConnections(NetworkConnections value) {
    super.setNetworkConnections(value);
  }

  //TODO Needs DestinationNetwork MO???
  @Override
  public DestinationNetworks getDestinationNetworks() {
    return super.getDestinationNetworks();
  }

  @Override
  public void setDestinationNetworks(DestinationNetworks value) {
    super.setDestinationNetworks(value);
  }

  //TODO Needs Route MO
  @Override
  public Route getRoute() {
    return super.getRoute();
  }

  public void setRoute(Route value) {
    super.setRoute(value);
  }

  @Override
  public long getProjectId() {
    return super.getProjectId();
  }

  @Override
  public void setProjectId(Long value) {
    super.setProjectId(value);
  }

  @Override
  public long getId() {
    return super.getId();
  }

  @Override
  public void setId(long value) {
    super.setId(value);
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public void setName(String value) {
    super.setName(value);
  }

  @Override
  public String getSchemaVersion() {
    return super.getSchemaVersion();
  }

  @Override
  public void setSchemaVersion(String value) {
    super.setSchemaVersion(value);
  }

  public long getSplitRatioSetId() {
    return splitRatioSetId;
  }

  public void setSplitRatioSetId(long splitRatioSetId) {
    this.splitRatioSetId = splitRatioSetId;
  }

  public long getDemandSetId() {
    return demandSetId;
  }

  public void setDemandSetId(long demandSetId) {
    this.demandSetId = demandSetId;
  }

  public long getFdSetId() {
    return fdSetId;
  }

  public void setFdSetId(long fdSetId) {
    this.fdSetId = fdSetId;
  }

  public long getSensorSetId() {
    return sensorSetId;
  }

  public void setSensorSetId(long sensorSetId) {
    this.sensorSetId = sensorSetId;
  }
}
