package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.scenario.Sensor.Type;

public class ScenarioFactory {

	public static Sensor createSensorByType(Sensor sens, Type type) {
		
		switch(type){
			case Loop: return null;
			default : return null;
		
		}
	}

}
