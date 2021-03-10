package com.interview.leetcode.topic.recursion;

/*

https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
===========================================================Requirement===========================================================
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the
rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future
operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
============================================================Example1=============================================================
Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
============================================================Example2=============================================================
Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:
============================================================Example3=============================================================
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
========================================================Solution Approach========================================================
1) Recursively choose one element from start and one element from end.
2) Record the minimum of all elements.

 */
public class MinimumOperationsToReduceXToZero {
    int ans;

    public int minOperations(int[] nums, int x) {
        ans = Integer.MAX_VALUE;
        recur(nums, 0, nums.length - 1, x, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void recur(int nums[], int start, int end, int target, int steps) {
        if (target == 0) {
            ans = Math.min(ans, steps);
            return;
        }
        if (start > end || target < 0) {
            return;
        }

        recur(nums, start + 1, end, target - nums[start], steps + 1);
        recur(nums, start, end - 1, target - nums[end], steps + 1);
    }
}
