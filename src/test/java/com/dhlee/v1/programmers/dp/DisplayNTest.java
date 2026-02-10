package com.dhlee.v1.programmers.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayNTest {

    private final DisplayN displayN = new DisplayN();

    @Test
    void testExample1() {
        assertEquals(4, displayN.solution(5, 12));
    }

    @Test
    void testExample2() {
        assertEquals(3, displayN.solution(2, 11));
    }
}
