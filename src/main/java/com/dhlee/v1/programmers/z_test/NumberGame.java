package com.dhlee.v1.programmers.z_test;

import java.util.Arrays;

/**
 * 숫자 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/12987
 */
public class NumberGame {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < A.length && bIndex < B.length) {

            if (B[bIndex] > A[aIndex]) {
                answer++;
                aIndex++;
                bIndex++;
            } else {
                bIndex++;
            }
        }

        return answer;
    }
}
