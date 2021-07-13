package com.interview.leetcode.topic.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
===========================================================Requirement===========================================================
1) Given a string, 
2) find the length of the longest substring without repeating characters.
3) Constraints : Input can contain "English letters, digits, symbols and spaces".

"abcad" output:4 ("bcad")
"abcbad" output:4 ("cbad")
======================================================Solution Approach======================================================
Expand : Always by 1-index.
Shrink : When a duplicate found. Shrink One or more, so while loop
Capture Result : During Expand only

1) Record unique character or slidingWindow in HashSet.
2) Initially left=0, right=0 and right will be moved.
3) right will be keep moving. left is stagnant and moves when duplicate occurs.
4) Add currentChar or rightChar to slidingWindowSet. 
5) If slidingWindowSet contains the rightChar already, it return false i.e duplicate found
6) If duplicate found, then move left to "previousIndexOfDuplicate" + 1.

Using array to track count is difficult, because input can contain 128 ASCII characters .
=======================================================Data Flow Analysis========================================================
input: bacad output:3
  
  l  r 
  bacad

at index3 rightChar and leftChar matches.
move leftChar by 2Index 
    lr 
  bacad

    l r 
  bacad

*/

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstringStep1(String s) {
    Set<Character> window = new HashSet<>();
    int left = 0, right = 0, n = s.length();
    int maxWindowResult = 0;
    while (right < n) {
      char rightChar = s.charAt(right++);
      if (window.contains(rightChar)) { // Shrink. Ex: aba or baa...Shrink happens at index2 

      } else { // Expand
        // Capture maxWindowResult
      }
    }
    return maxWindowResult;
  }

  public int lengthOfLongestSubstring(String s) {
    Set<Character> window = new HashSet<>();
    int left = 0, right = 0, n = s.length();
    int maxWindowResult = 0;
    while (right < n) {
      char rightChar = s.charAt(right++);
      if (window.contains(rightChar)) { // Shrink
        while (true) { // roll till leftChar == rightChar
          char leftChar = s.charAt(left);
          left++; // Ex: aa... left=0... move left to 1...
          if (leftChar == rightChar) break;
          window.remove(leftChar);
        }
      } else { // Expand
        window.add(rightChar);
        maxWindowResult = Math.max(maxWindowResult, window.size());
      }
    }
    return maxWindowResult;
  }
}
