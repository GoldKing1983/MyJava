package com.interview.leetcode.adobe.easy;

/*
============================================================Requirement==========================================================
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].

==============================================================Example============================================================
Input: nums = [1,2,3,4,5,6], k = 3
Output: [1,4,2,5,3,6] 
==========================================================Solution Approach======================================================
1) The problem has a hint. There will be 2n elements all the elements. So below input is invalid case. 
Input: nums = [1,2,3,4,5,6,7] k = 3

2) So fill 0th result and 1st result. 
      fill 2nd result and 3rd result.
      fill 4th result and 5th result.
==================How to get the right index==================      
 i = 0
    2*i    = 0
    2*i +1 = 1
 i = 1
    2*1    = 2
    2*1 +1 = 3
 i = 2
    2*2    = 4
    2*2 +1 = 5
=================================================================================================================================
 */
public class ShuffleTheArray {
  public int[] shuffle(int[] nums, int k) {
    int[] ans = new int[2 * k];
    for (int i = 0; i < k; i++) {
      ans[2 * i] = nums[i];
      ans[2 * i + 1] = nums[i + k];
    }
    return ans;
  }

  /*
   Input: nums = [1,2,3,4,5,6], n = 3
   Fill 0,3,1,4,2,5
   ==========if (i+k >=n) do mod operation======       
  */
  public int[] shuffleAlternateWorst(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n];
    int i = 0;
    int resultIndex = 0;
    k = k % n;
    int total = n;
    while (total-- > 0) {
      result[resultIndex] = nums[i];
      resultIndex++;
      if (i + k >= n) i = ((i + k) % n) + 1;
      else i = i + k;

    }
    return result;
  }
}
