package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemCollectorTest {
    private final ItemCollector itemCollector = new ItemCollector();

    @Test
    void testExample1() {
        int[][] board = {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 1, 0, 0, 0, 0, 0, 0, 1, 2},
                {2, 2, 2, 0, 0, 1, 0, 0, 2, 2},
                {2, 2, 2, 0, 0, 0, 0, 0, 2, 2}, // (3,3) 위치 주변 벽 확인
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 2, 2, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 하단 아이템 배치 확인
                {2, 2, 2, 2, 0, 0, 0, 0, 0, 0}
        };
        int startR = 4;
        int startC = 4;

        assertEquals(5, itemCollector.solution(board, startR, startC));
    }

    @Test
    void testExample2() {
        int[][] board = {
                {2, 2, 2},
                {2, 0, 2},
                {2, 2, 2}
        };
        assertEquals(0, itemCollector.solution(board, 1, 1));
    }

    @Test
    void testExample3() {
        int[][] board = {
                {2, 2, 2, 2, 2},
                {2, 1, 1, 1, 2}, // 아이템 3개가 나란히 있음
                {2, 2, 2, 2, 2}
        };
        // 한 번의 이동으로 경로상의 아이템 3개를 모두 먹어야 함
        assertEquals(3, itemCollector.solution(board, 1, 2));
    }

    @Test
    void testExample4() {
        int[][] board = {
                {2, 2, 2, 2, 2},
                {2, 1, 0, 0, 2}, // 왼쪽 끝에 아이템
                {2, 0, 0, 1, 2}, // 오른쪽 끝에 아이템
                {2, 2, 2, 2, 2}
        };
        // 시작점 (1, 2)에서 왼쪽으로 가서 하나 먹고,
        // 다시 리셋해서 오른쪽으로 가야만 2개를 다 먹을 수 있는 구조
        assertEquals(2, itemCollector.solution(board, 1, 2));
    }

}
