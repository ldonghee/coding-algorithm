package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LockAndKeyTest {

    private final LockAndKey lockAndKey = new LockAndKey();

    @Test
    void testExample1() {
        int[][] key = {
                {0, 0, 0}, {1, 0, 0}, {0, 1, 1}
        };
        int[][] lock = {
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        assertTrue(lockAndKey.solution(key, lock));
    }

}
