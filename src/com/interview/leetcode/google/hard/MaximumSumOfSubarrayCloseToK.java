package com.interview.leetcode.google.hard;

import java.util.TreeSet;

/*
This is not Leetcode Problem. Used by MaxSumOfRectangleNoLargerThanK.

Input: [2, -8, 1, 9], k: 8, MaxClosest: 4 (2,-8,1,9)
Input: [7, -7, 6, 5], k: 8, MaxClosest: 7 (7)
Input: [-3, -4, 4, 5], k: 8, MaxClosest: 5 (5)
Input: [2, -3, 9, 1], k: 8, MaxClosest: 8 (2,-3,9)
=====================================Data Flow Analysis===========================================================
Input: [5, -4, -3, 4], k: 8
CurrentSum: 5
TreeSet Values : [0]
Ceiling for (sum-k) 5-8=-3 is 0
Current Gap is 5
CurrentSum: 1
TreeSet Values : [0, 5]
Ceiling for (sum-k) 1-8=-7 is 0
Current Gap is 1
CurrentSum: -2
TreeSet Values : [0, 1, 5]
Ceiling for (sum-k) -2-8=-10 is 0
Current Gap is -2
CurrentSum: 2
TreeSet Values : [-2, 0, 1, 5]
Ceiling for (sum-k) 2-8=-6 is -2
Current Gap is 4
MaxClosest: 5
=====================================Data Flow Analysis===========================================================
Input: [2, -8, 1, 9], k: 8
CurrentSum: 2
TreeSet Values : [0]
Ceiling for (sum-k) 2-8=-6 is 0
Current Gap is 2
CurrentSum: -6
TreeSet Values : [0, 2]
Ceiling for (sum-k) -6-8=-14 is 0
Current Gap is -6
CurrentSum: -5
TreeSet Values : [-6, 0, 2]
Ceiling for (sum-k) -5-8=-13 is -6
Current Gap is 1
CurrentSum: 4
TreeSet Values : [-6, -5, 0, 2]
Ceiling for (sum-k) 4-8=-4 is 0
Current Gap is 4
MaxClosest: 4
=====================================Data Flow Analysis===========================================================
Input: [7, -7, 6, 5], k: 8
CurrentSum: 7
TreeSet Values : [0]
Ceiling for (sum-k) 7-8=-1 is 0
Current Gap is 7
CurrentSum: 0
TreeSet Values : [0, 7]
Ceiling for (sum-k) 0-8=-8 is 0
Current Gap is 0
CurrentSum: 6
TreeSet Values : [0, 7]
Ceiling for (sum-k) 6-8=-2 is 0
Current Gap is 6
CurrentSum: 11
TreeSet Values : [0, 6, 7]
Ceiling for (sum-k) 11-8=3 is 6
Current Gap is 5
MaxClosest: 7

 */
public class MaximumSumOfSubarrayCloseToK {
  public int findMaxSumCloseToK(int[] arr, int k) {
    int sum = 0;
    TreeSet<Integer> set = new TreeSet<>();
    int result = Integer.MIN_VALUE;
    set.add(0);

    for (int i = 0; i < arr.length; i++) {
      sum = sum + arr[i];

      Integer gap = set.ceiling(sum - k);
      if (gap != null) result = Math.max(result, sum - gap);

      set.add(sum);
    }

    return result;
  }
}
