package edu.berkeley.path.model_objects.shared;

import edu.berkeley.path.model_objects.scenario.Scenario;
import edu.berkeley.path.model_objects.shared.Parameters;


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
    @Override
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
    @Override
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

}
