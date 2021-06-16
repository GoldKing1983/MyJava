package com.interview.leetcode.topic.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/all-paths-from-source-to-target/
===========================================Requirement======================================================================
Given a directed, "acyclic graph - no cycle" of N nodes.
Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes starts from 0, 1, ...to graph.length - 1.
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
1) No visited logic is needed. Because graph is not having cycle. Just BFS.
2) This consumes more memory. Because even for invalid path. path will be created.

 */
public class AllPathsFromSourceToTargetBFSClone {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new ArrayList<>();

    Queue<List<Integer>> q = new LinkedList<>();
    q.add(Arrays.asList(0)); // Adding source to the queue

    int destination = graph.length - 1;

    while (!q.isEmpty()) {
      List<Integer> pathSoFar = q.poll();
      int lastNode = pathSoFar.get(pathSoFar.size() - 1); // Ex: [0,1,2].. lastNode=2
      // check if lastNode is destination add pathSoFar in result
      if (lastNode == destination) result.add(new ArrayList<>(pathSoFar));
      for (int child : graph[lastNode]) {
        List<Integer> newPath = new ArrayList<>(pathSoFar);
        newPath.add(child);
        q.add(newPath);
      }
    }

    return result;
  }
}
