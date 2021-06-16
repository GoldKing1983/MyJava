package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;
import java.util.Collections;

/*
https://leetcode.com/problems/reverse-words-in-a-string/description/
===========================================================Requirement===========================================================
1) Given an input string s, reverse the order of the words.
2) Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
3) You need to reduce multiple spaces between two words to a single space in the reversed string.

============================================================Example1=============================================================
Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:
============================================================Example2=============================================================
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
========================================================Solution Approach========================================================
step 1: reverse the whole string
step 2: reverse each word
step 3: clean up spaces
 */
public class ReverseWordsInAStringExcludeSpacesBetter {

  public String reverseWords(String s) {
    // s=null or s="   " return ""
    if (s == null || s.trim().length() == 0) return "";

    // trim first and last spaces.
    s = s.trim();
    // split by one or more spaces. Ex: "hello      test"... words=[hello,test]
    String[] words = s.split(" +");
    int n = words.length;

    StringBuilder sb = new StringBuilder();

    sb.append(words[n - 1]); // append the last word to result

    for (int i = n - 2; i >= 0; i--) { // append n-2 to 0th word to result with space
      sb.append(" ");
      sb.append(words[i]);
    }

    return sb.toString();
  }

  public static String reverseWordsJavaUtility(String s) {
    // RegEx to split string by one or more spaces.
    String[] words = s.trim().split(" +");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
  }

}
