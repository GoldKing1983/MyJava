package com.interview.leetcode.topic.graph;

import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/path-with-maximum-minimum-value/
https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/422849/The-question-is-wrong

1) Given a input matrix.
2) Traverse from 0,0 to m-1,n-1
3) There could be multiple path. Among multiple path, pick the smallest number which should be bigger.

Input: [[5,4,3],
        [3,2,6],
        [7,4,6]]
Output: 3
Explanation: Path1 : 5,4,3,6,6...Lowest number across the path is 3.
             Path2 : 5,3,7,4,6...Lowest number across the path is 3.
             Path3 : 5,4,2,4,6...Lowest number across the path is 2.
             path4: zigzag....
             out of all paths.... 3 is the biggest of lowest on path.
========================================================Solution Approach========================================================
Similar to PathWithMinimumEffort
===========================Solution Approach using Prims(Greedy) Algorithm ===========================
1) Greedily push the neighbors to pQ with smallestSeenSoFor and mark it as visited.
2) pQ will float with highest cost neighbor which is smallestSeenSoFor.
3) So path with smallestSeenSoFor always processed.
4) Return smallestSeenSoFor when m-1,n-1 is seen.
=======================================================Data Flow Analysis========================================================
        [[5,4,5],
         [1,2,6],
         [7,4,6]]
====processing order of nodes.====
processing cell : 0,0 with min : 5
processing cell : 0,1 with min : 4
processing cell : 0,2 with min : 4
processing cell : 1,2 with min : 4
processing cell : 2,2 with min : 4

=======================================================Data Flow Analysis========================================================
        [[5,4,3],
        [3,2,6],
        [7,4,6]]
when there is same number. pQ chooses the path, which we don't know.
Luckily problem didn't ask for specific path, if there is a conflict.
====processing order of nodes.====
processing cell : 0,0 with min : 5
processing cell : 0,1 with min : 4
processing cell : 1,0 with min : 3 (1,0 and 0,2 both has same min... )
processing cell : 0,2 with min : 3
processing cell : 2,0 with min : 3
processing cell : 1,2 with min : 3
processing cell : 2,1 with min : 3
processing cell : 2,2 with min : 3


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
