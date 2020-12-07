package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/valid-anagram/

Given two strings s and t , write a function to determine if t is an anagram of s.
Constraint : Input is only lowerCase alphabet.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

========================================================Solution Approach========================================================
1) Do a bucket sort
2) Loop1: Increment bucket for inputString1. Decrement bucket for inputString2
3) Loop2: If any bucketIndexValue != 0 return false.

 */
public class ValidAnagram {

  public boolean isAnagram(String inputString1, String inputString2) {
    if (inputString1.length() != inputString2.length()) return false;
    int[] bucket = new int[26];
    int n = inputString1.length();
    for (int i = 0; i < n; i++) {
      int index1 = inputString1.charAt(i) - 'a';
      bucket[index1]++;

      int index2 = inputString2.charAt(i) - 'a';
      bucket[index2]--;

    }

    for (int i = 0; i < 26; i++) if (bucket[i] != 0) return false;
    return true;
  }
}
