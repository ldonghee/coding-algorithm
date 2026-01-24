package com.dhlee.v1.programmers.search;

import java.util.HashSet;
import java.util.Set;

public class PrimeSearch {
    boolean[] visited;
    char[] prints;
    Set<Integer> primeSet = new HashSet<>();

    public int solution(String numbers) {
        primeSet.clear();
        visited = new boolean[numbers.length()];
        prints = new char[numbers.length()];

        for (int i=0; i<numbers.length(); i++) {
            prints[i] = numbers.charAt(i);
        }

        primeRecursion("", 0);

        return primeSet.size();
    }

    public void primeRecursion(String number, int depth) {
        if (!number.isEmpty() && isPrime(Integer.parseInt(number))) {
            System.out.println("Prime Number Found: " + number);
            primeSet.add(Integer.parseInt(number));
        }

        if (depth == prints.length) {
            return;
        }

        for (int i=0; i<prints.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            primeRecursion(number + prints[i], depth + 1);
            visited[i] = false;
        }
    }

    /**
     * 소수 찾기 Function
     */
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i*i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}