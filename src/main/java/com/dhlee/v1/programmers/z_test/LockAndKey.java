package com.dhlee.v1.programmers.z_test;

/**
 * 자물쇠와 열쇠
 * https://school.programmers.co.kr/learn/courses/30/lessons/60059
 */
public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;

        // 1. 자물쇠를 3배 크기로 확장 (중앙 배치)
        int size = n * 3;
        int[][] board = new int[size][size];

        // 2. 확장된 지도 중앙에 실제 자물쇠를 배치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i + n][j + n] = lock[i][j];
            }
        }

        // 3. 4방향 회전하며 체크(90도)
        for (int rotate = 0; rotate < 4; rotate++) {
            // 90도 회전
            key = getRotate(key);

            // 4. 확장된 맵의 모든 시작점을 순회 (0 부터 n*2 까지)
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    // 자물쇠에 열쇠 끼어 넣기
                    addKey(board, key, x, y);

                    // 자물쇠가 열리는지 체크
                    if (check(board, n)) {
                        return true;
                    }

                    // 열쇠 다시 빼기 (원상복구)
                    removeKey(board, key, x, y);
                }
            }
        }

        return false;
    }

    int[][] getRotate(int[][] key) {
        int m = key.length;
        int[][] rotated = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][m - 1 - i] = key[i][j];
            }
        }

        return rotated;
    }

    // 지도에 열쇠 값을 더함
    void addKey(int[][] board, int[][] key,  int x, int y) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                board[x + i][y + j] += key[i][j];
            }
        }
    }

    // 다시 빼기
    void removeKey(int[][] board, int[][] key, int x, int y) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                board[x + i][y + j] -= key[i][j];
            }
        }
    }

    // 중앙 자물쇠 영역이 모두 1인지 확인
    boolean check(int[][] board, int n) {
        for (int i = n; i < n * 2; i++) {
            for (int j = n; j < n * 2; j++) {
                if (board[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
