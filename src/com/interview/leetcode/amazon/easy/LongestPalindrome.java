package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

  public int longestPalindromeBucket(String s) {
    int[] lowerUpper = new int[52];
    int resultCount = 0;
    for (char c : s.toCharArray()) {
      if (Character.isLowerCase(c)) {
        lowerUpper[c - 'a']++;
      } else {
        lowerUpper[c - 'A' + 26]++;
      }
    }
    for (int i = 0; i < 52; i++) {
      int count = lowerUpper[i];
      resultCount = resultCount + (count % 2 == 0 ? count : count - 1);
    }
    for (int i = 0; i < 52; i++) {
      if (lowerUpper[i] % 2 != 0) return resultCount + 1;
    }
    return resultCount;
  }

  public int longestPalindrome(String s) {
    Set<Character> set = new HashSet<>();
    int result = 0;
    for (Character c : s.toCharArray()) {
      if (set.contains(c)) {
        set.remove(c);
        result = result + 2;
      } else {
        set.add(c);
      }
    }
    return set.isEmpty() ? result : result + 1;
  }

  public int longestPalindromeUsingMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int singleMax = 0;
    int result = 0;
    for (Integer i : map.values()) {
      if (i % 2 == 1) {
        result += i - 1;
        singleMax = 1;
      } else {
        result += i;
      }
    }
    return result + singleMax;
  }
}
