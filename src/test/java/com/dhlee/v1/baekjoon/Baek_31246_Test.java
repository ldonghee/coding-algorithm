package com.dhlee.v1.baekjoon;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Baek_31246_Test {

    private final Baek_31246 baek = new Baek_31246();

    @Test
    void testExample1() throws IOException {
        int N = 3;
        int K = 2;
        int[][] rows = {
                {3, 1},
                {2, 1},
                {1, 2}
        };
        assertEquals(0, baek.solution(N, K, rows));
    }

    @Test
    void testExample2() throws IOException {
        int N = 3;
        int K = 2;
        int[][] rows = {
                {10, 30},
                {21, 19},
                {10 ,12}
        };
        assertEquals(2, baek.solution(N, K, rows));
    }
}
