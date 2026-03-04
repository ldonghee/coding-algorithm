package com.dhlee.v1.programmers.z_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StickerCollectTest {
    private final StickerCollect stickerCollect = new StickerCollect();

    @Test
    void test1() {
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        assertEquals(36, stickerCollect.solution(sticker));
    }

    @Test
    void test2() {
        int[] sticker = {1, 3, 2, 5, 4};
        assertEquals(8, stickerCollect.solution(sticker));
    }
}