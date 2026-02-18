package com.dhlee.v1.programmers.z_test;

/**
 * 보행자 천국
 * https://school.programmers.co.kr/learn/courses/30/lessons/1832
 */
public class PedestrianParadise {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        // dp[row][col][direction]
        // direction 0: 왼쪽에서 온 경우, 1: 위에서 온 경우
        int[][][] dp = new int[m + 1][n + 1][2];
        dp[1][1][0] = 1;
        dp[1][1][1] = 1;

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                int current = cityMap[i - 1][j - 1];

                if (current == 2) {
                    dp[i][j][0] = dp[i][j - 1][0];
                    dp[i][j][1] = dp[i - 1][j][1];
                } else if (current == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                } else {
                    dp[i][j][0] = (dp[i][j - 1][0] + dp[i - 1][j][1]) % MOD;
                    dp[i][j][1] = (dp[i][j - 1][0] + dp[i - 1][j][1]) % MOD;
                }
            }
        }
        return (dp[m][n - 1][0] + dp[m - 1][n][1]) % MOD;
    }
}
