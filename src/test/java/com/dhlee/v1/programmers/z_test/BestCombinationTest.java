package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BestCombinationTest {

    private final BestCombination combination = new BestCombination();

    @Test
    void testExample1() {
        int n = 2;
        int s = 9;
        assertArrayEquals(new int[]{4, 5}, combination.solution(n, s));
    }

    @Test
    void testExample2() {
        int n = 2;
        int s = 1;
        assertArrayEquals(new int[]{-1}, combination.solution(n, s));
    }

    @Test
    void testExample3() {
        int n = 2;
        int s = 8;
        assertArrayEquals(new int[]{4, 4}, combination.solution(n, s));
    }

    @Test
    void testExample4() {
        int n = 3;
        int s = 9;
        assertArrayEquals(new int[]{3, 3, 3}, combination.solution(n, s));
    }
}
