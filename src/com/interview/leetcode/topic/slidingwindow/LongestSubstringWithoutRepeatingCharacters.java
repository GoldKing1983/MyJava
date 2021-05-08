package com.interview.leetcode.topic.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without repeating characters.
Input can contain "English letters, digits, symbols and spaces".

"abcad" output:4 ("bcad")
"abcbad" output:4 ("cbad")
======================================================Solution Approach======================================================
1) Record unique character or slidingWindow in HashSet.
2) Initially left=0, right=0 and right will be moved.
3) right will be keep moving. left is stagnant and moves when duplicate occurs.
4) Add currentChar or rightChar to slidingWindowSet. 
  If slidingWindowSet contains the rightChar already, it return false i.e duplicate found
5) If duplicate found, then move left to "previousIndexOfDuplicate" + 1.

Using array to track count is difficult, because input can contain 128 ASCII characters .
*/

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    int maxWindow = 0, left = 0;
    Set<Character> slidingWindowSet = new HashSet<>();
    for (char rightChar : s.toCharArray()) {
      boolean isUnique = slidingWindowSet.add(rightChar);
      if (!isUnique) { // duplicate. shrink window.
        char leftChar = s.charAt(left);
        while (leftChar != rightChar) {
          slidingWindowSet.remove(leftChar);
          left++;
          leftChar = s.charAt(left);
        }
        left++; // Ex: aa... left=0... move left to 1...
      }
      maxWindow = Math.max(slidingWindowSet.size(), maxWindow);

    }
    return maxWindow;
  }
}
