package com.interview.leetcode.google.hard;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/design-search-autocomplete-system/

See image "DesignSearchAutocompleteSystem.png".
Only thing more than a normal Trie is added a map of sentence to count in each of the Trie node to
facilitate process of getting top 3 results.

Understand TRIE problems and "TrieUsingMap.java" that is enough.

 */
public class DesignSearchAutocompleteSystemTrie {
  class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> counts;
    boolean isWord;

    public TrieNode() {
      children = new HashMap<>();
      counts = new HashMap<>();
      isWord = false;
    }
  }
}
