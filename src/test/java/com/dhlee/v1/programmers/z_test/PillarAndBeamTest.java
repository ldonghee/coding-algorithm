package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PillarAndBeamTest {

    private final PillarAndBeam pillarAndBeam = new PillarAndBeam();

    @Test
    void testExample1() {
        int n = 5;
        int[][] build_frame = {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {2, 1, 0, 1},
                {2, 2, 1, 1},
                {5, 0, 0, 1},
                {5, 1, 0, 1},
                {4, 2, 1, 1},
                {3, 2, 1, 1}
        };
        int[][] result = {
                {1, 0, 0},
                {1, 1, 1},
                {2, 1, 0},
                {2, 2, 1},
                {3, 2, 1},
                {4, 2, 1},
                {5, 0, 0},
                {5, 1, 0}
        };
        assertArrayEquals(result, pillarAndBeam.solution(n, build_frame));
    }

    @Test
    void testExample2() {
        int n = 5;
        int[][] build_frame = {
                {0, 0, 0, 1},
                {2, 0, 0, 1},
                {4, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {2, 1, 1, 1},
                {3, 1, 1, 1},
                {2, 0, 0, 0},
                {1, 1, 1, 0},
                {2, 2, 0, 1}
        };
        int[][] result = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 1},
                {2, 1, 1},
                {3, 1, 1},
                {4, 0, 0}
        };
        assertArrayEquals(result, pillarAndBeam.solution(n, build_frame));
    }
}
