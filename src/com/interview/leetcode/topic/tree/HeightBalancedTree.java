package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
===========================================================Requirement===========================================================
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.
============================================================Example1=============================================================
                        1
                       / \
                      2   3
                     / \
                    4   5
                   / \
                  6   7
output: false                     
============================================================Example2=============================================================
                            a
                       /        \
                      b          c
                    /   \       / \
                   d     e     l   m 
                  / \   / \   / \
                 f   g h   i n   o
                / \
               j   k
output: true
                        
 */

public class HeightBalancedTree {

  public boolean isBalanced(TreeNode node) {
    recur(node);
    return isBalanced;
  }

  private boolean isBalanced = true;

  private int recur(TreeNode node) {
    //if(!isBalanced) return 0; // If balanced is false. No more recursion needed.
    if (node == null) return 0;

    /* Get the height of left and right sub trees */
    int leftHeight = recur(node.left);
    int rightHeight = recur(node.right);

    if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;

    return Math.max(leftHeight, rightHeight);
  }


}
