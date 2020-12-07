package com.sample.datastructure.recursion;

/*
 * http://codingbat.com/prob/p145416
 *
 * This is an basic example of recursion and DFS.
 */
public class GroupSumImportant {

  // I can reduce a variable by reducing the target, instead of taking sum as an argument.
  public boolean groupSum(int index, int[] nums, int target) {
    if (target == 0) return true;

    // (target < 0 || index==a.length) for positive numbers
    if (index == nums.length) return false;

    boolean left = groupSum(index + 1, nums, target - nums[index]);
    boolean right = groupSum(index + 1, nums, target);
    return left || right;
  }

  // This takes an additional variable sum...
  public boolean groupSum(int start, int[] nums, int target, int sum) {
    if (target == sum) return true;

    if (start == nums.length) return false;

    boolean left = groupSum(start + 1, nums, target, sum + nums[start]);
    boolean right = groupSum(start + 1, nums, target, sum);

    return left || right;
  }
}
