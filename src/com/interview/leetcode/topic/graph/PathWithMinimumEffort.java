package com.interview.leetcode.topic.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/path-with-minimum-effort/
=======================================================Data Flow Analysis========================================================
below 1 test case is enough to explain for the interviewer.
input: [1,10,15] output: 9
visitedCosts : [0,9,9]
=======================================================Data Flow Analysis========================================================
input:
        1 ,10,15
        10,1 ,25
output: 10

Assume DIRECTIONS map is like {r,d,l,u}
visitedCosts :
        0, 9, 9
        9, N, 10
   At above stage... m-1,n-1 is updated to 10 and placed in pQ...
   in pQ 1,0 will float with higher priority rather than m-1,n-1.
        0, 9, 9
        9, 9, 10
   From 1,0--> 1,1 will be filled.
   At above stage...  from 1,1 to m-1,n-1 cost is 24.
   But already visitedCosts of m-1,n-1 has 10. So 24 is skipped.

   Now m-1,n-1 is picked from pQ and 10 is returned as result.
========================================================Solution Approach========================================================
1) Create a visitedCosts matrix.
2) Update the matrix point with minimum cost from neighbors.
3) If the m-1, n-1 point reached return the cost at that point.
4) Backtracking is not needed, because at any-point if any point is costlier, logic pick
shortest cost path. This is achieved by putting all the cost to pQ and pQ greedily chooses the
shortest cost path.

See the visual from https://leetcode.com/problems/path-with-minimum-effort/solution/ Approach2
Similar to ConnectingCitiesWithMinimumCost. Prims Greedy Algorithm
*/
public class PathWithMinimumEffort {
  // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int minimumEffortPath(int[][] heights) {
    int maxRow = heights.length, maxCol = heights[0].length;
    Integer[][] visitedCosts = new Integer[maxRow][maxCol];

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    minHeap.offer(new int[] {0, 0, 0}); // cost, row, col
    while (!minHeap.isEmpty()) {
      int[] top = minHeap.poll();
      int cost = top[0], row = top[1], col = top[2];
      // Because we visited this point already with lower cost, so no need to traverse again.
      if (visitedCosts[row][col] != null && visitedCosts[row][col] < cost) continue;
      if (row == maxRow - 1 && col == maxCol - 1) return cost; // Reach to bottom right
      for (int i = 0; i < 4; i++) {
        int nextRow = row + DIRECTIONS[i][0], nextCol = col + DIRECTIONS[i][1];
        if (nextRow < 0 || nextRow == maxRow || nextCol < 0 || nextCol == maxCol) continue;
        /*
        We carry forward the maximum because... consider below example
        Ex: [1,10,15]... for 1 and  10 cost is 9.
                         for 10 and 15 cost is 5. But we have to set 7. Because we need to find absolute max cost path
            visitedCosts = [0,9,9]
         */
        int newCost = Math.max(cost, Math.abs(heights[nextRow][nextCol] - heights[row][col]));
        // We visited this point already, but new point cost is cheaper. So traverse it and update
        // the visitedCost
        if (visitedCosts[nextRow][nextCol] == null || newCost < visitedCosts[nextRow][nextCol]) {
          visitedCosts[nextRow][nextCol] = newCost;
          minHeap.offer(new int[] {visitedCosts[nextRow][nextCol], nextRow, nextCol});
        }
      }
    }
    return 0; // Unreachable code, Java require to return interger value.
  }
}
