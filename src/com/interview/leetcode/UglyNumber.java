package com.interview.leetcode;

/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:

Input: 14
Output: false
Explanation: 14 is not ugly since it includes another prime factor 7.

=========================================================Solution Approach=========================================================
1) No need to look for backTracking style algorithm. Ex: We divide by 5 or 3 or 2.
If at end, we don't find output try for different combos.

2) It works in any way changing the order of division.
 */
public class UglyNumber {
  public boolean isUgly(int num) {
    if (num <= 0) return false; // For 0 and negative numbers.
    // if a number is divided by 2 or 3 or 5, it should be divisible by 30 i.e LCM of 2,3,5
    while (num % 30 == 0) num = num / 30;
    while (num % 5 == 0) num = num / 5;
    while (num % 3 == 0) num = num / 3;
    while (num % 2 == 0) num = num / 2;

    return num == 1;
  }
}
