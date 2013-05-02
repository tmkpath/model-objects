package edu.berkeley.path.model_objects.scenario;

import java.util.ArrayList;
import java.util.List;

public class SensorSet extends edu.berkeley.path.model_objects.jaxb.SensorSet  {
	
	/**
	 * Check to make sure all the Sensors are valid
	 * 
	 * @return boolean 
	 */
	protected boolean isValid() {
		for(Sensor s : getSensors()){
			if(!s.isValid())
				return false;
		}
		return true;
	}
	
	/**
	 * @return the projectId
	 */
	@Override
	public long getProjectId() {
		return super.getProjectId();
	}

	/**
	 * @param projectId the projectId to set
	 */
	 @Override
	public void setProjectId(Long projectId) {
		 super.setProjectId(projectId);
	}

	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(long id) {
		super.setId(id);	
	}

	/**
	 * @return the id
	 */
	@Override
	public long getId() {
		return super.getId();
	}

	/**
	 * @param name the name to set
	 */
	@Override
	public void setName(String name) {
		super.setName(name);
	}



	/**
	 * @param modstamp the modstamp to set
	 */
	@Override
	public void setModStamp(String modstamp) {
		super.setModStamp(modstamp);
	}


	/**
	 * @return the modStamp
	 */
	@Override
	public String getModStamp() {
		return super.getModStamp();
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return super.getName();
	}

	/**
	 * @return the description
	 */
	@Override
	public String getDescription() {
		return super.getDescription();
	}
	
	/**
	 * @param description the description to set
	 */
	@Override
	public void setDescription(String desc) {
		super.setDescription(desc);
		
	}
	

	/**
	 * Set the sensors list. Attaches list of Sensor Model Objects to scenario.
	 * 
	 * @param List<Sensor>	List of extended Sensors to add
	 */
	@SuppressWarnings("unchecked")
	public void setSensors(List<Sensor> sensors) {

			List<edu.berkeley.path.model_objects.jaxb.Sensor> sensorSet = getSensor();
			if ( sensorSet == null ) {
			  sensorSet = new ArrayList<edu.berkeley.path.model_objects.jaxb.Sensor>();  
			}
			sensorSet.clear();
			sensorSet.addAll((List<edu.berkeley.path.model_objects.jaxb.Sensor>)(List<?>)sensors);
			sensor = sensorSet;
	}
	
	/** 
	 * Get the list of sensors in the scenario.
	 * 
	 * @return List of all sensors as Sensor Model Objects. 
	 */
	@SuppressWarnings("unchecked")
	public List<Sensor> getSensors() {
		// return casted list of Sensors from JAXB base class
		return (List<Sensor>)(List<?>)super.getSensor();
	}

}
