package com.dhlee.v1.programmers.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 단속 카메라
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */
public class TrafficCamera {
    public int solution(int[][] routes) {
        int answer = 0;

        List<Route> list = new ArrayList<>();
        for (int[] route : routes) {
            list.add(new Route(route[0], route[1]));
        }
        Collections.sort(list);

        int lastCamera = Integer.MIN_VALUE;

        for (Route current: list) {
            if (lastCamera < current.start) {
                answer++;
                lastCamera = current.end;
            }
        }

        return answer;
    }

    public int solution2(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int last_camera = Integer.MIN_VALUE;
        for (int[] a : routes) {
            if (last_camera < a[0]) {
                ++ans;
                last_camera = a[1];
            }
        }
        return ans;
    }

    class Route implements Comparable<Route> {
        int start;
        int end;

        Route(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Route o) {
            return Integer.compare(end, o.end);
        }
    }
}
