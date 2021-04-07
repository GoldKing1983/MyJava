package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
===========================================================Requirement===========================================================
Input: "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
and this is the only possible move.  The result of this move is that the string is "aaca",
of which only "aa" is possible, so the final string is "ca".
========================================================Solution Approach========================================================
1) Instead of adding String to charArray or linkedList and then parsing
2) Add it StringBuilder or String


 */
public class RemoveAllAdjacentDuplicatesInString {

  // 16 ms. better
  //1) If current and previous match and remove previous
  //2) If current and previous don't match, add the current to stringBuilderResult.
  public String removeDuplicatesBetter(String input) {
    StringBuilder result = new StringBuilder();
    for (char currentChar : input.toCharArray()) {
      if (result.length() == 0) {
        result.append(currentChar);
        continue;
      }
      char previousChar = result.charAt(result.length() - 1);
      if (currentChar == previousChar) {
        result.deleteCharAt(result.length() - 1);
      } else {
        result.append(currentChar);
      }
    }
    return result.toString();
  }


}
