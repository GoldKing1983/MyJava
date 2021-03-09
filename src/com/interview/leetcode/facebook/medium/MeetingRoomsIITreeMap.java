package com.interview.leetcode.facebook.medium;

import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/meeting-rooms-ii/description/

http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
Similar to "MyCalendarII"

Given an array of meeting time intervals consisting of start and end times.
Find the minimum number of conference rooms required.

=========================================================Logical Answer==========================================================
1) Sort all the data by clubbing both startTime and endTime.
2) Iterate sorted data.
3) If data is startTime add +1.
4) If data is endTime add -1.
5) This will work without duplicate.
6) If there is duplicate in startTime/endTime. endTime has to appear before startTime.
=========================================================Ex: With Duplicate startTime/endTime====================================
[[0,10],[10,15]]
treeMap = {0=1, 10=0, 15=-1}

As stated in point6. For the above example, duplicates are consolidated. 
=========================================================Ex: Without Duplicate startTime/endTime====================================
[[0,10],[7,15]]
treeMap = {0=1, 7=1, 10=-1, 15=-1}
=================================================================================================================================
*/
public class MeetingRoomsIITreeMap {
  public int minMeetingRooms(int[][] intervals) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < intervals.length; i++) {
      int startT = intervals[i][0];
      int endT = intervals[i][1];
      map.put(startT, map.getOrDefault(startT, 0) + 1);
      map.put(endT, map.getOrDefault(endT, 0) - 1);
    }
    int runningCount = 0, minMeetingRoomsCount = 0;
    for (Integer currentCount : map.values()) {
      runningCount += currentCount;
      minMeetingRoomsCount = Math.max(runningCount, minMeetingRoomsCount);
    }
    return minMeetingRoomsCount;
  }
}
