package com.dhlee.v1.programmers.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DualPriorityQueueTest {

    private final DualPriorityQueue queue = new DualPriorityQueue();

    @Test
    void testExample1() {
        String[] operations = {
                "I 16",
                "I -5643",
                "D -1",
                "D 1",
                "D 1",
                "I 123",
                "D -1"
        };
        assertArrayEquals(new int[] {0, 0}, queue.solution(operations));
    }

    @Test
    void testExample2() {
        String[] operations = {
                "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
        };
        assertArrayEquals(new int[] {333, -45}, queue.solution(operations));
    }
}
