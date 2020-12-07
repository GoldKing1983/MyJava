package com.interview.leetcode.google.medium;

import java.util.Map;
import java.util.TreeMap;

public class MeetingRoomsIISimpleApproach {
  public int minMeetingRooms(int[][] intervals) {
    Map<Integer, Integer> timeToScore = new TreeMap<>();
    for (int[] interval : intervals) {
      int start = interval[0];
      int end = interval[1];
      timeToScore.put(start, timeToScore.getOrDefault(start, 0) + 1);
      timeToScore.put(end, timeToScore.getOrDefault(end, 0) - 1);
    }

    int maxScore = 0, sumScore = 0;
    for (int score : timeToScore.values()) {
      sumScore += score;
      if (sumScore > maxScore) {
        maxScore = sumScore;
      }
    }

    return maxScore;
  }
}
