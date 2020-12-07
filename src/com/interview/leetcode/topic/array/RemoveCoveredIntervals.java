package com.interview.leetcode.topic.array;

import java.util.Arrays;

/*

Given a list of intervals, remove all intervals that are covered by another interval in the list.

Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.


Input: intervals = [[1,4],[2,3]]
Output: 1

Input: intervals = [[2,3],[1,4]]
Output: 1

Input: intervals = [[1,2], [1,3], [1,4], [1,5]] 
Output: 1
 */
public class RemoveCoveredIntervals {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
    int resultCount = 1;
    int previousIntervalEnd = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      int currentIntervalEnd = intervals[i][1];

      if (currentIntervalEnd > previousIntervalEnd) {// Ex: [1,2][3,4]
        previousIntervalEnd = currentIntervalEnd;
        ++resultCount;// No Merge happend. So Increase resultCount
      }
    }
    return resultCount;
  }
}
