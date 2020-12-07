package com.interview.leetcode.topic.tree; 

import com.interview.leetcode.TreeNode;

/*
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest
means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.

Example:

Input: [10,5,15,1,8,null,7]

   10
   / \
  5  15
 / \   \
1   8   7

Output: 3
Explanation: The Largest BST Subtree in this case is below... 
                            5
                           / \
                          1   8 
We cannot pick 10. Because 10 has 7 on rightSide, which violates BST rule. 
                           

================================================Solution Approach====Similar to ValidBST========================
1) Do ValidBST recursively for each node. If validVST then return the count of nodes.
2) Similar to SubtreeOfAnotherTree.

================================================Time Complexity - O(n^2) worst case==============================================
 */
public class LargestBSTSubtree {
  public int largestBSTSubtree(TreeNode root) {
    if (root == null) return 0;

    if (isValid(Integer.MIN_VALUE, root, Integer.MAX_VALUE)) return count(root);

    int leftLargest = largestBSTSubtree(root.left);
    int rightLargest = largestBSTSubtree(root.right);
    return Math.max(leftLargest, rightLargest);
  }

  public int count(TreeNode n) {
    if (n == null) return 0;
    int leftCount = count(n.left);
    int rightCount = count(n.right);
    return 1 + leftCount + rightCount;
  }

  public boolean isValid(int low, TreeNode root, int high) {
    if (root == null) return true;
    if (root.val <= low || root.val >= high) return false;
    boolean leftIsValid = isValid(low, root.left, root.val);
    boolean rightIsValid = isValid(root.val, root.right, high);
    return leftIsValid && rightIsValid;

  }
}
