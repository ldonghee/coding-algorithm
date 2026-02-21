package com.dhlee.v1.programmers.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTransformTest {

    private final WordTransform transform = new WordTransform();

    @Test
    void testExample1() {
        String begin = "hit";
        String target = "cog";
        String[] words = {
                "hot", "dot", "dog", "lot", "log", "cog"
        };
        assertEquals(4, transform.solution(begin, target, words));
    }

    @Test
    void testExample2() {
        String begin = "hit";
        String target = "cog";
        String[] words = {
                "hot", "dot", "dog", "lot", "log"
        };
        assertEquals(0, transform.solution(begin, target, words));
    }
}
