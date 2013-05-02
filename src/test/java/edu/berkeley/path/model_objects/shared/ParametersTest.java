package edu.berkeley.path.model_objects.shared;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParametersTest {
	private static String NAME = "Parameter Name";
	private static String VALUE = "Parameter Value";
	private static Parameter p;
	private static Parameters pSet; 

	@Before
	public void setUp(){
		pSet = new Parameters();
		p = new Parameter();
		p.setName(NAME);
		p.setValue(VALUE);
	
	}
	
	@Test
	public void testSetParameter(){
		pSet.setParameter(p);
		assertEquals(1, pSet.getParameters().size());
	}

	@Test 
	public void setParameters(){
		ArrayList<Parameter> list = new ArrayList<Parameter>();
		list.add(new Parameter());
		list.add(new Parameter());
		list.add(new Parameter());
		list.add(new Parameter());
		pSet.setParameters(list);
		assertEquals(4, pSet.getParameters().size());
		
	}

}
