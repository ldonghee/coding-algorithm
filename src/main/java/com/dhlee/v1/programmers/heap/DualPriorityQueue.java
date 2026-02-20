package com.dhlee.v1.programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  이중우선순위큐
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42628
 */
public class DualPriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (String op: operations) {
            String[] str = op.split(" ");
            String command = str[0];
            Integer value = Integer.parseInt(str[1]);

            if (command.equals("I")) {
                maxQueue.add(value);
                minQueue.add(value);
            } else {
                if (value == -1) {
                    Integer min = minQueue.poll();
                    maxQueue.remove(min);
                } else {
                    Integer max = maxQueue.poll();
                    minQueue.remove(max);
                }
            }
        }

        if (maxQueue.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxQueue.peek(), minQueue.peek()};
    }
}
