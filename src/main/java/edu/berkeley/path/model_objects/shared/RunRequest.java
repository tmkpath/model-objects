package edu.berkeley.path.model_objects.shared;

import edu.berkeley.path.model_objects.MOException;
import edu.berkeley.path.model_objects.scenario.Scenario;
import edu.berkeley.path.model_objects.shared.Parameters;
import org.joda.time.JodaTimePermission;
import edu.berkeley.path.model_objects.shared.DateTime;

import java.util.Map;


/**
 * Created by tmk on 2/11/15.
 */
public class RunRequest extends edu.berkeley.path.model_objects.jaxb.RunRequest {

    /**
     * Gets the value of the scenario property.
     *
     * @return  {@link Scenario }
     *
     */
    @Override
    public Scenario getScenario() {
        return (Scenario) super.getScenario(); // The assumption is that the parent's Scenario is a model-objects
                                               // extended Scenario, not a JAXB base class one.  It should have been
                                               // built with the ModelObjectsFactory create...() methods.
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
     * Gets the value of the parameters property.
     *
     * @return {@link Parameters }
     *
     */
    @Override
    public Parameters getParameters() {
        return (Parameters) super.getParameters(); // The assumption is that the parent's Parameters is a model-objects
                                                   // extended Parameters, not a JAXB base class one.  It should have
                                                   // been built with the ModelObjectsFactory create...() methods.
    }

    /**
     * Sets the value of the parameters property.
     *
     * @param value {@link Parameters }
     *
     */
    public void setParameters(Parameters value) {
        super.setParameters(value);
    }

    /**
     * Gets the value of the id property.
     *
     */
    @Override
    public long getId() {
        return super.getId();
    }

    /**
     * Sets the value of the id property.
     *
     */
    @Override
    public void setId(long value) {
        super.setId(value);
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
     * Gets the value of the user id property.
     *
     * @return {@link String }
     *
     */
    @Override
    public String getUserId() {
        return super.getUserId();
    }

    /**
     * Sets the value of the user id property.
     *
     * @param value {@link String }
     *
     */
    @Override
    public void setUserId(String value) {
        super.setUserId(value);
    }


    /**
     * Calculates the number of time steps in this scenario.
     *
     */
    public int getTimeStepCount() throws MOException {

        Map<String, Parameter> parameterMap = getParameters().getParametersMap();

        // retrieve the run characteristics
        String simMode = parameterMap.get("global.sim_mode").getValue();
        String runMode = parameterMap.get("global.run_mode").getValue();

        // find the elements required for calculation
        String startTime = parameterMap.get("global.start_time").getValue();
        String endTime = parameterMap.get("global.end_time").getValue();
        Long reportFreqMillis = Long.valueOf(parameterMap.get("output.report_freq").getValue());

        if ( simMode == null || runMode == null || startTime == null || endTime == null || reportFreqMillis == null || reportFreqMillis == 0 ) {
            throw new MOException(null, "Error getting properties required for time step count calculation");
        }

        //Validate run mode and sim mode
        if ( simMode.equalsIgnoreCase("ESTIMATION") && runMode.equalsIgnoreCase("LIVE") ){
            return 0;
        }

        DateTime dateTime = new DateTime();
        org.joda.time.DateTime jodaStartTime = dateTime.setDateString(startTime);
        org.joda.time.DateTime jodaEndTime = dateTime.setDateString(endTime);

        long num = jodaEndTime.getMillis() - jodaStartTime.getMillis();

        return (int) ( num / reportFreqMillis ) ;
    }

}
