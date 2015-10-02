package edu.berkeley.path.model_objects.shared;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RunRequestTest {

    private static Parameter p;
    private static Parameters pSet;
    private static RunRequest runRequest;
    private static long RUN_REQUEST_ID = 100L;
    private static String RUN_REQUEST_NAME = "run request 100";
    private static long PROJECT_ID = 111L;
    private static long SCENARIO_ID = 222L;
    private static long RUN_ID = 333L;

    @Before
    public void setUp(){

        runRequest = new RunRequest();
        runRequest.setId(RUN_REQUEST_ID);
        runRequest.setName(RUN_REQUEST_NAME);

        pSet = new Parameters();
        pSet.setProjectId(PROJECT_ID);
        pSet.setScenarioId(SCENARIO_ID);
        pSet.setRunId(RUN_ID);

        p = new Parameter();
        p.setName("global.sim_mode");
        p.setValue("PREDICTION");
        pSet.setParameter(p);

        p = new Parameter();
        p.setName("global.run_mode");
        p.setValue("HISTORICAL");
        pSet.setParameter(p);

        p = new Parameter();
        p.setName("output.report_freq");
        p.setValue("2000");
        pSet.setParameter(p);

        p = new Parameter();
        p.setName("global.start_time");
        p.setValue("2014-01-22 17:00:00");
        pSet.setParameter(p);

        p = new Parameter();
        p.setName("global.end_time");
        p.setValue("2014-01-22 17:10:00");
        pSet.setParameter(p);

        runRequest.setParameters(pSet);

    }

    @Test
    public void testSetParameter(){

        assertEquals(RUN_REQUEST_NAME, runRequest.getName());
        assertEquals(RUN_REQUEST_ID, runRequest.getId());

        try {
            assertEquals(runRequest.getTimeStepCount(), 300);
        }
        catch (Exception e ) {
            fail();
        }
    }


}
