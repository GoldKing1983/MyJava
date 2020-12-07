package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/combinations/

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Input: n = 5, k = 3
Output:
[
	[1,2,3],
	[1,2,4],
	[1,2,5],
	[1,3,4],
	[1,3,5],
	[1,4,5],
	[2,3,4],
	[2,3,5],
	[2,4,5],
	[3,4,5]
]
==============================================================Solution Approach===================================================
1) Classic BackTracking similar to "FactorCombinations".
2) Add currentNumber to result. (i.e) 1
3) Start backTracking with nextNumber.(i.e) 2. This step is for 1s next combo is 2.
4) Remove currentNumber from result (i.e) 1 and try next combination. Try fresh combo which currentNumbers from 2.
5) Add Base Condition. If currResult size==k, add currResult to result and return.

 */
public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    backTrack(n, k, result, new LinkedList<>(), 1);
    return result;
  }

  private void backTrack(
      int n, int k, List<List<Integer>> result, LinkedList<Integer> currResult, int currentNumber) {
    if (currResult.size() == k) {
      result.add(new LinkedList<>(currResult));
      return;
    }

    while (currentNumber <= n) {
      currResult.add(currentNumber);
      backTrack(n, k, result, currResult, currentNumber + 1);
      currResult.removeLast();
      currentNumber++;
    }
  }
}
