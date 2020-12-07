package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/possible-bipartition/
https://www.geeksforgeeks.org/bipartite-graph/
1) Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
2) Each person may dislike some other people, and they should not go into the same group.
3) Ex: dislikes[i] = [a, b] means it is not allowed to put the people numbered a and b into the same group.
4) Return true if and only if it is possible to split everyone into two groups in this way.

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Input: N = 5, dislikes = [[1,2],[2,3],[4,5],[3,4]]
Output: True
============================================Solution Approach===================================================
0: Haven't been colored yet.
1: Red.
2: Blue.

0) Save member and their enemies in adjList.
1) Eagerly assign RED color to the source vertex(0th node) (putting into set U).
2) Color all the neighbors with BLUE color (putting into set V).
3) Color all neighbor’s neighbor with RED color (putting into set U).
4) This way, assign color to all vertices.
5) While assigning colors, if we find a neighbor which is colored with different color as current vertex,
then graph is not Bipartite.
================================================Data Flow Analysis================================================
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]

						          (2:Blue)  (1:Red)
					   (1:Red) ------2---->---4---->---
					----1---->|	  (2:Blue)
							   ------3------>-------->---

adjList is : [[], [2, 3], [1, 4], [1], [2]]
Coloring is done for node : 1 and its children's. Updated colors are : [0, 1, 2, 2, 1]
Coloring is already done for node : 2. So skipping it.
Coloring is already done for node : 3. So skipping it.
Coloring is already done for node : 4. So skipping it.
===================================================================================================================
 */
public class PossibleBipartitionDFS {
  public boolean possibleBipartition(int n, int[][] dislikes) {
    int[] colors = new int[n + 1]; // node start from 1 and not 0. So add 1 more entry.
    List<List<Integer>> adjList = new ArrayList<>(n + 1);
    for (int i = 0; i <= n; i++) adjList.add(new ArrayList<Integer>());
    for (int[] dislike : dislikes) { // Un-Directed Graph. So initialize both ways.
      adjList.get(dislike[0]).add(dislike[1]);
      adjList.get(dislike[1]).add(dislike[0]);
    }
    for (int i = 1; i <= n; i++) {
      if (colors[i] != 0) continue; // color assigned already. No need to traverse
      colors[i] = 1; // Eagerly assign color1.
      if (dfs(adjList, colors, i)) continue;
      return false;
    }
    return true;
  }

  private boolean dfs(List<List<Integer>> adjList, int[] colors, int parent) {

    for (Integer children : adjList.get(parent)) {
      if (colors[children] == 0) {
        // If parent is 1 set children 2. Else set children as 1
        colors[children] = colors[parent] == 1 ? 2 : 1;
        if (!dfs(adjList, colors, children)) return false;
      } else {
        // We don't need to do dfs, if the children got color already.
        // We need to verify only, if the children got right color.
        if (colors[children] == colors[parent]) return false;
      }
    }
    return true;
  }
}
