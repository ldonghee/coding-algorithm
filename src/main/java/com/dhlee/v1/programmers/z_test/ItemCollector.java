package com.dhlee.v1.programmers.z_test;

import java.util.*;

public class ItemCollector {
    private int maxItems = 0;
    private int startR, startC;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] board;
    private List<int[]> itemPos;

    public int solution(int[][] board, int r, int c) {
        this.maxItems = 0;
        this.startR = r;
        this.startC = c;
        this.board = board;
        this.itemPos = new ArrayList<>();

        // 1. 아이템 위치를 리스트에 담고 고유 번호 부여
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    itemPos.add(new int[]{i, j});
                }
            }
        }

        // 2. 초기 상태 비트마스크 설정 (시작점에 아이템이 있는 경우)
        int initialMask = 0;
        for (int i = 0; i < itemPos.size(); i++) {
            if (itemPos.get(i)[0] == r && itemPos.get(i)[1] == c) {
                initialMask |= (1 << i);
            }
        }

        // 3. 방문 체크 (좌표 + 획득 상태)
        // 리셋 조건이 포함되어 있으므로 동일 상태 중복 방문 방지가 필수입니다.
        Map<String, Integer> visited = new HashMap<>();

        dfs(r, c, initialMask, visited);
        return maxItems;
    }

    private void dfs(int r, int c, int mask, Map<String, Integer> visited) {
        int currentCount = Integer.bitCount(mask);
        maxItems = Math.max(maxItems, currentCount);

        // 모든 아이템을 찾았으면 즉시 종료
        if (currentCount == itemPos.size()) return;

        // 현재 상태 메모이제이션
        String state = r + "," + c + "," + mask;
        if (visited.getOrDefault(state, -1) >= currentCount) return;
        visited.put(state, currentCount);

        for (int[] dir : directions) {
            int currR = r;
            int currC = c;
            int nextMask = mask;
            boolean moved = false;

            // 벽(2)을 만날 때까지 한 방향으로 쭉 이동
            while (true) {
                int nr = currR + dir[0];
                int nc = currC + dir[1];

                // 경계 밖이거나 벽(2)이면 멈춤
                if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length || board[nr][nc] == 2) {
                    break;
                }

                currR = nr;
                currC = nc;
                moved = true;

                // 이동 경로 중에 아이템이 있는지 체크
                for (int i = 0; i < itemPos.size(); i++) {
                    if (itemPos.get(i)[0] == currR && itemPos.get(i)[1] == currC) {
                        nextMask |= (1 << i);
                    }
                }
            }

            if (moved) {
                // 옵션 1: 멈춘 지점에서 탐색 계속
                dfs(currR, currC, nextMask, visited);

                // 옵션 2: 리셋 (시작 지점으로 돌아가서 새로운 방향 탐색)
                // "갈 방향이 없거나 더 이상 아이템을 가질 수 없다면"의 로직은
                // 모든 방향 시도로 자연스럽게 포함됩니다.
                dfs(startR, startC, nextMask, visited);
            }
        }
    }
}
