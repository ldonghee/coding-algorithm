package com.dhlee.v1.programmers.z_test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 등산코스 정하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118669
 */
public class HikingRoute {
    class Node implements Comparable<Node> {
        int id;
        int weight;

        Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            return this.weight - o.weight;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 1. 그래프 구성
        List<List<Node>>  graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path: paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            // 양방향 연결
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        // 2. 산봉우리 여부 빠르게 확인 하기 위한 Set / boolean 배열
        boolean[] isSummit = new boolean[n + 1];
        for (int s : summits) {
            isSummit[s] = true;
        }

        // 3. 다익스트라 준비
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 모든 출입구를 시작점으로 동시에 넣음(다중 시작점 다익스트라)
        for (int gate : gates) {
            intensity[gate] = 0;
            pq.offer(new Node(gate, 0));
        }

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            // 현재 기록된 intensity 보다 크면 볼 필요 없음
            if (current.weight > intensity[current.id]) {
                continue;
            }

            // 산봉우리에 도착하면 더 이상 이동하지 않음 (문제 조건)
            if (isSummit[current.id]) {
                continue;
            }

            for (Node next : graph.get(current.id)) {
                // 경로 상의 최대 가중치 계산(현재까지의 max 와 다음 간선 중 더 큰 값)
                int maxWeight = Math.max(intensity[current.id], next.weight);

                // 그 maxWeight 가 기존에 기록된 intensity 보다 작다면 갱신
                if (intensity[next.id] > maxWeight) {
                    intensity[next.id] = maxWeight;
                    pq.offer(new Node(next.id, intensity[next.id]));
                }
            }
        }

        // 4. 결과 도출(산봉우리 번호 오름차순, intensity 최소 값)
        int minNode = -1;
        int minIntensity = Integer.MAX_VALUE;

        // 산봉우리 번호가 낮은 순서대로 출력해야 하므로 정렬
        Arrays.sort(summits);

        for (int s : summits) {
            if (intensity[s] < minIntensity) {
                minIntensity = intensity[s];
                minNode = s;
            }
        }

        return new int[]{minNode, minIntensity};
    }
}
