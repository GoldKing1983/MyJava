package com.interview.leetcode.facebook.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/valid-sudoku/description/

 */
public class ValidSudokuMap {
  public boolean isValidSudoku(char[][] board) {
    Map<Integer, Set<Character>> rows = new HashMap<>();
    Map<Integer, Set<Character>> cols = new HashMap<>();
    Map<Integer, Set<Character>> boxes = new HashMap<>();

    for (int i = 0; i < 9; i++) {
      rows.put(i, new HashSet<>());
      cols.put(i, new HashSet<>());
      boxes.put(i, new HashSet<>());
    }

    for (int rowId = 0; rowId < 9; rowId++) {
      for (int colId = 0; colId < 9; colId++) {
        if (board[rowId][colId] == '.') continue;

        Integer boxId = (rowId / 3) + (colId / 3) * 3; // *3 can stay anywhere

        if (rows.get(rowId).contains(board[rowId][colId])
            || cols.get(colId).contains(board[rowId][colId])
            || boxes.get(boxId).contains(board[rowId][colId])) return false;

        rows.get(rowId).add(board[rowId][colId]);
        cols.get(colId).add(board[rowId][colId]);
        boxes.get(boxId).add(board[rowId][colId]);
      }
    }
    return true;
  }
}
