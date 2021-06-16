package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/max-consecutive-ones-iii/
========================================================Requirement==============================================================
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
Return the length of the longest (contiguous) sub-array that contains only 1s.

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
                    c c       c   --> changedIndex 
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]

==============================================Solution Approach - Sliding Window=================================================
1) Start from index0. Create/Extend the window till kZero is found.
		1a) left stays at index0.
		1b) right moves till kZero's.
		1c) measure windowSize at each step and update maxWindow.
2) When the k+1Zero comes, Shrink the window till "firstSeenZero".
		2a) left moves to location "firstSeenZero+1". right stays at the same index.
		2b) measure windowSize at each step and update maxWindow.
3) Do step2 till indexN-1
============================See Also LongestRepeatingCharacterReplacement================
1) count the number of zeroes.
2) window = right-left+1
2) If the "zeroCount" <= K then "current window" "can" be answer.
3) Else increment left. Before incrementing, if left(left may point 0 or 1)is pointing 0, Decrement zeroCount.

===============
[1,1,1,0,0,0,1,1,1,1,0]
2

I cannot move left from index 3 to 6 directly.
It needs to go step by step only.

 */
public class MaxConsecutiveOnesIIISlidingWindow {

  public int longestOnes(int[] nums, int k) {
    int left = 0, right = 0, noOfZeroes = 0, n = nums.length;
    int longestOnes = 0;
    while (right < n) {
      if (nums[right] == 0) {
        noOfZeroes++;
        if (noOfZeroes > k) { // Shrink. By 1 zero
          while (nums[left] != 0) left++; // Move left to "firstSeenZero"
          left++; // Move left after "firstSeenZero".
        }
      }
      int currentLongestWindow = right - left + 1;
      longestOnes = Math.max(currentLongestWindow, longestOnes);
      right++;
    }
    return longestOnes;
  }
}
