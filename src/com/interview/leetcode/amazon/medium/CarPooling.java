package com.interview.leetcode.amazon.medium;

import java.util.Arrays;

public class CarPooling {
  public boolean carPooling(int[][] trips, int capacity) {
    int n = trips.length;
    int[][] startTime = new int[n][2];
    for (int i = 0, j = 0; i < n; i++) {
      int[] intervals = trips[i];
      startTime[j][0] = intervals[1];
      startTime[j++][1] = intervals[0];

      startTime[j][0] = intervals[2];
      startTime[j++][1] = intervals[0];
    }
    Arrays.sort(startTime, (a, b) -> a[0] - b[0]);

    Arrays.sort(
        startTime,
        (a, b) -> {
          if (Math.abs(a[0]) == Math.abs(b[0])) return a[0];
          return Math.abs(a[0]) - Math.abs(b[0]);
        });

    int currentRequiredMeetingRoom = 0;
    for (int[] time : startTime) {
      if (time[0] >= 0) currentRequiredMeetingRoom += time[1];
      else currentRequiredMeetingRoom -= time[1];
      if (currentRequiredMeetingRoom > capacity) return false;
    }
    return true;
  }
}
