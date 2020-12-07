package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

https://leetcode.com/problems/replace-words/

In English, we have a concept called root, which can be followed by some other words to form another longer word -
let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the
sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Input: dict = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Input: dict = ["cat","bat","bath","rat"] sentence = "the cattle was bathing"
Output: "the cat was bat"... bath and bat 2 match found. But only bat was took

Too many spaces can be trimmed into one space.
=====================================================
    			/*
               b
              /
             a
            /
           t(isEnd=true, word=bat)
          /
         h (isEnd=true, word=bath)

Note: the bigger string will never succeed...

 */
public class ReplaceWordsTrie {
  class TrieNode {
    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean isLeaf = false; // To identify the completion of word
    private String word;
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
    tempRoot.word = word;
  }

  // Returns the first occurrence of word
  public String search(String word) {
    TrieNode tempRoot = root;
    for (Character c : word.toCharArray()) {
      if (tempRoot.children.containsKey(c)) {
        tempRoot = tempRoot.children.get(c);
        if (tempRoot.isLeaf) return tempRoot.word;
      } else return null;
    }
    return null;
  }

  public String replaceWords(List<String> dict, String sentence) {
    for (String word : dict) insert(word);

    String[] split = sentence.split(" ");
    StringBuilder result = new StringBuilder();
    for (String s : split) {
      if ("".equals(s)) continue;
      String prefix = search(s);
      if (prefix == null) {
        result.append(s).append(' ');
      } else {
        result.append(prefix).append(' ');
      }
    }
    return result.substring(0, result.length() - 1);
  }
}
