package com.walmart.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

https://leetcode.com/problems/permutations/

Similar to Standard "code" of FactorCombinations. Time Complexity O(n^2).

1) This is not an efficient solution, as the contains method runs every-time.

2) Without contains backTrack solution is not possible. Because after "3" "2" has to to come.
 	1	2	3
 	1	3
   So we run loop from 0 to pick all numbers. Then duplicate comes. So contains is the only option.

=================================================================================================================================
*/
public class PermutationsDFSBackTrackBruteForce {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    generatePermutations(nums, nums.length, new LinkedList<>(), result);
    return result;
  }

  private void generatePermutations(int[] nums, int n, LinkedList<Integer> currentResult,
      List<List<Integer>> result) {
    if (currentResult.size() == n) {
      result.add(new LinkedList<>(currentResult));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (currentResult.contains(nums[i])) continue;
      currentResult.add(nums[i]);
      generatePermutations(nums, n, currentResult, result);
      currentResult.removeLast();
    }
  }
}
