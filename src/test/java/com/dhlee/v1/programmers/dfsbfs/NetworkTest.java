package com.dhlee.v1.programmers.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkTest {
    private final Network network = new Network();

    @Test
    void testExample1() {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        assertEquals(2, network.solution(n, computers));
    }

    @Test
    void testExample2() {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        assertEquals(1, network.solution(n, computers));
    }
}
