package com.interview.leetcode.topic.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-break/description/

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
==========================================================Solution Approach======================================================
1) Pass invalidDict set to cache the "combo" of word that failed.
2) If the same "combo" comes again return false.
===========================================================Why Memoization=======================================================
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

invalidDict = [catsandog, andog, og, sandog]
            
1) We can see that "og" is called 2 times. See WordBreakMemoize.png for Memoize details
2) There are so many cases, which will call itself. Ex: "s="aaaaaaaaac"   wordDict = ["a","b"].
For each "a" recursion will split, but we see with "a" starting result cannot be formed. Memo avoid all unnecessary combo.               
=====================================================Time Complexity=============================================================
Doing Memoization will convert this to O(n^3). Note "not exponential".
=================================================================================================================================
 */
public class WordBreakMemoitation {

  public boolean wordBreak(String s, List<String> wordDict) {
    return recur(s, s.length(), new HashSet<>(wordDict), new HashSet<>());
  }

  private boolean recur(String s, int n, Set<String> wordDict, Set<String> invalidDict) {
    if (wordDict.contains(s)) return true;

    if (invalidDict.contains(s)) return false;

    for (int i = 0; i < n; i++) {
      String prefixString = s.substring(0, i + 1);

      if (wordDict.contains(prefixString)) {
        String suffixString = s.substring(i + 1, n);

        if (recur(suffixString, suffixString.length(), wordDict, invalidDict)) return true;
      }
    }

    invalidDict.add(s);

    return false;

  }
}
