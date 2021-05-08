package com.interview.leetcode.topic.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/factor-combinations

CurrentFactor : 1. Current Result: []
CurrentFactor : 2. Current Result: [2]
CurrentFactor : 4. Current Result: [2, 2]
CurrentFactor : 8. Current Result: [2, 2, 2]
CurrentFactor : 16. Current Result: [2, 2, 2, 2]
CurrentFactor : 32. Current Result: [2, 2, 2, 4]
CurrentFactor : 64. Current Result: [2, 2, 2, 8]
CurrentFactor : 16. Current Result: [2, 2, 4]
CurrentFactor : 32. Current Result: [2, 2, 8]
CurrentFactor : 8. Current Result: [2, 4]
CurrentFactor : 32. Current Result: [2, 4, 4]
CurrentFactor : 64. Current Result: [2, 4, 8]
CurrentFactor : 16. Current Result: [2, 8]
CurrentFactor : 4. Current Result: [4]
CurrentFactor : 16. Current Result: [4, 4]
CurrentFactor : 32. Current Result: [4, 8]
CurrentFactor : 8. Current Result: [8]
CurrentFactor : 64. Current Result: [8, 8]


Output: [[2,2,2,2],[2,2,4],[2,8],[4,4]]



===========

 */
public class FactorCombinationsAlternate {
  public List<List<Integer>> getFactors(int n) {
    if (n <= 1) return List.of();
    return recur(new ArrayList<>(), new ArrayList<>(), 2, 1, n);
  }

  private List<List<Integer>> recur(List<List<Integer>> result, List<Integer> currentResult,
      int index, int currentFactor, int n) {
    if (currentFactor == n) {//result found
      result.add(new ArrayList<>(currentResult));
      return result;
    }
    if (currentFactor > n) return result;
    // run from 1 to n-1.. n is not needed, because we don't need to add n in result.
    for (int currentNumber = index; currentNumber < n; currentNumber++) {
      if (n % currentNumber == 0) { // if currentNumber is divisible exactly by n. Then we can add currentNumber to result.
        currentResult.add(currentNumber);
        recur(result, currentResult, index, currentFactor * currentNumber, n);
        currentResult.remove(currentResult.size() - 1);
        index = currentNumber + 1;
      }
    }
    return result;
  }
}
