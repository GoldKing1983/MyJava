package com.interview.leetcode.facebook.easy;

/*
====================================================Requirement==================================================================
Given an integer n, return any array containing "n" uniqueIntegers such that they add up to "0".

Don't confuse with sample example output given. We can form output in any way.  
======================================================Example1===================================================================
n = 1, output= [0]
n = 2, output= [1, -1]
n = 3, output= [1, -1, 0]
n = 4, output= [1, -1, 2, -2]
n = 5, output= [1, -1, 2, -2, 0]
n = 6, output= [1, -1, 2, -2, 3, -3]
===================================================Solution Approach=============================================================
Read the question carefully, we need to form "n" uniqueNumbers that make 0. 
An easier way to make 0 is by adding "uniqueNumber and -uniqueNumber"

1) Add  1 on firstIndex and -1 on secondIndex.
2) Add  2 on thirdIndex and -2 on fourthIndex.
3) Add  3 on fifthIndex and -3 on sixthIndex.

If n is odd. lastIndexValue by default contains 0.

Ex: n=2... loop runs one time filling first and second.
Ex: n=3... loop runs one time filling first and second. thirdIndex by default contains 0. 
 */
public class FindNUniqueIntegersSumUpToZero {

  public int[] sumZero(int n) {
    int[] result = new int[n];
    // n=1... Loop don't runs.
    // n=2... Loop runs 1 time.
    // n=3... Loop runs 1 time.
    // n=4... Loop runs 2 time.
    int i = 0, uniqueNumber = 1;
    while (i < n - 1) {
      result[i++] = uniqueNumber;
      result[i++] = -uniqueNumber;
      uniqueNumber++;
    }
    return result;


  }
}
