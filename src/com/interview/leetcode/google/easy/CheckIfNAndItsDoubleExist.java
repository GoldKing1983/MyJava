package com.interview.leetcode.google.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

Input: arr = [10,2,5,3] Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

Input: arr = [7,1,14,11] Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
===========================================Solution Approach=======================================================
1) Similar to TwoSum Problem. Check if the " multiple of 2  or divisor of 2" is available in set.
Multiple/Divide both cases needed, because [14,7] [7,14] both cases are true.
2) Another point is % condition needed before /2. Because without that number will be rounded.
=====================================================================================================================
 */
public class CheckIfNAndItsDoubleExist {
  public boolean checkIfExist(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int a : arr) {
      if (set.contains(a * 2)) return true;
      // Ex: % is needed. Because for 15 divisor is not possible.
      if (a % 2 == 0 && set.contains(a / 2)) return true;
      set.add(a);
    }
    return false;
  }
}
