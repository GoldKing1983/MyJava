package com.sample.datastructure.recursion;

/**
===========================================================Requirement===========================================================
 1) Given an array of elements, find the given target.
 2) If the input has 6, then result must include 6
 3) If there is no 6 present in the input then grouping sum other than 6 is ok.
========================================================Solution Approach========================================================
 1) If the currentInput is 6, then including the currentElement to sum and take that path
 2) Else Do the binary recursion by
     a) including the currentElement to sum and
     b) skipping  the currentElement to sum.
     c) Result can be found either in include or skip. So result is either one.
=================================================================================================================================
 */
public class GroupSum6 {
  public static void main(String[] args) {
    System.out.println(new GroupSum6().groupSum6(0, new int[] {5, 6, 2, 4}, 11));
    System.out.println(new GroupSum6().groupSum6(0, new int[] {7, 6, 11}, 11));
  }

  /**
   * If the input 2 sixes then both had to present in output...So iteration should happen till end
   */
  public boolean groupSum6(int startIndex, int[] nums, int target) {
    // System.out.println(target);
    if (startIndex == nums.length) return target == 0;

    if (nums[startIndex] == 6) return groupSum6(startIndex + 1, nums, target - nums[startIndex]);
    else {
      boolean left = groupSum6(startIndex + 1, nums, target - nums[startIndex]);
      boolean right = groupSum6(startIndex + 1, nums, target);

      return left || right;
    }
  }
}
