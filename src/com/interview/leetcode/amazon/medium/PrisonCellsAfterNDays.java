package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/prison-cells-after-n-days/

============================What we are tested============================
Simple logical problem. No maths. Only coding.
====================================================================================

1) Only one tricky part is 0th and n-1th cell data will be 0 after 1st iteration.
This is done by auto. Because "newCells" by default all "0". We don't process 0th and n-1th cell.

2) After every 14 steps state repeats. So at-most 14 state is enough

========================================================Logical Thinking why 14==================================================
1) Print the cells for 1000.
2) We can see that after every 14 steps, the result loops. 
 */
public class  PrisonCellsAfterNDays {
  public int[][] kClosest(int[][] points, int k) {
    Map<Integer, List<int[]>> result = new TreeMap<>();
    for(int[] point : points) {
      result.computeIfAbsent(calculateOrigin(point[0], point[1]), key-> new ArrayList<>()).add( point);
    }
    int[][] finalResult = new int[k][2];
    k--;
    outer : for(List<int[]> res : result.values()) {
      for(int[] r : res) {
        finalResult[k] = r;
        if(k-- == 0) break outer;
      }
    }
    return finalResult;

  }

  private int calculateOrigin(int x, int y) {
    return x*x + y*y;
  }
}
