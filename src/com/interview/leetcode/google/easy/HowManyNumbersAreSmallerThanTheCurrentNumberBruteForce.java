package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

Given the array nums, for each nums[i], find out how many numbers in the array are smaller than it.
Return the answer in an array.

Input: nums = [8,1,2,2,3] Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

Input: nums = [6,5,4,8]
Output: [2,1,0,3]

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
========================================Solution Approach - O(n^2) - Initial Thinking===========================================================
1) For each of data get the count of numbers
================================================================================================================================================


*/
public class HowManyNumbersAreSmallerThanTheCurrentNumberBruteForce {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] answer = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      for (int j = 0; j < nums.length; j++) {
        if (i != j && nums[j] < nums[i]) count++;
      }
      answer[i] = count;
    }
    return answer;
  }
}
