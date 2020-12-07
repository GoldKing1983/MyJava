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

    public int missingNumberXOR(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}
