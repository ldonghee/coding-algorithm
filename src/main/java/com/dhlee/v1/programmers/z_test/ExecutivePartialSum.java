package com.dhlee.v1.programmers.z_test;

/**
 * 연속 펄스 부분 수열의 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/161988
 */
public class ExecutivePartialSum {
    public long solutionV2(int[] sequence) {
        int n = sequence.length;
        long[] accumulate = new long[n + 1];

        for (int i=0; i<n; i++) {
            long mul = (i % 2 == 0) ? 1 : -1;
            long num = (long) sequence[i] * mul;
            accumulate[i + 1] = accumulate[i] + num;
        }

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i=0; i<accumulate.length; i++) {
            if (accumulate[i] < min) {
                min = accumulate[i];
            }
            if (accumulate[i] > max) {
                max = accumulate[i];
            }
        }

        return max - min;
    }

    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] pulse = new long[n];

        for (int i=0; i<n; i++) {
            long multiplier = (i % 2 == 0) ? 1 : -1;
            pulse[i] = sequence[i] * multiplier;
        }

        long maxCurrent = 0;
        long minCurrent = 0;
        long maxTotal = Long.MIN_VALUE;
        long minTotal = Long.MAX_VALUE;

        for (long val : pulse) {
            maxCurrent = Math.max(val, maxCurrent + val);
            maxTotal = Math.max(maxTotal, maxCurrent);

            minCurrent = Math.min(val, minCurrent + val);
            minTotal = Math.min(minTotal, minCurrent);
        }

        return Math.max(Math.abs(maxTotal), Math.abs(minTotal));
    }
}
