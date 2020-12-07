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

s = "foobaa", return "fb"



========================================================Solution Approach========================================================
1) Both different -->  writePtr++ and moveReadPtrDataToWritePtrData and readPtr++.
2) Both same --> writePtr-- and readPtr++.

input: "foobaa" output: "fb"

wr
 foobaa

 wr 
 foobaa

 wr
foobaa

w  r
foobaa

 w  r
fbobaa

  w  r 
fbabaa

 w    r 
fbabaa

 */
public class RemoveAllAdjacentDuplicatesInStringBest {
  public String removeDuplicates(String inputStr) {
    char[] result = inputStr.toCharArray();
    int write = -1, read = 0, n = result.length;
    while (read < n) {
      if (write >= 0 && result[write] == result[read]) {
        write--;
      } else {
        write++;
        result[write] = result[read];
      }
      read++;
    }
    return String.valueOf(result, 0, write + 1);
  }
}
