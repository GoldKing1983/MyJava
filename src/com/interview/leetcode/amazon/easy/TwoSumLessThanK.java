package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.TreeSet;

/*
https://leetcode.com/problems/two-sum-less-than-k/
===========================================================Requirement===========================================================
1) Given an array of number and target.
2) Find the sumOf2Number lessThan(notClosest or notEqualTo) target. 
3) The sumOf2Number must be lessThanTarget and cannot be equalToOrGreaterThan target 
Note: Generally we think equalTo can be answer. But that is wrong. Question is very clear return twoSumLessThanTarget
============================================================Example1=============================================================
nums   = [10,20,25,30,50]
target = 40

Output: 35 (10+25)
Note: we have twoSum40(10+30) which is ignored.   
========================================================Solution Approach1=======================================================
1) Sort the Array.
2) Take 2 pointers left and right.
3) if A[left] + A[right] >= K decrease left.
4) Else cache the answer. There might still closer answer, so loop continues.
========================================================Solution Approach2=======================================================
1) Similar to map approach of Two sum problem.
2) In case of 2 sum problem, in un-sorted array we look for "target-currentNumber" in HashMap,
3) Here we look for lower than target - currentNumber in TreeSet.
	Input : [34,23,1,24,75,33,54,8]
	target : 60
=================================================================================================================================
 */
public class TwoSumLessThanK {
  public int twoSumLessThanK(int[] arr, int target) {
    Arrays.sort(arr);
    int twoSumLessThanTarget = Integer.MIN_VALUE;
    for (int left = 0, right = arr.length - 1; left < right;) {
      if (arr[left] + arr[right] >= target) right--;
      else twoSumLessThanTarget = Math.max(twoSumLessThanTarget, arr[left++] + arr[right]);
    }
    return twoSumLessThanTarget == Integer.MIN_VALUE ? -1 : twoSumLessThanTarget;
  }

  /*
   * Below approach might be possibly over-thinking. Because since I have all the data in hand. One Time Sorting is better.
   * 
   * If I have to send result instantly on seeing a pair. Then below approach might be better. 
   * Ex: I have 1Million items. Within 10loops I found a pair, return immediately.
   * 
   * But in below problem, we need to parse all data to find closest. So this is in-efficient.
   */
  public int twoSumLessThanK1(int[] nums, int target) {
    TreeSet<Integer> set = new TreeSet<>();
    int twoSumLessThanTarget = Integer.MIN_VALUE;
    for (int num : nums) {
      Integer lessThanOrEqualToNum = set.lower(target - num);
      if (lessThanOrEqualToNum != null) {
        int currentTwoSumLessThanTarget = lessThanOrEqualToNum + num;
        twoSumLessThanTarget = Math.max(currentTwoSumLessThanTarget, twoSumLessThanTarget);
      }
      set.add(num);
    }
    return twoSumLessThanTarget == Integer.MIN_VALUE ? -1 : twoSumLessThanTarget;
  }
}
