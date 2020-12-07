package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.list.Node;


/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
==========================================Solution Approach=================================================================
1) Keep only one node for each level in list.  ------->This is the key for solution.
2) When the secondNode comes, take the previousNode and connect with secondNode(currentNode)
and update secondNode with firstNode in list, for next connection.  

Similar to BinaryTreeLevelOrderTraversalDFS
 */
public class PopulatingNextRightPointersInEachNodeIIDFS {
  public Node connect(Node root) {
    recur(root, 0, new ArrayList<>());
    return root;
  }

  public void recur(Node currentNode, int level, List<Node> list) {
    if (currentNode == null) return;

    if (level == list.size()) { // firstTime for each level add.
      list.add(currentNode);
    } else { // from secondTime connect previousNode with currentNode.
      Node previousNodeOnthatLevel = list.get(level);
      previousNodeOnthatLevel.next = currentNode;
      list.set(level, currentNode);
    }

    recur(currentNode.left, level + 1, list);
    recur(currentNode.right, level + 1, list);

  }
}
