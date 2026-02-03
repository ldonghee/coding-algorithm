package com.dhlee.v1.programmers.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameMapTest {

    private final GameMap gameMap = new GameMap();
    private final GameMapBfs gameMapBfs = new GameMapBfs();

    @Test
    void testExample1() {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        assertEquals(11, gameMap.solution(maps));
    }

    @Test
    void testExample2() {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        assertEquals(-1, gameMap.solution(maps));
    }

    @Test
    void testExample3() {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        assertEquals(11, gameMapBfs.solution(maps));
    }

    @Test
    void testExample4() {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        assertEquals(-1, gameMapBfs.solution(maps));
    }
}
