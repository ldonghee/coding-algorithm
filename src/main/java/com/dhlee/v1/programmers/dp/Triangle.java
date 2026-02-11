package com.dhlee.v1.programmers.dp;

/**
 * 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] sum = new int[triangle.length][triangle[triangle.length - 1].length];


        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = triangle[i][j];
                    continue;
                }

                if (j == 0) {
                    sum[i][j] = triangle[i][j] + sum[i - 1][j];
                    continue;
                }

                sum[i][j] = triangle[i][j] + Math.max(sum[i - 1][j], sum[i - 1][j - 1]);
            }
        }

        for (int i = 0; i < sum[sum.length - 1].length; i++) {
            answer = Math.max(sum[sum.length - 1][i], answer);
        }

        return answer;
    }

    public int solution_v2(int[][] triangle) {
        // 1. 밑에서 두 번째 줄부터 꼭대기까지 거꾸로 올라감
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 2. 현재 칸 아래에 있는 왼쪽 자식과 오른쪽 자식 중 큰 값을 선택
                int leftChild = triangle[i + 1][j];
                int rightChild = triangle[i + 1][j + 1];

                // 3. 현재 칸의 값에 더 큰 자식 값을 누적해서 더함
                triangle[i][j] += Math.max(leftChild, rightChild);
            }
        }

        // 4. 모든 계산이 끝나면 꼭대기에 최댓값이 모이게 됨
        return triangle[0][0];
    }
}
