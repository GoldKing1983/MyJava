package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/reverse-bits/

Reverse bits of a given 32 bits unsigned integer. Consider - sign also

Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000

 */
public class ReverseBits {
  public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 31; i++) {
      result += n & 1;
      n >>>= 1; // CATCH: must do unsigned shift
      result <<= 1;
    }
    result += n & 1; // CATCH: for last digit, no shifting needed. Just &
    return result;
  }
}
