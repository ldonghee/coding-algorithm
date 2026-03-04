package com.dhlee.v1.programmers.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HopscotchTest {
    private final Hopscotch hopscotch = new Hopscotch();

    @Test
    void test1() {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };

        Assertions.assertEquals(16, hopscotch.solution(land));
    }

    @Test
    void test2() {
        int[][] land = {
                {1, 1, 1, 1},
                {1, 1, 10, 1},
                {1, 50, 1, 1},
                {1, 60, 1, 1}
        };

        Assertions.assertEquals(72, hopscotch.solution(land));
    }

}