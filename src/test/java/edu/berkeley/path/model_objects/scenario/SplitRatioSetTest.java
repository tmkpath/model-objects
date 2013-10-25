/**
 * Copyright (c) 2012 The Regents of the University of California.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.berkeley.path.model_objects.TestConfiguration;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.network.Node;
import edu.berkeley.path.model_objects.MOException;

public class SplitRatioSetTest {
	private static final long ID = 1;
	private static final long PROJECT_ID = 10;  
	private static final String DESCRIPTION = "Test Set";
	private static final String NAME = "Test Set Name";
	private static final String MOD_STAMP = "01-APR-1982 23:23:12";
	
	private SplitRatioSet set;
	
	@Before
	public void setUp() throws MOException {
		set = new SplitRatioSet();
		set.setDescription(DESCRIPTION);
		set.setProjectId(PROJECT_ID);
		set.setId(ID);
		set.setName(NAME);
		set.setModStamp(MOD_STAMP);
		set.setLockedForEdit(true);
		set.setLockedForHistory(true);
		
		List<SplitRatioProfile> profiles = new ArrayList<SplitRatioProfile>();
		profiles.add(TestConfiguration.createSplitRatioProfile(1,3600,300,1, CrudFlag.UPDATE));
		profiles.add(TestConfiguration.createSplitRatioProfile(2,3660,300,2, CrudFlag.UPDATE));
		profiles.add(TestConfiguration.createSplitRatioProfile(3,3720,300,3, CrudFlag.UPDATE));
		
		set.setListOfSplitRatioProfiles(profiles);
	}
	
	@Test
	public void testGetters(){
		assertEquals(DESCRIPTION, set.getDescription());
		assertEquals(PROJECT_ID, set.getProjectId());
		assertEquals(ID,set.getId());
		assertEquals(NAME, set.getName());
		assertEquals(MOD_STAMP, set.getModStamp());
		assertEquals(true, set.isLockedForEdit());
		assertEquals(true, set.isLockedForHistory());
		assertEquals(3, set.getListOfSplitRatioProfiles().size());
	}

  @Test
	public void testGetSplitRatioProfileAtNode() {
		Node n = new Node();
		n.setId(ID);
		SplitRatioProfile profile = set.getSplitRatioProfileAtNode(n.getId());
		assertEquals(ID, profile.getNodeId());

		n.setId(1111);
		profile = set.getSplitRatioProfileAtNode(n.getId());
		assertNull(profile);
	}

	
}
