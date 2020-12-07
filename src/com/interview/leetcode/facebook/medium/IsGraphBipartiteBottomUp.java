package com.interview.leetcode.facebook.medium;

/*
Same as IsGraphBipartite, just removing private variable.

 */
public class IsGraphBipartiteBottomUp {

  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    Boolean[] colors = new Boolean[n];

    // This graph might be a disconnected graph. So check each unvisited node.
    for (int i = 0; i < n; i++) {
      if (colors[i] == null) {
        colors[i] = true;
        if (!isValid(graph, colors, i)) return false;
      }
    }
    return true;
  }


  public boolean isValid(int[][] graph, Boolean[] colors, int parent) {
    boolean parentColor = colors[parent];
    for (int child : graph[parent]) {
      if (colors[child] == null) { // not colored or not visited
        colors[child] = !parentColor; // Assign child node with opposite of parentColor

        // Similar to WordBreakRecursion. There if true, return true. Here if false, return false.
        if (!isValid(graph, colors, child)) return false;

      } else if (colors[child] == parentColor) {// if parent and child has same color. Terminate with false.
        return false;
      }
    }
    return true;
  }
}
