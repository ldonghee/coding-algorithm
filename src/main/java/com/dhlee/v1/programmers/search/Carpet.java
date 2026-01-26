package com.dhlee.v1.programmers.search;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        return findDimension(3, total, yellow);
    }

    private int[] findDimension(int h, int total, int yellow) {
        // total 이 h로 나누어 떨어지는지 확인 (가로가 정수여야 함)
        if (total % h == 0) {
            int w = total / h;

            // 중앙 노란색 타일 개수 조건 확인
            if ((w - 2) * (h - 2) == yellow) {
                return new int[] {w, h};
            }
        }

        // 조건을 만족하지 못하면 세로 길이를 1 늘려서 다음 재귀 호출
        return findDimension(h + 1, total, yellow);
    }
}