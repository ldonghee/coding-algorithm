package com.dhlee.v1.programmers.z_test;


/**
 *  스티커 모으기(2)
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12971
 */
public class StickerCollect {
    public int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length == 1) {
            return sticker[0];
        }

        answer = Math.max(answer, doMax(sticker, 0, sticker.length-2));
        answer = Math.max(answer, doMax(sticker, 1, sticker.length-1));

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

        for (int i=2; i<len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[start + i]);
        }

        return dp[len-1];
    }
}
