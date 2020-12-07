package com.sample.datastructure.karat.wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11
  
  
  
hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 3, 1) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true



 */
public class KaratWayFairOct1Problem2 {

  public static void main(String[] args) {
    // input for hasCommonAncestor
    int[][] parentChildPairs = new int[][] {

        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12},
        {12, 9}


    };

    printCommonAncestor(parentChildPairs);

  }

  private static void printCommonAncestor(int[][] input) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    for (int[] parentChild : input) {
      int parent = parentChild[0];
      int child = parentChild[1];
      adjMap.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
    }
    System.out.println(hasCommonAncestor(adjMap, 3, 8));
    System.out.println(hasCommonAncestor(adjMap, 5, 8));
    System.out.println(hasCommonAncestor(adjMap, 6, 8));
    System.out.println(hasCommonAncestor(adjMap, 6, 9));
    System.out.println(hasCommonAncestor(adjMap, 1, 3));
    System.out.println(hasCommonAncestor(adjMap, 3, 1));
    System.out.println(hasCommonAncestor(adjMap, 7, 11));
    System.out.println(hasCommonAncestor(adjMap, 6, 5));
    System.out.println(hasCommonAncestor(adjMap, 5, 6));


  }

  private static boolean hasCommonAncestor(Map<Integer, List<Integer>> adjMap, int child1,
      int child2) {
    Set<Integer> child1AllParents = new HashSet<>();
    Set<Integer> child2AllParents = new HashSet<>();
    dfs(adjMap, child1AllParents, child1);
    dfs(adjMap, child2AllParents, child2);
    for (Integer node : child1AllParents) {
      if (child2AllParents.contains(node)) return true;
    }
    return false;
  }

  // result holds the path from child to all the 
  private static void dfs(Map<Integer, List<Integer>> adjMap, Set<Integer> result, int source) {

    List<Integer> connectedParent = adjMap.get(source);
    if (connectedParent != null) {
      for (Integer nextParent : connectedParent) {
        result.add(nextParent);
        dfs(adjMap, result, nextParent);
      }
    }

  }

}
