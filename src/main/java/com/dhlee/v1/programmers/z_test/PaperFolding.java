package com.dhlee.v1.programmers.z_test;

public class PaperFolding {
    static int maxVal = Integer.MIN_VALUE;

    public int solution(int[] paper, int k) {
        maxVal = Integer.MIN_VALUE;
        for(int n : paper) maxVal = Math.max(maxVal, n); // 초기 배열 최댓값

        backtracking(paper, 0, k);
        return maxVal;
    }

    static void backtracking(int[] currentPaper, int count, int k) {
        if (count == k || currentPaper.length <= 1) return;

        for (int i = 1; i < currentPaper.length; i++) {
            int[] folded = foldSymmetric(currentPaper, i);

            // 매 단계 최댓값 갱신
            for (int val : folded) {
                if (val > maxVal) maxVal = val;
            }

            backtracking(folded, count + 1, k);
        }
    }

    static int[] foldSymmetric(int[] arr, int point) {
        int leftLen = point;
        int rightLen = arr.length - point;
        int newLen = Math.max(leftLen, rightLen);
        int[] newArr = new int[newLen];

        // 대칭 계산: 접는 선(point)을 기준으로 거리를 계산하여 더함
        // d는 접는 선으로부터 떨어진 거리 (1, 2, 3...)
        for (int d = 1; d <= newLen; d++) {
            int leftIdx = point - d;      // 왼쪽으로 d만큼 떨어진 인덱스
            int rightIdx = point + d - 1; // 오른쪽으로 d만큼 떨어진 인덱스

            int sum = 0;
            if (leftIdx >= 0) sum += arr[leftIdx];
            if (rightIdx < arr.length) sum += arr[rightIdx];

            // 새 배열의 끝(접는 선 쪽)부터 채워넣음
            newArr[newLen - d] = sum;
        }
        return newArr;
    }
}
