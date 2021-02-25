package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/missing-number/

input : [3,0,1,4,5,2] output: 6
Input: [3,0,1] Output: 2
 */
public class MissingNumber {
  /*
   1) XOR all the numbers from 0 to n, let’s call it x1.
   2) XOR all the numbers in the input array, let’s call it x2.
   3) The missing number can be found by x1 XOR x2.

  Input: [3,0,1] Output: 2
  Logical Thinking
  0 -> 0 = 0
  1 -> 1 = 0
  2 -> 0 = 2
  3 -> 3 = 0
    */
  public int missingNumberXor(int[] nums) {
    int x1 = 0, x2 = 0;
    for (int i = 0; i <= nums.length; ++i) x1 ^= i;
    for (int i = 0; i < nums.length; ++i) x2 ^= nums[i];

    return x1 ^ x2;
  }

  /*
  Ex: [0,1,3,4]
  ​index :  0  1  2  3
  value :  0  1  3  4
  initially assign result = 4.
  = 4 ∧ (0∧0) ∧ (1∧1) ∧ (2∧3) ∧ (3∧4)
  = 4 ∧ (2∧3) ∧ (3∧4) ==> remove (0∧0) ∧ (1∧1)  because they wont make any difference
  = (4∧4) ∧ (3∧3) ∧ 2 ==> Match 4 with 4 and 3 with 3, so that they can be removed, too.
  = 0 ∧ 0 ∧ 2
  = 2
  ​   */
  public int missingNumberBetterXor(int[] nums) {
    int result = nums.length;
    for (int i = 0; i < nums.length; i++) {
      result ^= i ^ nums[i];
    }
    return result;
  }
  /*
  sum = n(n+1)/2
   */
  public int missingNumber(int[] nums) { // sum
    int len = nums.length;
    int sum = len * (len + 1) / 2;
    for (int i = 0; i < len; i++) sum -= nums[i];
    return sum;
  }
}
