package com.dhlee.v1.programmers.sort;

import java.util.Arrays;

/**
 * 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class BigNumber {
    public String solution(int[] numbers) {

        String[] strNumbers = new String[numbers.length];
        for (int i=0; i< numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        return String.join("", strNumbers);
    }
}
