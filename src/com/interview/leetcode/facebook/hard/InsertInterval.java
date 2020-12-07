package com.interview.leetcode.facebook.hard;

import com.sample.tricky.MergeIntervalsBasedOnIndexApproach;
import java.util.Arrays;

/*
https://leetcode.com/problems/insert-interval/

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

=============================================Solution Approach=============================================
Step1: Append the "newInterval" to "startTime to startTimeArray" and "endTime to endTimeArray".
Step2: Do MergeInterval.

Note:
1) intervals[] is sorted by startTime. So I can append "newInterval" to "startTime to startTimeArray" at O(n) time.
2) But endTime needs sorting.

Time Complexity: O(n(log(n)) because of sorting
===========================================================================================================
intervals =   [[1,8],[6,7]]
newInterval = [2,5]

startT = [1, 2, 6]
endT   = [5, 7, 8]
===========================================================================================================
intervals   =  [[10,20],[30,40]]
newInterval = [50,50]

startT = [10, 30, 50]
endT = 	 [20, 40, 50]
===========================================================================================================
 */
public class InsertInterval {

  private void append(int[] start, int[] end, int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    boolean startAppended = false;
    int j = 0;
    for (int i = 0; i < n; i++, j++) {
      // =====newInterval startTime append Logic=====
      if (!startAppended && newInterval[0] <= intervals[i][0]) {
        start[j] = newInterval[0];
        i--;
        startAppended = true;
      } else start[j] = intervals[i][0];
    }
    if (j == n) start[j] = newInterval[0];

    // =====newInterval endTime append Logic=====
    int k = 0;
    for (int[] interval : intervals) end[k++] = interval[1];
    end[k] = newInterval[1];
    Arrays.sort(end);
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    int[] startT = new int[n + 1];
    int[] endT = new int[n + 1];
    append(startT, endT, intervals, newInterval);
    MergeIntervalsBasedOnIndexApproach m = new MergeIntervalsBasedOnIndexApproach();
    return m.merge(startT, endT);
  }
}
