package com.interview.leetcode.topic.array;

/*

https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation

1) During the non-zero, if zeroCount>0 then write(nonZero) is required. 
2) Find the write index. writeIndex = "read-zeroCount"
 */
public class MoveZeroesAlternate {
  public void moveZeroes(int[] nums) {
    int read = 0, zeroCount = 0, n = nums.length;
    while (read < n) {
      if (nums[read] == 0) { // zero
        zeroCount++;
      } else { // non-zero.
        if (zeroCount > 0) { // move
          nums[read - zeroCount] = nums[read];
          nums[read] = 0;
        }
      }
      read++;
    }
  }

}
