package com.sample.datastructure.recursion;

/**
 * http://codingbat.com/prob/p145416

===========================================================Requirement===========================================================
 Given an array of elements, find the given target
========================================================Solution Approach========================================================
1) Do the binary recursion by
         a) including the currentElement to sum and
         b) skipping  the currentElement to sum.
2) Result can be found either in include or skip. So result is either one.
=================================================================================================================================
 */
public class GroupSumImportant {

  // I can reduce a variable by reducing the target, instead of taking sum as an argument.
  public boolean groupSum(int index, int[] nums, int target) {
    if (target == 0) return true;

    // (target < 0 || index==a.length)..if input has negative then target<0 is fine
    if (index == nums.length) return false;

    boolean left = groupSum(index + 1, nums, target - nums[index]);
    boolean right = groupSum(index + 1, nums, target);
    return left || right;
  }

  // This takes an additional variable sum...
  public boolean groupSum(int index, int[] nums, int target, int currentSum) {
    if (target == currentSum) return true;

    if (index == nums.length) return false;

    boolean left = groupSum(index + 1, nums, target, currentSum + nums[index]);
    boolean right = groupSum(index + 1, nums, target, currentSum);

    return left || right;
  }
}
