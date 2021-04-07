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



1) Solution is similar to stack approach.
2) If stack is notEmpty and stackSize is 2 or more, compare current and previous.
3) If both are same. remove previous


==========Note if both are same. from 1 it goes to 2. Else it goes to 0. that is the trick. +2 or -2
Ex: aa
write = 0
write = 1
      current and previous are same. 
      write goes to 0.

Ex: ab
write = 0
write = 1
      current and previous are different. 
      write goes to 2.

 */
public class RemoveAllAdjacentDuplicatesInStringBest {
  public String removeDuplicates(String S) {
    if (S == null || S.length() == 0) return S;
    int write = 0;
    int n = S.length();
    char[] result = new char[n];

    for (int read = 0; read < n; read++) {
      result[write] = S.charAt(read);
      if (write <= 0) { // less than or equal to 1  element exists in result. So no compare possible
        write++;
      } else if (result[write] == result[write - 1]) {
        write--;
      } else {
        write++;
      }
    }
    return new String(result, 0, write);
  }
}
