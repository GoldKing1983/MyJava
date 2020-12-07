package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/description/
====================================================Requirement==================================================================
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
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
Note : Sorting is not required. In Example2 [2,3,5] or [3,2,5] or [5,2,3] all yields same combinations. Because we are 
skipping currentElement and proceeding with nextElement.

If elements are sorted we can skip proceed further. 

1) For Each of currentNumber, call recursion with currentNumber itself.
2) If the target==0. Result found. Return from recursion
3) If the target <0. Return from recursion. If input has negativeNumber, then recursion can go further all the way till n-1.
4) If the recursion returned, remove the lastNumber from currentResult, try the nextNumber from input.
=================================================Data Flow Analysis==============================================================
This problem is a classic backtracking problem like "FactorCombinations.java"

Input: {2, 3, 7, 6 }  Target: 7

[2]
[2, 2]
[2, 2, 2]
[2, 2, 3]
[2, 3]
[3]
[3, 3]
[6]
[7]


 */
public class CombinationSumOrCoinChangeWithSorting {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < candidates.length; i++) {
      combinationSumSorted(candidates, i, target - candidates[i], List.of(candidates[i]), ans);
    }
    return ans;
  }

  private void combinationSumSorted(int[] candidates, int start, int target, List<Integer> curr,
      List<List<Integer>> ans) {
    if (target == 0) {
      ans.add(curr);
      return;
    }
    if (target < 0) return;
    for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
      ArrayList<Integer> newCurr = new ArrayList<>(curr);
      newCurr.add(candidates[i]);
      combinationSumSorted(candidates, i, target - candidates[i], newCurr, ans);
    }

  }
}
