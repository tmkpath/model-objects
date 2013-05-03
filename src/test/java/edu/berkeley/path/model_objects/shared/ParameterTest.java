package edu.berkeley.path.model_objects.shared;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ParameterTest {
	private static String NAME = "Parameter Name";
	private static String VALUE = "Parameter Value";
	private static final String MOD_STAMP = "01-APR-1982 23:23:12";
	private static Parameter p;
	
	@Before
	public void setUp(){
		p = new Parameter();
		p.setName(NAME);
		p.setValue(VALUE);
		p.setModStamp(MOD_STAMP);
	}
	
	@Test
	public void testGetters(){
		assertEquals(NAME, p.getName());
		assertEquals(VALUE, p.getValue());
		assertEquals(MOD_STAMP, p.getModStamp());
	}

}
