package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;

/*

Input: [5,3,6,1,4,null,null,null,2]
   		    5
   		 /    \
   		3	   8
   	   / \    /
   	  1   4  7
   	  	 /  /
   	    2  6

data = 4 .... successor of 4 is 5.
data = 5 .... successor of 5 is 6.
data = 6 .... successor of 6 is 7
=========================================naive solution==============================================================
A naive solution of this problem would be doing an in-order traversal of the BST.
Once d is found, it returns the previous node in the traversal. The runtime of this approach is linear.
Runtime Complexity : O(n)
=========================================logical solution============================================================
1) We can use the property of BST.
2a) root value <= search value. We can Skip the entire left.  Go right
2b) root value > search value. We can skip the entire right. Go left. But cache the node. Because it could be result.
 *
 */
public class InorderSuccessorInBSTTopDown {

  /*
  Runtime Complexity : Logarithmic, O(log n).
  Memory Complexity : Constant, O(1).
   */
  public TreeNode inorderSuccessor(TreeNode root, TreeNode dd) {
    recur(root, dd);
    return cacheLeftNode;
  }

  TreeNode cacheLeftNode;

  private void recur(TreeNode root, TreeNode dd) {
    if (root == null) return;
    if (root.val > dd.val) {
      cacheLeftNode = root;
      recur(root.left, dd);
    } else {
      recur(root.right, dd);
    }
  }
}
