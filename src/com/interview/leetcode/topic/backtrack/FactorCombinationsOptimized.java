package com.interview.leetcode.topic.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/factor-combinations
 *================Reason behind Math.sqrt===================
 * 1) Reason why Math.sqrt works is. The starting point and further except the last one cannot
 * go beyond sqrt(target).
 * 2) Ex: For input 32...
 * Result is:[[2, 16], [2, 2, 8], [2, 2, 2, 4], [2, 2, 2, 2, 2], [2, 4, 4], [4, 8]]
 * Other than leaf all numbers are <=5 which is <=sqrt(32).
 * 3) Also note every-time target changes and upper changes. So it is dynamic and helps in avoiding
 * unnecessary combinations.
 *=============Solution========
 *1) Whenever mod succeeds, a result is found.
 *2) Add currentResult and mod answer to result.
 *3) Do backtrack.
 *
 *  ==========Tree View of logic=========
12 - {2, 6}                	   {2, 6}
             6 - {2, 3}        {2, 2, 3}
   - {3, 4}                    {3, 4}
=============================
=========How duplicates are skipped============
Ex: 2,2,3 then 2,3,2 cannot come.
above will never happen. Because if a number is selected then number less than cannot come after it.
it will always go in forward direction
===========
 */
public class FactorCombinationsOptimized {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new LinkedList<>();
    backtrack(2, n, new LinkedList<>(), res);
    return res;
  }

  void backtrack(int start, int target, List<Integer> currResult, List<List<Integer>> result) {
    for (int currentNumber = start; currentNumber <= Math.sqrt(target); currentNumber++) {
      if (target % currentNumber == 0) {
        currResult.add(currentNumber);
        result.add(new LinkedList<>(currResult));
        result.get(result.size() - 1).add(target / currentNumber);
        backtrack(currentNumber, target / currentNumber, currResult, result);
        currResult.remove(currResult.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    FactorCombinationsOptimized f = new FactorCombinationsOptimized();
    f.getFactors(12);
    // f.getFactors(32);
    // f.getFactors(23848713);
  }
}
