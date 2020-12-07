package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/description/
====================================================Requirement==================================================================
Given a set of positive numbers(no negative) (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.

Note: All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.
====================================================Example1=====================================================================
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
====================================================Example2=====================================================================
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
=================================================Solution Approach===============================================================
Note : Sorting is not required. In Example2 [2,3,5] or [3,2,5] or [5,2,3] all yields same combinations, only order changes. 
Because for each element(currentElement), if summing consecutiveElement goes beyond target, 
then we skip currentConsecutiveElement(backTrack) and summing continuous for next consecutiveElement.

input : [2,3,5] target = 7, output: [[2,2,3],[2,5]]
input : [3,2,5] target = 7, output: [[3,2,2],[2,5]]
input : [5,2,3] target = 7, output: [[5,2],[2,2,3]]

If elements are sorted we can skip next consecutiveElement and could try nextElement. 

1) For Each of currentNumber, call recursion with currentNumber itself.
2) If the target==0. Result found. Return from recursion
3) If the target <0. Return from recursion, because input is only positive numbers. 
If input has negativeNumber, then recursion can go further all the way till n-1.
4) BackTracking : If the recursion returned, remove the lastNumber from currentResult, try the nextNumber from input.
=================================================Data Flow Analysis==============================================================
This problem is a classic backtracking problem like "FactorCombinations.java"

Input: {2, 3, 7, 6 }  Target: 7

[]
[2]
[2, 2]
[2, 2, 2]
[2, 2, 2, 2]
[2, 2, 2]
[2, 2, 2, 3]
[2, 2, 2]
[2, 2, 2, 7]
[2, 2, 2]
[2, 2, 2, 6]
[2, 2]
[2, 2, 3]
[2, 2]
[2, 2, 7]
[2, 2]
[2, 2, 6]
[2]
[2, 3]
[2, 3, 3]
[2, 3]
[2, 3, 7]
[2, 3]
[2, 3, 6]
[2]
[2, 7]
[2]
[2, 6]
[]
[3]
[3, 3]
[3, 3, 3]
[3, 3]
[3, 3, 7]
[3, 3]
[3, 3, 6]
[3]
[3, 7]
[3]
[3, 6]
[]
[7]
[]
[6]
[6, 6]

 */
public class CombinationSumOrCoinChange {
  public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    recur(nums, target, new LinkedList<>(), result, 0, nums.length);
    return result;
  }

  private void recur(int[] nums, int target, LinkedList<Integer> currentResult,
      List<List<Integer>> result, int currentIndex, int n) {
    if (target == 0) {
      result.add(new LinkedList<>(currentResult));
      return;
    }
    if (target < 0) return;
    while (currentIndex < n) {
      currentResult.add(nums[currentIndex]);
      recur(nums, target - nums[currentIndex], currentResult, result, currentIndex, n);
      currentResult.removeLast();
      currentIndex++;
    }
  }
}
