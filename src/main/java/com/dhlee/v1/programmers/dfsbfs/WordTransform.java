package com.dhlee.v1.programmers.dfsbfs;

/**
 * 단어 변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class WordTransform {
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        dfs(begin, target, visited, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    void dfs(String current, String target, boolean[] visited, String[] words, int depth) {
        if (current.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isOneCharDiff(current, words[i])) {
                visited[i] = true;

                dfs(words[i], target, visited, words, depth + 1);

                visited[i] = false;
            }
        }
    }

    boolean isOneCharDiff(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }

        return diff == 1;
    }
}
