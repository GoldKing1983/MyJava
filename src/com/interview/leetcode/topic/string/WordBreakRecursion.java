package com.interview.leetcode.topic.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-break/description/
====================================================Requirement==================================================================
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
======================================================Example1===================================================================
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
              l
              le
              lee
              leet ------------>c   
                                co
                                cod
                                code--->return true
======================================================Example2===================================================================
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

                c
                ca
                cat------------>s
                                sa
                                san
                                sand------------>o
                                                 og---> return false
                                sando
                                sandog---> return false
                
                cats----------->a
                                an
                                and------------>o
                                                og---> return false
                                ando
                                andog---> return false
                catsa
                catsan
                catsand
                catsando
                catsandog---> return false

===================================================Solution Approach=============================================================
1) loop input string from 0th index.
2) If any substring found for the index. Branch out recursion for "suffixString". The main loop still continues.
=====================================================Time Complexity=============================================================
1) Runtime complexity of this solution is exponential, O(2^n). Ex: s = "aaaaaaa"
2) Because we are recursing n times.
3) Doing Memoization will convert this to O(n^3). Note "not exponential". 
=================================================================================================================================
 */
public class WordBreakRecursion {

  public boolean wordBreak(String s, List<String> wordDict) {
    return recur(s, s.length(), new HashSet<>(wordDict));
  }

  private boolean recur(String s, int n, Set<String> wordDict) {
    if (wordDict.contains(s)) return true;

    for (int i = 0; i < n; i++) {
      String prefixString = s.substring(0, i + 1);

      if (wordDict.contains(prefixString)) {
        String suffixString = s.substring(i + 1, n);

        if (recur(suffixString, suffixString.length(), wordDict)) return true;
      }
    }
    return false;

  }
}
