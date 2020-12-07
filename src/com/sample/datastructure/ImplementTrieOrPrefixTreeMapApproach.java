package com.sample.datastructure;

import java.util.HashMap;
import java.util.Map;
/*

https://leetcode.com/problems/implement-trie-prefix-tree
======================================TRIE Theory==================================================================
1) A TRIE stores words and supports add/search in O(w) time, where w is the length of the word.
2) It saves lot of memory, as compared to saving each word in HashMap.
3) The number of total words stored in the TRIE doesn't matter,
4) So looking up the word "apple" requires basically 5 operations regardless of
whether the TRIE stores 100 words or 1,000,000 words.
5) Benefit of using Map in TrieNode as compared to array is I can save any "Character" apart from Alphabet.
==================================================================================================================
1) There will be an one empty root node initially.
2) There after there will be one children will be added for each character which is not there in parent.

								root
								/
							   t
							  /
							 e
							/ \
						   e   a
						  /		\
						 s		 s
*/

public class ImplementTrieOrPrefixTreeMapApproach {
  class TrieNode {
    private Map<Character, TrieNode> children = new HashMap<>();
    // When the search needs to do find full word then isLeaf is mandate : Ex: input="Hellow"
    // search="Hello" -->return false
    private Boolean isLeaf = false; // To identify the completion of word
  }

  TrieNode root = new TrieNode();

  public void insert(String word) {
    TrieNode tempRoot = root;
    for (Character c : word.toCharArray()) {
      if (tempRoot.children.containsKey(c)) {
        tempRoot = tempRoot.children.get(c);
      } else {
        TrieNode newNode = new TrieNode();
        tempRoot.children.put(c, newNode);
        tempRoot = newNode;
      }
    }
    tempRoot.isLeaf = true;
  }

  // Returns if the complete word is in the trie.
  public boolean search(String word) {
    TrieNode tempRoot = root;
    for (Character c : word.toCharArray()) {
      if (tempRoot.children.containsKey(c)) {
        tempRoot = tempRoot.children.get(c);
      } else return false;
    }
    return tempRoot.isLeaf;
  }

  public boolean startsWith(String prefix) {
    TrieNode tempRoot = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (tempRoot.children.containsKey(c)) {
        tempRoot = tempRoot.children.get(c);
      } else {
        return false;
      }
    }
    return true;
  }
}
