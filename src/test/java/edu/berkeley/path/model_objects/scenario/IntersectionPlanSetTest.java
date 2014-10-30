/**
 * Copyright (c) 2014 The Regents of the University of California.
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

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntersectionPlanSetTest {


    private static final int IPS1_ID = 10;
    private static final int SPS1_ID = 20;
    private static final int SPS2_ID = 30;
    private static final String DESCRIPTION = "Intersection Plan Set Description";
    private static final String MOD_STAMP = "18-JAN-2008 02:51:00";
    private static final String NAME = "Intersection Plan Set Name";
    private static final long PROJECT_ID = 1;


    private IntersectionPlanSet intersectionPlanSet;

    @Before
    public void setUp(){
        intersectionPlanSet = new IntersectionPlanSet();
        intersectionPlanSet.setDescription(DESCRIPTION);
        intersectionPlanSet.setId(IPS1_ID);
        intersectionPlanSet.setModStamp(MOD_STAMP);
        intersectionPlanSet.setName(NAME);
        intersectionPlanSet.setProjectId(PROJECT_ID);


    }

    @Test
    public void testGetters(){
        assertEquals(DESCRIPTION,intersectionPlanSet.getDescription());
        assertEquals(IPS1_ID, intersectionPlanSet.getId());
        assertEquals(MOD_STAMP, intersectionPlanSet.getModStamp());
        assertEquals(NAME, intersectionPlanSet.getName());
        assertEquals(PROJECT_ID, intersectionPlanSet.getProjectId());

    }


    @Test
    public void testIsValid(){
        assertTrue(intersectionPlanSet.isValid());
    }

    @Test
    public void testSignalPlanSetList() {
        List<SignalPlanSet> signalPlanSets = new ArrayList<SignalPlanSet>();

        SignalPlanSet s1 = new SignalPlanSet();
        s1.setId(SPS1_ID);
        // set the up pointer
        s1.setIntersectionPlanSetId(IPS1_ID);
        signalPlanSets.add(s1);

        SignalPlanSet s2 = new SignalPlanSet();
        s2.setId(SPS2_ID);
        // set the up pointer
        s2.setIntersectionPlanSetId(IPS1_ID);
        signalPlanSets.add(s2);

        intersectionPlanSet.setListOfSignalPlanSets(signalPlanSets);

        List<SignalPlanSet> signalPlanSetList = intersectionPlanSet.getListOfSignalPlanSets();
        assertEquals(2, signalPlanSetList.size());
        assertEquals(SPS1_ID, signalPlanSetList.get(0).getId());
        assertEquals(SPS2_ID, signalPlanSetList.get(1).getId());
        assertEquals(IPS1_ID, signalPlanSetList.get(0).getIntersectionPlanSetId());
        assertEquals(IPS1_ID, signalPlanSetList.get(1).getIntersectionPlanSetId());
    }


}
