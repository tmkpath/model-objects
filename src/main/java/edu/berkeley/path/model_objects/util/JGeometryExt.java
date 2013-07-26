package edu.berkeley.path.model_objects.util;

import oracle.spatial.geometry.JGeometry;

/*
 * This class is needed so that JGeometry store method will work within multiple threads,
 * with multiple user's connections (web).
 *
 * @author mnjuhn
 *
 */
public class JGeometryExt extends JGeometry {
  public JGeometryExt()
  {
    // create a dummy rectangle JGeometry instance
    super(0.0, 0.0, 0.0, 0.0, 0);
  }

  /*
   * Clears Database Descriptor settings so that they are not inheritated from previous
   * store method connection.
   */
  public static void clearDBDescriptors()
  {
    geomDesc = null;
    pointDesc = null;
    elemInfoDesc = null;
    ordinatesDesc = null;
  }
}
