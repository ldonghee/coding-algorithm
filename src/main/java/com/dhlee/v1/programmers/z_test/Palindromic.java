package com.dhlee.v1.programmers.z_test;

/**
 *  가장 긴 팰린드롬
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12904
 */
public class Palindromic {
    public int solution(String s)
    {
        int n = s.length();
        if (n < 2) return n;

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            // 1. 홀수 길이 팰린드롬 확인 (중심이 i)
            maxLen = Math.max(maxLen, expandAroundCenter(s, i, i));

            // 2. 짝수 길이 팰린드롬 확인 (중심이 i와 i+1 사이)
            maxLen = Math.max(maxLen, expandAroundCenter(s, i, i + 1));
        }

        return maxLen;
    }

    private int expandAroundCenter(String s, int left, int right) {
        // 범위를 벗어나지 않고, 양끝 문자가 같을 때까지 확장
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 반복문을 빠져나올 때 left와 right는 팰린드롬 범위를 한 칸 벗어난 상태임
        // 따라서 길이는 (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }
}
