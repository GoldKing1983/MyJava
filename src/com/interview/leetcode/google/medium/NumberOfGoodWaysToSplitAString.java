package com.interview.leetcode.google.medium;

import java.util.HashSet;

/*
https://leetcode.com/problems/number-of-good-ways-to-split-a-string
    
    aacaba --> ans:2
    ("aac", "aba") 2 2
    ("aaca", "ba") 2 2
            
    aaaaa --> ans:4
    a aaaa 1 1
    aa aaa 1 1
    aaa aa 1 1
    aaaa a 1 1
    
    abcd --> ans:1
    ab cd 2 2
=======================================================Data Flow Analysis========================================================
aa --> ans:1
                   a a
                   | |
    leftToRight = [1,1]

                   a a
                   | | 
    rightToLeft = [1,1]
    
=======================================================Data Flow Analysis========================================================
aba --> ans:0
                   a b a
                   | | |
    leftToRight = [1,2,2]

                   a b a
                   | | |
    rightToLeft = [2,2,1]
=======================================================Data Flow Analysis========================================================
abba --> ans:1
                   a b b a
                   | | | |
    leftToRight = [1,2,2,2]
                   a b b a
                   | | | |
    rightToLeft = [2,2,2,1]
    
 */
public class NumberOfGoodWaysToSplitAString {
  public int numSplits(String s) {
    int n = s.length();

    var leftToRightUniqueCount = new HashSet<>();
    var leftToRight = new int[n];

    var rightToLeftUniqueCount = new HashSet<>();
    var rightToLeft = new int[n];

    int resultCount = 0;
    for (int i = 0; i < n; i++) {
      leftToRightUniqueCount.add(s.charAt(i));
      leftToRight[i] = leftToRightUniqueCount.size();
    }
    for (int i = n - 1; i >= 0; i--) {
      rightToLeftUniqueCount.add(s.charAt(i));
      rightToLeft[i] = rightToLeftUniqueCount.size();
    }
    for (int i = 0; i < n - 1; i++) {
      int firstHalfUniqueCount = leftToRight[i];
      int secondHalfUniqueCount = rightToLeft[i + 1];
      if (firstHalfUniqueCount == secondHalfUniqueCount) resultCount++;
    }
    return resultCount;
  }

}
