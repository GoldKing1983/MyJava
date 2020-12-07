package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*

Find all possible combinations of k numbers that add up to a number n, given that only numbers from
1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.

Input: k = 3, n = 7
Output: [[1,2,4]]

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

 */
public class CombinationSumIII {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    combination(ans, new ArrayList<Integer>(), k, 1, n);
    return ans;
  }

  private void combination(
      List<List<Integer>> ans, List<Integer> tempCombo, int k, int currentIndex, int n) {
    if (tempCombo.size() == k && n == 0) {
      List<Integer> li = new ArrayList<>(tempCombo);
      ans.add(li);
      return;
    }
    for (int i = currentIndex; i <= 9; i++) {
      tempCombo.add(i);
      combination(ans, tempCombo, k, i + 1, n - i);
      tempCombo.remove(tempCombo.size() - 1);
    }
  }
}
