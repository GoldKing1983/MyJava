package com.sample.datastructure.recursion;

/*
https://leetcode.com/problems/powx-n
====================================================Requirement==================================================================
Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
======================================================Example1===================================================================
Input: x = 2.00000, n = 10
Output: 1024.00000
======================================================Example2===================================================================
Input: x = 2.10000, n = 3
Output: 9.26100
======================================================Example3===================================================================
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
==================================================Solution Approach: O(n)========================================================
1) Base Case: Anything power0 is 1. So return 1
2) Call recursion, till n gets 0.

  For negative number do the below logic.
  1) base = 1 by base
  2) convert the negative number to positive number


*/
public class PowerNProblemLinear {

  private double postOrder(double base, long n) {
    if (n == 0) return 1.0; // Base Case

    return postOrder(base, n - 1) * base;
  }

  public double myPow(double base, int n) {
    if (n < 0) {
      base = 1 / base;
      n = -n;
    }

    return postOrder(base, n);
  }
}
