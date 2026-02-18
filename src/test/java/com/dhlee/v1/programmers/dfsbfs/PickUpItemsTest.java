package com.dhlee.v1.programmers.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PickUpItemsTest {
    private final PickUpItems pickUpItems = new PickUpItems();

    @Test
    void testExample1() {
        int[][] rectangle = {
                {1, 1, 7, 4},
                {3, 2, 5, 5},
                {4, 3, 6, 9},
                {2, 6, 8, 8}
        };
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        assertEquals(17, pickUpItems.solution(rectangle, characterX, characterY, itemX, itemY));
    }

    @Test
    void testExample2() {
        int[][] rectangle = {
                {1, 1, 8, 4},
                {2, 2, 4, 9},
                {3, 6, 9, 8},
                {6, 3, 7, 7}
        };
        int characterX = 9;
        int characterY = 7;
        int itemX = 6;
        int itemY = 1;
        assertEquals(11, pickUpItems.solution(rectangle, characterX, characterY, itemX, itemY));
    }

    @Test
    void testExample3() {
        int[][] rectangle = {
                {1, 1, 5, 7},
        };
        int characterX = 1;
        int characterY = 1;
        int itemX = 4;
        int itemY = 7;
        assertEquals(9, pickUpItems.solution(rectangle, characterX, characterY, itemX, itemY));
    }

    @Test
    void testExample4() {
        int[][] rectangle = {
                {2, 1, 7, 5},
                {6, 4, 10, 10},
        };
        int characterX = 3;
        int characterY = 1;
        int itemX = 7;
        int itemY = 10;
        assertEquals(15, pickUpItems.solution(rectangle, characterX, characterY, itemX, itemY));
    }

    @Test
    void testExample5() {
        int[][] rectangle = {
                {2, 2, 5, 5},
                {1, 3, 6, 4},
                {3, 1, 4, 6},
        };
        int characterX = 1;
        int characterY = 4;
        int itemX = 6;
        int itemY = 3;
        assertEquals(10, pickUpItems.solution(rectangle, characterX, characterY, itemX, itemY));
    }
}
