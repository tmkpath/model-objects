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
    private static final long PROJECT_ID = 100000;
    private static final long TASK_ID = 123;



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

        Network network = new Network();
        scenarioRequest.setDerivedTypeNetwork(network);


        // validate that setters and getters
        assertEquals(scenarioRequest.getName(), NAME);
        assertEquals(scenarioRequest.getTaskId(), TASK_ID);
        assertEquals(scenarioRequest.getProjectId(), PROJECT_ID);

        assertEquals(scenarioRequest.getListOfActuatorSets().size(), 2);
        assertEquals(scenarioRequest.getListOfRouteSets().size(), 1);
        assertEquals(scenarioRequest.getListOfInitialDensitySets().size(), 2);
        assertEquals(scenarioRequest.getListOfDemandSets(), null);
        assertEquals(scenarioRequest.getCTMTypeNetwork(), null);
        assertNotNull(scenarioRequest.getDerivedTypeNetwork());

    }







}
