package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/range-sum-of-bst/

See RangeSumOfBSTTopDown. Then this

                        10
                     /      \
                    5        20
              
                Case1: Go Both Side . 5 and 20 .  Ans 35    
                Case2: Go Left Side . 5 and 7  .  Ans 5
                Case3: Go Right Side. 15 and 20.  Ans 20

=========================================================Data Flow Analysis======================================================
                Case1: Go Both Side . 5 and 20 .  Ans 35
                
                Go all the way of left
                
                5sleft = 0
                5sright = 0
                5 returns = 5+0+0=5
                
                Go all the way of right
                
                20sleft = 0
                20sright = 0
                20 returns = 20+0+0=20
                
                10sleft = 5
                10sright = 20
                10 returns = 10+5+20=35
  
  
 */
public class RangeSumOfBSTBottomUp {

  public int rangeSumBST(TreeNode root, int leftRange, int rightRange) {
    if (root == null) return 0;
    // Ex: rootVal=10 leftRange=5 rightRange=7
    if (root.val > rightRange) return rangeSumBST(root.left, leftRange, rightRange);

    // Ex: rootVal=10 leftRange=15 rightRange=20
    if (root.val < leftRange) return rangeSumBST(root.right, leftRange, rightRange);

    // Go in both direction 
    int left = rangeSumBST(root.left, leftRange, rightRange);
    int right = rangeSumBST(root.right, leftRange, rightRange);
    return root.val + left + right;
  }
}
