package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://leetcode.com/problems/merge-intervals

Solved by index... Bit complicated and shortens the code. Keep it for understanding alternate approach.
==================================
 */
public class MergeIntervalsBasedOnIndexApproach {

  /*
  Time Complexity : O(NlogN) --> Because of sorting. It should be N+O(NlogN)
  Space Complexity : O(N)
   */
  public int[][] merge(int[][] intervals) {
    int n = intervals.length;
    if (n == 0) return new int[][] {};
    int[] startT = new int[n];
    int[] endT = new int[n];
    for (int i = 0; i < n; i++) {
      startT[i] = intervals[i][0];
      endT[i] = intervals[i][1];
    }
    Arrays.sort(startT);
    Arrays.sort(endT);
    return merge(startT, endT);
  }

  public int[][] merge(int[] startT, int[] endT) {
    List<int[]> tempResult = new ArrayList<>();
    int previousStartIndex = 0;
    for (int i = 1; i < startT.length; i++) {
      int currentStart = startT[i];
      int previousEnd = endT[i - 1];
      if (currentStart > previousEnd) { // disjoint intervals or no-merge
        tempResult.add(new int[] {startT[previousStartIndex], endT[i - 1]});
        previousStartIndex = i;
      } else {
        // If it is merge. No operation. 1) previousStart stays in same index. 2) compare will
        // happen on next currentStart and previousEnd, logic will work...don't confuse
      }
    }
    // for the last row of data
    tempResult.add(new int[] {startT[previousStartIndex], endT[startT.length - 1]});
    int[][] result = new int[tempResult.size()][2];
    for (int i = 0; i < result.length; i++) {
      result[i] = tempResult.get(i);
    }
    return result;
  }
}
