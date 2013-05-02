package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VehicleTypeTest {

	private static long ID = 1;
	private static int IS_STANDARD = 1;
	private static String MOD_STAMP = "01-APR-2008 00:00:00";
	private static String NAME = "Vehicle Type Name";
	private static double SIZE_FACTOR = 0.1;
	private static double EPSILON = 0.0;
	private static VehicleType type;
	
	@Before
	public void setUp(){
		type = new VehicleType();
		type.setId(ID);
		type.setIsStandard(IS_STANDARD);
		type.setModStamp(MOD_STAMP);
		type.setName(NAME);
		type.setSizeFactor(SIZE_FACTOR);
	}
	
	@Test
	public void testGetters(){
		assertEquals(ID, type.getId());
		assertEquals(IS_STANDARD, type.getIsStandard(), EPSILON);
		assertEquals(MOD_STAMP, type.getModStamp());
		assertEquals(NAME, type.getName());
		assertEquals(SIZE_FACTOR, type.getSizeFactor(), EPSILON);
	}
}
