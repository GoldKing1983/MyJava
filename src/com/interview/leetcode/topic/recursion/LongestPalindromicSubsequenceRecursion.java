package com.interview.leetcode.topic.recursion;

/*
https://leetcode.com/problems/longest-palindromic-subsequence/description/
========================================================Requirement==============================================================
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Input: "bbbab"
Output: 4.  One possible longest palindromic subsequence is "bbbb".

Input:"cbbd"
Output: 2
=============================================Initial Thinking====================================================================
Similar to "GroupSum6" and not "GroupSum".
 		i.e GroupSum ==> Go in 2path(left&right) vs GroupSum6 ==> Go in 1path If 6 Else Go in 2path(left&right)
=============================================Solution Approach===================================================================
    1) Start "left from 0" and "right from n-1".
    2) If first and last match "increment left" and "decrement right". Recur Single Time. Increment result by 2.
    3) Else recur both sides. RecurLeft is increment left and recur,
    						  RecurRight is decrement right and recur.
    4) Base case return is if left>right return 0. if left==right return 1.(Odd Palindrome)
	5) Note we are returning "Math.max(leftToRight, rightToLeft)". Because maxResult can come from either way. 
=======================================================Why Math.max==============================================================
Ex1: "bba"
left=1, right=1
left=1, right=2

Ex2: "abb"
left=1 right=1
left=2 right=1
=======================================================Depth Simulation==========================================================
Ex1: "bba"
						=====left=====
						start=0, end=2
						startChar and endChar are not matching.
						incrementLeft.		=====left=====
											start=1, end=2
											startChar and endChar are not matching.
											incrementLeft.
																	=====left=====
																	start=2, end=2
																	BaseCase matched. Return 1 for left.
											=====right=====
											left=1
											decrementRight			=====right=====
																	start=1, end=1
																	BaseCase matched. Return 1 for right.
											=====Math.max=====
											left=1, right=1. Math.max(1,1). Return 1 for left.
						=====right=====
						left=1
						decrementRight
						start=0, end=1
						leftChar and right matched.
						incrementLeft and decrementRight
											=====right=====
											start=1, end=0
											BaseCase matched. Return 0 for right.

						left=1, right=2+0. Math.max(1,2) Return 2.
=================================================================================================================================
 */
public class LongestPalindromicSubsequenceRecursion {

  public int longestPalindromeSubseq(String s) {
    return longestPalindromeSubseq(0, s.length() - 1, s);
  }

  int longestPalindromeSubseq(int left, int right, String s) {
    if (left == right) return 1; // Reached odd mid-index
    else if (left > right) return 0;
    else if (s.charAt(left) == s.charAt(right)) {
      return 2 + longestPalindromeSubseq(left + 1, right - 1, s);
    } else {
      int leftToRight = longestPalindromeSubseq(left + 1, right, s);
      int rightToLeft = longestPalindromeSubseq(left, right - 1, s);
      return Math.max(leftToRight, rightToLeft);
    }
  }
}
