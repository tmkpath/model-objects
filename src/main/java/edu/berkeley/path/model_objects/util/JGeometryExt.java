package edu.berkeley.path.model_objects.util;

import oracle.spatial.geometry.JGeometry;

public class JGeometryExt extends JGeometry {
  public JGeometryExt()
  {
    // create a dummy rectangle JGeometry instance
    super(0.0, 0.0, 0.0, 0.0, 0);
  }

  public static void clearDBDescriptors()
  {
    geomDesc = null;
    pointDesc = null;
    elemInfoDesc = null;
    ordinatesDesc = null;
  }
}
