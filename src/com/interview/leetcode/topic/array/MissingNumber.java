package com.interview.leetcode.topic.array;

import java.util.Arrays;

/*
https://leetcode.com/problems/missing-number/
===========================================================Requirement===========================================================
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
that is missing from the array.

Constraints:
0 <= nums[i] <= n
All the numbers of nums are unique.
============================================================Example1=============================================================
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since
it does not appear in nums.
Example 2:
============================================================Example2=============================================================
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since
it does not appear in nums.
========================================================Solution Approach========================================================
Solution1) Sorting - If index and
Solution2) Put it inside a hashSet.
Solution3) XOR operation.
Solution4) Two Pass.
           In firstPass... swap 0 to 0th index... 1 to 1stIndex... 
           In secondPass.. verify all numbers in sameIndex. If not return that number.

 */
public class MissingNumber {

  public int missingNumberSort(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] != i) return i;
    }
    return n;
  }

  /*
  Ex: [0,1,3,4]
  ​index :  0  1  2  3
  value :  0  1  3  4
  initially assign result = 4.
  = 4 ∧ (0∧0) ∧ (1∧1) ∧ (2∧3) ∧ (3∧4)
  = 4 ∧ (2∧3) ∧ (3∧4) ==> remove (0∧0) ∧ (1∧1)  because they wont make any difference
  = (4∧4) ∧ (3∧3) ∧ 2 ==> Match 4 with 4 and 3 with 3, so that they can be removed, too.
  = 0 ∧ 0 ∧ 2
  = 2
  ​   */
  public int missingNumberBetterXor(int[] nums) {
    int result = nums.length;
    for (int i = 0; i < nums.length; i++) {
      result = result ^ i ^ nums[i];
    }
    return result;
  }

  /*
  sum = n(n+1)/2
   */
  public int missingNumber(int[] nums) { // sum
    int n = nums.length;
    int sum = n * (n + 1) / 2;
    for (int i = 0; i < n; i++) sum = sum - nums[i];
    return sum;
  }
}
