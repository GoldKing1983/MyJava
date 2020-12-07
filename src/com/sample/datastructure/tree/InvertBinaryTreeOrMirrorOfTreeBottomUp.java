package com.sample.datastructure.tree;

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
1) Post-Order bottom-up seems reasonable. Pre-Order bottom-up also works
2) Swap 3s left and right return 3.                                
                       1
                     /   \
                    2     3
                   / \   / \
                  n   n n   n
3) Swap 2s left and right return 2.
4) Swap 1s left and right return 1.
                       1
                     /   \
                    3     2
                   / \   / \
                  n   n n   n

                       
=================================================================================================================================
*/
public class InvertBinaryTreeOrMirrorOfTreeBottomUp {
  /*
  Swap is possible if leftNull or rightNull or bothNull or bothNotNull.
  Swap is not possible only if root is null.
  */
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    invertTree(root.left);
    invertTree(root.right);

    // post-order swap. pre-order swap also works
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    return root;
  }
}
