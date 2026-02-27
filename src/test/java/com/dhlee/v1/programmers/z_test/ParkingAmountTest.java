package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ParkingAmountTest {

    private final ParkingAmount parkingAmount = new ParkingAmount();

    @Test
    void testExample1() {
        int[] fees = {
                180, 5000, 10, 600
        };
        String[] records = {
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };
        assertArrayEquals(new int[]{14600, 34400, 5000}, solution(fees, records));
    }

    @Test
    void testExample2() {
        int[] fees = {
                120, 0, 60, 591
        };
        String[] records = {
                "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"
        };
        assertArrayEquals(new int[]{0, 591}, parkingAmount.solution(fees, records));
    }

    @Test
    void testExample3() {
        int[] fees = {
                1, 461, 1, 10
        };
        String[] records = {
                "00:00 1234 IN"
        };
        assertArrayEquals(new int[]{14841}, parkingAmount.solution(fees, records));
    }

    public int[] solution(int[] fees, String[] records) {
        // 1. 차량별 누적 주차 시간을 저장할 맵 (차량번호 : 누적분)
        Map<String, Integer> totalTimeMap = new TreeMap<>(); // TreeMap을 쓰면 자동으로 차량번호 정렬됨
        // 2. 입차된 차량의 입차 시간을 관리할 맵 (차량번호 : 입차시간)
        Map<String, Integer> inTimeMap = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            int time = toMin(split[0]);
            String carNum = split[1];
            String type = split[2];

            if (type.equals("IN")) {
                inTimeMap.put(carNum, time);
            } else {
                int inTime = inTimeMap.remove(carNum);
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + (time - inTime));
            }
        }

        // 3. 아직 출차되지 않은 차량 처리 (23:59 출차 간주)
        int lastTime = toMin("23:59");
        for (String carNum : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNum);
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + (lastTime - inTime));
        }

        // 4. 요금 계산
        int[] answer = new int[totalTimeMap.size()];
        int idx = 0;
        for (String carNum : totalTimeMap.keySet()) {
            int time = totalTimeMap.get(carNum);
            int fee = fees[1]; // 기본 요금

            if (time > fees[0]) {
                // 초과 시간 계산 시 올림 처리 주의
                fee += Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            }
            answer[idx++] = fee;
        }

        return answer;
    }

    private int toMin(String time) {
        String[] split = time.split( ":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
