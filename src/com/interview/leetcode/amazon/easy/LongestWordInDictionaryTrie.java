package com.interview.leetcode.amazon.easy;

import java.util.Map;
import java.util.TreeMap;

/*
=================================================================================================================================
https://leetcode.com/problems/longest-word-in-dictionary/

Given a list of strings words representing an English Dictionary,
a) find the "longestWord" that can be built from dictionary,
b) build the "longestWord" by one character at a time by other words in words. If there is more than one possible answer,
return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Input:  words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:  The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:  Both "apply" and "apple" can be built from other words in the dictionary. However,
"apple" is lexicographically smaller than "apply".

=============================================Solution Approach===================================================================
								 root
								 /
							    a(isEnd=true, word=a)
							   /
							  p(isEnd=true, word=ap)
							 /
						    p(isEnd=true, word=app)
						   /
						  l(isEnd=true, word=appl)
						 / \
(isEnd=true, word=apple)e   y(isEnd=true, word=apply)

1) Insert all the word into TRIE.
2) Use TreeMap for TRIE node, because we wanted lexicographically smaller answer.
	====Find Longest====
1) Do DFS on TRIE node.
2) At any point if isEnd is not there then that path is broken.
3) From the TreeMap, save the first answer in that level
				Ex:"apple". will be save in result. "apply" will be skipped. (Similar to "BinaryTreeRightSideViewDFS")
				If "apply" grows as "applya". Still for next level "applya" will be selected.
============================================================================================================================
 */
public class LongestWordInDictionaryTrie {

  static class Trie {
    Map<Character, Trie> map = new TreeMap<>();
    boolean isEnd;
    String word;
  }

  private Trie rootPath = new Trie();

  public String longestWord(String[] words) {
    for (String word : words) insertWord(word);
    buildLongest(rootPath, 0);
    return result;
  }

  private void insertWord(String word) {
    Trie tempRootPath = rootPath;
    for (Character c : word.toCharArray()) {
      Trie existingPath = tempRootPath.map.get(c);
      if (existingPath == null) {
        Trie currentPath = new Trie();
        tempRootPath.map.put(c, currentPath);
        tempRootPath = currentPath;
      } else {
        tempRootPath = existingPath;
      }
    }
    tempRootPath.isEnd = true;
    tempRootPath.word = word;
  }

  private String result = "";

  private void buildLongest(Trie parent, int level) {
    for (Map.Entry<Character, Trie> entry : parent.map.entrySet()) {
      if (!entry.getValue().isEnd) continue;
      if (result.length() == level) result = entry.getValue().word;
      buildLongest(entry.getValue(), level + 1);
    }
  }
}
