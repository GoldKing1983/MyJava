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

  int minDiff = Integer.MAX_VALUE;
  Integer prev = null;

  public int getMinimumDifference(TreeNode root) {
    recur(root);
    return minDiff;
  }

  public void recur(TreeNode root) {

    if (root == null) return;

    recur(root.left);

    if (prev == null) prev = root.val;// There will be minimum 2 nodes in input. So no needed bother about minimum.
    else {
      int currentMin = root.val - prev;
      minDiff = Math.min(minDiff, currentMin);
    }
    recur(root.right);

  }

  // Solution based on "right-first-in-order-traversal".  currentDiff=  prev - root.val
  private void recurRightToLeft(TreeNode root) {
    if (root == null) return;

    recurRightToLeft(root.right);

    if (prev == null) prev = root.val;
    else {
      minDiff = Math.min(minDiff, prev - root.val);
      prev = root.val;
    }


    recurRightToLeft(root.left);

  }
}
