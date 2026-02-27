package com.dhlee.v1.programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class GameMap {
    int minStep = Integer.MAX_VALUE;

    // 효율성 테스트 실패
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        recursive(0, 0, maps, visited, 1);

        if (minStep == Integer.MAX_VALUE)
            return -1;
        return minStep;
    }

    public void recursive(int curX, int curY, int[][] maps, boolean[][] visited, int step) {
        if (curY == maps.length - 1 && curX == maps[0].length - 1) {
            minStep = Math.min(minStep, step);
            return;
        }

        if (!((curY >= 0 && curY <= maps.length - 1) && (curX >= 0 && curX <= maps[0].length - 1))) {
            return;
        }

        if (visited[curY][curX] || maps[curY][curX] == 0) {
            return;
        }

        visited[curY][curX] = true;

        recursive(curX + 1, curY, maps, visited, step + 1);
        recursive(curX - 1, curY, maps, visited, step + 1);
        recursive(curX, curY + 1, maps, visited, step + 1);
        recursive(curX, curY - 1, maps, visited, step + 1);

        visited[curY][curX] = false;
    }

    public int solution2(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 위, 아래, 왼쪽, 오른쪽
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, maps[0][0]});

        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int dist = current[2];

            if (curX == m - 1 && curY == n - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (maps[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextX, nextY, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
}
