package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Input: ["flower","flow","flight"]  Output: "fl"

Input: ["dog","racecar","car"] Output: ""

Input: ["aa","a"] Output: "a"

Input: ["aa"] Output: "aa"
========================================================Solution Approach========================================================
1) Take the "firstWord" as "result".
2) Compare "firstWord" and "secondWord". Update firstWord.
3) Compare "firstWord" and "thirdWord". Update firstWord.
4) At any-point "resultSize" is zero. Return "Empty". Finally return "firstWord"
5) It works like BFS.
 */
public class LongestCommonPrefixBFS {

  public String longestCommonPrefixSimple(String[] strs) {
    if (strs.length == 0) return "";
    StringBuilder firstWord = new StringBuilder(strs[0]); // Take first string as result.
    for (int i = 1; i < strs.length; i++) {
      String current = strs[i];
      if (firstWord.length() > current.length())
        firstWord.delete(current.length(), firstWord.length());

      for (int j = 0; j < firstWord.length(); j++) {
        if (firstWord.charAt(j) == current.charAt(j)) continue;
        firstWord.delete(j, firstWord.length());
        if (firstWord.length() == 0) return "";
      }
    }
    return firstWord.toString();
  }
}
