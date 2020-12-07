package com.sample.datastructure.tree;

/*
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/

Requirement
1) Array stores the tree as Pre-Order.
2) Verify if array is valid Pre-Order Tree.
==========================================Logical Thinking assuming nodes=========================================================
If input is [2,1,3], then output is true.
 			 2
 			/ \
 		   1   3
2 is the currentNode.
Push 1 to leftOf2. 1 is the currentNode.
3 cannot go in left or right of 1.
So recursion backtracks to 2. 2 is the currentNode again. So Push 3 to rightOf2
==========================================Logical Thinking assuming nodes=========================================================
If input is [1,2,3], then output is true.
				1
				 \
				  2
				   \
				   	3
1 is the currentNode. Cannot push 2 to leftOf1.
Push 2 to rightOf1. 2 is the currentNode.
Cannot push 3 to leftOf2. Push 3 to rightOf2.
==========================================Logical Thinking assuming nodes=========================================================
If input is [3,2,1], then output is true.
 		   		 3
 		   		/
 		   	   2
 		   	  /
 		   	 1
==========================================Logical Thinking assuming nodes=========================================================
If input is [2,3,1], then output is false.
 		   		 2
 		   		  \
 		   		   3
2 is the currentNode.
3 cannot go in leftOf2. Push 3 to rightOf2
3 is the currentNode. After that 1 cannot fit in left or right of 3. So false.
=================================================================================================================================
1) 5,2,1,10,6 Valid BST
	  5,2,1,10,6

	  		5
	  	   / \
	  	  2	 10
	     /	 /
	    1	6
=================================================================================================================================
2) 5,2,6,1 not a ValidBST

		 5
		/ \
	   2   6
	  /
	 1
Cannot fit 1 on right or left of 6. So false.
=========================================================================================================
3) Input: [5,2,6,1,3] Output: false

		5
	   / \
	  2   6
Cannot fit 1 on right or left of 6. So false.
==========================Solution Approach====================================
Similar to ValidateBinarySearchTreeOrValidBST.
1) Take the currentElement(mid) if it falls between low and high.
Then move onto nextElement. On the leftSide recurse with low to mid and on
right side recurse with mid to high.

 */
public class VerifyPreorderSequenceInBinarySearchTree {
  private int midIndex = 0;
  private int[] preorder;

  public boolean verifyPreorder(int[] preorder) {
    if (preorder.length <= 2) return true;
    this.preorder = preorder;
    return recur(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean recur(int low, int high) {
    if (midIndex == preorder.length) return true;
    int mid = preorder[midIndex];

    if (mid < low || mid > high) return false;

    midIndex++;
    boolean left = recur(low, mid);
    boolean right = recur(mid, high);
    return left || right;
  }
}
