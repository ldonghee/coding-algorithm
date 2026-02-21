package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeEvaluationTest {

    private final EmployeeEvaluation evaluation = new EmployeeEvaluation();

    @Test
    void testExample1() {
        int[][] scores = {
                {2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}
        };
        assertEquals(4, evaluation.solution(scores));
    }

    @Test
    void testExample2() {
        int[][] scores = {
                {1, 1}, {2, 2}, {3, 3}
        };
        assertEquals(-1, evaluation.solution(scores));
    }

    @Test
    void testExample3() {
        int[][] scores = {
                {5, 5}, {6, 4}, {7, 3}, {8, 2}, {9, 1}
        };
        assertEquals(1, evaluation.solution(scores));
    }

    @Test
    void testExample4() {
        int[][] scores = {
                {5, 5}, {7, 7}, {6, 1}
        };
        assertEquals(-1, evaluation.solution(scores));
    }
}
