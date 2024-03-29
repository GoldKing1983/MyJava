package com.interview.leetcode.topic.math;

/*

Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:
Input: columnNumber = 1
Output: "A"

Example 2:
Input: columnNumber = 28
Output: "AB"



 */
public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    if (n <= 0) return "";
    StringBuilder ret = new StringBuilder();
    while (n-- > 0) {
      ret.append((char) ('A' + (n % 26)));
      n /= 26;
    }
    return ret.reverse().toString();
  }
}
