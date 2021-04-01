package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/3sum
======================================================Requirement================================================================
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.
==================================================Solution Approach==============================================================
1) Sort the number
2) Take a number. Do 2Sum for remaining number.
3) Sorting takes O(log N). 2 loops in takes O(n^2). So Time Complexity is approximately: O(n^2)
4) Duplicate check needs to happen after forming first result.  If I do before forming result, then result will be empty.
================How to Avoid Duplicate in 3 cases==========================
1) Avoid Outer Loop Duplicate 
Ex: [-1 -1 0 1]
	first output formed with -1 0 1. Then again -1 0 1

2) Avoid Left Duplicate 
Ex: [-2,0,0,2,2] --> result:[[-2,0,2]]
	first output formed with -2 0 2. from index 0 1 and 3 then avoid result from index 0 2 and 3.

3) Avoid Right Duplicate 
Ex: [-2,0,0,2,2] --> result:[[-2,0,2]]
	first output formed with -2 0 2. from index 0 1 and 3 then avoid result from index 0 2 and 3.
===================Advanced Thinking=======
As per data, avoiding either left or right duplicate is enough. Because logically, avoiding duplicate on one side
will not form, same duplicate result again. So other side is balanced automatically.
=================================Important Note:======================================
Corner Case : [0,0,0,0]. Output: [0,0,0]. 
 
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length, outer = 0, totalLoop = n - 3;

    while (outer <= totalLoop) {
      int firstNumber = nums[outer];
      int left = outer + 1, right = n - 1;
      while (left < right) {
        int secondNumber = nums[left], thirdNumber = nums[right];
        int total = firstNumber + secondNumber + thirdNumber;
        if (total == 0) {
          result.add(Arrays.asList(firstNumber, secondNumber, thirdNumber));
          left++;
          right--;
          while (left < right && nums[left] == secondNumber) left++; // Handle Left Duplicate

          while (left < right && nums[right] == thirdNumber) right--; // Handle Right Duplicate

        } else if (total > 0) right--;
        else left++;
      }
      outer++;
      while (outer <= totalLoop && nums[outer] == nums[outer - 1]) outer++; // Handle Outer Duplicate
    }
    return result;
  }
}
