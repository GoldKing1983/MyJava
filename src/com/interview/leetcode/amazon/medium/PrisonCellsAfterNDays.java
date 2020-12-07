package com.interview.leetcode.amazon.medium;

/*
 * https://leetcode.com/problems/prison-cells-after-n-days/

============================What we are tested============================
Simple logical problem. No maths. Only coding.
====================================================================================

1) Only one tricky part is 0th and n-1th cell data will be 0 after 1st iteration.
This is done by auto. Because "newCells" by default all "0". We don't process 0th and n-1th cell.

2) After every 14 steps state repeats. So at-most 14 state is enough
 */
public class PrisonCellsAfterNDays {
  public int[] prisonAfterNDays(int[] cells, int N) {
    if (N == 0) return cells;
    // After every 14 steps state repeats. So at-most 14 state is enough
    N = N % 14 == 0 ? 14 : N % 14;

    int[] newCells = new int[8];

    while (N-- > 0) {
      // loop start from 1 and ends 7
      for (int i = 1; i < 7; i++) {
        if (cells[i - 1] == cells[i + 1]) newCells[i] = 1;
        else newCells[i] = 0;
      }
      cells = newCells;
      newCells = new int[8];
    }

    return cells;
  }
}
