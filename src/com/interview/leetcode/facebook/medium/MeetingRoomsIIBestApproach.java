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
3) if startTime is lesser, increment minMeetingRoomCount. Move startTime index.  
4) if endTime is lesser, decrement minMeetingRoomCount. Move endTime index.
5) if both are same, decrement minMeetingRoomCount. Move endTime index.
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
    int[] startTime = new int[n], endTime = new int[n];
    for (int i = 0; i < n; i++) {
      startTime[i] = intervals[i][0];
      endTime[i] = intervals[i][1];
    }
    Arrays.sort(startTime);
    Arrays.sort(endTime);
    int startIndex = 0, endIndex = 0;
    int runningCount = 0, minMeetingRoomCount = 0;
    while (startIndex < n || endIndex < n) {
      if (startIndex < n && endIndex < n) {
        if (endTime[endIndex] <= startTime[startIndex]) {
          runningCount--;
          endIndex++;
        } else {
          runningCount++;
          startIndex++;
        }
      } else if (startIndex < n) { //endTime exhausted or only startTime is available
        runningCount++;
        startIndex++;
      } else { //endTime exhausted or only startTime is available
        runningCount--;
        endIndex++;
      }
      minMeetingRoomCount = Math.max(runningCount, minMeetingRoomCount);
    }
    return minMeetingRoomCount;
  }
}
