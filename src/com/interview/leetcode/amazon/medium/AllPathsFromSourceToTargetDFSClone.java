package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/all-paths-from-source-to-target/
===========================================Requirement======================================================================
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

===========================================Solution approach:======================================================================
1) No visited logic is needed. Because graph is not having cycle. Just DFS.
2) This consumes more memory. Because even for invalid path. path will be created.
*/
public class AllPathsFromSourceToTargetDFSClone {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(graph, 0, graph.length - 1, new ArrayList<>(), result);
    return result;
  }

  private void dfs(
      int[][] graph, int source, int destination, List<Integer> list, List<List<Integer>> result) {
    // if soruce reached destination add that path in result
    if (source == destination) {
      result.add(list);
      return;
    }
    list.add(source); // add current vertex
    for (Integer vertex : graph[source]) {
      List<Integer> copyList = new ArrayList<>(list); // clone the path
      dfs(graph, vertex, destination, copyList, result);
    }
  }
}
