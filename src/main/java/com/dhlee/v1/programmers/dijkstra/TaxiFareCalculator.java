package com.dhlee.v1.programmers.dijkstra;

import java.util.*;

/**
 * 합승 택시 요금
 * https://school.programmers.co.kr/learn/courses/30/lessons/72413?language=java
 */
public class TaxiFareCalculator {
    private final int INF = 100_000_000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            graph.get(u).add(new Edge(v, cost));
            graph.get(v).add(new Edge(u, cost));
        }

        // 3. 각각의 출발지에서 최단 거리를 구합니다.
        int[] distS = dijkstra(s, n, graph);
        int[] distA = dijkstra(a, n, graph);
        int[] distB = dijkstra(b, n, graph);

        int answer = INF;
        for (int i = 1; i <= n; i++) {
            // 경로 합산: (S -> 경유지 i) + (경유지 i -> A) + (경유지 i -> B)
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }

        return answer;
    }

    private int[] dijkstra(int start, int n, List<List<Edge>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        // 비용이 낮은 순으로 꺼내도록 정렬 기준 설정
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            // 이미 더 짧은 경로를 찾았다면 무시
            if (current.cost > dist[current.to]) continue;

            for (Edge next : graph.get(current.to)) {
                if (dist[next.to] > dist[current.to] + next.cost) {
                    dist[next.to] = dist[current.to] + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }

    private static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}