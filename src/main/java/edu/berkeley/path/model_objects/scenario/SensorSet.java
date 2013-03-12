package edu.berkeley.path.model_objects.scenario;

import java.util.ArrayList;

import edu.berkeley.path.model_objects.util.ObjectFactory;

public class SensorSet extends edu.berkeley.path.model_objects.jaxb.SensorSet  {

	/** @y.exclude */ protected ArrayList<Sensor> sensor = new ArrayList<Sensor>();

	/////////////////////////////////////////////////////////////////////
	// populate / reset / validate / update
	/////////////////////////////////////////////////////////////////////

	protected void populate() {
		
		// replace jaxb.Sensor with simulator.Sensor
		for(edu.berkeley.path.model_objects.scenario.Sensor sens : sensor) {
			
			Sensor.Type type = null;
	    	try {
				type = sens.getSensorType();
			} catch (IllegalArgumentException e) {
				continue;
			}	
			
			// generate sensor
			if(type != null){
				Sensor s = ObjectFactory.createSensorFromJaxb(myScenario,sensor,type);
				if(s != null)
					sensor.add(s);
			}		    	
		}
	
	}

	protected boolean isValid() {
		boolean isValid = true;
		for(Sensor s : sensor){
			isValid = s.isValid();
			if(isValid == false)
				return false;
		}
		return isValid;
	}
	
	
	protected void reset() throws SiriusException {
		for(Sensor s : sensor)
			s.reset();
	}

	protected void update() throws SiriusException {

        // NOTE: ensembles have not been implemented for sensors. They do not apply
        // to the loop sensor, but would make a difference for floating sensors.
		for(Sensor sens : sensor)
			sens.update();
	}

	/**
	 * @return the list of sensors
	 */
	public ArrayList<Sensor> getSensors() {
		return sensor;
	}

	/**
	 * @return the projectId
	 */
	public long getProjectId() {
		return super.getProjectId();
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(long projectId) {
		 super.setProjectId(projectId);
	}

}
