package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RepresentableBinaryTreeTest {

    private final RepresentableBinaryTree tree = new RepresentableBinaryTree();

    @Test
    void testExample1() {
        long[] numbers = {7, 42, 5};
        assertArrayEquals(new int[] {1, 1, 0}, tree.solution(numbers));
    }

    @Test
    void testExample2() {
        long[] numbers = {63, 111, 95};
        assertArrayEquals(new int[] {1, 1, 0}, tree.solution(numbers));
    }
}
