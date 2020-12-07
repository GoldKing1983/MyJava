package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*
https://coding-interview-solutions.hackingnote.com/problems/clone-binary-tree.html

See Also CloneNAryTree/CloneGraphDFS
 */
public class CloneTree {
  public TreeNode cloneTree(TreeNode root) {
    if (root == null) return null;
    TreeNode clone = new TreeNode(root.val);
    clone.left = cloneTree(root.left);
    clone.right = cloneTree(root.right);
    return clone;
  }
}
