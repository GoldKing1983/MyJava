package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/first-unique-character-in-a-string/

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.


1) Update the frequency of each character.
2) Return first character that has a frequency of one.

 */
public class FirstUniqueCharacterInAString {
  public int firstUniqChar(String s) {
    int[] bucket = new int[26];
    for (char c : s.toCharArray()) bucket[c - 'a']++;

    int i = 0;
    for (char c : s.toCharArray()) {
      if (bucket[c - 'a'] == 1) return i;
      i++;
    }
    return -1;
  }
}
