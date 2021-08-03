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
Top-To-Bottom - gather the whole number
                                           0*10 + 1 = 1
                                            //      \\
                                        1*10+2=12   1*10+13=13
                                         //      \\
                                    12*10+4=124  12*10+5=125

Bottom-To-Top - traverse back the sum 
											   1(262)
										     /   \
									   (249)2     3(13)
										   / \
									 (124)4   5(125)
============================================Solution Approach======================================================================
Step0) generate currentNumber --> Top-To-Bottom - gather the wholeNumber
Step1) Add baseCondition. If currentNodes left and right is null. Then return wholeNumber.
Step2) Recurse Left and Right. 
Step3) Return Left+Right--> Bottom-To-Top - traverse back the sum
=======================================================Data Flow Analysis========================================================
	  Ex1: input: null. Ans=0.  So add ---> if (currentNode == null) return 0;
	  Ex2: input: [1] . Ans=1.
	  		Calculate PathSum : 1
	  		If left and right null then return pathsum...
====================================================================================================================================
time complexity and space complexity are 0(n) and 0(h),

*/
public class SumRootToLeafNumbersBottomUp {

  public int sumNumbers(TreeNode root) {

    return recur(root, 0);
  }

  private int recur(TreeNode root, int currentNumber) {
    if (root == null) return 0;

    currentNumber = currentNumber * 10 + root.val;

    if (root.left == null && root.right == null) return currentNumber;

    int left = recur(root.left, currentNumber);
    int right = recur(root.right, currentNumber);

    return left + right;
  }
}
