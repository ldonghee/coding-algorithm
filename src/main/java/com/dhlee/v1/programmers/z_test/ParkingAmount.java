package com.dhlee.v1.programmers.z_test;

import java.util.*;

/**
 *  주차 요금 계산
 *  https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class ParkingAmount {
    public int[] solution(int[] fees, String[] records) {

        Map<String, List<Integer>> recordMap = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for (String record : records) {
            String[] splitStr = record.split(" ");
            String[] times = splitStr[0].split(":");
            String carNumber = splitStr[1];
            String op = splitStr[2];

            Integer calTime = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            List<Integer> carTimes = recordMap.get(carNumber) == null ? new ArrayList<>() : recordMap.get(carNumber);
            carTimes.add(calTime);
            recordMap.put(carNumber, carTimes);
        }

        for (String key : recordMap.keySet()) {
            List<Integer> times = recordMap.get(key);
            if (times.size() % 2 != 0) {
                times.add(23 * 60 + 59);
            }

            int cal = 0;
            for (int i = 0; i < times.size(); i++) {
                int time = times.get(i);
                if (i % 2 == 1) {
                    cal += time;
                } else {
                    cal -= time;
                }
            }
            result.put(key, cal);
        }

        Map<String, Integer> answers = new HashMap<>();
        for (String key : result.keySet()) {
            int totalTime = result.get(key);
            int fee = fees[1];

            if (totalTime > fees[0]) {
                int overTime = totalTime - fees[0];

                int extraUnits = (int) Math.ceil((double) overTime / fees[2]);
                fee += extraUnits * fees[3];
            }
            answers.put(key, fee);
        }

        List<String> keys = new ArrayList<>(answers.keySet());
        Collections.sort(keys);

        List<Integer> finalAnswers = new ArrayList<>();
        for (String key : keys) {
            finalAnswers.add(answers.get(key));
        }
        return finalAnswers.stream().mapToInt(Integer::intValue).toArray();
    }
}
