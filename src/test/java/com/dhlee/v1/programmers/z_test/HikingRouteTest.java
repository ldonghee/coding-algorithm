package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HikingRouteTest {

    private final HikingRoute route = new HikingRoute();

    @Test
    void testExample1() {
        int n = 6;
        int[][] paths = {
                {1, 2, 3},
                {2, 3, 5},
                {2, 4, 2},
                {2, 5, 4},
                {3, 4, 4},
                {4, 5, 3},
                {4, 6, 1},
                {5, 6, 1}
        };
        int[] gates = {1, 3};
        int[] summits = {5};
        assertArrayEquals(new int[] {5, 3},route.solution(n, paths, gates, summits));
    }

    @Test
    void testExample2() {
        int n = 7;
        int[][] paths = {
                {1, 4, 4},
                {1, 6, 1},
                {1, 7, 3},
                {2, 5, 2},
                {3, 7, 4},
                {5, 6, 6}
        };
        int[] gates = {1};
        int[] summits = {2, 3, 4};
        assertArrayEquals(new int[] {3, 4},route.solution(n, paths, gates, summits));
    }

    @Test
    void testExample3() {
        int n = 7;
        int[][] paths = {
                {1, 2, 5},
                {1, 4, 1},
                {2, 3, 1},
                {2, 6, 7},
                {4, 5, 1},
                {5, 6, 1},
                {6, 7, 1}
        };
        int[] gates = {3, 7};
        int[] summits = {1, 5};
        assertArrayEquals(new int[] {5, 1},route.solution(n, paths, gates, summits));
    }

    @Test
    void testExample4() {
        int n = 5;
        int[][] paths = {
                {1, 3, 10},
                {1, 4, 20},
                {2, 3, 4},
                {2, 4, 6},
                {3, 5, 20},
                {4, 5, 6}
        };
        int[] gates = {1, 2};
        int[] summits = {5};
        assertArrayEquals(new int[] {5, 6},route.solution(n, paths, gates, summits));
    }
}
