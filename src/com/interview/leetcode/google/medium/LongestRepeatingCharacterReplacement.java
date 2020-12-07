package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
==========================Problem Description===============================================================
Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
In one operation, you can choose any character of the string and change it to any other uppercase English character.
Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
=========================================================================================================
Input:
s = "ABAB", k = 2
Output:4

Input:
s = "AABABBA", k = 1
Output:4
====================================================Key Note on Solution========================================================
Make all letter as same letter(change all letters to mostFreqLetter or longest-repeating-character)
or in the current window or I need to "replace all letter other than" "mostFreqLetter".
If "replace count" or "letter count other than max freq letter" is <=k, Then window length can be max answer.
==========================================Logical Thinking on Solution===========================================================
1) Use a HashMap to count the frequency of each letter.
2) Iterate through the string to add one letter at a time to the window(window = right - left + 1)
3) Calculate windowCount and mostFreqLetterCount.
4) So "OtherLetterCount = windowCount-mostFreqLetterCount".
5) If "OtherLetterCount <= K" then current window is the answer.
6) Else Move Left(Shrink the Window.)
========================See Also MaxConsecutiveOnesIII=================================================================
Input: "ABC" K=50
for A, window = 1,  (1-1>50) = false.  longestRepeatingCharAfterReplacement=1
for B, window = 2,  (2-1>50) = false.  longestRepeatingCharAfterReplacement=2
for C, window = 3,  (3-1>50) = false.  longestRepeatingCharAfterReplacement=3
=========================================================================================================================
Input: "aabccbb", k=2 Ans:5
for a, window = 1(a),  (1-1>2) = false.  longestRepeatingCharAfterReplacement=window=1
		===mostFreqLetter = 2 ======
for a, window = 2(aa),    (2-2>2) = false.  longestRepeatingCharAfterReplacement=window=2
for b, window = 3(aab),   (3-2>2) = false.  longestRepeatingCharAfterReplacement=window=3
for c, window = 4(aabc),  (4-2>2) = false.  longestRepeatingCharAfterReplacement=window=4

for c, window = 5(aabcc), (5-2>2) = true.   Shrink Window by moving left.
Shrunk window = 4 (abcc).

for b, window = 5(abccb), (5-2>2) = true.
Shrunk window = 4 (bccb) longestRepeatingCharAfterReplacement=4.

       ===mostFreqLetter = 3 ======
for b, window = 5(bccbb), (5-3>2) = false.   longestRepeatingCharAfterReplacement=5
=========================================================================================================================
 */
public class LongestRepeatingCharacterReplacement {
  public int characterReplacement(String s, int k) {
    Map<Character, Integer> freq = new HashMap<>();
    int mostFreqLetterCount = 0;
    int longestRepeatingCharAfterReplacement = 0;
    for (int left = 0, right = 0; right < s.length(); right++) {
      char rightChar = s.charAt(right);
      int rightCharCount = freq.getOrDefault(rightChar, 0) + 1;
      freq.put(rightChar, rightCharCount);

      mostFreqLetterCount = Math.max(mostFreqLetterCount, rightCharCount);

      int window = right - left + 1;
      int otherLetterCount = window - mostFreqLetterCount;
      if (otherLetterCount <= k) {
        longestRepeatingCharAfterReplacement =
            Math.max(longestRepeatingCharAfterReplacement, window);
      } else {
        char leftChar = s.charAt(left);
        freq.put(leftChar, freq.get(leftChar) - 1);
        left++;
      }
    }
    return longestRepeatingCharAfterReplacement;
  }
}
