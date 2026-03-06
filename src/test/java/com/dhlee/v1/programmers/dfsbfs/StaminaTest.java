package com.dhlee.v1.programmers.dfsbfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StaminaTest {
    private final Stamina stamina = new Stamina();

    @Test
    void test() {
        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };
        Assertions.assertEquals(3, stamina.solution(k, dungeons));
    }
}