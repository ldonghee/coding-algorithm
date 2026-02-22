package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NightWorkIndexTest {

    private final NightWorkIndex nightWork = new NightWorkIndex();

    @Test
    void testExample1() {
        int n = 4;
        int[] works = {4, 3, 3};
        assertEquals(12, nightWork.solution(n, works));
    }

    @Test
    void testExample2() {
        int n = 1;
        int[] works = {2, 1, 2};
        assertEquals(6, nightWork.solution(n, works));
    }

    @Test
    void testExample3() {
        int n = 3;
        int[] works = {1, 1};
        assertEquals(0, nightWork.solution(n, works));
    }
}
