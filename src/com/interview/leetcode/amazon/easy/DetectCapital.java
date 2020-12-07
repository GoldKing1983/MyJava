package com.interview.leetcode.amazon.easy;
/*
https://leetcode.com/problems/detect-capital/

 */
public class DetectCapital {
  public boolean detectCapitalUse(String word) {
    if (word == null || word.length() <= 1) return true;
    // When seeing lowerCase only 1 case is possible. After that all low.
    if (Character.isLowerCase(word.charAt(0))) return isAllLowerCase(word);

    // When seeing upperCase 2 cases are possible. After that all low or all high.

    // If second char is lowerCase, then all next should be lowerCase
    if (Character.isLowerCase(word.charAt(1))) return isAllLowerCase(word);

    // If second char is upperCase, then all next should be upperCase
    for (int i = 2; i < word.length(); i++) {
      if (Character.isLowerCase(word.charAt(i))) return false;
    }
    return true;
  }

  private boolean isAllLowerCase(String word) {
    // not verifying 0th character
    for (int i = 1; i < word.length(); i++) {
      if (Character.isUpperCase(word.charAt(i))) return false;
    }
    return true;
  }
}
