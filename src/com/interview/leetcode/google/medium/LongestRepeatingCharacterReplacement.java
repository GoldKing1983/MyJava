package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-repeating-character-replacement/
===========================================================Requirement===========================================================
1) Given a string s that consists of only uppercase English letters, 
2) You are allowed replace at most k characters on that string.
3) Find the length of longestSubString that all characters are same.
============================================================Example1=============================================================
Input:
s = "ABAB", k = 2
Output:4
============================================================Example2=============================================================
Input:
s = "AABABBA", k = 1
Output:4
========================================================Logical Thinking=========================================================
1) In the current window, make all letter as same letter(change otherLetterCount to mostFreqLetter)
2) If "otherLetterCount" is <=k. Then window length can be max answer.
========================================================Solution Approach========================================================
Expand         : Always by 1. 
Shrink         : when OtherLetterCount > K.  Shrink by 1 only. 
Capture Result : when OtherLetterCount <= K

1) Find mostFreqLetterCount at each step.
2) So "OtherLetterCount = currentWindowSize-mostFreqLetterCount".
3) If "OtherLetterCount <= K" then current window is the answer.
4) Else Move Left(Shrink the Window.)
=======================================================Data Flow Analysis========================================================
Input: "aabccbb", k=2 Ans:5

for a, currentWindowSize = 1(a),     otherLetterCount=0. resultCount=1
for a, currentWindowSize = 2(aa),    otherLetterCount=0. resultCount=2
for b, currentWindowSize = 3(aab),   otherLetterCount=1. resultCount=3
for c, currentWindowSize = 4(aabc),  otherLetterCount=2. resultCount=4

for c, currentWindowSize = 5(aabcc), otherLetterCount=3. 
Shrink Window by moving left. currentWindowSize =4(abcc).

for b, currentWindowSize = 5(abccb), otherLetterCount=3.
Shrink Window by moving left. currentWindowSize =4 (bccb). 

for b, currentWindowSize = 5(bccbb), otherLetterCount=2. resultCount=5
========================See Also MaxConsecutiveOnesIII=================================================================
Input: "ABC" K=50
for A, window = 1,  (1-1>50) = false.  longestRepeatingCharAfterReplacement=1
for B, window = 2,  (2-1>50) = false.  longestRepeatingCharAfterReplacement=2
for C, window = 3,  (3-1>50) = false.  longestRepeatingCharAfterReplacement=3
=========================================================================================================================
 */
public class LongestRepeatingCharacterReplacement {
  public int characterReplacement(String s, int k) {
    Map<Character, Integer> freq = new HashMap<>();
    int mostFreqLetterCount = 0;
    int resultCount = 0;
    for (int left = 0, right = 0; right < s.length(); right++) {
      char rightChar = s.charAt(right);
      int rightCharCount = freq.getOrDefault(rightChar, 0) + 1;
      freq.put(rightChar, rightCharCount);

      mostFreqLetterCount = Math.max(mostFreqLetterCount, rightCharCount);

      int currentWindowSize = right - left + 1;
      int otherLetterCount = currentWindowSize - mostFreqLetterCount; // replaceCount
      if (otherLetterCount <= k) { // Shrink
        resultCount = Math.max(resultCount, currentWindowSize);
      } else { // Shrink
        char leftChar = s.charAt(left);
        freq.put(leftChar, freq.get(leftChar) - 1);
        left++;
      }
    }
    return resultCount;
  }
}
