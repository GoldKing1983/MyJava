package com.interview.leetcode.ebay;

/*
https://leetcode.com/problems/binary-gap/
=========================================================Requirement==========================================================
Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
If there aren't two consecutive 1's, return 0.

Input: 22
Output: 2
Explanation:  22 in binary is 10110. The longest lies between index0 and index2 i.e 2-0=2

Input: 5
Output: 2
Explanation:  5 in binary is 101. The longest lies between index0 and index2 i.e 2-0=2

Input: 15
Output: 1
Explanation:  15 in binary is 1111. The longest lies between index0and1 index1and2 index2and3 all are 1.
=======================================Solution Approach - O(N) - Sliding Window=================================================
1) Move left to firstSeen1.
2) right=left+1.
3) When right is 1. SecondOne is found.
4) Calculate window size. 
5) left=right. right=right+1. Do from step3 till all elements are iterated. 

Note: Input is a positive integer. So if I do rightShift operation, we can ignore 32nd index value.
									  if I do leftShift operation, then I need to traverse 32 times.
Note: I can do from leftToRight or rightToLeft both yields same answer.
Because above algorithm explains from leftToRight. But implemented in rightToLeft, because parsing from leftToRight is difficult.
 */
public class BinaryGapRightShift {
	public int binaryGap(int n) {
		if (n <= 2)
			return 0;
		int left = 0;
		while ((n & 1) != 1) {
			n = n >> 1;
			left++;
		}
		n = n >> 1;
		int maxWidth = 0;
		for (int right = left + 1; right < 31; right++) {
			if ((n & 1) == 1) {
				int currentWidth = right - left;
				maxWidth = Math.max(maxWidth, currentWidth);
				left = right;
			}
			n = n >> 1;
		}
		return maxWidth;
	}

}
