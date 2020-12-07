package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/delete-tree-nodes/

A tree rooted at node 0 is given as follows:

1) The number of nodes is nodes;
2) The value of the i-th node is value[i];
3) The parent of the i-th node is parent[i].

Remove every subtree whose sum of values of nodes is zero.
After doing so, return the number of nodes remaining in the tree.

============================================================================================
Input: nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
Output: 2

					1
				 /     \
			   -2	    4
			   / \	   / \

 */
public class DeleteTreeNodes {
  public int deleteTreeNodes(int n, int[] parent, int[] value) {
    List<List<Integer>> graph = new ArrayList<>(n); // Create graph for the tree
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    for (int i = 0; i < n; i++) if (parent[i] != -1) graph.get(parent[i]).add(i);
    return dfs(graph, value, 0)[1];
  }

  private int[] dfs(List<List<Integer>> graph, int[] value, int root) {
    int sum = value[root];
    int cntRemainNodes = 1;
    for (int child : graph.get(root)) {
      int[] temp = dfs(graph, value, child);
      sum += temp[0];
      cntRemainNodes += temp[1];
    }
    if (sum == 0) cntRemainNodes = 0; // Don't count nodes of this subtree
    return new int[] {sum, cntRemainNodes};
  }
}
