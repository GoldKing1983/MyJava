package com.interview.leetcode.topic.slidingwindow;

/*
https://leetcode.com/problems/permutation-in-string/
===========================================================Requirement===========================================================
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
Verify if s2 has "any of s1 permutation string". If yes true. Else false.

Ex: s1="abc" s2="cab"  Output: true
Ex: s1="abc" s2="abxc" Output: false
========================================================Solution Approach========================================================

=======================Solution Approach=====Bucket Sort or Counter Approach=============
	======================InitialWindow==========process both inputString and patternString============
1) Simple Math... Decrement the PatternString and Increment the InputString.
2) Verify allZero. Result can be formed at InitialWindow. Ex : input="abc" pattern="cab"
	======================SlidingWindow===========process only inputString===========
1) From Left Elements are removed, so decrement.
2) From Right Elements are added, so increment.
3) Verify allZero.
4) At anypoint permutation found return true.
=====================================================================================================================
 */
public class PermutationInStringCounterApproach {
  public boolean checkInclusion(String searchString, String inputString) {
    if (searchString.length() > inputString.length()) return false; // ex: searchString:"ab" inputString:"a"
    int[] bucket = new int[26];
    for (int i = 0; i < searchString.length(); i++) {
      bucket[inputString.charAt(i) - 'a']++;
      bucket[searchString.charAt(i) - 'a']--;
    }
    if (allZero(bucket)) return true;

    for (int left = 0, right = searchString.length(); right < inputString
        .length(); left++, right++) {
      bucket[inputString.charAt(left) - 'a']--;
      bucket[inputString.charAt(right) - 'a']++;
      if (allZero(bucket)) return true;
    }
    return false;

  }

  private boolean allZero(int[] bucket) {
    for (int b : bucket) if (b != 0) return false;
    return true;
  }
}
