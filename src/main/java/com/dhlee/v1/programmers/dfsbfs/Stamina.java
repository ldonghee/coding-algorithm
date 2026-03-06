package com.dhlee.v1.programmers.dfsbfs;

/**
 * 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class Stamina {
    /**
     * 최소 필요 피로도, 소모 피로도
     */
    int answer = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        for (int i = 0; i < dungeons.length; i++) {
            dfs(i, k, dungeons, 1);
        }

        return answer;
    }

    void dfs(int pos, int k, int[][] dungeons, int depth) {
        int[] dungeon = dungeons[pos];


        answer = Math.max(answer, depth);

        visited[pos] = true;

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (k - dungeon[1] >= dungeons[i][0]) {
                dfs(i, k - dungeon[1], dungeons, depth + 1);
            }
        }

        visited[pos] = false;
    }
}
