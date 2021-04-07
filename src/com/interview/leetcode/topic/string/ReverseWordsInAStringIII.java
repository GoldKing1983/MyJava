package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInAStringIII {
  public String reverseWords(String s) {

    StringBuilder result = new StringBuilder();
    int n = s.length();
    StringBuilder currentString = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char currentChar = s.charAt(i);
      if (currentChar == ' ') { // reverse and add it to result.
        currentString.reverse();
        if (result.length() != 0) result.append(" ");
        result.append(currentString);
        currentString = new StringBuilder();
      } else {
        currentString.append(currentChar);
      }
    }

    // for the last word 
    currentString.reverse();
    if (result.length() != 0) result.append(" ");
    result.append(currentString);

    return result.toString();
  }

}
