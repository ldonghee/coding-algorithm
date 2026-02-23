package com.dhlee.v1.programmers.z_test;

/**
 * 최고의 조합
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */
public class BestCombination {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        }

        int[] answer = new int[n];
        int remainder = s % n ;
        int mock = s / n;

        // 모든 칸을 몫으로 채움
        for (int i=0; i<n; i++) {
            answer[i] = mock;
        }

        // 뒤에서부터 1씩 더해줌
        for (int i=0; i<remainder; i++) {
            answer[n - 1 - i] += 1;
        }

        return answer;
    }
}
