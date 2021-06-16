package com.interview.leetcode.linkedin.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.

1) Map the source character to destination character in a HashMap.
2) If it is not matching return false.
3) Do Step1 and Step2 for String1 as source and String2 as destination and vice versa.

===================Why we need to do for both sides==========================================
compare str1, str2
str1 = "ab"
str2 = "aa"

 map[]
 a alternate is a
 map[a,a]
 b alternate is b
 map[b,a]

true on comparing str1, str2 

compare str1, str2 with reversed
str1 = "aa"
str2 = "ab"

 map[]
 a alternate is a
 map[a,a]
 a alternate is a... b cannot come. return false.
===============================================================================================
 */
public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    return isMatched(s, t) && isMatched(t, s);
  }

  public boolean isMatched(String str1, String str2) {
    Map<Character, Character> alternate = new HashMap<>();
    for (int i = 0; i < str1.length(); i++) {
      char c1 = str1.charAt(i);
      char c2 = str2.charAt(i);
      if (alternate.containsKey(c1)) {
        if (alternate.get(c1) != c2) return false;
      } else {
        alternate.put(c1, c2);
      }
    }

    return true;
  }

  public boolean isIsomorphicBestApproach(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    Set<Character> occupied = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      if (map.containsKey(sChar)) {
        char replacedSChar = map.get(sChar);
        if (tChar == replacedSChar) continue;
        return false;
      }
      if (occupied.contains(tChar)) return false;
      map.put(sChar, tChar);
      occupied.add(tChar);
    }
    return true;
  }
}
