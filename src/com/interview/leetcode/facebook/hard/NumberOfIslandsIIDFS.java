package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/number-of-islands-ii/

1) Doing DFS from [0,0] to [n,n] is costlier operation for each Island placed in matrix.
2) But doing only 4 direction for each of "Island placed" step by step will not work for DFS.
3) So thinking this problem with DFS is "wrong approach"

================================================Solution Approach==================================================================
Wrong Thinking

On placing a island. If any side 1 then decrement the count.
	 						 a
						 b	 x	 c
						 	 d

====================================================================================================================================




 */
public class NumberOfIslandsIIDFS {
  private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public List<Integer> numIslands2(int maxRow, int maxCol, int[][] positions) {
    List<Integer> result = new ArrayList<>();
    if (maxRow <= 0 || maxCol <= 0) return result;
    boolean isLand[][] = new boolean[maxRow][maxCol];
    int count = 0; // number of islands

    for (int[] position : positions) {
      int currentRow = position[0];
      int currentCol = position[1];

      if (isLand[currentRow][currentCol]) {
        result.add(count);
        continue;
      }

      count++;

      for (int[] dir : DIRECTIONS) {
        int nextRow = currentRow + dir[0];
        int nextCol = currentCol + dir[1];
        if (nextRow < 0 || nextRow >= maxRow || nextCol < 0 || nextCol >= maxCol) continue;

        if (isLand[nextRow][nextCol]) continue;
        isLand[nextRow][nextCol] = true;

        count--;
      }

      result.add(count);
    }
    return result;
  }
}
