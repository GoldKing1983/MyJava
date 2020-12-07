package com.walmart.string;

/*
https://leetcode.com/problems/reverse-words-in-a-string/
 
Input: "  world! hello  "
Output: "world! hello"
* =========== Approach ========
1) Split words by empty.
2) Put last word in first. Go on.
3) Multiple empties will create blank. Skip those.
*/
public class ReverseWord {

  // Solution Approach 2
  public String reverseWords(String s) {
    if (s == null || s.length() == 0) return "";

    String[] words = s.split(" ");
    StringBuilder sb = new StringBuilder();

    for (int i = words.length - 1; i >= 0; i--) {
      // "blue is    sky" input will create some "". So skip those.
      if (words[i].equals("")) continue;
      sb.append(" ");
      sb.append(words[i]);
    }

    return sb.toString().trim();
  }
}
