package com.dhlee.v1.programmers.dijkstra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaxiFareCalculatorTest {
    private final TaxiFareCalculator calculator = new TaxiFareCalculator();

    @Test
    void testExample1() {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };
        Assertions.assertEquals(82, calculator.solution(n, s, a, b, fares));
    }

    @Test
    void testExample2() {
        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] fares = {
                {5, 7, 9},
                {4, 6, 4},
                {3, 6, 1},
                {3, 2, 3},
                {2, 1, 6}
        };
        Assertions.assertEquals(14, calculator.solution(n, s, a, b, fares));
    }

    @Test
    void testExample3() {
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] fares = {
                {2, 6, 6},
                {6, 3, 7},
                {4, 6, 7},
                {6, 5, 11},
                {2, 5, 12},
                {5, 3, 20},
                {2, 4, 8},
                {3, 4, 9}
        };
        Assertions.assertEquals(18, calculator.solution(n, s, a, b, fares));
    }
}