package com.interview.leetcode.topic.trie;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/*
https://leetcode.com/problems/number-of-matching-subsequences/

Solution based on Trie(prefixTrie-don't build Trie itself) + BFS
========================================================Solution Approach========================================================
1) Do one thing at a time.
2) Assume s = "abcde" word="ace"
3) For each of char "s". verify 0th char of word matches. If matches. Update word by substring(1) skipping 0th char.
   s="abcde" word="ace"
   parse 0th of s. "a" found.     word = "ce"
   parse 1sr of s. "b" not found. word = "ce"
   parse 2nd of s. "c" found.     word = "e"
   parse 3rd of s. "d" notfound.  word = "e"
   parse 4th of s. "e" found.     size==1 ---> result found.
4) Now do the same thing with multiple words using map and queue.        
=======================================================Data Flow Analysis========================================================
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".


 Initial Trie:{a=[a, acd, ace], b=[bb]}
=====Parsing: a=====
   ==Found a result with a char ending:a
Updated Trie:{a=[ace], b=[bb], c=[cd]}
Updated Trie:{a=[], b=[bb], c=[cd, ce]}
=====Parsing: b=====
Updated Trie:{a=[], b=[b], c=[cd, ce]}
=====Parsing: c=====
Updated Trie:{a=[], b=[b], c=[ce], d=[d]}
Updated Trie:{a=[], b=[b], c=[], d=[d], e=[e]}
=====Parsing: d=====
   ==Found a result with a char ending:d
=====Parsing: e=====
   ==Found a result with a char ending:e


 */
public class NumberOfMatchingSubsequences {

  public int numMatchingSubseq(String inputString, String[] words) {
    var trieMap = new HashMap<Character, Deque<String>>();

    for (String word : words) {
      trieMap.computeIfAbsent(word.charAt(0), k -> new ArrayDeque<>()).offer(word);
    }

    int resultCount = 0;
    for (char c : inputString.toCharArray()) {
      if (!trieMap.containsKey(c)) continue; // ex: s=hello.. words=[xyz]
      Deque<String> queue = trieMap.get(c);
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        if (word.length() == 1) {
          resultCount++;
        } else {
          trieMap.computeIfAbsent(word.charAt(1), k -> new ArrayDeque<>()).offer(word.substring(1));
        }
      }
    }
    return resultCount;
  }
}
