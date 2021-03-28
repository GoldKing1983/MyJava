package com.interview.leetcode.topic.trie;


import java.util.HashMap;
import java.util.Map;

/*
                                m
                                |
                                o
                                |
                            ---------
                           |    |    |
                           b    n    u
                           |    |    |
                           |   / \   |
                           i  e   i  s

 */
public class SearchSuggestionsSystem {
    static class Trie {
        private Map<Character, Trie> children = new HashMap<>();
        boolean isLeaf = false;
        String word = "";
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

}
