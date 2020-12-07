package com.interview.leetcode.facebook.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/meeting-rooms-ii/description/
http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
=========================================================Solution Approach=======================================================
Don't c see this. 
=================================================================================================================================
*/
public class MeetingRoomsIIAlternateThinking {

  public int minMeetingRooms(int[][] intervals) {
    int n = intervals.length;
    Integer[] startEndTimeAppended = new Integer[n * 2];
    for (int i = 0, j = 0; i < n; i++) {
      startEndTimeAppended[j++] = intervals[i][0];
      startEndTimeAppended[j++] = -intervals[i][1];
    }
    Arrays.sort(startEndTimeAppended, (a, b) -> {
      if (Math.abs(a) == Math.abs(b)) return a;
      return Math.abs(a) - Math.abs(b);
    });

    int minMeetingRoom = 0;
    int currentRequiredMeetingRoom = 0;
    for (Integer time : startEndTimeAppended) {
      if (time >= 0) currentRequiredMeetingRoom++;
      else currentRequiredMeetingRoom--;
      minMeetingRoom = Math.max(currentRequiredMeetingRoom, minMeetingRoom);
    }
    return minMeetingRoom;
  }
}
