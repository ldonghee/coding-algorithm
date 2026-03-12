package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationInstallerTest {
    StationInstaller stationInstaller = new StationInstaller();

    @Test
    void test1() {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        int expected = 3;

        int result = stationInstaller.solution(n, stations, w);
        assertEquals(expected, result);
    }

    @Test
    void test2() {
        int n = 16;
        int[] stations = {9};
        int w = 2;
        int expected = 3;

        int result = stationInstaller.solution(n, stations, w);
        assertEquals(expected, result);
    }
}