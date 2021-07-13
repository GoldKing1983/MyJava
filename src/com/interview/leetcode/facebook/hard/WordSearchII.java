package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.facebook.medium.WordSearchBackTrackBoggle;

/*

https://leetcode.com/problems/word-search-ii/description/

This problem is an extension of WordSearch.java. Adding just a for loop on top inside findWords method

 */
public class WordSearchII {
  public List<String> findWords(char[][] board, String[] words) {
    WordSearchBackTrackBoggle w = new WordSearchBackTrackBoggle();
    List<String> result = new ArrayList<>();
    int maxRow = board.length, maxCol = board[0].length;
    for (String searchWord : words) {
      if (result.contains(searchWord)) {
        continue;
      }
      boolean[][] visited = new boolean[maxRow][maxCol];
      outer: for (int row = 0; row < maxRow; row++) {
        for (int col = 0; col < maxCol; col++) {
          if (board[row][col] == searchWord.charAt(0)) {
            visited[row][col] = true;
            if (w.backTrack(board, searchWord, 1, searchWord.length(), row, maxRow, col, maxCol,
                visited)) {
              result.add(searchWord);
              break outer;
            }
            visited[row][col] = false;
          }

        }
      }
    }

    return result;
  }
}
