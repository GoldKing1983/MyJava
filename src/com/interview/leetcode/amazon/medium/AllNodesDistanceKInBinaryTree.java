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
1) Convert the problem from tree to graph.
2) Build a undirected graph using tree-nodes as vertices, and the parent-child relation as edges
3) Do BFS with source-node (target) to find all vertices with distance K to it.

===========================================================Data Flow Analysis====================================================
[3,5,1,6,2,0,8,null,null,7,4]

dataMap = {0=[1], 1=[3, 0, 8], 2=[5, 7, 4], 3=[5, 1], 4=[2], 5=[3, 6, 2], 6=[5], 7=[2], 8=[1]}
dataMap is to understand the graph structure(parent-child relationship).

 */
public class AllNodesDistanceKInBinaryTree {
  Map<TreeNode, List<TreeNode>> adjMap = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    List<Integer> result = new ArrayList<>();
    if (root == null || K < 0) return result;

    adjMap.put(root, new ArrayList<>());
    buildMap(root.left, root);
    buildMap(root.right, root);

    if (!adjMap.containsKey(target)) return result;
    Set<TreeNode> visited = new HashSet<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(target);
    visited.add(target);
    while (!q.isEmpty()) {
      int size = q.size();
      if (K == 0) {
        for (int i = 0; i < size; i++) result.add(q.poll().val);
        return result;
      }
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        for (TreeNode next : adjMap.get(node)) {
          if (visited.contains(next)) continue;
          visited.add(next);
          q.add(next);
        }
      }
      K--;
    }
    return result;
  }

  /*
   * Do Pre-Order or Post-Order Traversal. Both will work.  
             1
            / \
           2   3
    1) 1 will be added already to map in main method. with child empty.
    =========buildMap will called with 2 as root and 1 as parent.=========
    2) Put 2 to map, with child empty.
    3) Connect 1 and 2. Connect 2 and 1.
    =========buildMap will called with 3 as root and 1 as parent.=========
    4) Put 3 to map, with child empty.
    5) Connect 1 and 3. Connect 3 and 1.            
   */
  private void buildMap(TreeNode root, TreeNode parent) {
    if (root == null) return;

    adjMap.put(root, new ArrayList<>());
    adjMap.get(root).add(parent);
    adjMap.get(parent).add(root);

    buildMap(root.left, root);
    buildMap(root.right, root);
  }

}
