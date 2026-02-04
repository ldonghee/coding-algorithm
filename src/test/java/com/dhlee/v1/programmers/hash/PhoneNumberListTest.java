package com.dhlee.v1.programmers.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneNumberListTest {
    private final PhoneNumberList phoneNumberList = new PhoneNumberList();

    @Test
    void testExample1() {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        Assertions.assertFalse(phoneNumberList.solution(phoneBook));
    }

    @Test
    void testExample2() {
        String[] phoneBook = {"123","456","789"};
        Assertions.assertTrue(phoneNumberList.solution(phoneBook));
    }

    @Test
    void testExample3() {
        String[] phoneBook = {"12","123","1235","567","88"};
        Assertions.assertFalse(phoneNumberList.solution(phoneBook));
    }
}
