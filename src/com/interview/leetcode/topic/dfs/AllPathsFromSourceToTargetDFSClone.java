package com.interview.leetcode.topic.dfs;

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
    return dfs(graph, 0, graph.length - 1, new ArrayList<>(), new ArrayList<>());
  }

  private List<List<Integer>> dfs(int[][] graph, int source, int destination,
      List<Integer> currResult, List<List<Integer>> result) {

    currResult.add(source); // add current node to result 
    if (source == destination) { // if source reached destination add that path in result
      result.add(currResult);
      return result;
    }
    for (Integer child : graph[source]) {
      List<Integer> copyList = new ArrayList<>(currResult); // clone the path
      dfs(graph, child, destination, copyList, result);
    }
    return result;
  }
}
