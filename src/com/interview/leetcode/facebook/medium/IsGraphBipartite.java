package com.interview.leetcode.facebook.medium;

/*
===========================================================Requirement===========================================================
https://leetcode.com/problems/is-graph-bipartite/description/
https://www.geeksforgeeks.org/bipartite-graph/

Given an undirected graph, return true if and only if it is bipartite.

A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph 
has one node in A and another node in B.
========================================================Solution Approach========================================================
1. Eagerly assign RED color to the source vertex(0th node) (putting into set U).
2. Color all the neighbors with BLUE color (putting into set V).
3. Color all neighbor’s neighbor with RED color (putting into set U).
4. This way, assign color to all vertices.
5. While assigning colors, if we find a neighbor which is colored with different color as current vertex,
then graph is not Bipartite.

Null  : Haven't been colored yet or not visited
true : colored. Red.
false  : colored. Blue 
=======================================================Data Flow Analysis========================================================
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.


       0(Red) ---> 1(Blue) ---> 
                               0(Red) colored already.
                               2(Red)
                               return back.
                               
                   3(Blue) --->
                               0(Red) colored already.
                               2(Red) colored already.
                               return back.
       1 colored already.
       2 colored already.
       3 colored already.
       
       return true.
=================================================================================================================================       
 */
public class IsGraphBipartite {

  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    Boolean[] colors = new Boolean[n];

    // This graph might be a disconnected graph. So check each unvisited node.
    for (int i = 0; i < n; i++) {
      if (colors[i] == null) {
        colors[i] = true;
        validColor(graph, colors, i);
        if (!isBiPartite) return false;
      }

    }
    return true;
  }

  private boolean isBiPartite = true;

  public void validColor(int[][] graph, Boolean[] colors, int parent) {
    boolean parentColor = colors[parent];
    for (int child : graph[parent]) {
      if (colors[child] == null) { // not colored or not visited
        colors[child] = !parentColor; // Assign child node with opposite of parentColor
        validColor(graph, colors, child);
      } else if (colors[child] == parentColor) {// if parent and child has same color. Terminate with false.
        isBiPartite = false;
        return;
      }
    }
  }
}
