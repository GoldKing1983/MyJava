package com.interview.leetcode.google.medium;

import java.util.Arrays;

/*

Requirement : Given a string S, find out the length of the longest repeating substring(s).
Return 0 if no repeating substring exists.

Input: "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.

Input: "abbabba"
Output: 4
Explanation: The longest repeating substrings are "abba" and "abba",

Input: "banana"
Output: 3
Explanation: The longest repeating substrings are "ana" and "ana",

===========================Solution Approach- Time Complexity-O (n^2 log n)===================================================
1) Get n suffix of the string. "abc" -> "abc","bc","c"
2) Then sort them.
3) If have two String has common prefix, they must be neighbors. for loop them find longest common prefix.
======================================================Data Flow Analysis======================================================
Input: "banana" Output: 3

str = banana, its suffixes are:
banana
anana
nana
ana
na
a

after sort, the suffix array looks like:
a
ana
anana
banana
na
nana

"ana" and "anana" matches the highest length in when comparing current and previous. So return 3.
=============================================================================================================================

 */
public class LongestRepeatingSubstring {
  public int longestRepeatingSubstring(String s) {
    int n = s.length();
    String[] suffix = new String[n]; // all strings in suffix[] has different starting position
    for (int i = 0; i < n; i++) {
      suffix[i] = s.substring(i);
    }
    Arrays.sort(suffix); // lexicographic order
    int res = 0;
    for (int i = 1; i < n; i++) {
      String prevString = suffix[i - 1], currString = suffix[i];
      int maxLength = Math.min(prevString.length(), currString.length());
      for (int currLength = 0; currLength < maxLength; currLength++) {
        if (prevString.charAt(currLength) != currString.charAt(currLength)) break;
        res = Math.max(res, currLength + 1); // length starts from 0. So add 1
      }
    }
    return res;
  }
}
