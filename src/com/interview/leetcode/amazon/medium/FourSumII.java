package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;

/*
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
there are such that A[i] + B[j] + C[k] + D[l] is zero.

Requirement Short: Given 4 array pick 1 from each element, so that it sums to 0.

========================================================Solution Approach==========================================================
1) Add all the combinations of 2 array in map.
2) 
 */
public class FourSumII {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int a : A)
      for (int b : B) {
        int sum = a + b;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }

    int resultCount = 0;
    for (int c : C)
      for (int d : D) {
        int sum = -c - d;
        resultCount += map.getOrDefault(sum, 0);
      }
    return resultCount;
  }
}
