package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/word-search-ii/description/
========================================================Requirement========================================================
 Given a 2D board and a list of words from the dictionary, find all words in the board.

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
===========================================================================================================================
Reason for TRIE: When I do DFS on board. Every time in board I need to navigate 4*4*4*4 directions.
TRIE regulates the "board" DFS to minimal.

1) Build TRIE for all words.
2) Navigate board from (0,0). Do DFS on board against TRIE.
3) Result should not contains duplicate.
				Input: board =[["a","a"]]
					   words =["a"]
				Output:["a"]
4) For above input, If I do DFS for "board" against TRIE. for(0,0) I will find 1 output, then another output for (0,1).
   So result will be Output:["a","a"] which is wrong.
5) To solve above problem. 3 things I can do.
		Option1) Put the result in HashSet<>(). This will remove duplicate result. Below code is based on Option1.
		Option2) Visit only 1 time for 'a' at (0,0). Ex: ignore for 'a' at (0,1)
					But Option2 will fail for below case. Because after visiting "a" at (0,0). which don't find any result,
					I will not visit 'a' at (0,2), but result comes from "a" at (0,2)

					Input: board =[["a","b","a","c"]]
					   words =["ac"]

		Option3) Whenever a result is found, Add the result to List, update isEnd to false. But this will corrupt
				 the TRIE data-structure.

Optimization Part: Trie could be pruned from leaf. See "WordSearch2trie_prune.png"

======

 */
public class WordSearchIIEfficientTRIEOption1 {
  // right,down,left,top
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public List<String> findWords(char[][] board, String[] words) {
    Set<String> result = new HashSet<>();
    TrieNode root = new TrieNode();
    buildTrie(root, words);
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        dfs(board, row, col, root, result, new boolean[board.length][board[0].length]);
      }
    }

    return new ArrayList<>(result);
  }

  class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
    String word;
  }

  private void dfs(char[][] board, int row, int col, TrieNode trieRoot, Set<String> result,
      boolean[][] visited) {
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;

    if (visited[row][col]) return;

    char currentChar = board[row][col];
    if (!trieRoot.children.containsKey(currentChar)) return;
    trieRoot = trieRoot.children.get(currentChar);

    if (trieRoot.isEnd) result.add(trieRoot.word);

    visited[row][col] = true;

    for (int i = 0; i < DIRECTIONS.length; i++)
      dfs(board, DIRECTIONS[i][0] + row, DIRECTIONS[i][1] + col, trieRoot, result, visited);

    visited[row][col] = false;
  }

  private void buildTrie(TrieNode root, String[] words) {
    for (String word : words) {
      TrieNode tempRoot = root;
      for (Character c : word.toCharArray()) {
        if (tempRoot.children.containsKey(c)) {
          tempRoot = tempRoot.children.get(c);
        } else {
          TrieNode current = new TrieNode();
          tempRoot.children.put(c, current);
          tempRoot = current;
        }
      }
      tempRoot.isEnd = true;
      tempRoot.word = word;
    }
  }
}
