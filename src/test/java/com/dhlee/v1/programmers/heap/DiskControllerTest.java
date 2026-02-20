package com.dhlee.v1.programmers.heap;

import com.dhlee.v1.heap.DiskController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiskControllerTest {
    private final DiskController controller = new DiskController();

    @Test
    void testExample1() {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        Assertions.assertEquals(8, controller.solution(jobs));
    }
}
