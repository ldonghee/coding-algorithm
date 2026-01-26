package com.dhlee.v1.programmers.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarpetTest {

    private final Carpet carpet = new Carpet();

    @Test
    void testExample1() {
        assertArrayEquals(new int[] {4,3}, carpet.solution(10, 2));
    }

    @Test
    void testExample2() {
        assertArrayEquals(new int[]{3, 3}, carpet.solution(8, 1));
    }

    @Test
    void testExample3() {
        assertArrayEquals(new int[]{8, 6}, carpet.solution(24, 24));
    }
}

