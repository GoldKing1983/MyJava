package com.interview.leetcode.google.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/confusing-number/
 */
public class ConfusingNumber {
  public boolean confusingNumber(int N) {
    Map<Character, Character> map = new HashMap<>();
    map.put('6', '9');
    map.put('9', '6');
    map.put('0', '0');
    map.put('1', '1');
    map.put('8', '8');

    String s = Integer.toString(N);
    int len = s.length();
    StringBuilder reversedString = new StringBuilder(s);
    for (int i = 0; i < len; i++) {
      if (!map.containsKey(map.get(s.charAt(i)))) return false;
      reversedString.setCharAt(i, map.get(s.charAt(i)));
    }
    int reversedNumber = Integer.parseInt(reversedString.reverse().toString());
    return N != reversedNumber;
  }
}
