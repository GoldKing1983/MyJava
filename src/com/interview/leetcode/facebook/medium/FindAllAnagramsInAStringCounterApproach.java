package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/

Same code as PermutationInStringCounterApproach. Instead of returning true, when a pattern found.
This code, keep go all the way and record "startOfPattern".

*/
public class FindAllAnagramsInAStringCounterApproach {
  public List<Integer> findAnagrams(String input, String pattern) {
    int inputLength = input.length(), patternLength = pattern.length();
    List<Integer> result = new ArrayList<>();
    if (patternLength > inputLength) return result;

    int[] freqMap = new int[26];
    for (int i = 0; i < patternLength; i++) {
      freqMap[pattern.charAt(i) - 'a']--;
      freqMap[input.charAt(i) - 'a']++;
    }
    if (allZero(freqMap)) result.add(0);
    for (int left = 0, right = patternLength; right < inputLength; left++, right++) {
      freqMap[input.charAt(left) - 'a']--;
      freqMap[input.charAt(right) - 'a']++;
      if (allZero(freqMap)) result.add(left + 1);
    }

    return result;
  }

  private boolean allZero(int[] freqMap) {
    for (int i = 0; i < 26; i++) if (freqMap[i] != 0) return false;
    return true;
  }
}
