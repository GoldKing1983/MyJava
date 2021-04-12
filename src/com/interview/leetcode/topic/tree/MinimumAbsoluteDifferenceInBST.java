package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/minimum-absolute-difference-in-bst/

				Input:

                      2
                   /     \
                  1       4

				Output: 1

Explanation:
The "minimum absolute difference" between 1 and 2 is 1. (which is answer or minimal of all)
The "minimum absolute difference" between 2 and 4 is 4. 
=========================================================Solution Approach=======================================================

          =====HighLevel=====
1) If I do in-order traversal, I will be getting, sorted data.  
        1 --> 2 --> 4 
2) So compare current(root.val-2) and previous(1).
          =====Deep-Dive=====
                      2
                   /     \
                  1       4
1) Do In-Order Traversal
2) During the firstTime, when the recursion goes all the way left, previous is notSet. So set previous during the firstTime.
              a) recursion goes all the way to leftEnd (i.e) 1.
              b) at node1. left will return.
              c) prev==null. So prev updated to 1.
              d) at node1. right will return.
          
3) From secondTime onwards  compare current(root.val-2) and previous(1) and update minDiff.       
              a) recursion go back to node2.
              b) prev=1. current=2. minDiff updated to 1.

*/

public class MinimumAbsoluteDifferenceInBST {

  int minDifference = Integer.MAX_VALUE;
  Integer previousValue = null;

  public int minDiffInBST(TreeNode root) {
    if (root == null) return minDifference;
    minDiffInBST(root.left);
    if (previousValue == null) previousValue = root.val;
    else {
      int currentDifference = root.val - previousValue;
      minDifference = Math.min(minDifference, currentDifference);
      previousValue = root.val;
    }
    return minDiffInBST(root.right);
  }

  // Solution based on "right-first-in-order-traversal".  currentDiff=  previousValue - root.val
  private int recurRightToLeft(TreeNode root) {
    if (root == null) return minDifference;

    recurRightToLeft(root.right);

    if (previousValue == null) previousValue = root.val;
    else {
      int currentDifference = previousValue - root.val;
      minDifference = Math.min(minDifference, currentDifference);
      previousValue = root.val;
    }


    return recurRightToLeft(root.left);

  }
}
