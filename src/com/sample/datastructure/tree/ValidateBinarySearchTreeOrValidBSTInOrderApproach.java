package com.sample.datastructure.tree;

import com.interview.leetcode.TreeNode;

/*

https://leetcode.com/problems/validate-binary-search-tree/

1) If I print the BST in in-order, I will be getting data in ascending order.
2) So if prev >= curr return false.  
 */
public class ValidateBinarySearchTreeOrValidBSTInOrderApproach {
  TreeNode prev = null;

  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    boolean left = isValidBST(root.left);
    if (prev == null) prev = root;
    else {
      if (prev.val >= root.val) return false;
      prev = root;
    }
    boolean right = isValidBST(root.right);
    return left && right;
  }
}
