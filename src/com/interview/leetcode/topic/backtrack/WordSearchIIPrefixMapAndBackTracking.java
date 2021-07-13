package com.interview.leetcode.topic.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
https://leetcode.com/problems/word-search-ii/description/

1) Building TRIE complicates the solution. PrefixMap works better.
2) Understand this approach, on top of it see WordSearchIIEfficientTRIEOption1

 */
public class WordSearchIIPrefixMapAndBackTracking {
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public List<String> findWords(char[][] board, String[] words) {
    Map<String, Set<String>> prefixMap = new TreeMap<>();
    Set<String> result = new HashSet<>();
    Set<String> source = new HashSet<>();
    for (String word : words) {
      source.add(word);
      StringBuilder prefix = new StringBuilder();
      for (Character c : word.toCharArray()) {
        prefix.append(c);
        prefixMap.computeIfAbsent(prefix.toString(), v -> new HashSet<>()).add(word);
      }
    }
    int maxRow = board.length, maxCol = board[0].length;
    boolean[][] visited = new boolean[maxRow][maxCol];
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        StringBuilder currentWord = new StringBuilder();
        currentWord.append(board[row][col]);
        if (prefixMap.containsKey(currentWord.toString())) {
          visited[row][col] = true;
          dfs(board, row, maxRow, col, maxCol, prefixMap, currentWord, result, source, visited);
          visited[row][col] = false;
        }
      }
    }
    return new ArrayList<>(result);

  }

  private void dfs(char[][] board, int row, int maxRow, int col, int maxCol,
      Map<String, Set<String>> prefixMap, StringBuilder currentWord, Set<String> result,
      Set<String> source, boolean[][] visited) {

    if (source.contains(currentWord.toString())) result.add(currentWord.toString());

    for (int[] DIRECTION : DIRECTIONS) {
      int nextRow = row + DIRECTION[0];
      int nextCol = col + DIRECTION[1];

      if (nextRow == maxRow || nextRow < 0 || nextCol == maxCol || nextCol < 0) continue;
      if (visited[nextRow][nextCol]) continue;
      if (!prefixMap.containsKey(currentWord.toString() + board[nextRow][nextCol])) continue;

      visited[nextRow][nextCol] = true;
      currentWord.append(board[nextRow][nextCol]);
      dfs(board, nextRow, maxRow, nextCol, maxCol, prefixMap, currentWord, result, source, visited);
      currentWord.deleteCharAt(currentWord.length() - 1);
      visited[nextRow][nextCol] = false;

    }
  }
}
