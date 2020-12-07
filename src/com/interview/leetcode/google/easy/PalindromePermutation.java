package com.interview.leetcode.google.easy;

import java.util.HashSet;
import java.util.Set;

/*
 Given a string, determine if re-arranging characters of the string could form a palindrome.

Solution is simple:
1) For even number of character....To be a palindrome, every character should occur even. Set size will be 0.
2) For odd number of character....To be a palindrome, every character should occur even and one character can occur once.
So set size will be 1.


For example:
"code" -> False,
"aab" -> True,
"carerac" -> True. (ccaarre)
 */

public class PalindromePermutation {
  public static boolean canPermutePalindrome(String s) {
    Set<Character> set = new HashSet<>();
    for (Character c : s.toCharArray()) {
      if (set.contains(c)) set.remove(c);
      else set.add(c);
    }
    return set.size() <= 1; // For Odd character palindrome
  }

  public boolean canPermutePalindromeBetter(String s) {
    int[] map = new int[128];
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i)]++;
    }
    int count = 0;
    for (int key = 0; key < map.length && count <= 1; key++) {
      count += map[key] % 2;
    }
    return count <= 1;
  }
}
