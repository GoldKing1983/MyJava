package com.interview.leetcode.topic.bst;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/inorder-successor-in-bst/

Input: [20,9,25,5,12,null,null,null,null,11,14]
   		   20
   		 /    \
   		9	   25
   	   / \
   	  5   12
   	  	 /  \
   	   11    14

successor of  9 is 11.
successor of 14 is 20.
successor of 12 is 14
=========================================naive solution==============================================================
A naive solution of this problem would be doing an in-order traversal of the BST.
Once d is found, it returns the previous node in the traversal. The runtime of this approach is linear.
Runtime Complexity : O(n)
=========================================logical solution============================================================
1) We can use the property of BST.
2a) root value <= search value. We can Skip the entire left.  Go right
2b) root value > search value. We can skip the entire right. Go left. But cache the leftNode. Because it could be result.

=========================================Bottom-Up Special============================================================
1) If you visualize and see any example. First "InorderSuccessor" will be floating at bottom
2) So if there is a result available and if it went left at least one time. Then return root.
From 20 return 20.
 						Ex: Inorder successor or 10 is 20.
 								20
 							   /
 							 10

 *
 */
public class InorderSuccessorInBSTBottomUp {

  /*
  Runtime Complexity : Logarithmic, O(log n).
  Memory Complexity : Constant, O(1).
   */
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) return null;

    if (root.val <= p.val) return inorderSuccessor(root.right, p);

    TreeNode cacheLeftNode = inorderSuccessor(root.left, p);
    return cacheLeftNode != null ? cacheLeftNode : root;
  }
}
