package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
=====================================================================Requirement==============================================
Design a data structure that supports the following two operations:
		void addWord(word)
		bool search(word)

search(word) can search
	a) literal word or
	b) regular expression(. only), "." means it can represent any one letter.
===================================================Solution Approach==========================================================
1) Insert data into TRIE data structure.
								root
								/
							   t
							  /
							 .
							/ \
						   e   a
						  /		\
						 s		 s
2) For the "." character, (DFS) recursively call for all the character in Map with the corresponding node
	Ex: t.es
 */
public class AddAndSearchWordTRIE {

  static class Trie {
    private Map<Character, Trie> children = new HashMap<>();
    boolean isLeaf = false;
  }

  Trie root = new Trie();

  public void addWord(String word) {
    Trie tempRoot = root;
    for (int i = 0; i < word.length(); i++) {
      Character c = word.charAt(i);
      if (tempRoot.children.containsKey(c)) {
        tempRoot = tempRoot.children.get(c); // Move to next Node
      } else {
        Trie nextNode = new Trie();
        tempRoot.children.put(c, nextNode);
        tempRoot = nextNode;
      }
    }
    tempRoot.isLeaf = true;
  }

  public boolean search(String word) {
    Trie tempRoot = root;
    return searchFromLevel(word, tempRoot);
  }

  public boolean searchFromLevel(String word, Trie tempRoot) {
    for (int i = 0; i < word.length(); i++) {
      Character c = word.charAt(i);
      // for the case input=["a"] and searchString=["a."]
      if (tempRoot.children.size() == 0) return false;
      // Below recursion logic is similar to WordBreakRecursion
      if (c == '.') {
        // For the "." character, recursively call for all the character in Map with the
        // corresponding node
        for (Map.Entry<Character, Trie> m : tempRoot.children.entrySet()) {
          // There could be multiple path going from "." Only one path will succeed if the
          // "searchWord" is found, rest all path will return false.
          if (searchFromLevel(word.substring(i + 1, word.length()),
              tempRoot.children.get(m.getKey()))) {
            return true;
          }
        }
        return false;
      } else if (tempRoot.children.containsKey(c)) {
        tempRoot = tempRoot.children.get(c); // Move to next Node
      } else {
        return false;
      }
    }
    return tempRoot.isLeaf;
  }
}
