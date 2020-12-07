package com.sample.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Compare this problem against DetectCycleInDirectedGraphBetter.
1) Node once visited never needs re-visit again. Because of bi-directional property. It visit everything.
       		1	2
  			 \ /
			  3
Ex:[1,3][2,3]. In Un-Directed Graph all nodes are visited in first DFS itself i.e for source 1

In case of Directed Graph. First DFS for source 1, will visit only path 1 --> 3...
Second DFS will run for 2 and it will see 3 again.

Above is the reason why "DetectCycleInDirectedGraph" needs 2 visited logic.


2) visited is not reseted for "undirected graph" and for directed graph it is reseted.
I feel "directed graph" also does not reset. But big test cases are failing.
This needs some deep-dive.....need to verify with some leetcode problem
 */
public class DetectCycleInUnDirectedGraph {
  public boolean isCyclic() {
    boolean[] visited = new boolean[nodeCount];
    for (int u = 0; u < nodeCount; u++) {
      if (visited[u]) continue;
      visited[u] = true;
      if (isCyclic(u, visited, -1)) return true;
    }
    return false;
  }

  private boolean isCyclic(int parent, boolean[] visited, int grandParent) {

    for (Integer child : adjList.get(parent)) {
      if (visited[child]) {
        // if child and grandParent are same then it is not cycle
        if (child == grandParent) continue;
        return true; // Found Cycle
      }
      // Mark the current node as visited
      visited[child] = true;
      if (isCyclic(child, visited, parent)) return true;
    }
    return false;
  }

  private final int nodeCount;
  private final List<List<Integer>> adjList;

  public DetectCycleInUnDirectedGraph(int nodeCount) {
    this.nodeCount = nodeCount;
    adjList = new ArrayList<>(nodeCount);
    for (int i = 0; i < nodeCount; i++) adjList.add(new LinkedList<>());
  }

  private void addEdge(int source, int dest) {
    adjList.get(source).add(dest);
    adjList.get(dest).add(source);
  }

  public static void main(String[] args) {
    DetectCycleInUnDirectedGraph g1 = new DetectCycleInUnDirectedGraph(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 1);
    g1.addEdge(3, 4);
    if (g1.isCyclic()) System.out.println("Graph contains cycle");
    else System.out.println("Graph doesn't contains cycle");

    /*			   0-----1
      | 	/
      |   /
      |  /
      | /
      2-----3----4

    */

    DetectCycleInUnDirectedGraph g2 = new DetectCycleInUnDirectedGraph(3);
    g2.addEdge(0, 1);
    g2.addEdge(1, 2);
    if (g2.isCyclic()) System.out.println("Graph contains cycle");
    else System.out.println("Graph doesn't contains cycle");
  }
}
