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
1) Sort startTime and endTime separately. 
2) Skip 0th interval. Because person can attend that meeting by all means.
3) Traverse from 1st interval. If previousEnd>currentStart or currentStart<previousEnd return false.  

	Input: [[0,30],[5,10],[15,20]] Output: false
		startTime 	endTime
			0		   10
			5		   20
			15         30


*/
public class MeetingRooms {

  /*
   Time Complexity : O(N∗logN)
   */
  public boolean canAttendMeetings(int[][] intervals) {
    int n = intervals.length;
    int[] startTime = new int[n], endTime = new int[n];
    for (int i = 0; i < n; i++) {
      startTime[i] = intervals[i][0];
      endTime[i] = intervals[i][1];
    }
    Arrays.sort(startTime);
    Arrays.sort(endTime);
    for (int i = 1; i < n; i++) if (startTime[i] < endTime[i - 1]) return false;
    return true;
  }
}
