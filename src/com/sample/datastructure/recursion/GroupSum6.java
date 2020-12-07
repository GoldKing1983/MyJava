package com.sample.datastructure.recursion;

/**
 * Note: Question is a bit tricky, if there is a 6 present in the input then sum should have 6 to
 * achieve target. If there is no 6 present in the input then grouping sum other than 6 is ok.
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

    boolean left = groupSum6(startIndex + 1, nums, target - nums[startIndex]);
    boolean right = groupSum6(startIndex + 1, nums, target);

    return left || right;
  }
}
