package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromicTest {

    private final Palindromic palindromic = new Palindromic();

    @Test
    void testExample1() {
        String s = "abcdcba";
        assertEquals(7, palindromic.solution(s));
    }

    @Test
    void testExample2() {
        String s = "abacde";
        assertEquals(3, palindromic.solution(s));
    }
}
