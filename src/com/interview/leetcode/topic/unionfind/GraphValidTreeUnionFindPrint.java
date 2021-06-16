package com.interview.leetcode.topic.unionfind;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/graph-valid-tree/discuss/69018/AC-Java-Union-Find-solution

 */
public class GraphValidTreeUnionFindPrint {

  public boolean validTree(int n, int[][] edges) {

    // initialize n isolated islands
    int[] nodes = new int[n];

    // initially assign each node to to point itself.
    for (int i = 0; i < n; i++) nodes[i] = i;

    for (int[] edge : edges) {
      //System.out.println("======processing : [" + edge[0] + "," + edge[1] + "]======");  
      int node1 = find(nodes, edge[0]);
      int node2 = find(nodes, edge[1]);

      // if two vertices happen to be in the same set then there's a cycle
      System.out.println(edge[0] + " is pointing " + node1);
      System.out.println(edge[1] + " is pointing " + node2);
      if (node1 == node2) {
        System.out.println("Both the nodes are pointing " + node1 + ". So returning false");
        return false;
      }

      // union

      nodes[node1] = node2;
      System.out.println("Grouping " + edge[0] + " and " + edge[1] + " to " + nodes[node1]);
      System.out.println("Nodes After Grouping : " + Arrays.toString(nodes));

      n--;
    }
    return n == 1;
  }

  public int find(int[] roots, int id) {
    while (true) {
      if (roots[id] == id) return id;
      id = roots[id];
    }

  }
}
