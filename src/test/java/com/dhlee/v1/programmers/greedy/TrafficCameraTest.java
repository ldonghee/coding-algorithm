package com.dhlee.v1.programmers.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficCameraTest {
    private final TrafficCamera camera = new TrafficCamera();

    @Test
    void testExample1() {
        int[][] routes = {
                {-20, -15},
                {-14, -5},
                {-18, -13},
                {-5, -3}
        };
        assertEquals(2, camera.solution(routes));
    }

    @Test
    void testExample1_V2() {
        int[][] routes = {
                {-20, -15},
                {-14, -5},
                {-18, -13},
                {-5, -3}
        };
        assertEquals(2, camera.solution2(routes));
    }
}
