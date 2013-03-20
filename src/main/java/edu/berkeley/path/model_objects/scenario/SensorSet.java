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
	 * @return the list of sensors
	 */
	public void setSensors(ArrayList<Sensor> sensors) {
		sensor = sensors;
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

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		super.setId(id);	
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		super.setName(name);
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String desc) {
		super.setDescription(desc);
		
	}

	/**
	 * @param modstampMicros the modstamp to set
	 */
	public void setModStamp(Long modstampMicros) {
		super.setModStamp(modstampMicros);
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the modStamp
	 */
	public long getModStamp() {
		return modStamp;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
