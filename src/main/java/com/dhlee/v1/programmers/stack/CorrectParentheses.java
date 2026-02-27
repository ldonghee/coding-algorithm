package com.dhlee.v1.programmers.stack;

import java.util.Stack;

/**
 *  올바른 괄호
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class CorrectParentheses {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            // System.out.println();
            char c = s.charAt(i);
            if (i == 0 && c == ')') {
                return false;
            }

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }


        if (stack.size() > 0) {
            return false;
        }
        return answer;
    }

    boolean solution2(String s) {
        boolean answer = true;

        int count = 0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                count++;
            } {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return answer;
    }
}
