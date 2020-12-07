package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    if (intervals.length == 0) return intervals;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int previousStart = intervals[0][0];
    int previousEnd = intervals[0][1];
    List<int[]> tempResult = new ArrayList<>();
    for (int i = 1; i < intervals.length; i++) {
      int currentStart = intervals[i][0];
      int currentEnd = intervals[i][1];
      if (currentStart > previousEnd) { // disjoint intervals or no-merge
        tempResult.add(new int[] {previousStart, previousEnd});
        previousStart = currentStart;
        previousEnd = currentEnd;
      } else { // Merge...currentStart <= previousEnd
        previousEnd = Math.max(previousEnd, currentEnd); // Need for Math.max --> Ex: [[1,4],[2,3]].. previousEnd = 4 and not 3
      }
    }
    tempResult.add(new int[] {previousStart, previousEnd});
    int[][] result = new int[tempResult.size()][2];
    for (int i = 0; i < tempResult.size(); i++) result[i] = tempResult.get(i);
    return result;
  }
}
