package com.dhlee.v1.programmers.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TravelRouteTest {

    private final TravelRoute travelRoute = new TravelRoute();

    @Test
    void testExample1() {
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };
        assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"}, travelRoute.solution(tickets));
    }

    @Test
    void testExample2() {
        String[][] tickets = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };
        assertArrayEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}, travelRoute.solution(tickets));
    }
}
