package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.UglyNumber;

/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
===========================================Solution Approach - BruteForce TLE===========================================
1) For each of currentNumber from 1 to Integer.MAX_VALUE, if a number is ugly. decrement n.
2) Return the currentNumber.
===========================================Data Flow Analysis===========================================
Input: n = 10 Output: 12

2
3
4
5
6
8
9
10
12

 */
public class UglyNumberIIBruteForce {
  public int nthUglyNumber(int n) {
    UglyNumber ugly = new UglyNumber();
    int currentNumber = 1;
    while (n > 1) {
      currentNumber++;
      if (ugly.isUgly(currentNumber)) {
        n--;
      }
    }
    return currentNumber;
  }
}
