package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberGameTest {

    private final NumberGame game = new NumberGame();

    @Test
    void testExample1() {
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};
        assertEquals(3, game.solution(a, b));
    }

    @Test
    void testExample2() {
        int[] a = {2, 2, 2, 2};
        int[] b = {1, 1, 1, 1};
        assertEquals(0, game.solution(a, b));
    }

    @Test
    void testExample3() {
        int[] a = {10, 9, 8};
        int[] b = {1, 2, 3};
        assertEquals(0, game.solution(a, b));
    }
}
