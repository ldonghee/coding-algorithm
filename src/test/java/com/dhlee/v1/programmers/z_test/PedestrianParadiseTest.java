package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PedestrianParadiseTest {

    private final PedestrianParadise pedestrian = new PedestrianParadise();

    @Test
    void testExample1() {
        int m = 3;
        int n = 3;
        int[][] cityMap = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        Assertions.assertEquals(6, pedestrian.solution(m, n, cityMap));
    }

    @Test
    void testExample2() {
        int m = 3;
        int n = 6;
        int[][] cityMap = {
                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 1, 0},
                {1, 0, 0, 2, 2, 0}
        };
        Assertions.assertEquals(2, pedestrian.solution(m, n, cityMap));
    }
}
