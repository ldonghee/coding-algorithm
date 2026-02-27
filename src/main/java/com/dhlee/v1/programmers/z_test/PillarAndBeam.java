package com.dhlee.v1.programmers.z_test;

/**
 * 기둥과 보 설치
 * https://school.programmers.co.kr/learn/courses/30/lessons/60061
 */
public class PillarAndBeam {
    boolean[][][] build;
    int N;

    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        build = new boolean[n + 1][n + 1][2];

        int count = 0;

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int action = frame[3];

            if (action == 1) {
                // 설치
                build[x][y][type] = true;
                if (!isValid()) {
                    build[x][y][type] = false;
                } else {
                    count++;
                }
            }
            {
                // 삭제
                build[x][y][type] = false;
                if (!isValid()) {
                    build[x][y][type] = true;
                } else {
                    count--;
                }
            }
        }

        return getResult(count);
    }

    int[][] getResult(int count) {
        int[][] answer = new int[count][3];
        int idx = 0;

        for (int x = 0; x <= N; x++) {
            for (int y = 0; y <= N; y++) {
                if (build[x][y][0]) {
                    answer[idx++] = new int[]{x, y, 0};
                }
                if (build[x][y][1]) {
                    answer[idx++] = new int[]{x, y, 1};
                }
            }
        }

        return answer;
    }

    boolean isValid() {
        for (int x = 0; x <= N; x++) {
            for (int y = 0; y <= N; y++) {
                // 기둥 검사
                if (build[x][y][0]) {
                    if (!canPillar(x, y)) {
                        return false;
                    }
                }
                // 보 검사
                if (build[x][y][1]) {
                    if (!canBeam(x, y)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean canPillar(int x, int y) {
        if (y == 0) {
            return true;
        }
        // 아래 기둥
        if (y > 0 && build[x][y - 1][0]) {
            return true;
        }
        // 보 위
        if (build[x][y][1] || (x > 0 && build[x - 1][y][1])) {
            return true;
        }

        return false;
    }

    boolean canBeam(int x, int y) {
        // 기둥 위
        if (y > 0 && build[x][y - 1][0] || (x < N && build[x + 1][y + 1][0])) {
            return true;
        }
        // 양옆 보
        if (x > 0 && x < N && build[x - 1][y][1] && build[x + 1][y][1]) {
            return true;
        }

        return false;
    }
}
