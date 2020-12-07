package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;

/*

1) This code is a mixture of "InorderSuccessorInBSTTopDown" and "InorderSuccessorInBSTBottomUp".
2) Like "InorderSuccessorInBSTTopDown" sets globally the cacheLeftNode.
3) Like "InorderSuccessorInBSTBottomUp" returns result all the bubbling up.

 */
public class InorderSuccessorInBSTBest {

  TreeNode cacheLeftNode = null;

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) return null;

    if (root.val <= p.val) return inorderSuccessor(root.right, p);

    cacheLeftNode = root;
    inorderSuccessor(root.left, p);
    return cacheLeftNode;
  }
}
