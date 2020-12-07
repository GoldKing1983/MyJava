package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
  https://leetcode.com/problems/increasing-order-search-tree/
  
===========================================================Requirement===========================================================
1) Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree
and make a skewed tree out of it.

Input: 
                      1
                     / \
                    2   3
                    
Output:              
                      2
                       \
                        1
                         \
                          3
===========================================================Solution Approach=====================================================
1) Do InOrder Traversal. Because we need to form result as left,root,right.

2) During the firstTime resultRoot is assigned with currentNode (i.e) 2
3) From secondTime onwards resultRoot.right=currentNode (i.e) 2sRight = 1 then 1sRight=3......

4) I need to return resultRoot created during firstTime. So cache the resultRoot during the firstTime and send it in result.       
  
 */
public class IncreasingOrderSearchTree {

  TreeNode cacheResultRoot = null;
  TreeNode resultRoot = null;

  public TreeNode increasingBST(TreeNode root) {
    if (root == null) return null;
    recur(root);
    return cacheResultRoot;
  }

  public void recurStep1(TreeNode root) {
    if (root == null) return;
    recur(root.left);

    TreeNode currentNode = new TreeNode(root.val);
    // === Add Logic to assign this node as skewed node.

    recur(root.right);
  }

  private void recur(TreeNode root) {
    if (root == null) return;
    recur(root.left);

    // Clone/Create the rootValue  
    TreeNode currentNode = new TreeNode(root.val);
    if (cacheResultRoot == null) {
      resultRoot = currentNode;
      cacheResultRoot = resultRoot;
    } else {
      resultRoot.right = currentNode;
      resultRoot = resultRoot.right;
    }

    recur(root.right);
  }
}
