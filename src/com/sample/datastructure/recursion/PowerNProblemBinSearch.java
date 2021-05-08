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
Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
==========================================Solution Approach - O(log n)==========================================
1) Base Case: Anything power0 is 1. So return 1
2) Divide the n, till n gets 0.
3) if n is even return currentAnswer*currentAnswer. Else return currentAnswer * currentAnswer * base
==========================================Data Flow Analysis==========================================
	Ex: 2^10 = 1024

						10 ==> 5 ==> 2 ==> 1 ==> 0
						  						 0 ==>    1  ==>  2  ==>   5    ==>    10
						      						   1*2=2    2*2=4   4*4*2=32   32*32=1024
	Ex: 5^3 = 125
						3 ==> 1 ==> 0
									0 ==> 1   ==>  3
										 1*5=5	  5*5*5=125
  Note: Multiplying "base" for all the odd.
*/
public class PowerNProblemBinSearch {

  private double postOrder(double base, long n) {
    if (n == 0) return 1.0; // Base Case. Anything power0 is 1.

    double currentAnswer = postOrder(base, n / 2);

    if (n % 2 == 0) return currentAnswer * currentAnswer;

    return currentAnswer * currentAnswer * base;
  }

  public double myPow(double base, int n) {
    // 2^
    if (n < 0) {
      base = 1 / base;
      // n = -n; not sure when this is needed. But without this is good.
    }

    return postOrder(base, n);
  }
}
