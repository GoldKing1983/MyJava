package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

===================================================Solution Approach===================================================
1) Update Each index by n.
2) For the duplicate number it will be updated more than 1 time.
3) Now in the second loop. For each index, if (number-n >= n) then it is duplicate.

Problem is similar to "FindTheDuplicateNumberNegativeApproach".
In FindTheDuplicateNumberNegativeApproach only 1 duplicate can exist with constraint don't change input array.
=======================================Data Flow Analysis================================================================================
Input : [1,1,1,1,1] Output: 1

[6, 1, 1, 1, 1]
[11, 1, 1, 1, 1]
[16, 1, 1, 1, 1]
[21, 1, 1, 1, 1]
[26, 1, 1, 1, 1]

Input : [1,2,2,3,3] Output: 2,3
[6, 2, 2, 3, 3]
[6, 7, 2, 3, 3]
[6, 12, 2, 3, 3]
[6, 12, 7, 3, 3]
[6, 12, 12, 3, 3]
=========================================================================================================================================

 */
public class FindAllDuplicatesInAnArrayAddNApproach {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int n = nums.length;
    // Step1 : Update original input array with "n".
    for (int i = 0; i < n; i++) {
      int index = (nums[i] - 1) % n;
      nums[index] += n;
    }

    // Step2 : Get the result
    for (int i = 0; i < n; i++) {
      if (((nums[i] - 1) - n) >= n) res.add(i + 1);
    }

    return res;
  }
}
