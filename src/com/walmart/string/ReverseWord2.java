package com.walmart.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Input: "  world! hello  "
 * Output: "world! hello"
* =========== Solution Approach========
1) Parse individual character and create list of words.
2) Put last word in first. Go on.
*/
public class ReverseWord2 {

  public String reverseWords(String s) {
    List<String> words = new ArrayList<>();
    removeSpacesAndMoveWordsToList(s, words);
    StringBuilder sb = new StringBuilder();

    for (int i = words.size() - 1; i >= 0; i--) {
      sb.append(words.get(i));
      if (i > 0) sb.append(" ");
    }
    return sb.toString();
  }

  private void removeSpacesAndMoveWordsToList(String s, List<String> ls) {
    StringBuilder sb = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (c == ' ') {
        if (sb.length() == 0) continue;
        ls.add(sb.toString());
        sb = new StringBuilder();
      } else sb.append(c);
    }
    // For the last word
    if (sb.length() > 0) ls.add(sb.toString());
  }
}
