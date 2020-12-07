package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
*
Input: n = 4, edges = [[2,3],[1,2],[1,3]] , Output: 2... Input is connected all the way and forming only 1 connection.
But 1 node is hanging which is not given in edges relation. So output= connectedCount + n-nodesWithVisitedFlag.size();
*
*/
public class NumberOfConnectedComponentsInAnUndirectedGraph_DFS {
  public int countComponents(int n, int[][] edges) {
    Map<Integer, List<Integer>> adjMatrixMap = new HashMap<>();
    for (int i = 0; i <= n; i++) adjMatrixMap.put(i, new ArrayList<>());
    for (int i = 0; i < edges.length; i++) {
      adjMatrixMap.get(edges[i][0]).add(edges[i][1]);
      adjMatrixMap.get(edges[i][1]).add(edges[i][0]);
    }
    Set<Integer> isVisited = new HashSet<>();
    int connectedCount = 0;
    for (int i = 1; i <= n; i++) {
      if (isVisited.add(i)) {
        connectedCount++;
        doDFS(adjMatrixMap, i, isVisited);
      }
    }
    // Hanging nodes with no connections should be added in result. which is done by below line.
    return connectedCount + n - isVisited.size();
  }

  private void doDFS(
      Map<Integer, List<Integer>> adjMatrixMap, int parentNode, Set<Integer> isVisited) {
    for (Integer childNode : adjMatrixMap.get(parentNode)) {
      if (isVisited.add(childNode)) {
        doDFS(adjMatrixMap, childNode, isVisited);
      }
    }
  }
}
