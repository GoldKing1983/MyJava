package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/invert-binary-tree/description/
===========================================================Requirement===========================================================
Invert a binary tree

            input:
                      1
                     / \
                    2   3
            output:
                      1
                     / \
                    3   2
========================================================Solution Approach========================================================
1) Do swap in Pre-Order or Post-Order traversal
2) Pre-Order does swap from top to bottom.
3) Post-Order does swap from bottom to top.
4) Performance point : To avoid null swap at leaf, add the condition (parent.left != null || parent.right != null)
=======================================================Data Flow Analysis========================================================

	Ex: 1,2,3
                       1
                     /   \
                    2     3
                   / \   / \
                  n   n n   n

1st swap PreOrder:(2 and 3 swapped)		          1st swap PostOrder:(2sLeft & 2sRight swapped)
			     1										 1
			   /   \								   /   \
			  3     2 								  2     3
             / \   / \                               / \   / \
            n   n n   n                             n   n n   n
             
2nd swap PreOrder:(3sLeft & 3sRight swapped)	  2nd swap PostOrder:(3sLeft & 3sRight swapped)
                 1                                       1
               /   \                                   /   \
              3     2                                 2     3
             / \   / \                               / \   / \
            n   n n   n                             n   n n   n

3rd swap PreOrder:(2sLeft & 2sRight swapped)      3rd swap PostOrder:(2 and 3 swapped)
                 1                                       1
               /   \                                   /   \
              3     2                                 3     2
             / \   / \                               / \   / \
            n   n n   n                             n   n n   n

*/
public class InvertBinaryTreeOrMirrorOfTreeForwardRecursion {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) return root;
    forwardRecurPreOrder(root);
    return root;
  }

  private void forwardRecurPreOrder(TreeNode root) {
    if (root == null) return;

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    // post-order swap. pre-order swap also works
    forwardRecurPreOrder(root.left);
    forwardRecurPreOrder(root.right);
  }


}
