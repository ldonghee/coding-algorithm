package com.dhlee.v1.programmers.dp;

/**
 * 등굣길
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
public class GoToTheSchool {

    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        // 출발점
        dp[1][1] = 1;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                // 이전 칸이 웅덩이였다면 위에서 0으로 바꿨기 때문에 안전하게 더해짐
                // 위쪽에서 오는 경로 더하기
                if (i > 1) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j]) % MOD;
                }

                // 왼쪽에서 오는 경로 더하기
                if (j > 1) {
                    dp[i][j] = (dp[i][j] + dp[i][j-1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}
