package com.dhlee.v1.programmers.dp;

import java.util.Arrays;

/**
 * 땅따먹기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */
public class Hopscotch {
    int solution(int[][] land) {
        int answer = 0;

        int row = land.length;
        int col = land[0].length;

        int[][] dp = new int[row][col];

        for (int i=0; i<col; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i=1; i<row; i++) {
            for (int j=0; j<col; j++) {
                for (int k=0; k<col; k++) {
                    if (j != k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                    }
                }
            }
        }

        for (int i=0; i<col; i++) {
            answer = Math.max(answer, dp[row - 1][i]);
        }

        return answer;
    }

    /**
     * 최적화
     */
    int solution2(int[][] land) {
        int m = land[0].length;

        // 전체 dp 배열 대신 이전 행만 유지
        int[] prev = Arrays.copyOf(land[0], m);

        for (int i = 1; i < land.length; i++) {
            int[] curr = new int[m];

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        curr[j] = Math.max(curr[j], prev[k] + land[i][j]);
                    }
                }
            }

            prev = curr; // 이전 행 교체
        }

        int answer = 0;
        for (int val : prev) {
            answer = Math.max(answer, val);
        }
        return answer;
    }
}
