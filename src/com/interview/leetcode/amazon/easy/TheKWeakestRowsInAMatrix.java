package com.interview.leetcode.amazon.easy;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers for each row is:
row 0 -> 2
row 1 -> 4
row 2 -> 1
row 3 -> 2
row 4 -> 5
Rows ordered from the weakest to the strongest are [2,0,3,1,4]

========================Solution1 Note==============================
1) Smallest Count Index should come at top.
2) If there are 2 small at 2 different index then small index should come at top

Done with : ((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0])

========================Solution2 Note=============
1) To keep only top K elements in priority queue. Reverse the order and remove elements more than k

((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
=====================================
 */
public class TheKWeakestRowsInAMatrix {
  public int[] kWeakestRows(int[][] mat, int k) {
    PriorityQueue<int[]> q =
        new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    for (int i = 0; i < mat.length; i++) {
      boolean found = false;
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 0) {
          q.offer(new int[] {j, i});
          found = true;
          break;
        }
      }
      if (!found) q.offer(new int[] {mat[0].length, i});
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) result[i] = q.poll()[1];
    return result;
  }

  public int[] kWeakestRowsOptimizedKeepTopOnly(int[][] mat, int k) {
    PriorityQueue<int[]> q =
        new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
    for (int i = 0; i < mat.length; i++) {
      boolean found = false;
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 0) {
          q.offer(new int[] {j, i});
          found = true;
          break;
        }
      }
      if (!found) q.offer(new int[] {mat[0].length, i});
      if (q.size() > k) q.poll();
    }
    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) result[i] = q.poll()[1];
    return result;
  }
}
