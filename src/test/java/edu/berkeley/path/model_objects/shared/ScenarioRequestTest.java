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
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class ScenarioRequestTest {

    private static final String NAME = "test envelope";
    private static final String SET_NAME = "test set";
    private static final String USER_ID = "test user";
    private static final String SET_DESCRIPTION = "test set description";

    private static final String DERIVED_NAME = "derived network";
    private static final String DERIVED_DESCRIPTION = "derived network description";
    private static final String CTM_NAME = "ctm network";
    private static final String CTM_DESCRIPTION = "ctm network description";

    private static final long PROJECT_ID = 100000;
    private static final long TASK_ID = 123;
    private static final long NETWORK_ID = 8;



    private ScenarioRequest scenarioRequest;

    @Before
    public void setUp(){
        scenarioRequest = new ScenarioRequest();
        scenarioRequest.setName(NAME);
        scenarioRequest.setTaskId(TASK_ID);
        scenarioRequest.setProjectId(PROJECT_ID);

    }


    @Test
    public void testSetLists(){

        scenarioRequest.setBuild(true);
        scenarioRequest.setPersist(true);
        scenarioRequest.setExecute(false);
        scenarioRequest.setUserId(USER_ID);

        List<Parameters> parametersList = new ArrayList<Parameters>();
        Parameters parameters = new Parameters();

        List<Parameter> parameterList = new ArrayList<Parameter>();
        Parameter parameter1 = new Parameter();
        parameterList.add(parameter1);
        Parameter parameter2 = new Parameter();
        parameterList.add(parameter2);
        Parameter parameter3 = new Parameter();
        parameterList.add(parameter3);
        parameters.setParameters(parameterList);
        parametersList.add(parameters);
        scenarioRequest.setListOfParameters(parametersList);

        InitialDensitySet initialDensitySet1 = new InitialDensitySet();
        InitialDensitySet initialDensitySet2 = new InitialDensitySet();
        List<InitialDensitySet> initialDensitySetList = new ArrayList<InitialDensitySet>();
        initialDensitySetList.add(initialDensitySet1);
        initialDensitySetList.add(initialDensitySet2);
        scenarioRequest.setListOfInitialDensitySets(initialDensitySetList);

        RouteSet routeSet = new RouteSet();
        List<RouteSet> routeSetList = new ArrayList<RouteSet>();
        routeSetList.add(routeSet);
        scenarioRequest.setListOfRouteSets(routeSetList);

        ActuatorSet actuatorSet1 = new ActuatorSet();
        ActuatorSet actuatorSet2 = new ActuatorSet();
        List<ActuatorSet> actuatorSetList = new ArrayList<ActuatorSet>();
        actuatorSetList.add(actuatorSet1);
        actuatorSetList.add(actuatorSet2);
        scenarioRequest.setListOfActuatorSets(actuatorSetList);

        List<DemandSet> demandSetList = new ArrayList<DemandSet>();
        DemandSet demandSet = new DemandSet();
        demandSet.setName(SET_NAME);
        demandSetList.add(demandSet);
        scenarioRequest.setListOfDemandSets(demandSetList);

        List<FundamentalDiagramSet> fundamentalDiagramSetList = new ArrayList<FundamentalDiagramSet>();
        FundamentalDiagramSet fundamentalDiagramSet1 = new FundamentalDiagramSet();
        FundamentalDiagramSet fundamentalDiagramSet2 = new FundamentalDiagramSet();
        FundamentalDiagramSet fundamentalDiagramSet3 = new FundamentalDiagramSet();
        fundamentalDiagramSetList.add(fundamentalDiagramSet1);
        fundamentalDiagramSetList.add(fundamentalDiagramSet2);
        fundamentalDiagramSetList.add(fundamentalDiagramSet3);
        scenarioRequest.setListOfFundamentalDiagramSets(fundamentalDiagramSetList);

        List<SplitRatioSet> splitRatioSetList = new ArrayList<SplitRatioSet>();
        SplitRatioSet splitRatioSet = new SplitRatioSet();
        splitRatioSet.setNetworkId(NETWORK_ID);
        splitRatioSet.setDescription(SET_DESCRIPTION);
        splitRatioSetList.add(splitRatioSet);
        scenarioRequest.setListOfSplitRatioSets(splitRatioSetList);

        List<SensorSet> sensorSetList = new ArrayList<SensorSet>();
        SensorSet sensorSet = new SensorSet();
        sensorSet.setName(SET_NAME);
        sensorSetList.add(sensorSet);
        scenarioRequest.setListOfSensorSets(sensorSetList);


        Network network = new Network();
        network.setName(DERIVED_NAME);
        network.setDescription(DERIVED_DESCRIPTION);
        network.setProjectId(PROJECT_ID);
        scenarioRequest.setDerivedNetwork(network);

        Network network2 = new Network();
        network2.setName(CTM_NAME);
        network2.setDescription(CTM_DESCRIPTION);
        network2.setProjectId(PROJECT_ID);
        scenarioRequest.setCTMNetwork(network2);


        // validate that setters and getters
        assertEquals(scenarioRequest.getName(), NAME);
        assertEquals(scenarioRequest.getTaskId(), TASK_ID);
        assertEquals(scenarioRequest.getProjectId(), PROJECT_ID);
        assertEquals(scenarioRequest.getUserId(), USER_ID);

        assertEquals(scenarioRequest.isBuild(), true);
        assertEquals(scenarioRequest.isPersist(), true);
        assertEquals(scenarioRequest.isExecute(), false);

        assertEquals(scenarioRequest.getListOfParameters().size(), 1);
        assertEquals(scenarioRequest.getListOfParameters().get(0).getParameter().size(), 3);
        assertEquals(scenarioRequest.getListOfSensorSets().size(), 1);
        assertEquals(scenarioRequest.getListOfActuatorSets().size(), 2);
        assertEquals(scenarioRequest.getListOfRouteSets().size(), 1);
        assertEquals(scenarioRequest.getListOfInitialDensitySets().size(), 2);
        assertEquals(scenarioRequest.getListOfDemandSets().size(), 1);
        assertEquals(scenarioRequest.getListOfDemandSets().get(0).getName(), SET_NAME);
        assertEquals(scenarioRequest.getListOfFundamentalDiagramSets().size(), 3);
        assertEquals(scenarioRequest.getListOfSplitRatioSets().size(), 1);
        assertEquals(scenarioRequest.getListOfSplitRatioSets().get(0).getNetworkId(), NETWORK_ID);
        assertEquals(scenarioRequest.getListOfSplitRatioSets().get(0).getDescription(), SET_DESCRIPTION);
        assertEquals(scenarioRequest.getListOfSensorSets().size(), 1);
        assertEquals(scenarioRequest.getListOfSensorSets().get(0).getName(), SET_NAME);

        assertNotNull(scenarioRequest.getCTMNetwork());
        assertEquals(scenarioRequest.getCTMNetwork().getName(), CTM_NAME);
        assertEquals(scenarioRequest.getCTMNetwork().getDescription(), CTM_DESCRIPTION);

        assertNotNull(scenarioRequest.getDerivedNetwork());
        assertEquals(scenarioRequest.getDerivedNetwork().getName(), DERIVED_NAME);
        assertEquals(scenarioRequest.getDerivedNetwork().getDescription(), DERIVED_DESCRIPTION);

    }







}
