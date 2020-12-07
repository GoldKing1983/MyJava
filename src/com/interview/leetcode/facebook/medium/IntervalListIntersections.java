package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/interval-list-intersections/

1) Understand MergeIntervalsBest.
2) Here we can treat A as previous and B as current.
3) Additionally input can be altered. So compare previous with current and current with previous.
Ex1: A=[1,3] B=[2,4] Ans: 2,3
Ex2: A=[2,4] B=[1,3] Ans: 2,3
4) Functionality wise, here generate result only if there is a merge.

 */
public class IntervalListIntersections {

  public int[][] intervalIntersection(int[][] interval1, int[][] interval2) {

    List<Integer> result = new ArrayList<>();
    int i1 = 0, i2 = 0;
    while (i1 < interval1.length && i2 < interval2.length) {
      int interval1Start = interval1[i1][0];
      int interval1End = interval1[i1][1];
      int interval2Start = interval2[i2][0];
      int interval2End = interval2[i2][1];

      //      Ex: [10,20] [5,9]               Ex: [5,9] [10,20]
      if (interval1Start > interval2End || interval2Start > interval1End) {
        // No Merge . 
      } else { // Ex1: [1,3] [2,4].. Ex2: [2,4] [1,3].. Ans: 2,3
        int startAnswer = Math.max(interval1Start, interval2Start);
        int endAnswer = Math.min(interval1End, interval2End);
        result.add(startAnswer);
        result.add(endAnswer);
      }
      // Keep the bigger one as current or increment the smaller one.
      // Ex: i1=[1,2] i2=[3,4].. i1 might can have bigger which can be used for next compare.
      // But i2 cannot have smaller. Because of ascending order.
      if (interval1End < interval2End) i1++;
      else i2++;
    }

    // Convert to static array. No logic below
    int[][] resultArray = new int[result.size() / 2][2];
    for (int i = 0, j = 0; i < result.size() / 2; i++) {
      resultArray[i][0] = result.get(j++);
      resultArray[i][1] = result.get(j++);
    }
    return resultArray;
  }
}
