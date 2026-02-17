package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecutivePartialSumTest {

    private final ExecutivePartialSum sum = new ExecutivePartialSum();

    @Test
    void testExample1() {
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        assertEquals(10, sum.solutionV2(sequence));
    }

    @Test
    void testExample2() {
        int[] sequence = {1, 2, 5, -3, 2, -3, 6};
        assertEquals(19, sum.solutionV2(sequence));
    }

    @Test
    void testExample3() {
        int[] sequence = {-1, -2, -3, -4, -5};
        assertEquals(5, sum.solutionV2(sequence));
    }
}
