package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/graph-valid-tree/discuss/69018/AC-Java-Union-Find-solution

Requirement: Verify given graph is a valid tree.

1) For the graph to be a valid tree, it must have exactly n - 1 edges with no cycle.
2) if number of edges are less, then it is not fully connected or some nodes are hanging.
3) if number of edges are more, then there is cycle.
4) Additionally, if the graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle.
==============================================================================================================================
Example1: See Image GraphValidTreeExample1.jpg
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]].Output: true

				--- 0 ---
			   |    |    |
			   1    2    3
			   |
			   4
==============================================================================================================================
Example 2: See image GraphValidTreeExample2.jpg
Input: n = 5 and edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]. Output: false

        0
        |
    --- 1 --- 2 --- 3
   |    |			|
   4     -----------
==============================================================================================================================
Example 3:
n = 6 and edges = [(0, 5), (4, 0), (1, 2), (4, 5), (3, 2)]. Output: false

							0                 1
						 /     \             /
 						5 ----- 4           2
 										   /
 										  3

Corner case here "n-1==edge" condition satisfied, but it is disconnected.


 */
public class GraphValidTreeUnionFind { 

  public boolean validTree(int n, int[][] edges) {
    // initialize n isolated islands
    int[] nodes = new int[n];
    Arrays.fill(nodes, -1);
    if (edges.length != n - 1) return false;

    for (int[] edge : edges) {
      int node1 = find(nodes, edge[0]);
      int node2 = find(nodes, edge[1]);

      // if two vertices happen to be in the same set then there's a cycle
      if (node1 == node2) return false;

      // union
      nodes[node1] = node2;
    }
    return true;
  }

  public int find(int[] roots, int id) {
    while (roots[id] != -1) id = roots[id];
    return id;
  }
}
