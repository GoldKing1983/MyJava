package com.interview.leetcode.amazon.easy;

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
}
