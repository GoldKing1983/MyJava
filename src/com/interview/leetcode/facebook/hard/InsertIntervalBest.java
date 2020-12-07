package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/insert-interval/

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

=============================================Solution Approach=============================================
1) As per the requirement, intervals are sorted. So I can use that as benefit.

===========================================================================================================
 */
public class InsertIntervalBest {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();
    int[] toBeAdded = newInterval;

    for (int i = 0; i < intervals.length; i++) {
      int currentStartTime = intervals[i][0];
      int currentEndTime = intervals[i][1];
      int toBeAddedStartTime = toBeAdded[0];
      int toBeAddedEndTime = toBeAdded[1];

      /*1. No overlap and toBeAdded appears before current interval, add toBeAdded to result.*/
      if (currentStartTime > toBeAddedEndTime) {
        ans.add(toBeAdded);
        toBeAdded = intervals[i];
      }

      /*2. Has overlap, update the toBeAdded to the merged interval.*/
      else if (currentEndTime >= toBeAddedStartTime)
        toBeAdded =
            new int[] {
              Math.min(currentStartTime, toBeAddedStartTime),
              Math.max(currentEndTime, toBeAddedEndTime)
            };

      /*3. No overlap and toBeAdded appears after current interval, add current interval to result.*/
      else ans.add(intervals[i]);
    }
    ans.add(toBeAdded);
    int[][] res = new int[ans.size()][2];
    for (int i = 0; i < ans.size(); i++) {
      res[i][0] = ans.get(i)[0];
      res[i][1] = ans.get(i)[1];
    }
    return res;
  }
}
