package com.interview.leetcode.linkedin.medium;

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

  public int countComponents(int n, int[][] edges) {
    // result is n if all are disconnected...


    // if (nodes[i] == i) then it is parent or root else current node is pointing parent
    int[] nodes = new int[n];

    // initially assign each node to to point itself.
    for (int i = 0; i < n; i++) nodes[i] = i;

    for (int[] edge : edges) {
      int sourceNode = edge[0];
      int targetNode = edge[1];
      int sourceNodeGroup = find(nodes, sourceNode);
      int targetNodeGroup = find(nodes, targetNode);

      // sourceNode and targetNode are already in the same group. So no operation needed.
      if (sourceNodeGroup == targetNodeGroup) continue;

      // sourceNode and targetNode are in different group or not in any group, group them together.
      // Either source goto target group or target can go to source group.
      nodes[sourceNodeGroup] = targetNodeGroup; // union
      n--;
    }
    return n;
  }

  // Find where "node or nodeId" belongs to in the nodes.
  public int find(int[] nodes, int nodeId) {
    while (true) {
      // reached where node belong to
      if (nodes[nodeId] == nodeId) return nodeId;
      nodes[nodeId] = nodes[nodes[nodeId]]; // optional: path compression
      nodeId = nodes[nodeId];
    }
  }
}
