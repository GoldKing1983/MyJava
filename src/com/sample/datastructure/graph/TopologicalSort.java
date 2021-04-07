package com.sample.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
====
Fibonacci series can be said as Topological Series.
Because to get f(n), pre-requisites are f(n-1) and f(n-2).
to get f(n-1), pre-requisites are f(n-2) and f(n-3).
=======
1) It is on directed graph
2) Can be done only on Acyclic(no cycle) graph.
3) There can be more than one answer can come for the sorting.
Answer can be 12345 or 12354
4) Applications are 1) Pre-Requisite problem(CourseSchedule.java),2) Task Scheduling
5) indegree field is about number of incoming edges for a node.

 Ex: [1,2] [1,3] [2,4][3,4]
 			   ---->2----
 		1---->|          |---->4
 			   ---->3----

 Here 4 cannot come before 3 and 2... So possible output is 1234 or 1324. The above example is not a cycle.
 *	Note: sortedOrder saves only 1 possible output. Ex: either 1234 or 1324
 */
public class TopologicalSort {
  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    if (vertices <= 0) return sortedOrder;

    // a. Initialize the graph. // count of incoming edges for every vertex
    HashMap<Integer, Integer> inDegree = new HashMap<>();
    HashMap<Integer, List<Integer>> adjMatrix = new HashMap<>(); // adjacency list graph
    for (int i = 0; i < vertices; i++) {
      inDegree.put(i, 0);
      adjMatrix.put(i, new ArrayList<>());
    }

    // b. Build the graph
    for (int i = 0; i < edges.length; i++) {
      int parent = edges[i][0], child = edges[i][1];
      adjMatrix.get(parent).add(child); // put the child into it's parent's list
      inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
    }

    // c. Find all sources i.e., all vertices with 0 in-degrees
    Queue<Integer> sourceQ = new ArrayDeque<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) sourceQ.add(entry.getKey());
    }

    // d. For each source(parent), add it to the sortedOrder and subtract one from all of its
    // children's in-degrees, if a child's in-degree is zero, add it to the sources queue
    while (!sourceQ.isEmpty()) {
      int parent = sourceQ.poll();
      sortedOrder.add(parent);
      // get the node's children to decrement their in-degrees
      List<Integer> children = adjMatrix.get(parent);
      for (int child : children) {
        inDegree.put(child, inDegree.get(child) - 1);
        if (inDegree.get(child) == 0) sourceQ.add(child);
      }
    }
    // topological sort is not possible as the graph has a cycle
    if (sortedOrder.size() != vertices) return new ArrayList<>();

    return sortedOrder;
  }
}
