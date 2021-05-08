package com.interview.leetcode.linkedin.easy;

/*
 https://leetcode.com/problems/reverse-integer/discuss/4056/Very-Short-(7-lines)-and-Elegant-Solution
===========================================================Requirement===========================================================
1) Given a signed 32-bit integer x, return x with its digits reversed. 
2) If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
========================================================Solution Approach========================================================

Overflow can be handled in 2 ways
  Approach1) Just use long.
  Approach2) At each step, after getting result... 
             Rollback and see whether previousResult can be achieved.
             If we can get previousResult, overflow did't happened. Else overflow, return 0. 
             
             Ex: 123
                 result = 0
                 newResult = 3
                 rollBackResult = 0
                 result = 3
                 
                 result = 3
                 newResult = 32
                 rollBackResult = 
         
 */
public class ReverseInteger {

  public int reverse1(int x) {
    int result = 0;

    while (x != 0) {
      int lastDigit = x % 10;
      int newResult = (result * 10) + lastDigit;

      // Just do the reverse operation of above operation and see verify, do we able get back previous value of "result".
      int rollBackOfNewResult = newResult / 10;
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
