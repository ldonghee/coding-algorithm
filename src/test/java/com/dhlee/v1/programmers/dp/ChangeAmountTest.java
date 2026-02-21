package com.dhlee.v1.programmers.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeAmountTest {

    private final ChangeAmount amount = new ChangeAmount();

    @Test
    void testExample1() {
        int n = 5;
        int[] money = {1, 2, 5};
        assertEquals(4, amount.solution(n, money));
    }
}
