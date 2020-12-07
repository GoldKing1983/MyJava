package com.interview.leetcode.google.hard;

/*

https://leetcode.com/problems/shortest-path-visiting-all-nodes/

It is a traveling salesman problem without the constraint that same node can be visited many times.
Also 0 cost to travel from nodeA to nodeB.
 */
public class ShortestPathVisitingAllNodes {
  public int shortestPathLength(int[][] adjMatrix) {
    int longest = 0;
    int n = adjMatrix.length;

    for (int k = 0; k < n; k++) {
      int currentLongest = path(adjMatrix, k, 0, new boolean[n]);
      longest = Math.max(longest, currentLongest);
    }

    return 2 * (n - 1) - longest;
  }

  // longest path starting from i
  public int path(int[][] graph, int i, int depth, boolean[] visited) {
    visited[i] = true;
    int res = depth;
    for (int j : graph[i]) {
      if (!visited[j]) {
        res = Math.max(res, path(graph, j, depth + 1, visited));
        if (res == graph.length - 1) return res; // otherwise TEL
      }
    }
    visited[i] = false;
    return res;
  }
}
