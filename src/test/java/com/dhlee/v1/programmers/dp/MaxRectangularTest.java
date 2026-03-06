package com.dhlee.v1.programmers.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxRectangularTest {
    private final MaxRectangular rectangular = new MaxRectangular();

    @Test
    void test1() {
        int[][] board = {
                {0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}
        };

        Assertions.assertEquals(9, rectangular.solution(board));
    }

    @Test
    void test2() {
        int[][] board = {
                {0,0,1,1},{1,1,1,1}
        };

        Assertions.assertEquals(4, rectangular.solution(board));
    }
}