package com.dhlee.v1.programmers.dp;


/**
 * 스티커 모으기(2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12971
 */
public class StickerCollect {
    public int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length == 1) {
            return sticker[0];
        }

        answer = Math.max(answer, doMax(sticker, 0, sticker.length - 2));
        answer = Math.max(answer, doMax(sticker, 1, sticker.length - 1));

        return answer;
    }

    private int doMax(int[] sticker, int start, int end) {
        int len = end - start + 1;
        if (len == 1) {
            return sticker[start];
        }

        int[] dp = new int[len];
        dp[0] = sticker[start];
        dp[1] = Math.max(sticker[start], sticker[start + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[start + i]);
        }

        return dp[len - 1];
    }

    /*
        14 6 5 11 3 9 2 10
        6 -> 11 -> 9 -> 10 => 36

        1 100 0 10 1000 0 0
        => 최댓값 구하기

        2가지 경우
        - 0 번에서 시작, length -1 까지
        - 1 번에서 시작, length 까지

        dp[i] = i 번쨰 까지 최대 점수
        i 뜯는다
            - dp[i-2] + sticker[i]

        i 뜯지 않는다
            - dp[i-1]

        dp[i] = max(dp[i-2] + sticker[i], dp[i-1])


    */
    public int solution2(int sticker[]) {
        int n = sticker.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];

        if (n == 1) {
            return sticker[0];
        }
        if (n == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0], sticker[1]);

        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];
        dp2[2] = Math.max(sticker[1], sticker[2]);

        for (int i = 3; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }


        return Math.max(dp[n - 2], dp2[n - 1]);
    }
}
