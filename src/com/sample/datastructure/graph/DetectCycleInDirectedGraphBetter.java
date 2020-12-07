package com.sample.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
See Image DirectedGraphCyclicVsAcyclic.jpg

1) In the current recursion, if the same node visited for more than 1 time. Then there is a cycle.
Ex: 1 -> 2, 2 - > 3, 3 -> 1 =====================> 1 comes 2nd time
visitedInCurrentRecursion manages  cycle.

2) visitedInOverAllRecursion is for performance and avoids un-necessary visiting of node again.
Ex: 1 -> 3 and 2 -> 3. Now 3 and its childs are visited through 1. So it can be skipped during 2's recursion.
Ignoring visitedInOverAllRecursion will not affect output.

 */
public class DetectCycleInDirectedGraphBetter {

  public boolean isCyclic() {
    boolean[] visitedInOverAllRecursion = new boolean[nodeCount];
    boolean[] visitedInCurrentRecursion = new boolean[nodeCount];
    for (int source = 0; source < nodeCount; source++) {
      if (visitedInOverAllRecursion[source]) continue;
      visitedInOverAllRecursion[source] = true;
      visitedInCurrentRecursion[source] = true;
      if (isCyclic(source, visitedInOverAllRecursion, visitedInCurrentRecursion)) return true;
    }
    return false;
  }

  private boolean isCyclic(
      int parent, boolean[] visitedInOverAllRecursion, boolean[] visitedInCurrentRecursion) {

    for (Integer child : adjList.get(parent)) {
      if (visitedInOverAllRecursion[child]) continue;
      if (visitedInCurrentRecursion[child]) return true;
      visitedInOverAllRecursion[child] = true;
      visitedInCurrentRecursion[child] = true;

      if (isCyclic(child, visitedInOverAllRecursion, visitedInCurrentRecursion)) return true;
    }
    // reset, so that for next recursion it can be used again.
    visitedInCurrentRecursion[parent] = false;
    return false;
  }

  private void addEdge(int source, int dest) {
    adjList.get(source).add(dest);
  }

  private final int nodeCount;
  private final List<List<Integer>> adjList;

  public DetectCycleInDirectedGraphBetter(int nodeCount) {
    this.nodeCount = nodeCount;
    adjList = new ArrayList<>(nodeCount);
    for (int i = 0; i < nodeCount; i++) adjList.add(new LinkedList<>());
  }

  public static void main(String[] args) {
    DetectCycleInDirectedGraphBetter graph = new DetectCycleInDirectedGraphBetter(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);
    /*
    	 ----------<-----------------
    	|					         |
        |		  ----->1----->2-----
    	 -->0----|
    		      ----->2----->3-----
    		      		   |	     |
    		      		    ---------

    */
    if (graph.isCyclic()) System.out.println("Graph contains cycle");
    else System.out.println("Graph doesn't " + "contain cycle");
  }
}
