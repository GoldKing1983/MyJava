package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*

https://leetcode.com/problems/sum-root-to-leaf-numbers/

Similar to PathSumII2.java

Input:
		   1
	     /   \
	    2     3
	   / \
	  4   5
	    
	    124
	    125
	     13
	   ==== 
Output: 262
       ====
===================================================Data Flow Analysis==============================================================
Top-To-Bottom
											   1(1)
										     /   \
										(12)2     3(13)
										   / \
									 (124)4   5(125)

Bottom-To-Bottom
											   1(262)
										     /   \
									   (249)2     3(13)
										   / \
									 (124)4   5(125)
============================================Solution Approach======================================================================
Step1) Recurse Left and Right.
Step2) Return Left+Right.
Step3) Add baseCondition. If currentNodes left and right is null. Then return pathSum.
	  For the base case code... just take 2 example
	  Ex1: input: null. Ans=0.  So add ---> if (currentNode == null) return 0;
	  Ex2: input: [1] . Ans=1.
	  		Calculate PathSum : 1
	  		If left and right null then return pathsum...
====================================================================================================================================

*/
public class SumRootToLeafNumbersBottomUp {

  public int sumNumbers(TreeNode root) {

    return recur(root, 0, 0);
  }

  private int recur(TreeNode root, int currentNumber, int sum) {
    if (root == null) return 0;
    int nextNumber = currentNumber * 10 + root.val;

    if (root.left == null && root.right == null) {
      sum += nextNumber;
      return sum;
    }

    int left = recur(root.left, nextNumber, sum);
    int right = recur(root.right, nextNumber, sum);

    return left + right;
  }
}
