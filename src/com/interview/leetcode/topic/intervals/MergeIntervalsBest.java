package com.interview.leetcode.topic.intervals;

import java.util.Arrays;

/*
https://leetcode.com/problems/merge-intervals

========================================================Merge Needed - currentStart <= previousEnd ==============================
Since we do sort, previous will be always lesser or equal to current. So corner cases are eliminated.

Case1)		previous   ===>    1==========3
			current    ===>		 	2==========4

            previous   ===>    1==========3
            current    ===>    1===============4

                    =====InvalidCase==Sorting avoids the below case and change it to case1==
            current    ===>         2==========4
            previous   ===>    1==========3

Case2)		previous   ===>    1===============4
			current    ===>		 	2=====3

Case3)		previous   ===>    1====2
			current    ===>		 	2=====3
======================================Merge Not Needed or DisJoint Set - currentStart >  previousEnd=============================
Case4)		previous    ===>    1====2
			current 	===>		 	   3=====4
============================================================Solution Approach====================================================
1) In case of Merge, update previousEnd with Math.max(previousEnd, currentEnd). previousStart stays as such.
          Ex: [[1,4],[2,3]]
              previousEnd = 4 and not 3
2) In case of No Merge, add previousStart and previousEnd to result. set current as previous.
3) Add lastRow to the result.
=================================================================================================================================
 */
public class MergeIntervalsBest {

  /*
  Time Complexity : O(NlogN) --> Because of sorting. It should be N+O(NlogN)
  Space Complexity : O(N)
   */
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    /*
    Coding for below 3 cases
    1 -- 4
         4 -- 5

    1--------------4
        2------3

    1 -- 4
            5 -- 6


    */
    int n = intervals.length;
    int[][] result = new int[n][2];
    int resultIndex = 0;
    int previousStartTime = intervals[0][0];
    int previousEndTime = intervals[0][1];
    for (int i = 1; i < n; i++) {
      int currentStartTime = intervals[i][0];
      int currentEndTime = intervals[i][1];
      if (currentStartTime <= previousEndTime) { // merge
        // Need for Math.max --> Ex: [[1,4],[2,3]].. previousEnd = 4 and not 3
        previousEndTime = Math.max(currentEndTime, previousEndTime);
      } else { // no merge
        result[resultIndex][0] = previousStartTime;
        result[resultIndex++][1] = previousEndTime;
        previousStartTime = currentStartTime;
        previousEndTime = currentEndTime;
      }
    }
    result[resultIndex][0] = previousStartTime;
    result[resultIndex][1] = previousEndTime;

    return Arrays.copyOfRange(result, 0, resultIndex + 1);
  }
}
