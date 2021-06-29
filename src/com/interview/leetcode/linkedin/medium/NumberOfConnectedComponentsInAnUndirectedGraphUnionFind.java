package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
=====================================================Example 1:=========================================================================
See image NumberOfConnectedComponentsInAnUndirectedGraphExample1.jpg
Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]].Output: 2
     0          3
     |          |
     1 --- 2    4
=====================================================Example 2:=========================================================================
See image NumberOfConnectedComponentsInAnUndirectedGraphExample2.jpg
Input: n = 5 and edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]. Output:  1
        0
        |
    --- 1 --- 2 --- 3
   |    |			|
   4     -----------
=====================================================Example 3:=========================================================================
Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]. Output:  1

     0           4
     |           |
     1 --- 2 --- 3
==============================================================================================================================
5
[[0,1],[1,2],[0,2],[3,4]]

 */
public class NumberOfConnectedComponentsInAnUndirectedGraphUnionFind {

  public int minimumCost(int n, int[][] connections) {
    int[] root = new int[n + 1];
    for (int i = 0; i <= n; i++) root[i] = i;

    Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

    int cost = 0, connectionCount = 1;

    for (int[] connection : connections) {
      int sourceNodeId = connection[0], targatNodeId = connection[1];
      int sourceNodeGroup = find(root, sourceNodeId);
      int targetNodeGroup = find(root, targatNodeId);

      if (sourceNodeGroup == targetNodeGroup) continue;

      root[targetNodeGroup] = sourceNodeGroup;
      cost += connection[2];

      connectionCount++;
    }

    return connectionCount == n ? cost : -1;
  }

  public int find(int[] root, int id) {
    while (true) {
      //root[id] = root[root[id]]; // path compression
      if (id == root[id]) return id;
      id = root[id];
    }
  }

}
