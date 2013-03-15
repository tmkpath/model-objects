package edu.berkeley.path.model_objects.scenario;

import java.util.ArrayList;

public class SensorSet extends edu.berkeley.path.model_objects.jaxb.SensorSet  {

	/** @y.exclude */ protected ArrayList<Sensor> sensor = new ArrayList<Sensor>();

	/////////////////////////////////////////////////////////////////////
	// populate / reset / validate / update
	/////////////////////////////////////////////////////////////////////

	protected void populate() {
		for(edu.berkeley.path.model_objects.scenario.Sensor sens : sensor) {
			
			Sensor.Type type = null;
	    	try {
				type = sens.getSensorType();
			} catch (IllegalArgumentException e) {
				continue;
			}	
			
			// generate sensor
			if(type != null){
				Sensor s = ScenarioFactory.createSensor(type);
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
