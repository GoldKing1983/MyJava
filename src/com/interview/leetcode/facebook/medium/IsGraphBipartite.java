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

  /*
  1) true is red, false is blue and null is not-colored
  2) Do Dfs.
  3) Start color the node with true...alternatively change it.
  4) If a node is visited check its color, different than current
  
  */
  public boolean solve(int[][] graph) {
    int maxRow = graph.length;
    Boolean[] dp = new Boolean[maxRow];
    for (int row = 0; row < maxRow; row++) {
      if (dp[row] != null) continue; // already colred
      dp[row] = true; // set default color as red
      if (!isBiPartite(graph, dp, row, true)) return false;
    }
    return true;

  }

  private boolean isBiPartite(int[][] graph, Boolean[] dp, int sourceRow, Boolean currentColor) {

    for (int neighbor : graph[sourceRow]) {
      // we don't need to do anything dp[neighbor]==null.. because it is not colored and recursion must run..
      if (dp[neighbor] != null) { // not colored

        // if currentColor and neighborColr same return false
        if (currentColor == dp[neighbor]) return false;
        continue; // already colored... 
      }
      // Assign neighbor node with opposite of parentColor
      dp[neighbor] = !currentColor;
      if (!isBiPartite(graph, dp, neighbor, !currentColor)) return false;
    }
    return true;
  }
}
