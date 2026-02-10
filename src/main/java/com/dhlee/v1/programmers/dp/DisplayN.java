package com.dhlee.v1.programmers.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N으로 표현
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 */
public class DisplayN {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        // 1. DP 리스트 초기화 (0번 인덱스는 사용 안 함, 1~8번 사용)
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i=0; i<8; i++) {
            dp.add(new HashSet<>());
        }

        // 2. N을 1번 사용하는 경우
        dp.get(1).add(N);

        for (int i=2; i<=8; i++) {
            Set<Integer> currentSet = dp.get(i);

            // NNN... 같은 숫자 넣기 (5, 55, 555...)
            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(i));
            currentSet.add(repeatedN);

            // 3. 조합 만들기: i번 사용 = j번 사용 (op) (i-j)번 사용
            for (int j=1; j<i; j++) {
                for (int val1: dp.get(j)) {
                    for (int val2: dp.get(i - j)) {
                        currentSet.add(val1 + val2);
                        currentSet.add(val1 - val2);
                        currentSet.add(val1 * val2);
                        if (val2 != 0) {
                            currentSet.add(val1 / val2);
                        }
                    }
                }
            }

            // 4. 목표 숫자가 있으면 즉시 반환
            if (currentSet.contains(number)) return i;
        }

        return -1;
    }
}
