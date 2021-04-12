package com.interview.leetcode.linkedin.easy;

import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/meeting-rooms/description/
=========================================================Requirement=============================================================
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings.

Input: [[0,10],[9,20]]
Output: false

Input: [[0,10],[10,20]]
Output: true
=========================================================BruteForce==============================================================
The straight-forward solution is to compare every two meetings in the array,
and see if they conflict with each other (i.e. if they overlap).
Two meetings overlap if one of them starts while the other is still taking place.
=========================================================Solution Approach=======================================================
Same logic as MeetingRoomsII

    [10,20][20,30]
    10 -> 1
    20 -> -1 updated to 0
    30 -> 1

    [10,20][20,30] [19,20]
    10 -> 1
    19 -> 1
    20 -> -1, updated to 0, updated to -1
    30 -> 1



*/
public class MeetingRoomsUsingTreeMap {

  /*
   Time Complexity : O(N∗logN)
   */
  public boolean canAttendMeetings(int[][] intervals) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int[] interval : intervals) {
      map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
      map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
    }
    int totalCount = 0;
    for (Integer count : map.values()) {
      totalCount += count;
      if (totalCount > 1) return false;
    }
    return true;
  }
}
