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

}
