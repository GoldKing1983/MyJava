package com.interview.leetcode.linkedin.easy;

import java.util.Arrays;

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
1) Sort array by startTime. 
2) Skip 0th interval. Because person can attend that meeting by all means.
3) Traverse from 1st interval. If previousEnd>currentStart return false.  
 */
public class MeetingRoomsAlternate {
  /*
  Time Complexity : O(N∗logN)
   */
  public boolean canAttendMeetings(int[][] intervals) {
    // Sort the intervals by start time
    Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

    for (int i = 1; i < intervals.length; i++) {
      int previousEnd = intervals[i - 1][1];
      int currentStart = intervals[i][0];

      if (previousEnd > currentStart) return false;
    }


    return true;
  }
}
