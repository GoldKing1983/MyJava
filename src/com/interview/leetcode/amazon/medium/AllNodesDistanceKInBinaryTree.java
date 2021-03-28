package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
===========================================================Requirement===========================================================
Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

					      3
					   /     \
					  5       1
					 / \     / \
					6   2   0   8
				       / \
				      7   4
		target=6, K=2 Answer: 3,2
		target=7, K=2 Answer: 4,5
		target=7, K=3 Answer: 6,3
===========================================================Solution Approach=====================================================
1) Think of folding the tree as graph from targetNode. So at-most a node can have 3 neighbors(parent,left and child)
2) Convert the problem from tree to graph.
Step1) Build a undirected graph using tree-nodes as vertices, and the parent-left-right relation as edges
Step2) Do BFS with source-node (target) to find all vertices with distance K to it.
===========================================================Data Flow Analysis====================================================
[3,5,1,6,2,0,8,null,null,7,4]

dataMap = {0=[1], 1=[3, 0, 8], 2=[5, 7, 4], 3=[5, 1], 4=[2], 5=[3, 6, 2], 6=[5], 7=[2], 8=[1]}
dataMap is to understand the graph structure(parent-child relationship).

 */
public class AllNodesDistanceKInBinaryTree {
  Map<Integer, List<Integer>> adjMap = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    buildMap(root);
    return doBFS(target.val, K);
  }

  private List<Integer>  doBFS(int target, int K) {
    if (!adjMap.containsKey(target)) return new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    LinkedList<Integer> q = new LinkedList<>();
    q.add(target);
    visited.add(target);
    while (K-- > 0) {
      int size = q.size();
      while(size-- > 0) {
        Integer currentNode = q.poll();
        for (Integer neighborNode : adjMap.get(currentNode)) {
          if (visited.contains(neighborNode)) continue;
          visited.add(neighborNode);
          q.add(neighborNode);
        }
      }
    }
    return q;
  }

  private void buildMap(TreeNode root) {
    if (root == null) return;

    buildMap(root.left);
    buildMap(root.right);

    if(root.left!=null) {
      adjMap.computeIfAbsent(root.val, k-> new ArrayList<>()).add(root.left.val);
      adjMap.computeIfAbsent(root.left.val, k-> new ArrayList<>()).add(root.val);
    }
    if(root.right!=null) {
      adjMap.computeIfAbsent(root.val, k-> new ArrayList<>()).add(root.right.val);
      adjMap.computeIfAbsent(root.right.val, k-> new ArrayList<>()).add(root.val);
    }
  }

}
