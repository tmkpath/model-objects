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

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.*;

public class RouteSetTest {
    RouteSet routeSet;
    Route route;
    ArrayList<RouteLink> rlinks;
    RouteLink rlink1;
    RouteLink rlink2;

    private static String ROUTE_SET_NAME = "TEST ROUTE SET";
    private static long ROUTE_SET_ID = 1;
    private static long ROUTE_SET_PROJECT_ID = 1;

    private static String ROUTE_NAME = "TEST ROUTE";
    private static long ROUTE_ID = 1;

    private static long ROUTE_LINK_ID1 = 1;
    private static int ROUTE_LINK_ORDER1 = 1;

    private static long ROUTE_LINK_ID2 = 2;
    private static int ROUTE_LINK_ORDER2 = 2;

    @Before
    public void setup() {
        routeSet = new RouteSet();
        routeSet.setId(ROUTE_SET_ID);
        routeSet.setProjectId(ROUTE_SET_PROJECT_ID);
        routeSet.setName(ROUTE_SET_NAME);

        // Mock route Object
        route = new Route();
        route.setName(ROUTE_NAME);
        route.setId(ROUTE_ID);

        // Add two route links
        rlink1 = new RouteLink();
        rlink1.setLinkId(ROUTE_LINK_ID1);
        rlink1.setLinkOrder(ROUTE_LINK_ORDER1);

        rlink2 = new RouteLink();
        rlink2.setLinkId(ROUTE_LINK_ID2);
        rlink2.setLinkOrder(ROUTE_LINK_ORDER2);

        rlinks = new ArrayList<RouteLink>();
        rlinks.add(rlink1);
        rlinks.add(rlink2);
        route.setListOfRouteLinks(rlinks);

        List<Route> routes = new ArrayList<Route>();
        routes.add(route);
        routeSet.setListOfRoutes(routes);
    }

    @Test
    public void testSettersGetters() {
        // test routeSet  model object
        assertEquals(routeSet.getName(), ROUTE_SET_NAME);
        assertEquals(routeSet.getId(), ROUTE_SET_ID);
        assertEquals(routeSet.getProjectId(), ROUTE_SET_PROJECT_ID);

        // test first in list of routes
        route = routeSet.getListOfRoutes().get(0);
        assertNotNull(route);
        assertEquals(routeSet.getName(), ROUTE_SET_NAME);
        assertEquals(routeSet.getId(), ROUTE_SET_ID);
        assertEquals(routeSet.getProjectId(), ROUTE_SET_PROJECT_ID);

        // test route model object
        assertEquals(route.getName(), ROUTE_NAME);
        assertEquals(route.getId(), ROUTE_ID);

        // test first in list of route links
        rlink1 = route.getListOfRouteLinks().get(0);
        assertNotNull(rlink1);
        assertEquals((long)rlink1.getLinkId(), ROUTE_LINK_ID1);
        assertEquals(rlink1.getLinkOrder(), ROUTE_LINK_ORDER1);

        // test second in list of route links
        rlink2 = route.getListOfRouteLinks().get(1);
        assertNotNull(rlink2);
        assertEquals((long)rlink2.getLinkId(), ROUTE_LINK_ID2);
        assertEquals(rlink2.getLinkOrder(), ROUTE_LINK_ORDER2);
    }
}