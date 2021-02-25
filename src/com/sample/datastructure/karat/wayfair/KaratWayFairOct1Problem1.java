package com.sample.datastructure.karat.wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

===========================================================Requirement===========================================================
Given a below tree of parentChild relationship in a array [i,j] where i represents parent and j represent child.
Print all nodes with 0 parent.
Print all nodes with 1 parent.
                                      14         13
                                       \        /
                            2     1     4      12
                             \   /   /  \  \  /
                               3    5    8  9
                               \  /  \       \
                                6     7       11
========================================================Solution Approach========================================================
1) Add all the nodes to map with "key as childNode" and value as "list of parentNodes"
2) For the availableNodes, Add all the node with 0 parent to result.
3) For the availableNodes, Add all the node with 1 parent to result.
 */
public class KaratWayFairOct1Problem1 {

  public static void main(String[] argv) {
    int[][] parentChildPairs = new int[][] {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8},
        {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}};


    System.out.println(getInDegree(parentChildPairs));

  }

  private static List<List<Integer>> getInDegree(int[][] input) {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> zeroParent = new ArrayList<>();
    List<Integer> oneParent = new ArrayList<>();
    Set<Integer> availableNodes = new HashSet<>();
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    for (int[] parentChild : input) {
      int parent = parentChild[0];
      int child = parentChild[1];
      availableNodes.add(parent);
      availableNodes.add(child);
      adjMap.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
    }
    for (Integer node : availableNodes) {
      if (!adjMap.containsKey(node)) zeroParent.add(node);
    }
    result.add(zeroParent);

    for (Map.Entry<Integer, List<Integer>> entry : adjMap.entrySet()) {
      if (entry.getValue().size() == 1) {
        oneParent.add(entry.getKey());
      }
    }
    result.add(oneParent);

    return result;
  }


}
