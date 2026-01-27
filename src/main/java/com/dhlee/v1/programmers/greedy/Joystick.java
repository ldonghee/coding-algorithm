package com.dhlee.v1.programmers.greedy;

/**
 * 조이스틱
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Joystick {
    private int minMove = Integer.MAX_VALUE;

    public int solution(String name) {
        int answer = 0;

        char[] charArray = name.toCharArray();
        boolean[] visited = new boolean[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            int upDown = Math.min(charArray[i] - 'A', 'Z' - charArray[i] + 1);
            answer += upDown;

            if (charArray[i] == 'A') {
                visited[i] = true;
            }
        }

        backtrack(0, visited, 0, charArray.length);

        return answer + minMove;
    }

    private void backtrack(int pos, boolean[] visited, int move, int length) {
        visited[pos] = true;

        if (allVisited(visited)) {
            minMove = Math.min(minMove, move);
            visited[pos] = false;
            return;
        }


        // 오른쪽으로 이동
        for (int i=1; i<length; i++) {
            int nextPos = (pos + i + length) % length;
            if (!visited[nextPos]) {
                backtrack(nextPos, visited, move + i, length);
                break;
            }
        }

        // 왼쪽으로 이동
        // 현재 위치에서 i 만큼을 뺀 값을 구해야 하는데, 이때 인덱스가 음수가 되는 것을 방지하기 위해 전체 길이(len)를 더한 후 나머지 연산을 수행합니다.
        for (int i=1; i<length; i++) {
            int nextPos = (pos - i + length) % length;
            if (!visited[nextPos]) {
                backtrack(nextPos, visited, move + i, length);
                break;
            }
        }

        visited[pos] = false;
    }

    private boolean allVisited(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
