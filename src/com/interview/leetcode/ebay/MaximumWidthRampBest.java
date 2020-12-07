package com.interview.leetcode.ebay;

/*
=========================================================Requirement==========================================================
https://leetcode.com/problems/maximum-width-ramp/

Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

Input: [6,0,8,2,1,5]
Output: 4
Explanation:
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.

Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation:
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
=====================================================Solution Approach - O(N^2)==============================================
1) For each of number in left, right=left+1... Go all the way "n". if nums[right]>nums[left]. Update biggest length.   
=====================================================Solution Approach - O(N)================================================
1) Traverse from the right, Save max value for eachIndex in an array. 
      Ex: nums = [6,0,8,2,1,5]
          maxR = [8, 8, 8, 5, 5, 5]
2) Do Sliding Window between nums and maxR array.           
3) Compare inputNums(left) and maxR(right), if the "maxR" is bigger increment right, else increment left. 
4) Capture biggest when "maxR" has bigger. 
5) The basic idea here is, I am avoiding the unnecessary travel for eachNumber. Because I can stop traversal, when  there is
no bigger number beyond an index, which is achieved by maxR array.    

 */
public class MaximumWidthRampBest {
  public int maxWidthRamp(int[] nums) {
    int n = nums.length;
    if (n <= 1) return 0;

    int[] maxR = new int[n];
    maxR[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      maxR[i] = Math.max(nums[i], maxR[i + 1]);
    }

    int left = 0;
    int right = 0;
    int result = 0;
    while (true) {
      if (nums[left] <= maxR[right]) {
        result = Math.max(result, right - left);
        right++;
      } else {
        left++;
      }
      if (right == n) return result;
    }
  }
}
