package com.interview.leetcode.topic.intervals;

import java.util.Arrays;

/*
https://leetcode.com/problems/non-overlapping-intervals/

1) Given an array of intervals intervals where intervals[i] = [start, end], 
2) return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

    1 2
    1   3 -- Ignore
      2 3
        3 4
    
    ans=1
    
=================   
     1 4
     2  5 -- Ignore

    ans=1
     
=================     
    1    4 -- Ignore
     2 3 
    
    ans=1
=========================================================Layman's terms==========================================================
1) If you see 2 interval which is overlapping. 
2) Keep the smallest interval and ignore biggest interval, so that you can optimally keep have non-overlapping-interval.  
========================================================Solution Approach========================================================     
    1) Sort by start time
    2) If there is overlap keep only smallest time interval.
    
 */
public class NonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    int n = intervals.length;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int previousEnd = intervals[0][1];
    int noOfIgnoredInterval = 0;
    for (int i = 1; i < n; i++) {
      int currentStart = intervals[i][0];
      int currentEnd = intervals[i][1];
      if (currentStart < previousEnd) { // overlap... We need to ignore either current or previous interval
        // 1 3 and 1 2... ignore 1 3
        previousEnd = Math.min(previousEnd, currentEnd);
        noOfIgnoredInterval++;
      } else {
        previousEnd = currentEnd;
      }
    }
    return noOfIgnoredInterval;
  }
}
