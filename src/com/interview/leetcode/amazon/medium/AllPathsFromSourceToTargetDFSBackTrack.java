package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/all-paths-from-source-to-target/
==========================================================Requirement============================================================
Given a directed, "acyclic graph - no cycle" of N nodes.
Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
graph[i] is a list of all nodes j for which the edge (i, j) exists.

Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.

=========================================================Solution approach=======================================================
1) No visited logic is needed. Because graph is not having cycle. Just DFS.
2) This is memory efficient code as compare to AllPathsFromSourceToTargetDFSClone.

 */
public class AllPathsFromSourceToTargetDFSBackTrack {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();

    currentPath.add(0);
    dfsSearch(graph, 0, result, currentPath);

    return result;
  }

  private void dfsSearch(int[][] graph, int parent, List<List<Integer>> allPath,
      List<Integer> currentPath) {
    if (parent == graph.length - 1) {
      allPath.add(new ArrayList<Integer>(currentPath));
      return;
    }

    for (int child : graph[parent]) {
      currentPath.add(child);
      dfsSearch(graph, child, allPath, currentPath);
      currentPath.remove(currentPath.size() - 1);
    }
  }
}
