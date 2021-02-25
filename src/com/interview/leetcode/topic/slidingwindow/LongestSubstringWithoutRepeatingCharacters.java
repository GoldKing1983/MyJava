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
1) Record unique character in HashSet.
2) Initially left=0, right will be moved.
3) If duplicate not found, add it to Set. window=(right-left+1)  or set.size().
4) If duplicate found, then move left to "previousIndexOfDuplicate" + 1.

Using array to track count is difficult, because input can contain 128 ASCII characters .
*/

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    int maxWindow = 0;
    Set<Character> set = new HashSet<>();
    for (int left = 0, right = 0; right < s.length(); right++) {
      char rightChar = s.charAt(right);
      if (set.contains(rightChar)) { // duplicate. shrink window.
        char leftChar = s.charAt(left);
        while (leftChar != rightChar) {
          set.remove(leftChar);
          left++;
          leftChar = s.charAt(left);
        }
        left++; // shrink to "previous index of duplicate" + 1.
      } else {
        set.add(rightChar);
        maxWindow = Math.max(set.size(), maxWindow);
      }
    }
    return maxWindow;
  }
}
