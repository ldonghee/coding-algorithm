package com.dhlee.v1.programmers.z_test;

import java.util.Arrays;

/**
 *  인사고과
 *  https://school.programmers.co.kr/learn/courses/30/lessons/152995#
 */
public class EmployeeEvaluation {
    public int solution(int[][] scores) {
        int n = scores.length;
        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];

        // 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                // 두번째 점수 오름차순
                return a[1] - b[1];
            }
            // 첫번째 점수 오름차순
            return b[0] - a[0];
        });

        int maxSecond = 0;
        int rank = 1; // 완호 순위

        for (int[] score : scores) {

            // 지배당한 경우 (탈락)
            if (score[1] < maxSecond) {
                // 완호가 지배당하면 -1 (참조)
                if (score == wanho) {
                    return -1;
                }
                continue;
            }

            maxSecond = Math.max(score[1], maxSecond);

            int sum = score[0] + score[1];
            if (sum > wanhoSum) {
                rank++;
            }
        }

        return rank;
    }
}
