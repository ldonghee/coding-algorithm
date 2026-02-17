package com.dhlee.v1.programmers.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FatigueTest {

    private final Fatigue fatigue = new Fatigue();

    @Test
    void testExample1() {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        Assertions.assertEquals(3, fatigue.solution(k, dungeons));
    }
}
