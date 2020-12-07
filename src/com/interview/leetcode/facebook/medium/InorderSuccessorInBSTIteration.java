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
2a) root value < search value. We can Skip the entire left.  Go right
2b) root value == search value. We can Skip the entire left.  Go right
                Ex: [2,null,3] target = 2 
                  2
                   \
                    3
                   
2c) root value > search value. We can skip the entire right. Go left. But cache the node. Because it could be result.
 *
 */
public class InorderSuccessorInBSTIteration {

  /*
  Runtime Complexity : Logarithmic, O(log n).
  Memory Complexity : Constant, O(1).
   */
  public TreeNode inorderSuccessor(TreeNode root, TreeNode dd) {
    TreeNode cacheResult = null;
    while (root != null) {
      if (root.val <= dd.val) root = root.right;
      else { // Ex: for 6 cache 7
        cacheResult = root;
        root = root.left;
      }
    }
    return cacheResult;
  }
}
