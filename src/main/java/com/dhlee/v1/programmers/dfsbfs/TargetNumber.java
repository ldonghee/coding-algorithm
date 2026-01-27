package com.dhlee.v1.programmers.dfsbfs;

/**
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargetNumber {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        recursive(numbers, target, 0, 0);
        return answer;
    }

    private void recursive(int[] numbers, int target, int sum, int depth) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer += 1;
            }
            return;
        }

        recursive(numbers, target, sum + numbers[depth], depth + 1);
        recursive(numbers, target, sum - numbers[depth], depth + 1);
    }
}
