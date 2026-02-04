package com.dhlee.v1.programmers.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigNumberTest {

    private final BigNumber bigNumber = new BigNumber();

    @Test
    void testExample1() {
        int[] numbers = {6, 10, 2};
        Assertions.assertEquals("6210", bigNumber.solution(numbers));
    }

    @Test
    void testExample2() {
        int[] numbers = {3, 30, 34, 5, 9};
        Assertions.assertEquals("9534330", bigNumber.solution(numbers));
    }
}
