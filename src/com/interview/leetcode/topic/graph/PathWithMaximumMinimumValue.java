package com.interview.leetcode.topic.graph;

import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/path-with-maximum-minimum-value/

1) Given a input matrix.
2) Traverse from 0,0 to m-1,n-1
3) Gather the highest sum during the traversal. Return the smallest number across the traversal.

Input: [[5,4,5],
        [1,2,6],
        [7,4,6]]
Output: 4
Explanation: Path with maximum sum is achieved through 5,4,5,6,6...Lowest number across the path is 4.
========================================================Solution Approach========================================================
Similar to PathWithMinimumEffort
===========================Solution Approach using Prims(Greedy) Algorithm ===========================
1) Greedily push the neighbors to pQ and mark it as visited.
2) pQ will float with highest cost neighbor.
3) So path with highest cost route, always processed. Record the min along the path.

 */
public class PathWithMaximumMinimumValue {
  int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int maximumMinimumPath(int[][] A) {
    int maxRow = A.length;
    int maxCol = A[0].length;
    boolean[][] visited = new boolean[maxRow][maxCol];

    // in the BFS approach, for each step, we are interested in getting the maximum min that we have
    // seen so far, thus we reverse the ordering in the pq
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

    pq.offer(new int[] {0, 0, A[0][0]});

    // BFS
    while (!pq.isEmpty()) {
      int[] cell = pq.poll();
      int row = cell[0];
      int col = cell[1];

      if (row == maxRow - 1 && col == maxCol - 1) return cell[2];

      visited[row][col] = true;

      for (int[] dir : DIRECTIONS) {
        int nextRow = row + dir[0];
        int nextCol = col + dir[1];

        if (nextRow < 0 || nextRow >= maxRow || nextCol < 0 || nextCol >= maxCol) continue;
        if (visited[nextRow][nextCol]) continue;

        // we are keeping track of the min element that we have seen until now
        pq.offer(new int[] {nextRow, nextCol, Math.min(cell[2], A[nextRow][nextCol])});
      }
    }
    return -1;
  }
}
