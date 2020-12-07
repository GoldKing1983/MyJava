package com.interview.leetcode.facebook.hard;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
====================================Logical Approach====================================
Step1: Identification of Initial Window
=====
1) Keep left and right pointer to 0.
2) Add "rightCharacter" to Map with its count. Because duplicate can occur.
3) window = right-left+1. Calculate window at each step.
Step2: Shrink the Window
=====
4) When map size exceeds K. Then decrement leftCharacter count from map.
5) If the "leftCharacter" count is 0. Then remove the element from map and window is balanced again. Otherwise keep shrink.

			"aabababcd"
			2
			Output: 7
			When loop reaches 'c'. It has to delete "aababa"


"aa"
2
Output:2

"ccaabbb"
2
Output:5 (aabbb)


 */
public class LongestSubstringWithAtMostKDistinctCharactersSlidingWindow {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int longest = 0;
    for (int left = 0, right = 0; right < s.length(); right++) {
      Character rightChar = s.charAt(right);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
      if (map.size() == k + 1) { // window crossed
        while (true) {
          Character leftChar = s.charAt(left++);
          map.put(leftChar, map.get(leftChar) - 1);
          if (map.get(leftChar) == 0) {
            map.remove(leftChar);
            break;
          }
        }
      }
      longest = Math.max(longest, right - left + 1);
    }
    return longest;
  }
}
