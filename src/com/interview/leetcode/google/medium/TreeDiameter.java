package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/tree-diameter/

This problem wants us to think tree as n-ary structure. So there can be more than 1 child for a node.


1) build AdjacentList. Map is not needed, because node starts from 0 and ends at n.
1a) We build Bi-directional map because tree is "undirected tree".
2) do dfs from node 0.
2a) In case of binary tree (DiameterOfBinaryTree), there will be leftTreeHeight and rightTreeHeight.
But here there can be more than 2 maxDepth for a node. So Result is maxDepth1+maxDepth2.
2b) But diameter returns "maxDepth1+1". Ex: "DiameterOfBinaryTreeOrLongestPath" returns Math.max(leftTreeHeight, rightTreeHeight) + 1
2c) Look DiameterOfBinaryTreeOrLongestPath. It is exactly same logic.
Difference is a) In this problem tree can have more than 2 leaf.
			  b) In this problem tree is undirected tree or bidirectional.

input = [[0,1],[1,2],[2,3],[1,4],[4,5]]
AdjacentList =[[1], [0, 2, 4], [1, 3], [2], [1, 5], [4]]
Output: 4 longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
							   0
							  /
							 1
							/ \
						   2   4
						  /		\
						 3 		 5

========================How Parent is skipped to avoid going in-definite loop===============
parent= 0 child= 1 Skipping Child false
parent= 1 child= 0 Skipping Child true
parent= 1 child= 2 Skipping Child false
parent= 2 child= 1 Skipping Child true
parent= 2 child= 3 Skipping Child false
parent= 3 child= 2 Skipping Child true
parent= 1 child= 4 Skipping Child false
parent= 4 child= 1 Skipping Child true
parent= 4 child= 5 Skipping Child false
parent= 5 child= 4 Skipping Child true
=============================================================================================
For Node: 3 maxDepth1st 0 maxDepth2nd 0
For Node: 2 maxDepth1st 1 maxDepth2nd 0
For Node: 5 maxDepth1st 0 maxDepth2nd 0
For Node: 4 maxDepth1st 1 maxDepth2nd 0
For Node: 1 maxDepth1st 2 maxDepth2nd 2
For Node: 0 maxDepth1st 3 maxDepth2nd 0
=============================================================================================
Time: O(n), where n is the number of edges in the tree
Space: O(n)


Bi-directional mapping is needed because tree is un-directed. Check for below input.
If we don't save it like "graph bi-direction" then for below input tree looks like disconnected tree.
[[2,0],[1,2]] Output: 2

			 1	 0
			  \	/
			   2
Changing List to Set for below case.
 [[2,0],[0,2]] Output:1

 */
public class TreeDiameter {
  private int maxDiameter = 0;
  private List<Set<Integer>> adjacentList = new ArrayList<>();

  public int treeDiameter(int[][] edges) {
    buildAdjMatrix(edges);
    dfs(0, -1, adjacentList);
    return maxDiameter;
  }

  private void buildAdjMatrix(int[][] edges) {
    for (int i = 0; i <= edges.length; ++i) adjacentList.add(new HashSet<>());
    for (int[] edge : edges) {
      adjacentList.get(edge[0]).add(edge[1]);
      adjacentList.get(edge[1]).add(edge[0]);
    }
  }

  private int dfs(int root, int parent, List<Set<Integer>> adjacentList) {
    int maxDepth1st = 0, maxDepth2nd = 0;
    for (int child : adjacentList.get(root)) {
      // Only one way from root node to child node, don't allow child node go to root node again!
      if (child == parent) continue;
      int currentMaxDepth = dfs(child, root, adjacentList);

      // Update maxDepth1st and maxDepth2nd
      if (currentMaxDepth > maxDepth1st) {
        maxDepth2nd = maxDepth1st;
        maxDepth1st = currentMaxDepth;
      } else if (currentMaxDepth > maxDepth2nd) maxDepth2nd = currentMaxDepth;
    }

    // Sum of the top 2 highest depths is the longest path through this root
    int longestPathThroughRoot = maxDepth1st + maxDepth2nd;
    maxDiameter = Math.max(maxDiameter, longestPathThroughRoot);
    // "TreeHeight" sends the max only i.e "Math.max(left, right) +1". So similar logic
    return maxDepth1st + 1;
  }
}
