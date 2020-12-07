package com.interview.leetcode.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/stream-of-characters/
=========================================================Requirement==============================================================
Implement the StreamChecker class as follows:

1) StreamChecker(words): Constructor, initialize the data structure with the given dictionary of words.
2) query(letter): returns true if the "lastSequenceOfContinuousCharacters" are available in dictionary.

 Ex1: words= ["ab"]
 	 query1 = 'a'; --> false
 	 query2 = 'b'; --> true... b occurs, a also occurs

 Ex2: words= ["ab"]
 	 query1 = 'a'; --> false
 	 query2 = 'c'; --> false
 	 query3 = 'b'; --> false... b occurs, a also occurs previously but it is discontinued.

=========================================================Solution Approach=========================================================
1) Build a TRIE from reverse for the dictionary of words.
2) Save the query into list and compare from last. If found a valid word return true.

 */
public class StreamOfCharacters {
  List<Character> stream = new ArrayList<>();

  class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;
  }

  TrieNode root = new TrieNode();

  public StreamOfCharacters(String[] words) {
    for (String word : words) {

      TrieNode tempRoot = root;
      for (int i = word.length() - 1; i >= 0; i--) {
        Character currentChar = word.charAt(i);
        if (tempRoot.children.containsKey(currentChar)) {
          tempRoot = tempRoot.children.get(currentChar);
        } else {
          TrieNode currNode = new TrieNode();
          tempRoot.children.put(currentChar, currNode);
          tempRoot = currNode;
        }
      }
      tempRoot.isLeaf = true;
    }
  }

  public boolean query(char letter) {
    TrieNode tempRoot = root;
    stream.add(letter);
    int n = stream.size() - 1;
    while (n >= 0) {
      Character currentChar = stream.get(n);
      n--;
      if (tempRoot.children.containsKey(currentChar)) {
        tempRoot = tempRoot.children.get(currentChar);
        if (tempRoot.isLeaf) return true;
      } else return false;
    }
    return false;
  }
}
