package com.dhlee.v1.programmers.dp;

/**
 * 멀리뛰기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */
public class Jump {
    public long solution(int n) {
        // 몇가지 갯수
        // dp[n] = dp[n-2] + dp[n-1]

        // dp[1] = 1
        // dp[2] = 2
        // dp[3] = dp[1] + dp[2] = 3
        // dp[4] = dp[2] + dp[3] = 5
        // dp[5] = dp[3] + dp[4] = 8
        if (n == 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1 % 1234567;
        dp[2] = 2 % 1234567;
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }


        return dp[n];
    }
}
