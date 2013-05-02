package edu.berkeley.path.model_objects.shared;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ParameterTest {
	private static String NAME = "Parameter Name";
	private static String VALUE = "Parameter Value";
	private static Parameter p;
	
	@Before
	public void setUp(){
		p = new Parameter();
		p.setName(NAME);
		p.setValue(VALUE);
	}
	
	@Test
	public void testGetters(){
		assertEquals(NAME, p.getName());
		assertEquals(VALUE, p.getValue());
		
	}

}
