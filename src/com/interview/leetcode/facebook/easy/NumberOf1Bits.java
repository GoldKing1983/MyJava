package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/number-of-1-bits/
Count the number of 1s in number.
Ex: 1(01) -> Ans: 1
Ex: 2(10) -> Ans: 1
Ex: 3(11) -> Ans: 2
Ex: 4(100) ->Ans: 1
 */
public class NumberOf1Bits {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    String s = Integer.toBinaryString(n);
    int count = 0;
    for (char c : s.toCharArray()) {
      if (c == '1') count++;
    }
    return count;
  }

  public int hammingWeightByRightShift(int n) {
    int count = 0;
    int totalRightShifts = 32;
    while (totalRightShifts-- > 0) {
      int lastBit = n & 1;
      if (lastBit == 1) count++;
      n >>>= 1; // Shift Right Side with sign
    }
    return count;
  }
}
