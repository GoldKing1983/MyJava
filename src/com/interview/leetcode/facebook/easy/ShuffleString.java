package com.interview.leetcode.facebook.easy;

import java.util.Map;
import java.util.TreeMap;

public class ShuffleString {
  public String restoreString(String s, int[] indices) {
    Map<Integer, Character> map = new TreeMap<>();
    int i = 0;
    for (Integer index : indices) {
      map.put(index, s.charAt(i++));
    }
    StringBuilder result = new StringBuilder();
    for (Character c : map.values()) {
      result.append(c);
    }
    return result.toString();
  }
}
