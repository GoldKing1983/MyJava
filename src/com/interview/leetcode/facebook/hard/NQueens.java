package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
https://leetcode.com/problems/n-queens/

This problem is an extension of NQueensII. Understand that first
Additionally Here we are saving queen position and generating result.
 *
 */
public class NQueens {

  private Set<Integer> columnsOccupied = new HashSet<>();
  private Set<Integer> diagonalsOccupied = new HashSet<>();
  private Set<Integer> antiDiagonalsOccupied = new HashSet<>();

  private List<List<String>> finalResult = new ArrayList<>();
  private List<Integer> queenPosition = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    recur(0, n);
    return finalResult;
  }

  private void generateResult(int n) {
    List<String> currentResult = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringBuilder currentRow = new StringBuilder();
      for (int j = 0; j < n; j++) currentRow.append('.');
      int currentRowQueenPosition = queenPosition.get(i);
      currentRow.setCharAt(currentRowQueenPosition, 'Q');
      currentResult.add(currentRow.toString());
    }
    finalResult.add(currentResult);
  }

  private void recur(int currentRow, int n) {
    if (currentRow == n) generateResult(n);
    for (int currentColumn = 0; currentColumn < n; currentColumn++) {
      if (columnsOccupied.contains(currentColumn)) continue;

      int currentDiagonal = currentRow + currentColumn;
      if (diagonalsOccupied.contains(currentDiagonal)) continue;

      int currentAntiDiagonal = currentRow - currentColumn;
      if (antiDiagonalsOccupied.contains(currentAntiDiagonal)) continue;

      columnsOccupied.add(currentColumn);
      diagonalsOccupied.add(currentDiagonal);
      antiDiagonalsOccupied.add(currentAntiDiagonal);
      queenPosition.add(currentColumn);

      recur(currentRow + 1, n);

      queenPosition.remove(queenPosition.size() - 1);
      columnsOccupied.remove(currentColumn);
      diagonalsOccupied.remove(currentDiagonal);
      antiDiagonalsOccupied.remove(currentAntiDiagonal);
    }
  }
}
