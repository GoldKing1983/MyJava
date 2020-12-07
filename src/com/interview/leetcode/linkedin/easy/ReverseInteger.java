package com.interview.leetcode.linkedin.easy;

/*
 https://leetcode.com/problems/reverse-integer/discuss/4056/Very-Short-(7-lines)-and-Elegant-Solution



The only challenge is to handle overflow, which can be handled in many ways look into reverse1 and reverse2 method
 */
public class ReverseInteger {

  public int reverse1(int x) {
    int result = 0;

    while (x != 0) {
      int lastDigit = x % 10;
      int newResult = (result * 10) + lastDigit;

      // Just do the reverse operation of above operation and see verify, do we able get back previous value of "result".
      int rollBackOfNewResult = (newResult - lastDigit) / 10;
      if (rollBackOfNewResult != result) return 0;

      result = newResult;
      x = x / 10;
    }
    return result;
  }

  /*
   * Avoid overflow by using long. Check if result goes beyond "max" and "min" values.
   * But if the interviewer asks what if input is long and ouptut is long. Then reverse1 logic is the right approach.
   */
  public int reverse2(int input) {
    long result = 0;
    while (input != 0) {
      int lastDigit = input % 10;
      result = (result * 10) + lastDigit;
      input = input / 10;

      if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
    }
    return (int) result;
  }
}
