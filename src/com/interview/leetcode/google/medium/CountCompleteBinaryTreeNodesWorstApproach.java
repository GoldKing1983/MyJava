package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/count-complete-tree-nodes/description/
Given a complete binary tree, count the number of nodes.

	Input:
		     1
		   /   \
		  2     3
		 / \   /
		4   5 6

	Output: 6

Complete Binary Trees are filled from left to right "strictly".
So left node might(or equal) be having 1 node greater than right node.
 ===Time Complexity: O(n) solution approach=======
Check method "countNodes_TimeLimitExceeded"  which fails.
It is a simple height of tree with "return as 0 if null" and without (Math.max)

*/
public class CountCompleteBinaryTreeNodesWorstApproach {

  /*
  O(n). Base on TreeHeight logic.
  Below code visits every node in tree, which causes Too much time and fails when there are too many nodes.
  */
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftCount = countNodes(root.left);
    int rightCount = countNodes(root.right);
    return leftCount + rightCount + 1;
  }
}
