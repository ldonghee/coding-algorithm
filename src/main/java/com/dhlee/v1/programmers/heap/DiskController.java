package com.dhlee.v1.programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *  디스크 컨트롤러
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class DiskController {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Job> queue = new PriorityQueue<>();

        int timer = 0;
        int totalResponseTime = 0;
        int jobIndex = 0;
        int completedJobs = 0;

        while (completedJobs < jobs.length) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= timer) {
                queue.offer(new Job(jobs[jobIndex][0], jobs[jobIndex][1]));
                jobIndex++;
            }

            if (queue.isEmpty()) {
                timer = jobs[jobIndex][0];
            } else {
                Job current = queue.poll();

                totalResponseTime += (timer - current.startTime) + current.processTime;
                timer += current.processTime;
                completedJobs++;
            }
        }

        return totalResponseTime / jobs.length;
    }

    class Job implements Comparable<Job> {
        int startTime;
        int processTime;

        Job(int startTime, int processTime) {
            this.startTime = startTime;
            this.processTime = processTime;
        }

        @Override
        public int compareTo(Job o) {
            return Integer.compare(this.processTime, o.processTime);
        }
    }
}
