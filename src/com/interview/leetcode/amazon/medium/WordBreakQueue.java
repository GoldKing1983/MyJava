package com.interview.leetcode.amazon.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
https://leetcode.com/problems/word-break/description/

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Input: s = "bb", wordDict = ["a","b","bbb","bbbb"]
Expected: true

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

Input: s = "cars", wordDict = ["car","ca","rs"]
Output: true

Input: s = "cars", wordDict = ["ca","cars"]
Output: true
===========================================Solution approach:==================================================================================

 */
public class WordBreakQueue {

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordDictSet = new HashSet<>(wordDict);
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[s.length()];
    queue.add(0);
    while (!queue.isEmpty()) {
      int start = queue.poll();
      if (visited[start]) continue;
      visited[start] = true;
      for (int end = start + 1; end <= s.length(); end++) {
        String prefixString = s.substring(start, end);
        if (wordDictSet.contains(prefixString)) {
          if (end == s.length()) return true; // Reached end, nothing more to process.
          queue.add(end);
        }
      }
    }
    return false;
  }
}
