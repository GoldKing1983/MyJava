package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/permutation-in-string

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
Verify if s1 has s2 permutation string. If yes true. Else false.

Ex: s1="abc" s2="cab"  Output: true
Ex: s1="abc" s2="abdc" Output: false
=============================================Solution Approach=============================================
1) Initialize freqMap with s1 "character" and its "count".
		=====Initial Window======
2) Form the Initial Window. Slide s2 from 0 to s1.length. If a match found. Decrement freqMap and increase matchCount.
3) If the matchCount == freqMap.size(). Return true Ex: s1=ab s2=abcd
		=====Shrink/EnLarge Window======
4) Keep left=0 and right=s1.length. Window length is always s1.length.
5) From the left, elements are removed out of window. So increment freqMap.
6) From the right, elements are added to window. So decrement freqMap.
7) If Increment/Decrement makes it value to 0. Increment MatchCount.
8) If the matchCount == freqMap.size. return true.

========================Example flow==================
Ex: s1="abc" s2="adcba" Output: True

		===Initial FreqMap values===
{a=1, b=1, c=1}

		===FreqMap values after Initial Window===
{a=0, b=1, c=0} matchCount=2

		===After Initial Window===
Left is at position: 0. Right is at position: 3
		===Start Sliding Window===
Left Char is: a. Right Char is: b
{a=1, b=0, c=0} matchCount=2

Left is at position: 1. Right is at position: 4
Left Char is: d. Right Char is: a
{a=0, b=0, c=0} matchCount=3. Return True.

================================================================================================
 */
public class PermutationInStringSlidingWindow {
  public boolean checkInclusion(String s1, String s2) {
    if (s2.length() < s1.length()) return false;
    int right = 0;
    int matchCount = 0;

    Map<Character, Integer> freqMap = new HashMap<>();
    for (Character c : s1.toCharArray()) freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

    // Forming initial Window.
    while (right < s1.length()) {
      Character rightChar = s2.charAt(right);
      if (freqMap.containsKey(rightChar)) {
        int countDecremented = freqMap.get(rightChar) - 1;
        freqMap.put(rightChar, countDecremented);
        if (countDecremented == 0) matchCount++;
      }
      right++;
    }
    if (matchCount == freqMap.size()) return true;

    // Shrink/EnLarge the Window.
    for (int left = 0; right < s2.length(); left++, right++) {
      Character leftChar = s2.charAt(left);
      Character rightChar = s2.charAt(right);
      if (freqMap.containsKey(leftChar)) {
        int leftCharCountIncremented = freqMap.get(leftChar) + 1; // removing from window so +
        freqMap.put(leftChar, leftCharCountIncremented);
        if (leftCharCountIncremented - 1 == 0) matchCount--;
      }
      if (freqMap.containsKey(rightChar)) {
        int rightCharCountDecremented = freqMap.get(rightChar) - 1; // adding to window so -
        freqMap.put(rightChar, rightCharCountDecremented);
        if (rightCharCountDecremented == 0) matchCount++;
      }
      if (matchCount == freqMap.size()) return true;
    }
    return false;
  }
}
