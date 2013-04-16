package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.scenario.Sensor.Type;

public class ScenarioFactory {
	
    /**
     * Create an instance of Sensor Model Object
     * 
     * @return  Sensor Model Object
     */
	public static Sensor createSensor(Type type) {
		return new Sensor();
	}
	
	   /**
     * Create an instance of DemandSet Model Object
     * 
     * @return  DemandSet Model Object 
     */
    public DemandSet createDemandSet() {
        return new DemandSet();
    }
    
    /**
     * Create an instance of DemandProfile Model Object
     * 
     * @return  DemandProfile Model Object 
     */
    public DemandProfile createDemandProfile() {
        return new DemandProfile();
    }

}
