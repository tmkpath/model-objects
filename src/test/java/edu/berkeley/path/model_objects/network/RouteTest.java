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

package edu.berkeley.path.model_objects.network;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.*;

public class RouteTest {
    Route route;
    ArrayList<RouteLinks> rlinks;
    RouteLinks rlink1;
    RouteLinks rlink2;

    private static String ROUTE_NAME = "TEST ROUTE";
    private static long ROUTE_ID = 1;
    private static long PROJECT_ID = 1;

    private static long ROUTE_LINK_ID1 = 1;
    private static long ROUTE_LINK_ORDER1 = 1;

    private static long ROUTE_LINK_ID2 = 2;
    private static long ROUTE_LINK_ORDER2 = 2;

    @Before
    public void setup() {
        // Mock route Object
        route = new Route();
        route.setName(ROUTE_NAME);
        route.setId(ROUTE_ID);
        route.setProjectId(PROJECT_ID);

        // Add two route links
        rlink1 = new RouteLinks();
        rlink1.setLinkReferenceId(ROUTE_LINK_ID1);
        rlink1.setLinkOrder(ROUTE_LINK_ID1);

        rlink2 = new RouteLinks();
        rlink2.setLinkReferenceId(ROUTE_LINK_ID2);
        rlink2.setLinkOrder(ROUTE_LINK_ID2);

        rlinks = new ArrayList<RouteLinks>();
        rlinks.add(rlink1);
        rlinks.add(rlink2);
        route.setListOfRouteLinks(rlinks);
    }

    @Test
    public void testSettersGetters() {
        // test route model object
        assertEquals(route.getName(), ROUTE_NAME);
        assertEquals(route.getId(), ROUTE_ID);
        assertEquals(route.getProjectId(), PROJECT_ID);

        // test first in list of route links
        rlink1 = route.getListOfRouteLinks().get(0);

        assertEquals((long)rlink1.getLinkReferenceId(), ROUTE_LINK_ID1);
        assertEquals(rlink1.getLinkOrder(), ROUTE_LINK_ORDER1);

        // test second in list of route links
        rlink2 = route.getListOfRouteLinks().get(1);

        assertEquals((long)rlink2.getLinkReferenceId(), ROUTE_LINK_ID2);
        assertEquals(rlink2.getLinkOrder(), ROUTE_LINK_ORDER2);

    }
}