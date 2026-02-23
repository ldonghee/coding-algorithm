package com.dhlee.v1.programmers.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  여행 경로
 *  https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */
public class TravelRoute {
    List<String> answers = new ArrayList<>();
    boolean[] visited;
    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(answers);
        return answers.get(0).split(" ");
    }

    void dfs(String current, String path, String[][] tickets, int count) {
        if (count == tickets.length) {
            answers.add(path);
            return;
        }

        for (int i=0; i<tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;

                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1);

                visited[i] = false;
            }
        }
    }
}
