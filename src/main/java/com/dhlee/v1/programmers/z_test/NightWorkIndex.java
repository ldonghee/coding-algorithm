package com.dhlee.v1.programmers.z_test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  야근 지수
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */
public class NightWorkIndex {
    public long solution(int n, int[] works) {
        long answer = 0;

        int total = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work: works) {
            total += work;
            queue.offer(work);
        }

        if (total < n) {
            return 0;
        }

        while(n > 0) {
            int max = queue.poll();
            max -= 1;
            n -= 1;
            queue.offer(max);
        }

        while (!queue.isEmpty()) {
            int work = queue.poll();
            answer += work * work;
        }

        return answer;
    }
}
