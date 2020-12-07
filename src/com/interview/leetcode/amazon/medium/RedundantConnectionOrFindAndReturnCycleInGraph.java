package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/redundant-connection/

==========================================================Requirement==========================================================
In this problem, a tree is an undirected graph that is connected and has cycles.

Return an edge that can be removed, so that the resulting graph is a tree of N nodes. If there are multiple answers,
return the answer that occurs first in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
============================================================Example=============================================================
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this. Remove connection [2,3] so that it looks like tree.
			  1
			 / \
			2 - 3



Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]. Remove connection [1,4] so that it looks like tree
Output: [1,4]
Explanation: The given undirected graph will be like this:
			5 - 1 - 2
			    |   |
			    4 - 3

=================================================Solution Approach=================================================
If the node already belong to a group then there is a cycle, return that node.

 */
public class RedundantConnectionOrFindAndReturnCycleInGraph {
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length + 1; // nodes start from 1. So addding 1.

    // if (nodes[i] == i) then it is parent or root else current node is pointing parent
    int[] nodes = new int[n];

    // initially assign each node to to point itself.
    for (int i = 0; i < n; i++) nodes[i] = i;

    for (int[] edge : edges) {
      int sourceNode = edge[0];
      int targetNode = edge[1];
      int sourceNodeGroup = find(nodes, sourceNode);
      int targetNodeGroup = find(nodes, targetNode);

      // sourceNode and targetNode are already in the same group. Then there is a cycle.
      if (sourceNodeGroup == targetNodeGroup) return edge;

      // sourceNode and targetNode are in different group or not in any group, group them together.
      // Either source goto target group or target can go to source group.
      nodes[sourceNodeGroup] = targetNodeGroup; // union
    }
    return new int[] {0, 0};
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
