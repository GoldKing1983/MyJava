package com.interview.leetcode.facebook.easy;

/*

https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation

 */
public class MoveZeroesBest {
  public void moveZeroes(int[] nums) {
    int snowBallSize = 0;
    for (int read = 0; read < nums.length; read++) {
      if (nums[read] == 0) {
        snowBallSize++;
      } else if (snowBallSize > 0) {
        nums[read - snowBallSize] = nums[read];
        nums[read] = 0;
      }
    }
  }

}
