package com.dhlee.v1.programmers.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TargetNumberTest {

    private final TargetNumber targetNumber = new TargetNumber();

    @Test
    void testExample1() {
        int[] numbers = {1, 1, 1, 1, 1};
        assertEquals(5, targetNumber.solution(numbers, 3));
    }

    @Test
    void testExample2() {
        int[] numbers = {4, 1, 2, 1};
        assertEquals(2, targetNumber.solution(numbers, 4));
    }
}
