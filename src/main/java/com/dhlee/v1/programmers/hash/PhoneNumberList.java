package com.dhlee.v1.programmers.hash;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 전화번호 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        Set<String> phoneSet = new HashSet<>();
        Collections.addAll(phoneSet, phone_book);

        for (String phoneNumber: phone_book) {
            for (int i=0; i<phoneNumber.length()-1; i++) {
                String sb = phoneNumber.substring(0, i+1);
                if (phoneSet.contains(sb)) {
                    return false;
                }
            }
        }

        return true;
    }
}
