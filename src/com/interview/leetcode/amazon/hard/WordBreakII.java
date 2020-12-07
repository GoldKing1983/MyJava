package com.interview.leetcode.amazon.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a
sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

 */
public class WordBreakII {
  public List<String> wordBreak(String s, List<String> wordDict) {
    return wordBreak(s, new HashSet<>(wordDict));
  }

  public List<String> wordBreak(String s, Set<String> wordDict) {
    return recur(s, wordDict, new HashMap<>());
  }

  // DFS function returns an array including all substrings derived from s.
  List<String> recur(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
    if (map.containsKey(s)) return map.get(s);

    LinkedList<String> res = new LinkedList<>();
    if (s.length() == 0) {
      res.add("");
      return res;
    }
    for (String word : wordDict) {
      if (s.startsWith(word)) {
        List<String> sublist = recur(s.substring(word.length()), wordDict, map);
        for (String sub : sublist) res.add(word + (sub.isEmpty() ? "" : " ") + sub);
      }
    }
    map.put(s, res);
    return res;
  }
}
