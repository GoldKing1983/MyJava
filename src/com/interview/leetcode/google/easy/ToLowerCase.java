package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/to-lower-case/

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Input: "Hello"
Output: "hello"

Input: "here"
Output: "here"

Input: "LOVELY"
Output: "lovely"


 */
public class ToLowerCase {
  public String toLowerCase(String str) {
    StringBuilder result = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (Character.isUpperCase(c)) {
        int index = c - 'A';
        char lowerCaseLetter = (char) ('a' + index);
        result.append(lowerCaseLetter);
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }
}
