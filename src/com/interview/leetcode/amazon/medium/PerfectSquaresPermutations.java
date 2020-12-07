package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/perfect-squares/

Input: n = 12 Output: 3  Explanation: 12 = 4 + 4 + 4.

Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.

===================================Throw Time Limit Exceptions================

Step1) Generate candidate.
Step2) Permute the combos.

Similar to FactorCombinations. Generate all combinations from candidate.

[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
[1, 1, 1, 1, 1, 1, 1, 1, 4]
[1, 1, 1, 1, 1, 1, 1, 4, 1]
[1, 1, 1, 1, 1, 1, 4, 1, 1]
[1, 1, 1, 1, 1, 4, 1, 1, 1]
[1, 1, 1, 1, 4, 1, 1, 1, 1]
[1, 1, 1, 1, 4, 4]
[1, 1, 1, 4, 1, 1, 1, 1, 1]
[1, 1, 1, 4, 1, 4]
[1, 1, 1, 4, 4, 1]
[1, 1, 1, 9]
[1, 1, 4, 1, 1, 1, 1, 1, 1]
[1, 1, 4, 1, 1, 4]
[1, 1, 4, 1, 4, 1]
[1, 1, 4, 4, 1, 1]
[1, 1, 9, 1]
[1, 4, 1, 1, 1, 1, 1, 1, 1]
[1, 4, 1, 1, 1, 4]
[1, 4, 1, 1, 4, 1]
[1, 4, 1, 4, 1, 1]
[1, 4, 4, 1, 1, 1]
[1, 9, 1, 1]
[4, 1, 1, 1, 1, 1, 1, 1, 1]
[4, 1, 1, 1, 1, 4]
[4, 1, 1, 1, 4, 1]
[4, 1, 1, 4, 1, 1]
[4, 1, 4, 1, 1, 1]
[4, 4, 1, 1, 1, 1]
[4, 4, 4]
[9, 1, 1, 1]


 */
public class PerfectSquaresPermutations {
  List<Integer> squareNumbers = new ArrayList<>();

  public int numSquares(int n) {
    buildPerfectSquares(n);
    recur(n, 0, 0);
    return minCount;
  }

  int minCount = Integer.MAX_VALUE;
  List<List<Integer>> combos = new ArrayList<>();
  List<Integer> combo = new ArrayList<>();

  private void recur(int target, int currentSum, int count) {
    if (target == currentSum) {
      combos.add(new ArrayList<>(combo));
      minCount = Math.min(count, minCount);
      return;
    }
    if (currentSum > target) return;
    for (int i = 0; i < squareNumbers.size(); i++) {
      combo.add(squareNumbers.get(i));
      recur(target, currentSum + squareNumbers.get(i), count + 1);
      combo.remove(combo.size() - 1);
    }
  }

  private void buildPerfectSquares(int n) {
    for (int i = 1; i <= n; i++) {
      int ii = i * i;
      if (ii > n) break;
      squareNumbers.add(ii);
    }
  }
}
