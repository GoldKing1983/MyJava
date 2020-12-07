package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/map-sum-pairs/

1) Insert the way you like
2) For the method sum, you'll be given a string representing the prefix, and you need to
return the sum of all the pairs' value whose key starts with the prefix.

Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5(2+3)
Input: insert("appa", 6), Output: Null
Input: sum("ap"), Output: 11(2+6+3)
Input: sum("app"), Output: 11(2+6+3)
Input: sum("a"), Output: 11(2+6+3)
						 a
						/
					   p
					  /
					 p(2)
   					/ \
   				   l   a(6)
   				  /
   				 e(3)
==================================Solution Approach=============================
1) When inserting into TRIE. Append value at end only
2) When getting value for prefix. Go till the desired node.
If the link is broken in middle return 0, that means prefix not found.
Once desired node is reached. Do DFS to fetch value of all nodes and sum it.
 */
public class MapSumPairs {
  class TrieNode {
    Map<Character, TrieNode> children;
    int value;

    public TrieNode() {
      children = new HashMap<>();
      value = 0;
    }
  }

  TrieNode root;

  /** Initialize your data structure here. */
  public MapSumPairs() {
    root = new TrieNode();
  }

  public void insert(String key, int val) {
    TrieNode curr = root;
    for (char c : key.toCharArray()) {
      TrieNode next = curr.children.get(c);
      if (next == null) {
        next = new TrieNode();
        curr.children.put(c, next);
      }
      curr = next;
    }
    curr.value = val;
  }

  public int sum(String prefix) {
    TrieNode curr = root;
    for (char c : prefix.toCharArray()) {
      TrieNode next = curr.children.get(c);
      if (next == null) {
        return 0;
      }
      curr = next;
    }

    return dfs(curr);
  }

  private int dfs(TrieNode root) {
    int sum = 0;
    for (char c : root.children.keySet()) {
      sum += dfs(root.children.get(c));
    }
    return sum + root.value;
  }
}
