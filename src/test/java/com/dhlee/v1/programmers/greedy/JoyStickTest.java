package com.dhlee.v1.programmers.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JoyStickTest {

    private final Joystick joystick = new Joystick();

    @Test
    void testExample1() {
        assertEquals(23, joystick.solution("JAN"));
    }

    @Test
    void testExample2() {
        assertEquals(11, joystick.solution("JAZ"));
    }

    @Test
    void testExample3() {
        assertEquals(56, joystick.solution("JEROEN"));
    }
}

