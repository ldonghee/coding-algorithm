package com.dhlee.v1.programmers.z_test;

/**
 * 기지국 설치
 * https://school.programmers.co.kr/learn/courses/30/lessons/12979
 */
public class StationInstaller {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1;
        int index = 0;

        while(location <= n) {
            // 이미 설치된 기지국의 전파 범위 안에 있는 경우
            if (index < stations.length && location >= stations[index] - w) {
                location = stations[index] + w + 1;
                index++;
            } else {
                answer ++;
                location = location  + (w * 2) + 1;
            }
        }

        return answer;
    }
}
