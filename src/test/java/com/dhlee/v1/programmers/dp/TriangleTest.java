package com.dhlee.v1.programmers.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    private final Triangle rectangle = new Triangle();

    @Test
    void testExample1() {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        assertEquals(30, rectangle.solution(triangle));
    }

    @Test
    void testExample1_V2() {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        assertEquals(30, rectangle.solution_v2(triangle));
    }
}
