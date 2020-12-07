package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/insert-into-a-binary-search-tree/
===========================================================Requirement===========================================================
Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
insert the value into the BST

=======================================================Data Flow Analysis========================================================
                         10
                        /  \
                       n    25
1) If I want to insert 5.
2) 5 is less than 10. So root.left = recur(null).
3) On seeing null base condition satisfied and will return node(5)
4) root.left = node(5).
5) root 10 will be returned.

If I want to insert 15. Then it will be
                         10
                        /  \
                       n    25
                           /
                          15

Another possible solution is below. But that is tricky which we don't want to code.
                         10
                        /  \
                       n    15
                             \
                              25

=================================================================================================================================
 */

public class InsertIntoABinarySearchBottomUp {
  public TreeNode insertIntoBST(TreeNode root, int target) {
    if (root == null) return new TreeNode(target);

    if (target < root.val) root.left = insertIntoBST(root.left, target);

    else root.right = insertIntoBST(root.right, target);

    return root;
  }
}
