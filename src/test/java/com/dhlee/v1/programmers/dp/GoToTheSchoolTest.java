package com.dhlee.v1.programmers.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoToTheSchoolTest {

    private final GoToTheSchool school = new GoToTheSchool();

    @Test
    void testExample1() {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        Assertions.assertEquals(4, school.solution(m, n, puddles));
    }
}
