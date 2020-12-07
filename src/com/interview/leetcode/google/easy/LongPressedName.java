package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/long-pressed-name/

This problem is an simple logical problem. If initial thinking solution is wrong, then need to add lot of if-else,
which will pull more cases and finally no output.

Input: name = "a", typed = "aa"
Output: true

Input: name = "aa", typed = "a"
Output: false

Input: name = "a", typed = "ab"
Output: false

Input: name = "ab", typed = "aa"
Output: false

=========================================================Solution Approach=================================================
Step1) Pick the character from nameStr  at index "n", lets say "nameStrChar".
Step2) Pick the character from typedStr at index "t", lets say "typedStrChar".
Step3) If both are different, return false.
Step4) Else, We confirmed both the chars are same. Now we need to check for count
Step5) Count the "numberOfTimes" the "nameStrChar" is appearing in nameString, lets say nameStrCharCount.
Step6) Count the "numberOfTimes" the "nameStrChar" is appearing in typedString, lets say typedStrCharCount.
Step7) if (nameStrCharCount > typedStrCharCount) return false;
Step8) Finally both length should reached till the end else return false.
===========================================================================================================================

 */
public class LongPressedName {
  public boolean isLongPressedName(String nameStr, String typedStr) {
    int n = 0, t = 0;
    while (n < nameStr.length() && t < typedStr.length()) {
      char nameStrChar = nameStr.charAt(n++);
      char typedStrChar = typedStr.charAt(t++);
      if (nameStrChar != typedStrChar) return false;

      int nameStrCharCount = 1;
      while (n < nameStr.length()) {
        if (nameStrChar != nameStr.charAt(n)) break;
        n++;
        nameStrCharCount++;
      }

      int typedStrCharCount = 1;
      while (t < typedStr.length()) {
        if (typedStr.charAt(t) != typedStrChar) break;
        typedStrCharCount++;
        t++;
      }
      if (nameStrCharCount > typedStrCharCount) return false;
    }
    // For Case "ab", "aa". Here n size will be 1 and t size will be 2
    if (n != nameStr.length()) return false;
    // For Case "a", "ab". Here n size will be 1 and t size will be 1
    if (t != typedStr.length()) return false;
    return true;
  }
}
