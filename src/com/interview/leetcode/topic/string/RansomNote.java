package com.interview.leetcode.topic.string;

public class RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] bucket = new int[26];
    for (char c : magazine.toCharArray()) bucket[c - 'a']++;

    for (char c : ransomNote.toCharArray()) {
      bucket[c - 'a']--;
      if (bucket[c - 'a'] < 0) return false;
    }
    return true;
  }
}
