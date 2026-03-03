package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaperFoldingTest {
    private final PaperFolding paperFolding = new PaperFolding();

    @Test
    void testExample1() {
        int[] paper = {1, 3, 5, -1, 3};
        int k = 3;
        assertEquals(11, paperFolding.solution(paper, k));
    }


    @Test
    void testExample2() {
        int[] paper = {1, 3, 5, -1, 3};
        int k = 0;
        assertEquals(5, paperFolding.solution(paper, k));
    }

    @Test
    void testExample3() {
        int[] paper = {10, -20, 10, -20, 10};
        int k = 2;
        // (10-20) + (10-20) + 10 = -10 (모두 접었을 때)
        // 하지만 초기값 10이 더 크므로 10이 유지되어야 함
        assertEquals(10, paperFolding.solution(paper, k));
    }
}
