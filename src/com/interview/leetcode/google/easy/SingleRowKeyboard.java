package com.interview.leetcode.google.easy;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/single-row-keyboard/

Same Logic as "SingleRowKeyboardArray", used map.

*/
public class SingleRowKeyboard {
  public int calculateTime(String keyboard, String word) {
    Map<Character, Integer> map = new HashMap<>();
    int prevIndex = 0;
    for (Character c : keyboard.toCharArray()) {
      map.put(c, prevIndex++);
    }
    // for a 1 character word answer is 0.
    int count = 0;
    prevIndex = 0; // Logically it can be 0. map[keyboard.charAt(0) - 'a'];
    for (char ch : word.toCharArray()) {
      int currIndex = map.get(ch);
      int diff = Math.abs(currIndex - prevIndex);
      prevIndex = currIndex;
      count += diff;
    }
    return count;
  }
}
