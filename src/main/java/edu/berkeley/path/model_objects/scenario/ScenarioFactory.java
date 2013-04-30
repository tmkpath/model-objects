package edu.berkeley.path.model_objects.scenario;

public class ScenarioFactory {
	
    /**
     * Create an instance of Sensor Model Object
     * 
     * @return  Sensor Model Object
     */
	public Sensor createSensor() {
		return new Sensor();
	}

  /**
   * Create an instance of SensorSet Model Object
   *
   * @return  SensorSet Model Object
   */
  public SensorSet createSensorSet() {
    return new SensorSet();
  }

  /**
   * Create an instance of Density Model Object
   * @return  Density Model Object
   */
  public Density createDensity() {
    return new Density();
  }

  /**
   * Create an instance of InitialDensitySet Model Object
   *
   * @return  InitialDensitySet Model Object
   */
  public InitialDensitySet createInitialDensitySet() {
    return new InitialDensitySet();
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
