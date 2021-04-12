package com.interview.datastructure.karat.wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

===========================================================Requirement===========================================================
Given a below tree of parentChild relationship in a array [i,j] where i represents parent and j represent child.
Find whether any 2 node has common parent.

         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11
  
  
  
hasCommonAncestor( 3, 8) => false
hasCommonAncestor( 5, 8) => true
hasCommonAncestor( 6, 8) => true
hasCommonAncestor( 6, 9) => true
hasCommonAncestor( 1, 3) => false
hasCommonAncestor( 3, 1) => false
hasCommonAncestor( 7, 11) => true
hasCommonAncestor( 6, 5) => true
hasCommonAncestor( 5, 6) => true

========================================================Solution Approach========================================================
1) Add all the nodes to map with "key as childNode" and value as "list of parentNodes"
2) For the node1, do DFS and collect all parents in node1AllParents.
3) For the node2, do DFS and collect all parents in node2AllParents.
4) If any of node1AllParents and node2AllParents matches then return true

 */
public class KaratWayFairOct1Problem2 {

    public static void main(String[] args) {
        // input for hasCommonAncestor
        int[][] parentChildPairs = new int[][]{

                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12},
                {12, 9}


        };

        printCommonAncestor(parentChildPairs);

    }

    private static Map<Integer, List<Integer>> adjMap = new HashMap<>();

    private static void printCommonAncestor(int[][] input) {

        for (int[] parentChild : input) {
            int parent = parentChild[0];
            int child = parentChild[1];
            adjMap.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
        }
        System.out.println(hasCommonAncestor(3, 8));
        System.out.println(hasCommonAncestor(5, 8));
        System.out.println(hasCommonAncestor(6, 8));
        System.out.println(hasCommonAncestor(6, 9));
        System.out.println(hasCommonAncestor(1, 3));
        System.out.println(hasCommonAncestor(3, 1));
        System.out.println(hasCommonAncestor(7, 11));
        System.out.println(hasCommonAncestor(6, 5));
        System.out.println(hasCommonAncestor(5, 6));


    }

    private static boolean hasCommonAncestor(int node1,
                                             int node2) {
        Set<Integer> node1AllParents = new HashSet<>();
        Set<Integer> node2AllParents = new HashSet<>();
        dfs(node1AllParents, node1);
        dfs(node2AllParents, node2);
        for (Integer node : node1AllParents) {
            if (node2AllParents.contains(node)) return true;
        }
        return false;
    }

    // result holds the path from child to all the
    private static void dfs(Set<Integer> result, int source) {

        List<Integer> connectedParent = adjMap.get(source);
        if (connectedParent != null) {
            for (Integer nextParent : connectedParent) {
                result.add(nextParent);
                dfs(result, nextParent);
            }
        }

    }

}
