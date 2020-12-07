package com.interview.leetcode.amazon.medium;

import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/car-pooling/

Same problem as MeetingRoomsII
There we calculate maxRequiredMeetingRooms.
Here also we calculate maxRequiredCapacity. if maxCapacity > givenCapacity return false.
 */
public class CarPoolingTreeMap {
  public boolean carPooling(int[][] trips, int capacity) {
    Map<Integer, Integer> m = new TreeMap<>();
    for (int[] trip : trips) {
      m.put(trip[1], m.getOrDefault(trip[1], 0) + trip[0]);
      m.put(trip[2], m.getOrDefault(trip[2], 0) - trip[0]);
    }
    int maxCapacity = 0;
    for (int currentCapacity : m.values()) {
      maxCapacity += currentCapacity;
      if (maxCapacity > capacity) return false;
    }
    return true;
  }
}
