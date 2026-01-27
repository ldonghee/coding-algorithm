package com.dhlee.v1.programmers.greedy;

import java.util.Stack;

/**
 * 큰 수 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */

class MakeBigNumber {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size() - k; i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }

    public String solution2(String number, int k) {
        Stack<Character> stack = new Stack<>();
        stack.push(number.charAt(0));
        int count = 0;

        for (int i=1; i<number.length(); i++) {
            char next = number.charAt(i);


            while (!stack.isEmpty() && next > stack.peek() && count < k) {
                stack.pop();
                count++;
            }

            if (count >= k) {
                for (int j=i; j< number.length(); j++) {
                    stack.push(number.charAt(j));
                }
                break;
            }

            stack.push(next);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length() - k; i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}
