package com.interview.leetcode.topic.math;

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

    if (n == 0 || n==2) return false;
    if (n == 1) return true;

    while (true){
      if(n%3 != 0) return false;
      n /= 3;
      if(n==1) return true;
    }

  }

  public boolean isPowerOfThreeBinarySearch(int n) {
    if (n==0 || n==2) return false;
    if(n==1) return true;
    int low=1, high=n/2;
    while(low<=high) {
      double mid = low+(high-low)/2;
      double midThreePower = Math.pow(3, mid);
      if(midThreePower == n) return true;
      else if(midThreePower > n) high = (int)mid-1;
      else low = (int)mid+1;
    }
    return false;
  }
}
