package com.dhlee.v1.programmers.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeSearchTest {

    private final PrimeSearch primeSearch = new PrimeSearch();

    @Test
    void testExample1() {
        assertEquals(3, primeSearch.solution("17"));
    }

    @Test
    void testExample2() {
        assertEquals(2, primeSearch.solution("011"));
    }

    @Test
    void testSingleDigit() {
        assertEquals(1, primeSearch.solution("2"));
        assertEquals(1, primeSearch.solution("3"));
        assertEquals(1, primeSearch.solution("5"));
        assertEquals(1, primeSearch.solution("7"));
    }

    @Test
    void testNonPrimeDigits() {
        assertEquals(0, primeSearch.solution("1"));
        assertEquals(0, primeSearch.solution("4"));
        assertEquals(0, primeSearch.solution("6"));
        assertEquals(0, primeSearch.solution("8"));
        assertEquals(0, primeSearch.solution("9"));
    }
}

