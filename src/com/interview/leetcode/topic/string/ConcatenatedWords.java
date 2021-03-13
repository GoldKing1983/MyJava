package com.interview.leetcode.topic.string;

import java.util.*;

/*
===========================================================Requirement===========================================================
1) Given an array of strings words (without duplicates).
2) return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
============================================================Example1=============================================================
Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
"dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
============================================================Example1=============================================================
Input: words = ["cat","dog","catdog"]
Output: ["catdog"]
========================================================Solution Approach========================================================
Call WordBreak1 for each of word in dictionary except the sameWord itself.

 */
public class ConcatenatedWords {

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Set<String> wordDict = new HashSet<>();
    for (String word : words) wordDict.add(word);

    List<String> result = new ArrayList<>();
    for (String word : words) {
      wordDict.remove(word);
      if (recur(word, word.length(), wordDict, new HashSet<>())) result.add(word);
      wordDict.add(word);
    }
    return result;
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
