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
                if (i == 1 && j == 1) {
                    continue;
                }

                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        return dp[n][m];
    }
}
