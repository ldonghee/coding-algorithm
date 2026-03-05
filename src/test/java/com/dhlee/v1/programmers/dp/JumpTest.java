package com.dhlee.v1.programmers.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JumpTest {
    private final Jump jump = new Jump();

    @Test
    void test1() {
        Assertions.assertEquals(5, jump.solution(4));
    }

    @Test
    void test2() {
        Assertions.assertEquals(3, jump.solution(3));
    }
}