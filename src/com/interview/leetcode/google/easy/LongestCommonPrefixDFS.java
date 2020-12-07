package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Input: ["flower","flow","flight"]  Output: "fl"

Input: ["dog","racecar","car"] Output: ""

Input: ["aa","a"] Output: "a"

========================================================Solution Approach========================================================
1) Take the "firstWord" as "result".
2) Pick the "firstWords" "firstCharacter"  and compare with "restOfWords" "firstCharacter".
3) Pick the "firstWords" "secondCharacter" and compare with "restOfWords" "secondCharacter".
4) At any-point, there is a mismatch in comparism, return "firstWord.substring(0, index)"
5) This works like DFS.
 */
public class LongestCommonPrefixDFS {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    int index = 0;
    String firstWord = strs[0]; // Take first string as result.
    while (true) {
      if (firstWord.length() == index) return firstWord.substring(0, index);
      char c = firstWord.charAt(index);
      for (int i = 1; i < strs.length; i++) {
        // If Second string is short. Return result
        if (strs[i].length() == index) return firstWord.substring(0, index);
        if (c == strs[i].charAt(index)) continue;
        return firstWord.substring(0, index); // If Second string not matches. Return result
      }
      index++;
    }
  }
}
