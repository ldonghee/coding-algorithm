package com.dhlee.v1.programmers.dfsbfs;

/**
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, visited, computers);
                answer++;
            }
        }

        return answer;
    }

    void dfs(int cur, int n, boolean[] visited, int[][] computers) {
        visited[cur] = true;

        for (int i = 0; i < n; i++) {
            if (i != cur && !visited[i] && computers[cur][i] == 1) {
                dfs(i, n, visited, computers);
            }
        }
    }
}
