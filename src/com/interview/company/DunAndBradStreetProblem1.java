package com.interview.company;

import com.interview.leetcode.TreeNode;

/*
Given a BST. Find the edgeCount or width between 2 nodes.
                     10
                   /    \
                  5      20
                 / \    /  \
                1   7  15   25
                
node1=1 node2=15. Output: edgeCount=4
node1=1 node2=7.  Output: edgeCount=2

======================================================Solution Approach1=========================================================
1) Do LCA of bst (LowestCommonAncestorOfABinarySearchTree) and find parent of node1 and node2.
2) From the parent get the height till node1, say node1Height
3) From the parent get the height till node2, say node2Height.
4) Return node1Height+node2Height            
======================================================Alternate Solution=========================================================
1) From root to node1, save the node hierarchy in list1.
2) From root to node2, save the node hierarchy in list2.
3) Find the sum.
This approach might looks like better, because it does only 2 recursion. But if there are million nodes. the node1 and node2
are at end. Time Complexity : O(h) + O(h).

But Solution Approach1 will take O(h) + O(2) + O(2). So case by case both has advantage.
Also "Solution Approach1" doesn't need any space complexity 
 */
public class DunAndBradStreetProblem1 {

  public int getWidth(TreeNode root, TreeNode node1, TreeNode node2) {
    TreeNode parent = lowestCommonAncestor(root, node1, node2);
    int node1HeightFromParent = getHeight(parent, node1);
    int node2HeightFromParent = getHeight(parent, node2);
    return node1HeightFromParent + node2HeightFromParent;
  }

  private TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
    int rootValue = root.val;
    int node1Value = node1.val;
    int node2Value = node2.val;

    if (rootValue < node1Value && rootValue < node2Value) {
      return lowestCommonAncestor(root.right, node1, node2);
    }
    if (rootValue > node1Value && rootValue > node2Value) {
      return lowestCommonAncestor(root.left, node1, node2);
    }
    return root;
  }

  private int getHeight(TreeNode root, TreeNode target) {
    if (root.val == target.val) return 0;
    if (root.val > target.val) return getHeight(root.left, target) + 1;
    return getHeight(root.right, target) + 1;
  }


}
