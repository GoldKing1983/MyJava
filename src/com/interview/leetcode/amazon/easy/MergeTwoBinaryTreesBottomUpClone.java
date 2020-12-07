package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/merge-two-binary-trees/description/

                  5                     5
                 / \                   / \ 
                n  20                 15  n
               
                 
     1) TreeNode with 10 created.
     2) 10.left  = mergeTrees(n,15)
                   root1Left is null, so root2Left(15) returned.
                   10.left = 15
                  
     3) 10.right = mergeTrees(20,n) 
                   root2Right is null, so root1Right(20) returned
                   10.right = 20
                 
     4) 10 returned. 
                  
*/
public class MergeTwoBinaryTreesBottomUpClone {

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return null;
    if (root1 == null) return root2;
    if (root2 == null) return root1;
    TreeNode result = new TreeNode(root1.val + root2.val);
    result.left = mergeTrees(root1.left, root2.left);
    result.right = mergeTrees(root1.right, root2.right);
    return result;
  }

}
