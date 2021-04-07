package com.interview.leetcode.amazon.easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveVowelsFromAString {
  public String removeVowels(String S) {
    char[] result = new char[S.length()];
    int i = 0;
    for (char c : S.toCharArray()) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
      result[i++] = c;
    }
    return new String(result).substring(0, i);
  }

  public String removeVowelsUsingSet(String s) {
    char[] result = new char[s.length()];
    Set<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    int resultIndex = 0;
    for (char c : s.toCharArray()) {
      if (vowels.contains(c)) continue;
      result[resultIndex] = c;
      resultIndex++;
    }
    return new String(result).substring(0, resultIndex);
  }
}
