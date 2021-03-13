package com.interview.leetcode.topic.string;

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
======================================================Example1===================================================================
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

queue=[leetcode]
read from queue - leetcode
queue=[]
              l
              le
              lee
              leet
queue=[code]
              still the previous substring continues
              leetc
              leetco
              leetcod
              leetcode--->loop ends

read from queue - code
              c
              co
              cod
              code--->return true

======================================================Example2===================================================================
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

queue=[catsandog]
queue=[]
                c
                ca
                cat
queue=[sandog]
                still the previous substring continues
                cats

queue=[sandog, andog]
                still the previous substring continues
                catsa
                catsan
                catsand
                catsando
                catsandog---> loop ends

read from queue - sandog
queue=[andog]

                s
                sa
                san
                sand
queue=[andog,og]
                sando
                sandog---> loop ends
read from queue - andog
queue=[og]
                a
                an
                and
queue=[og,og]
                ando
                andog---> loop ends

read from queue - og
queue=[og]
                o
                og---> loop ends

read from queue - og
og visited already --> so nothing left in queue... return false

=====================================================Time Complexity=============================================================
Doing Memoization will convert this to O(n^3). Note "not exponential".
=================================================================================================================================

 */
public class WordBreakQueue {

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordDictSet = new HashSet<>(wordDict);
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.add(s);
    while (!queue.isEmpty()) {
      String currentString = queue.poll();
      if (visited.contains(currentString)) continue;
      visited.add(currentString);
      int n = currentString.length();
      for (int i = 0; i < n; i++) {
        String prefixString = currentString.substring(0, i + 1);
        if (wordDictSet.contains(prefixString)) {
          if (i + 1 == n) return true; // Reached end, nothing more to process.
          String suffixString = currentString.substring(i + 1, n);
          queue.add(suffixString);
        }
      }
    }
    return false;
  }
}
