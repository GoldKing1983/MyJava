package com.interview.leetcode.google.medium;

import java.util.HashSet;

/*
https://leetcode.com/problems/number-of-good-ways-to-split-a-string

input: acbabab
    a  cbabab
    =  ======
    
    ac babab
    == =====
    
    acb abab
    === ====

    acba bab
    ==== ===

    acbab ab
    ===== ==

    acbaba b
    ====== =

 */
public class NumberOfGoodWaysToSplitAStringBruteForce {
  public int numSplits(String s) {
    int n = s.length();
    var firstHalfUniqueCount = new HashSet<>();
    int resultCount = 0;
    for (int i = 0; i < n; i++) {
      firstHalfUniqueCount.add(s.charAt(i));
      int seconfHalfUniqueCount = getCount(s.substring(i + 1));
      if (firstHalfUniqueCount.size() == seconfHalfUniqueCount) resultCount++;
    }
    return resultCount;
  }

  private int getCount(String s) {
    var secondHalfUniqueCount = new HashSet<>();
    for (Character c : s.toCharArray()) secondHalfUniqueCount.add(c);
    return secondHalfUniqueCount.size();

  }
}
