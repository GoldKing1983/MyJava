package com.interview.leetcode.topic.string;

import java.util.HashSet;
import java.util.Set;

public class CountDifferentPalindromicSubsequences {
  public int countPalindromicSubsequences(String S) {
    Set<String> set = new HashSet<>();
    palindromicSubsequences("", 0, S, set);
    return set.size() - 1;
  }

  private void palindromicSubsequences(String cur, int i, String s, Set<String> set) {
    if (i == s.length()) {
      if (isPal(cur)) set.add(cur);
      return;
    }
    palindromicSubsequences(cur, i + 1, s, set);
    palindromicSubsequences(cur + s.charAt(i), i + 1, s, set);
  }

  private boolean isPal(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r && s.charAt(l) == s.charAt(r)) {
      l++;
      r--;
    }
    return l >= r;
  }
}
