package edu.berkeley.path.model_objects.traffic_state;

/**
 * TrafficState Model Object Factory that can be used to create new instances of
 * traffic states based model object classes.  This factory can be extended,
 * it's methods over-ridden and then passed into the model object database access
 * layer to return application specific extended model object classes
 *
 */
public class TrafficStateFactory extends edu.berkeley.path.model_objects.jaxb.ObjectFactory {

	/**
	 * Create an instance of LinkState Model Object
	 *
	 * @return  LinkState Model Object
	 */
	public LinkState createLinkState() {
		return new LinkState();
	}

  /**
   * Create an instance of LinkStateDebug Model Object
   *
   * @return  LinkStateDebug Model Object
   */
  public LinkStateDebug createLinkStateDebug() {
    return new LinkStateDebug();
  }

  /**
   * Create an instance of LinkStateDetail Model Object
   *
   * @return  LinkStateDetail Model Object
   */
  public LinkStateDetail createLinkStateDetail() {
    return new LinkStateDetail();
  }
}
