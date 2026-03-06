package com.dhlee.v1.programmers.dp;

/**
 * 가장 큰 정 사각형 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12905
 */
public class MaxRectangular {
    /*
        0 1 1 1
        1 0 0 0
        1 0 1 1
        1 0 1 1

        1 0 0 0
        0 1 0 0
        0 1 0 0
        0 1 0 0
    */
    public int solution(int [][]board)
    {
        int answer = 0;
        int height = board.length;
        int width = board[0].length;
        int[][] dp = new int[height][width];


        for (int row=0; row<height; row++) {
            for (int col=0; col<width; col++) {
                if (board[row][col] == 0) {
                    dp[row][col] = 0;
                    continue;
                }

                if (row == 0 || col == 0) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = Math.min(dp[row-1][col], Math.min(dp[row][col-1], dp[row-1][col-1])) + 1;
                }
                answer = Math.max(answer, dp[row][col]);

            }
        }

        return answer * answer;
    }
}
