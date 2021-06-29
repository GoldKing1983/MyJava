package com.interview.leetcode.topic.intervals;

import java.util.Arrays;

/*
https://leetcode.com/discuss/interview-question/374846/Twitter-or-OA-2019-or-University-Career-Fair

[[1,3] [3,5] [3,4] [5,7] [7,1]

1) Same problem as NonOverlappingIntervals.
2) NonOverlappingIntervals we return noOfIgnoredInterval.
3) Here we return noOfNonOverlappingInterval.

 */
public class UniversityCareerFair {

  public int eraseOverlapIntervals(int[][] intervals) {
    int n = intervals.length;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int previousEnd = intervals[0][1];
    int noOfNonOverlappingInterval = 1;
    for (int i = 1; i < n; i++) {
      int currentStart = intervals[i][0];
      int currentEnd = intervals[i][1];
      if (currentStart < previousEnd) { // overlap... We need to ignore either current or previous interval
        // 1 3 and 1 2... ignore 1 3
        previousEnd = Math.min(previousEnd, currentEnd);
      } else {
        previousEnd = currentEnd;
        noOfNonOverlappingInterval++;
      }
    }
    return noOfNonOverlappingInterval;
  }

}
