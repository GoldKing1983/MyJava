package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/power-of-three/

Given an integer, write a function to determine if it is a power of three.

Input: 27
Output: true

Input: 0
Output: false

Input: 9
Output: true

Input: 45
Output: false

 */
public class PowerOfThree {
  public boolean isPowerOfThree(int n) {
    if (n < 1) return false;

    while (n % 3 == 0) n /= 3;

    return n == 1;
  }
}
