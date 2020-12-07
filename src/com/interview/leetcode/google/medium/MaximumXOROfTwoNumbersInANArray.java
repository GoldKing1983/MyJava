package com.interview.leetcode.google.medium;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

Requirement is a bit odd. "Sum(X-OR) of Maximum of 2 of numbers". Which application would require this?

x ^ 0 = x  ==> (if x is 0 then result is 0, if x is 1 then result is 1.)
x ^ x = 0  ==> (if x is 0 then result is 0, if x is 1 then result is 0.)
x ^ 1 = !x ==> (if x is 0 then result is 1, if x is 1 then result is 0.)

1) To get the maximum of x-or, start

	25 => 11001
	 5 => 00101
	      =====
	28 => 11100
 */
public class MaximumXOROfTwoNumbersInANArray {

  public int findMaximumXOR(int[] nums) {
    int maxNum = nums[0];
    for (int num : nums) maxNum = Math.max(maxNum, num);
    // length of max number in a binary representation
    int L = (Integer.toBinaryString(maxNum)).length();

    int maxXor = 0, currXor;
    Set<Integer> prefixes = new HashSet<>();
    for (int i = L - 1; i > -1; --i) {
      // go to the next bit by the left shift
      maxXor <<= 1;
      // set 1 in the smallest bit
      currXor = maxXor | 1;
      prefixes.clear();
      // compute all possible prefixes
      // of length (L - i) in binary representation
      for (int num : nums) prefixes.add(num >> i);
      // Update maxXor, if two of these prefixes could result in currXor.
      // Check if p1^p2 == currXor, i.e. p1 == currXor^p2.
      for (int p : prefixes) {
        if (prefixes.contains(currXor ^ p)) {
          maxXor = currXor;
          break;
        }
      }
    }
    return maxXor;
  }
}
