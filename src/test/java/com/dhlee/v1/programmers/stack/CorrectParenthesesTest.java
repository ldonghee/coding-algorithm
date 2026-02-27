package com.dhlee.v1.programmers.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorrectParenthesesTest {

    private final CorrectParentheses parentheses = new CorrectParentheses();

    @Test
    void testExample1() {
        String s = "()()";
        assertTrue(parentheses.solution2(s));
    }

    @Test
    void testExample2() {
        String s = "(())()";
        assertTrue(parentheses.solution2(s));
    }

    @Test
    void testExample3() {
        String s = ")()(";
        assertFalse(parentheses.solution2(s));
    }

    @Test
    void testExample4() {
        String s = "(()(";
        assertFalse(parentheses.solution2(s));
    }
}
