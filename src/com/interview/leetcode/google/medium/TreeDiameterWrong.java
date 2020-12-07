package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/tree-diameter/

Building the tree as "Directed" without parent check will fail in below corner cases.

============================================Corner Cases=================================================
[[2,0],[1,2]] ExpectedOutput: 2

			 1	 0
			  \	/
			   2
But below code will print 0
============================================Corner Cases=================================================
Changing List to Set for below case.
 [[2,0],[0,2]] ExpectedOutput:1

 Below Code will go in InfiniteLoop

 */
public class TreeDiameterWrong {
  private int maxDiameter = 0;
  private List<List<Integer>> adjacentList = new ArrayList<>();

  public int treeDiameter(int[][] edges) {
    buildAdjMatrix(edges);
    dfs(0, adjacentList);
    return maxDiameter;
  }

  private void buildAdjMatrix(int[][] edges) {
    // create "edges.length+1" nodes. Ex:[0,1] 2 nodes.
    for (int i = 0; i <= edges.length; i++) adjacentList.add(new ArrayList<>());
    for (int[] edge : edges) adjacentList.get(edge[0]).add(edge[1]);
  }

  private int dfs(int root, List<List<Integer>> adjacentList) {
    int maxDepth1st = 0, maxDepth2nd = 0;
    for (int child : adjacentList.get(root)) {

      int currentMaxDepth = adjacentList.isEmpty() ? 0 : dfs(child, adjacentList) + 1;

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
    return maxDepth1st;
  }
}
