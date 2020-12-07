package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

================================Solution Approach================================================================
Solution is more about breaking the "structuring logic" into "parts". Similar to MaximizeDistanceToClosestPerson
No Algorithm or DS. Plain Java Coding for the requirement.
1) Find the range between lower and first number in the array.
2) Find ranges between adjacent number in the array.
3) Find the range between upper and last number in the array.
========================================================================================================
 */
public class MissingRanges {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      result.add(formRange(lower, upper));
      return result;
    }

    // 1st step
    int firstNumber = nums[0];
    if (firstNumber > lower) {
      result.add(formRange(lower, firstNumber - 1));
    }

    // 2nd step
    for (int i = 0; i < nums.length - 1; i++) {
      int currentNumber = nums[i];
      int nextNumber = nums[i + 1];
      if (currentNumber == nextNumber) continue;
      // Without Casting IntegerMaxBoundException will throw.
      if ((long) nextNumber - (long) currentNumber > 1) { // nextNumber > currentNumber + 1
        result.add(formRange(currentNumber + 1, nextNumber - 1));
      }
    }

    // 3rd step
    int lastNumber = nums[nums.length - 1];
    if (lastNumber < upper) {
      result.add(formRange(lastNumber + 1, upper));
    }
    return result;
  }

  public String formRange(int low, int high) {
    return low == high ? String.valueOf(low) : (low + "->" + high);
  }
}
