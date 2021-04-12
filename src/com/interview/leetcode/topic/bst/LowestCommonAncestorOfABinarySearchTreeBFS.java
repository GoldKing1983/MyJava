package com.interview.leetcode.topic.bst;

import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
Note: node1 and node2 are always different and both values will always exist in the BST.

                              5
                             / \
                            1   10 

node1=1 and node2=10.  Ans=5
node1=1 and node2=5.   Ans=5
node1=5 and node2=10.  Ans=5

=================================================================================================================================
 */
public class LowestCommonAncestorOfABinarySearchTreeBFS {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      if (curr.val < p.val && curr.val < q.val) queue.add(curr.right);
      else if (curr.val > p.val && curr.val > q.val) queue.add(curr.left);
      else return curr;
    }

    return root;
  }
}
