package com.sample.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

See Image DirectedGraphCyclicVsAcyclic.jpg

1) In the current recursion, if the same node visited for more than 1 time. Then there is a cycle.
Ex: 1 -> 2, 2 - > 3, 3 -> 1....1 comes 2nd time
		 ----------<---------
		|					 |
	    |		  ---->2---->3
		 -->1----|
			      ---->

visited manages cycle.

 */
public class DetectCycleInDirectedGraph {
  private boolean isCyclic(int source, boolean[] visited) {
    for (Integer child : adjList.get(source)) {
      if (visited[child]) return true;
      visited[child] = true;
      if (isCyclic(child, visited)) {
        return true;
      }
    }
    visited[source] = false; // reset visited to reuse in main function.
    return false;
  }

  private boolean isCyclic() {
    boolean[] visited = new boolean[nodeCount];
    for (int i = 0; i < nodeCount; i++) {
      visited[i] = true;
      if (isCyclic(i, visited)) return true;
    }
    return false;
  }

  private final int nodeCount;
  private final List<List<Integer>> adjList;

  public DetectCycleInDirectedGraph(int nodeCount) {
    this.nodeCount = nodeCount;
    adjList = new ArrayList<>(nodeCount);
    for (int i = 0; i < nodeCount; i++) adjList.add(new LinkedList<>());
  }

  private void addEdge(int source, int dest) {
    adjList.get(source).add(dest);
  }

  public static void main(String[] args) {
    DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph(4);
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
