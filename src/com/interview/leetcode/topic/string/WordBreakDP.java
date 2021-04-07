package com.interview.leetcode.topic.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Almost Same logic as WordBreakQueue

When a match happens, in WordBreakQueue we put the suffixString in queue, here we set dp[j] to true. that is the only
difference.

In WordBreakQueue we fetch values from queue, here which ever index is true, we pick the following substring
=====================================================Time Complexity=============================================================
O(n^3). Note: "not exponential".
=================================================================================================================================
 */
public class WordBreakDP {

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dictionary = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length()];
    int n = s.length();

    for (int i = 0; i < n; i++) {
      if (dp[i] || i == 0) {
        for (int j = i + 1; j <= n; j++) {
          String prefixString = s.substring(i, j);
          if (dictionary.contains(prefixString)) {
            if (j == n) return true;
            dp[j] = true;
          }
        }
      }
    }
    return false;
  }

}
