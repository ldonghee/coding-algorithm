package com.dhlee.v1.programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 아이템 줍기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87694
 */
public class PickUpItems {
    int[][] map = new int[102][102];
    boolean[][] visited = new boolean[102][102];
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        for (int[] rec: rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int x = x1; x<=x2; x++) {
                for (int y = y1; y<=y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        // 내부 영역 제거(테두리만 1)
        for (int[] rec: rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int x=x1+1; x<x2; x++) {
                for (int y=y1+1; y<y2; y++) {
                    map[x][y] = 0;
                }
            }
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    int bfs(int posX, int posY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{posX, posY, 0});
        visited[posX][posY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            if (x == itemX && y == itemY) {
                return dist;
            }

            for (int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < 102 && nextY < 102) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY, dist + 1});
                    }
                }
            }
        }

        return 0;
    }
}
