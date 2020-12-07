package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
===========================================================Requirement===========================================================
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

                    1
                   / \
                  2   5
                 / \   \
                3   4   6
The flattened tree should look like:

                  1
                   \
                    2
                     \
                      3
                       \
                        4
                         \
                          5
                           \
                            6
========================================================Solution Approach========================================================
1) Do swap in post-order traversal
2) setLeft, setRight, setTempRoot
=======================================================Data Flow Analysis========================================================
        input:
                          1
                         / \
                        2   3
        step1:             
                     3.right = null, 3.left=null, pre=3.
        step2:             
                     2.right = 3, 2.left=null, pre=2
                           1
                          /
                         2
                        / \
                       n   3
        step3:                       
                       1.right=2, 1.left=null, pre=1
                           1
                          / \
                         n   2
                            / \
                           n   3
                       
                     

*/
public class FlattenBinaryTreeToLinkedList {



  TreeNode tempRoot = null;

  public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.right);
    flatten(root.left);

    root.left = null;
    //=========Swap Logic=========
    root.right = tempRoot;
    tempRoot = root;
  }
}
