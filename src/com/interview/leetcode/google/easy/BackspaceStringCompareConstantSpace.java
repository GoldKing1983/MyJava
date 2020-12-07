package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/backspace-string-compare/description/
==================================================================================================================================
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
========================================================Solution Approach========================================================
1) Take 2 Pointer ptr1 points inputString1 and ptr2 points inputString2.
2) Scan from Last.
3) Make the pointer stand on "character".
		Ex: "#c"   -> ptr stands on index 1.
		Ex: "c#"   -> ptr stands on index -1.
		Ex: "cc#"  -> ptr stands on index 0.
4) Compare ptr1 character with ptr2 character. If they differ return false.
=================================================================================================================================
 */
public class BackspaceStringCompareConstantSpace {
  public boolean backspaceCompare(String S, String T) {
    int count1 = 0;
    int count2 = 0;
    for (int ptr1 = S.length() - 1, ptr2 = T.length() - 1; ptr1 >= 0 || ptr2 >= 0; ptr1--, ptr2--) {
      while (ptr1 >= 0 && (count1 != 0 || S.charAt(ptr1) == '#')) {
        if (S.charAt(ptr1) == '#') count1++;
        else count1--;
        ptr1--;
      }
      while (ptr2 >= 0 && (count2 != 0 || T.charAt(ptr2) == '#')) {
        if (T.charAt(ptr2) == '#') count2++;
        else count2--;
        ptr2--;
      }
      if (ptr1 < 0 && ptr2 < 0) return true;
      if (ptr1 < 0 || ptr2 < 0) return false;
      if (S.charAt(ptr1) != T.charAt(ptr2)) return false;
    }
    return true;
  }
}
