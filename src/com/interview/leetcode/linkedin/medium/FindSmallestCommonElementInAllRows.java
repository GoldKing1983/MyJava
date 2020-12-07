package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;

/*
* https://leetcode.com/problems/find-smallest-common-element-in-all-rows/

1) Start from 0thRow OthColumn as source.
2) If the 0thRowData was found in all remaining rows. Return answer.
3) Else increase 0thRow  next column and do step2.
4) For Efficiency use "Arrays.binarySearch".
5) Arrays.binarySearch returns index of element if searchKey is found. if searchKey not found,
then it returns -value.


*

*/
public class FindSmallestCommonElementInAllRows {
  public int smallestCommonElement(int[][] mat) {
    int rowSize = mat.length, colSize = mat[0].length;
    for (int col = 0; col < colSize; ++col) {
      int zerothRowData = mat[0][col];
      boolean found = false;
      for (int i = 1; i < rowSize; ++i) {
        found = Arrays.binarySearch(mat[i], zerothRowData) >= 0;
        if (!found) break;
      }
      if (found) return mat[0][col];
    }
    return -1;
  }
}
