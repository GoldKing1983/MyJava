package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/sum-root-to-leaf-numbers/
*
* Similar to PathSumII2.java

Input:
		   1
	     /   \
	    2     3
	   / \   / \
	  4   5 6   7
Output: 522

============Approach1 School Maths===================================
Below approach is difficult to implement due to
1) I need to have different denominator(1,10,100) at different levels.
2) I need to do bottom-up recursion for the sum to work.

		4*1 + 2*10 + 1*100 = 124
		5*1 + 2*10 + 1*100 = 125
		6*1 + 3*10 + 1*100 = 136
		7*1 + 3*10 + 1*100 = 137
			  		        =====
					         522
					        =====
=============Approach2 Logical=====Implemented Below=========================================
1) Just forward recursion.
1a) Only PreOrder traversal will work. Because node needs to be processed first.
https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/328601/all-dfs-traversals-preorder-postorder-inorder-in-java-in-5-lines
2) Multiply 10 for each node.
3) If leaf node found. Add currentSum to sum which is final answer.

		0*10 + 1 = 1     ==> level0
		1*10 + 2 = 12    ==> level1 left
		1*10 + 3 = 13    ==> level1 right

		12*10+ 4 = 124   ==> level2
		12*10+ 5 = 125   ==> level2
		13*10+ 6 = 136   ==> level2
		13*10+ 7 = 137   ==> level2
==============

*/
public class SumRootToLeafNumbersTopDown {
  public int sumNumbers(TreeNode root) {

    recur(root, 0);
    return sum;
  }

  int sum = 0;

  private void recur(TreeNode root, int currentNumber) {
    if (root == null) return;
    int nextNumber = currentNumber * 10 + root.val;

    if (root.left == null && root.right == null) {
      sum += nextNumber;
      return;
    }

    recur(root.left, nextNumber);
    recur(root.right, nextNumber);
  }
}
