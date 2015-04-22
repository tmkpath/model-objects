package edu.berkeley.path.model_objects.shared;

import edu.berkeley.path.model_objects.scenario.Scenario;
import edu.berkeley.path.model_objects.scenario.SensorSet;
import edu.berkeley.path.model_objects.scenario.ActuatorSet;
import edu.berkeley.path.model_objects.scenario.InitialDensitySet;
import edu.berkeley.path.model_objects.scenario.DemandSet;
import edu.berkeley.path.model_objects.scenario.ControllerSet;
import edu.berkeley.path.model_objects.scenario.FundamentalDiagramSet;
import edu.berkeley.path.model_objects.scenario.RouteSet;
import edu.berkeley.path.model_objects.scenario.SplitRatioSet;
import edu.berkeley.path.model_objects.network.Network;
import edu.berkeley.path.model_objects.shared.Parameters;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ScenarioRequest  extends edu.berkeley.path.model_objects.jaxb.ScenarioRequest {


    /**
     * Gets the value of the task_id property.
     *
     */
    @Override
    public long getTaskId() { return super.getTaskId(); }

    /**
     * Sets the value of the task_id property.
     *
     */
    @Override
    public void setTaskId(long value) {
        super.setTaskId(value);
    }


    /**
     * Gets the value of the model_id property.
     *
     */
    @Override
    public long getModelId() { return super.getModelId(); }

    /**
     * Sets the value of the model_id property.
     *
     */
    @Override
    public void setModelId(long value) {
        super.setModelId(value);
    }

    /**
     * Gets the value of the projectId property.
     *
     */
    @Override
    public long getProjectId() {
        return super.getProjectId();
    }

    /**
     * Sets the value of the projectId property.
     *
     */
    @Override
    public void setProjectId(long value) {
        super.setProjectId(value);
    }

    /**
     * Gets the value of the name property.
     *
     * @return {@link String }
     *
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * Sets the value of the name property.
     *
     * @param value {@link String }
     *
     */
    @Override
    public void setName(String value) {
        super.setName(value);
    }

    /**
     * Gets the value of the description property.
     *
     * @return {@link String }
     *
     */
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * Sets the value of the name property.
     *
     * @param value {@link String }
     *
     */
    @Override
    public void setDescription(String value) {
        super.setDescription(value);
    }

    /**
     * Gets the value of the scenario property.
     *
     * @return  {@link Scenario }
     *
     */
    @Override
    public Scenario getScenario() {
        return (Scenario) super.getScenario();
    }

    /**
     * Sets the value of the scenario property.
     *
     * @param value {@link Scenario }
     *
     */
    public void setScenario(Scenario value) {
        super.setScenario(value);
    }


    /**
     * Gets the value of the DerivedNetwork property.
     *
     * @return  {@link Network }
     *
     */
    public Network getDerivedNetwork() {
        if (super.getDerivedTypeNetwork() != null) {
            return (Network) super.getDerivedTypeNetwork().getNetwork();
        }
        else
            return null;
    }

    /**
     * Sets the value of the DerivedNetwork property.
     *
     * @param value {@link Network }
     *
     */
    public void setDerivedNetwork(Network value) {
        if (this.derivedTypeNetwork == null) {
            this.derivedTypeNetwork = new edu.berkeley.path.model_objects.jaxb.DerivedTypeNetwork();
        }
        super.getDerivedTypeNetwork().setNetwork(value);
    }


    /**
     * Gets the value of the CTMNetwork property.
     *
     * @return  {@link Network }
     *
     */
    public Network getCTMNetwork() {
        if (super.getCTMTypeNetwork() != null) {
            return (Network) super.getCTMTypeNetwork().getNetwork();
        }
        else
            return null;

    }

    /**
     * Sets the value of the CTMNetwork property.
     *
     * @param value {@link Network }
     *
     */
    public void setCTMNetwork(Network value) {
        if (this.ctmTypeNetwork == null) {
            this.ctmTypeNetwork = new edu.berkeley.path.model_objects.jaxb.CTMTypeNetwork();
        }
        super.getCTMTypeNetwork().setNetwork(value);
    }





    /**
     * Get the list of Parameters Attached to ScenarioRequest.
     *
     * @return List of Parameters Model Objects.
     */
    @SuppressWarnings("unchecked")
    public List<Parameters> getListOfParameters() {
        // return casted list of Parameters from JAXB base class
        if (this.parametersList != null ) {
            return (List<Parameters>) (List<?>) this.parametersList.getParameters();
        } else {
            return null;
        }
    }

    /**
     * Set the Parameters. Attaches list of Parameters Objects to ScenarioRequest.
     *
     * @param parametersList	List of extended parametersList to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfParameters(List<Parameters> parametersList) {
        if (null != parametersList) {
            if ( this.parametersList != null ) {
                this.parametersList.getParameters().clear();
            }
            else {
                this.parametersList = new edu.berkeley.path.model_objects.jaxb.ParametersList();
            }
            this.parametersList.getParameters().addAll((List<edu.berkeley.path.model_objects.jaxb.Parameters>) (List<?>) parametersList);
        }
    }

    /**
     * Get the list of SensorSets Attached to ScenarioRequest.
     *
     * @return List of SensorSet Model Objects.
     */
    @SuppressWarnings("unchecked")
    public List<SensorSet> getListOfSensorSets() {
        // return casted list of SensorSets from JAXB base class
        if (this.sensorSetList != null ) {
            return (List<SensorSet>) (List<?>) this.sensorSetList.getSensorSet();
        } else {
            return null;
        }
    }

    /**
     * Set the SensorSets. Attaches list of SensorSet Objects to ScenarioRequest.
     *
     * @param sensorSetList	List of SensorSets to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfSensorSets(List<SensorSet> sensorSetList) {
        if (null != sensorSetList) {
            if ( this.sensorSetList != null ) {
                this.sensorSetList.getSensorSet().clear();
            }
            else {
                this.sensorSetList = new edu.berkeley.path.model_objects.jaxb.SensorSetList();
            }
            this.sensorSetList.getSensorSet().addAll((List<edu.berkeley.path.model_objects.jaxb.SensorSet>) (List<?>) sensorSetList);
        }
    }


    /**
     * Get the list of ActuatorSet Attached to ScenarioRequest.
     *
     * @return List of ActuatorSet Model Objects.
     */
    @SuppressWarnings("unchecked")
    public List<ActuatorSet> getListOfActuatorSets() {
        // return casted list of ActuatorSets from JAXB base class
        if (this.actuatorSetList != null ) {
            return (List<ActuatorSet>) (List<?>) this.actuatorSetList.getActuatorSet();
        } else {
            return null;
        }
    }

    /**
     * Set the ActuatorSets. Attaches list of ActuatorSet Objects to ScenarioRequest.
     *
     * @param actuatorSetList	List of ActuatorSet to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfActuatorSets(List<ActuatorSet> actuatorSetList) {
        if (null != actuatorSetList) {
            if ( this.actuatorSetList != null ) {
                this.actuatorSetList.getActuatorSet().clear();
            }
            else {
                this.actuatorSetList = new edu.berkeley.path.model_objects.jaxb.ActuatorSetList();
            }
            this.actuatorSetList.getActuatorSet().addAll((List<edu.berkeley.path.model_objects.jaxb.ActuatorSet>) (List<?>) actuatorSetList);
        }
    }


    /**
     * Get the list of InitialDensitySet Attached to ScenarioRequest.
     *
     * @return List of InitialDensitySet Model Objects.
     */
    @SuppressWarnings("unchecked")
    public List<InitialDensitySet> getListOfInitialDensitySets() {
        // return casted list of InitialDensitySet from JAXB base class
        if (this.initialDensitySetList != null ) {
            return (List<InitialDensitySet>) (List<?>) this.initialDensitySetList.getInitialDensitySet();
        } else {
            return null;
        }
    }

    /**
     * Set the InitialDensitySets. Attaches list of InitialDensitySet Objects to ScenarioRequest.
     *
     * @param initialDensitySetList	List of InitialDensitySet to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfInitialDensitySets(List<InitialDensitySet> initialDensitySetList) {

        if (null != initialDensitySetList) {
            if ( this.initialDensitySetList != null ) {
                this.initialDensitySetList.getInitialDensitySet().clear();
            }
            else {
                this.initialDensitySetList = new edu.berkeley.path.model_objects.jaxb.InitialDensitySetList();
            }
            this.initialDensitySetList.getInitialDensitySet().addAll((List<edu.berkeley.path.model_objects.jaxb.InitialDensitySet>) (List<?>) initialDensitySetList);
        }
    }


    /**
     * Get the list of DemandSet Attached to ScenarioRequest.
     *
     * @return List of DemandSet Model Objects.
     */
    @SuppressWarnings("unchecked")
    public List<DemandSet> getListOfDemandSets() {
        // return casted list of DemandSet from JAXB base class
        if (this.demandSetList != null ) {
            return (List<DemandSet>) (List<?>) this.demandSetList.getDemandSet();
        } else {
            return null;
        }
    }

    /**
     * Set the DemandSets. Attaches list of DemandSet Objects to ScenarioRequest.
     *
     * @param demandSetList	List of DemandSets to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfDemandSets(List<DemandSet> demandSetList) {
        if (null != demandSetList) {
            if ( this.demandSetList != null ) {
                this.demandSetList.getDemandSet().clear();
            }
            else {
                this.demandSetList = new edu.berkeley.path.model_objects.jaxb.DemandSetList();
            }
            this.demandSetList.getDemandSet().addAll((List<edu.berkeley.path.model_objects.jaxb.DemandSet>) (List<?>) demandSetList);
        }
    }


    /**
     * Get the list of ControllerSet Attached to ScenarioRequest.
     *
     * @return List of ControllerSet Model Objects.
     */
    @SuppressWarnings("unchecked")
    public List<ControllerSet> getListOfControllerSets() {
        // return casted list of ControllerSet from JAXB base class
        if (this.controllerSetList != null ) {
            return (List<ControllerSet>) (List<?>) this.controllerSetList.getControllerSet();
        } else {
            return null;
        }
    }

    /**
     * Set the ControllerSets. Attaches list of ControllerSet Objects to ScenarioRequest.
     *
     * @param controllerSetList	List of ControllerSets to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfControllerSets(List<ControllerSet> controllerSetList) {
        if (null != controllerSetList) {
            if ( this.controllerSetList != null ) {
                this.controllerSetList.getControllerSet().clear();
            }
            else {
                this.controllerSetList = new edu.berkeley.path.model_objects.jaxb.ControllerSetList();
            }
            this.controllerSetList.getControllerSet().addAll((List<edu.berkeley.path.model_objects.jaxb.ControllerSet>) (List<?>) controllerSetList);
        }
    }


   /**
     * Get the list of FundamentalDiagramSet Attached to ScenarioRequest.
     *
     * @return List of FundamentalDiagramSet Model Objects.
     */
    @SuppressWarnings("unchecked")
    public List<FundamentalDiagramSet> getListOfFundamentalDiagramSets() {
        // return casted list of FundamentalDiagramSet from JAXB base class
        if (this.fundamentalDiagramSetList != null ) {
            return (List<FundamentalDiagramSet>) (List<?>) this.fundamentalDiagramSetList.getFundamentalDiagramSet();
        } else {
            return null;
        }
    }

    /**
     * Set the FundamentalDiagramSets. Attaches list of FundamentalDiagramSet Objects to ScenarioRequest.
     *
     * @param fundamentalDiagramSetList	List of ControllerSets to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfFundamentalDiagramSets(List<FundamentalDiagramSet> fundamentalDiagramSetList) {
        if (null != fundamentalDiagramSetList) {
            if ( this.fundamentalDiagramSetList != null ) {
                this.fundamentalDiagramSetList.getFundamentalDiagramSet().clear();
            }
            else {
                this.fundamentalDiagramSetList = new edu.berkeley.path.model_objects.jaxb.FundamentalDiagramSetList();
            }
            this.fundamentalDiagramSetList.getFundamentalDiagramSet().addAll((List<edu.berkeley.path.model_objects.jaxb.FundamentalDiagramSet>) (List<?>) fundamentalDiagramSetList);
        }
    }


    /**
     * Get the list of RouteSets Attached to ScenarioRequest.
     *
     * @return List of RouteSet Model Objects.
     */
    @SuppressWarnings("unchecked")
    public List<RouteSet> getListOfRouteSets() {
        // return casted list of RouteSet from JAXB base class
        if (this.routeSetList != null ) {
            return (List<RouteSet>) (List<?>) this.routeSetList.getRouteSet();
        } else {
            return null;
        }
    }

    /**
     * Set the RouteSets. Attaches list of RouteSet Objects to ScenarioRequest.
     *
     * @param routeSetList	List of RouteSets to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfRouteSets(List<RouteSet> routeSetList) {
        if (null != routeSetList) {
            if ( this.routeSetList != null ) {
                this.routeSetList.getRouteSet().clear();
            }
            else {
                this.routeSetList = new edu.berkeley.path.model_objects.jaxb.RouteSetList();
            }
            this.routeSetList.getRouteSet().addAll((List<edu.berkeley.path.model_objects.jaxb.RouteSet>) (List<?>) routeSetList);
        }
    }




    /**
     * Get the list of SplitRatioSets Attached to ScenarioRequest.
     *
     * @return List of SplitRatioSet Model Objects.
     */
    @SuppressWarnings("unchecked")
    public List<SplitRatioSet> getListOfSplitRatioSets() {
        // return casted list of SplitRatioSet from JAXB base class
        if (this.splitRatioSetList != null ) {
            return (List<SplitRatioSet>) (List<?>) this.splitRatioSetList.getSplitRatioSet();
        } else {
            return null;
        }
    }

    /**
     * Set the SplitRatioSets. Attaches list of SplitRatioSet Objects to ScenarioRequest.
     *
     * @param splitRatioSetList	List of SplitRatioSets to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfSplitRatioSets(List<SplitRatioSet> splitRatioSetList) {
        if (null != splitRatioSetList) {
            if ( this.splitRatioSetList != null ) {
                this.splitRatioSetList.getSplitRatioSet().clear();
            }
            else {
                this.splitRatioSetList = new edu.berkeley.path.model_objects.jaxb.SplitRatioSetList();
            }
            this.splitRatioSetList.getSplitRatioSet().addAll((List<edu.berkeley.path.model_objects.jaxb.SplitRatioSet>) (List<?>) splitRatioSetList);
        }
    }

}
