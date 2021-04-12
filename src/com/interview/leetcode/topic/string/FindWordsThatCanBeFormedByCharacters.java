package com.interview.leetcode.topic.string;

import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters {
  public int countCharacters(String[] words, String chars) {
    int[] bucket = new int[26];
    for (int i = 0; i < chars.length(); i++) {
      char c = chars.charAt(i);
      bucket[c - 'a']++;
    }
    int resultCount = 0;
    for (String word : words) {
      int[] tempBucket = Arrays.copyOf(bucket, 26);
      boolean isComplete = true;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (--tempBucket[c - 'a'] < 0) {
          isComplete = false;
          break;
        }
      }
      if (isComplete) resultCount += word.length();
    }
    return resultCount;
  }
}
