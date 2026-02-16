package com.dhlee.v1.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 모바일 광고 입찰
 * https://www.acmicpc.net/problem/31246
 */
public class Baek_31246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 지면 수
        int K = Integer.parseInt(st.nextToken()); // 목표 낙찰 수

        int[][] ads = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ads[i][0] = Integer.parseInt(st.nextToken()); // 내 입찰가 (A)
            ads[i][1] = Integer.parseInt(st.nextToken()); // 경쟁사 입찰가 (B)
        }

        for (int i=0; i<N; i++) {
            System.out.println(ads[i][0] + " " + ads[i][1]);
        }

        Baek_31246 answer = new Baek_31246();
        System.out.println(answer.solution(N, K, ads));
    }

    public int solution(int N, int K, int[][] rows) throws IOException {
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            int a = rows[i][0];
            int b = rows[i][1];
            list.add(b - a);
        }
        Collections.sort(list);

        if (list.get(K - 1) <= 0) {
            return 0;
        }
        return list.get(K - 1);
    }

}
