package com.dhlee.v1.programmers.z_test;

/**
 * 표현 가능한 이진 트리
 * https://school.programmers.co.kr/learn/courses/30/lessons/150367
 */
public class RepresentableBinaryTree {
    public int[] solution(long[] numbers) {
        int[] answers = new int[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            int k = 0;
            while ((int) Math.pow(2, k) - 1 < binary.length()) {
                k++;
            }
            int treeSize = (int) Math.pow(2, k) - 1;

            StringBuilder sb = new StringBuilder();
            while (sb.length() < treeSize - binary.length()) {
                sb.append("0");
            }
            sb.append(binary);

            if (checkTree(sb.toString())) {
                answers[i] = 1;
            } else {
                answers[i] = 0;
            }
        }

        return answers;
    }

    boolean checkTree(String s) {
        if (s.length() <= 1) {
            return true;
        }

        int mid = s.length() / 2;
        String left = s.substring(0, mid);
        String right = s.substring(mid + 1);

        char parent = s.charAt(mid);
        if (parent == '0') {
            if (left.contains("1") || right.contains("1")) {
                return false;
            }
        }

        return checkTree(left) && checkTree(right);
    }
}
