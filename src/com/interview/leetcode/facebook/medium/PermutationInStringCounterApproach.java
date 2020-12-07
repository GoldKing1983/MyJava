package com.interview.leetcode.facebook.medium;

/*
https://leetcode.com/problems/permutation-in-string/

=======================Solution Approach=====Counter Approach=============
	======================InitialWindow==========process both inputString and patternString============
1) Simple Math... Decrement the PatternString and Increment the InputString.
2) Verify allZero. Result can be formed at InitialWindow. Ex : input="abc" pattern="cab"
	======================SlidingWindow===========process only inputString===========
1) From Left Elements are removed, so decrement.
2) From Right Elements are added, so increment.
3) Verify allZero.
=====================================================================================================================
 */
public class PermutationInStringCounterApproach {
  public boolean checkInclusion(String pattern, String input) {
    int inputLength = input.length(), patternLength = pattern.length();
    if (patternLength > inputLength) return false;

    int[] freqMap = new int[26];
    for (int i = 0; i < patternLength; i++) {
      freqMap[pattern.charAt(i) - 'a']--;
      freqMap[input.charAt(i) - 'a']++;
    }
    if (allZero(freqMap)) return true;
    for (int left = 0, right = patternLength; right < inputLength; left++, right++) {
      freqMap[input.charAt(left) - 'a']--;
      freqMap[input.charAt(right) - 'a']++;
      if (allZero(freqMap)) return true;
    }

    return false;
  }

  private boolean allZero(int[] freqMap) {
    for (int i = 0; i < 26; i++) if (freqMap[i] != 0) return false;
    return true;
  }
}
