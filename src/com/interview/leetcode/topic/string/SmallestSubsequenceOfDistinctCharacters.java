package com.interview.leetcode.topic.string;

public class SmallestSubsequenceOfDistinctCharacters {
  public String smallestSubsequence(String text) {
    int n = text.length();
    int[] arr = new int[n];
    int k = -1;
    int[] lastpos = new int[26];
    for (int i = 0; i < n; i++) lastpos[text.charAt(i) - 'a'] = i;

    boolean[] alpha = new boolean[26];
    for (int i = 0; i < n; i++) {
      int currentCharIndex = text.charAt(i) - 'a';
      if (alpha[currentCharIndex]) continue;
      while (k >= 0 && arr[k] > currentCharIndex && lastpos[arr[k]] > i) {
        alpha[arr[k]] = false;
        k--;
      }
      arr[++k] = currentCharIndex;
      alpha[currentCharIndex] = true;
    }
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i <= k; i++) ans.append((char) ('a' + arr[i]));
    return ans.toString();
  }

}
