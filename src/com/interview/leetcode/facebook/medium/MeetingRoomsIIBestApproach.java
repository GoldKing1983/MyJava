package com.interview.leetcode.facebook.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/meeting-rooms-ii/description/

http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
See Also "MyCalendarII"
=========================================================Logical Answer==========================================================
1) Sort all the data by clubbing both startTime and endTime.
2) Iterate sorted data.
3) If data is startTime add +1.
4) If data is endTime add -1.
5) This will work without duplicate.
6) If there is duplicate in startTime/endTime. endTime has to appear before startTime.
=========================================================Solution Approach=======================================================
0) Separate startTime and endTime in array.
1) Sort startTime and endTime
2) Compare startTime and endTime.
3) if startTime is lesser, add +1. Move startTime index.
4) if endTime is lesser, add -1. Move endTime index.
5) if both are same, add -1. Move endTime index.
6) At each point calculate update minMeetingRoomCount by comparing with runningCount and minMeetingRoomCount
=========================================================Data Flow Analysis======================================================
Input = [[0, 30],[30,50]
  startTime      endTime
	0      			30
	30      		50

	0  -> 1
	30 -> 0 (picked endTime)
	30 -> 1
	50 -> 0
==============================================================
*/
public class MeetingRoomsIIBestApproach {
  public int minMeetingRooms(int[][] intervals) {
    int n = intervals.length;
    int[] start = new int[n], end = new int[n];
    int i = 0;
    for (int[] interval : intervals) {
      start[i] = interval[0];
      end[i++] = interval[1];
    }
    Arrays.sort(start);
    Arrays.sort(end);

    int startIndex = 0, endIndex = 0;
    int minMeetingRoomRequired = 0;
    int currentMeetingRoomRequired = 0;
    while (startIndex < n && endIndex < n) {
      int startTime = start[startIndex];
      int endTime = end[endIndex];
      if (startTime < endTime) {
        currentMeetingRoomRequired++;
        minMeetingRoomRequired = Math.max(minMeetingRoomRequired, currentMeetingRoomRequired);
        startIndex++;
      } else { // startTime >= endTime --> decrement always
        currentMeetingRoomRequired--;
        endIndex++;
      }
    }
    return minMeetingRoomRequired;
  }
}
