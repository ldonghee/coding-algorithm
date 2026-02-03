package com.dhlee.v1.programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class GameMapBfs {
    // 이동 방향(우 좌 하 상)
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        // n x m 크기의 맵
        int n = maps.length;    // 행의 개수
        int m = maps[0].length; // 열의 개수

        // 거리를 저장할 배열
        int[][] distance = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();

        // 시작점 설정 (0, 0)에서 1칸 이동한 상태로 시작
        queue.offer(new int[]{0, 0});
        distance[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            // 도착점에 도달했다면 현재까지의 거리를 반환
            if (y == n - 1 && x == m -1) {
                return distance[y][x];
            }

            for (int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 맴 범위 내에 있고, 이동할 수 있는 칸이면, 아직 방문하지 않았다면
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (maps[ny][nx] == 1 && distance[ny][nx] == 0) {
                        distance[ny][nx] = distance[y][x] + 1; // 이전 칸 거리 + 1
                        queue.offer(new int[]{ny, nx});        // 큐에 새 위치 추가
                    }
                }
            }
        }

        return -1; // 도착점에 도달하지 못한 경우
    }
}
