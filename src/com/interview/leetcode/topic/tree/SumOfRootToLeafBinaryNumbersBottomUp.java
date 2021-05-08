package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/



=============Note: Previous result for root node is 0.=====================
				    1        -----level0------
				   / \
				  0   1      -----level1------
		   -----level0------
   					0*2+1 = 1
   		   -----level1------
 					1*2+0 = 2
 					1*2+1 = 3
 					      ===
 					        5
====================================================================================================

 */
public class SumOfRootToLeafBinaryNumbersBottomUp {
  public int sumRootToLeaf(TreeNode root) {
    return recur(root, 0);
  }

  private int recur(TreeNode root, int currentNumber) {
    if (root == null) return 0;

    currentNumber = currentNumber * 2 + root.val;

    if (root.left == null && root.right == null) return currentNumber;

    int left = recur(root.left, currentNumber);
    int right = recur(root.right, currentNumber);

    return left + right;
  }
}
