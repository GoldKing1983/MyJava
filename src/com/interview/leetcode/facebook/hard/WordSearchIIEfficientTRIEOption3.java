package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

https://leetcode.com/problems/word-search-ii/description/

1) Read WordSearchIIEfficientOption1.
2) Whenever a result is found, update isEnd to false. We can still add the result to List. But this will corrupt
				 the TRIE data-structure.


======

 */
public class WordSearchIIEfficientTRIEOption3 {
  // right,down,left,top
  private int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    if (board == null || board.length == 0) return res;

    TrieNode root = new TrieNode();
    buildTrie(root, words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        dfs(board, i, j, root, res, new boolean[board.length][board[0].length]);
      }
    }

    return new ArrayList<>(res);
  }

  class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
    String word;
  }

  private void dfs(
      char[][] board, int row, int col, TrieNode root, List<String> res, boolean[][] visited) {
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;

    if (visited[row][col]) return;

    char c = board[row][col];

    if (!root.children.containsKey(c)) return;

    root = root.children.get(c);

    if (root.isEnd) {
      root.isEnd = false;
      res.add(root.word);
    }

    visited[row][col] = true;

    for (int i = 0; i < dir.length; i++)
      dfs(board, dir[i][0] + row, dir[i][1] + col, root, res, visited);

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
