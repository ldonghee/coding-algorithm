package com.dhlee.v1.programmers.search;

/**
 * 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class Fatigue {
    int answer = -1;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }

    private void dfs(int curFatigue, int[][] dungeons, boolean[] visited, int depth) {
        answer = Math.max(answer, depth);

        // 모든 던전을 후보로 두고 하나씩 방문 시도
        for (int i = 0; i < dungeons.length; i++) {
            // 아직 방문하지 않았고, 최소 필요 피로도를 충족한다면
            if (!visited[i] && curFatigue >= dungeons[i][0]) {
                visited[i] = true;

                // 재귀 호출: 피로도 소모하고, 방문 횟수 + 1
                dfs(curFatigue - dungeons[i][1], dungeons, visited, depth + 1);

                visited[i] = false;
            }
        }
    }
}
