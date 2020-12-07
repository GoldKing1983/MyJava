package com.interview.leetcode.facebook.hard;

import com.interview.leetcode.facebook.medium.WordSearchBackTrackBoggle;
import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/word-search-ii/description/

This problem is an extension of WordSearch.java. Adding just a for loop on top inside findWords method

 */
public class WordSearchII {
  public List<String> findWords(char[][] board, String[] words) {
    WordSearchBackTrackBoggle w = new WordSearchBackTrackBoggle();
    List<String> result = new ArrayList<>();
    for (String searchWord : words) {
      if (result.contains(searchWord)) {
        continue;
      }
      boolean[][] visited = new boolean[board.length][board[0].length];
      outer:
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (w.recur(board, i, j, searchWord, 0, visited)) {
            result.add(searchWord);
            break outer;
          }
        }
      }
    }

    return result;
  }
}
