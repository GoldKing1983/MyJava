package com.interview.leetcode.linkedin.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/binary-search-tree-iterator/

   1) Requirement is to use uses O(h) memory. Save "left side of tree data" to stack, during init
   1a) Initially push root and all its left to stack. 
   2) During next() call, pick data from stack which is result.
   2a) Then Check if the node has right.
   2b) If the node has right, push it to stack.
   2c) push all right's left to stack.
   

   Ex1: 8, 4, 9, 3 , 6 , 5 , 7

   		  8
   		 / \
   		4	9
   	   / \
   	  3   6
   	  	 / \
   	    5   7
===================Coding Trick=====How to avoid 2 push and make it as 1 push===On the above example for data 4=================
1) When right is there for a rootNode.  General thought of coding would be

	if (null != result.right) {
		TreeNode root = result.right;
		stack.push(root);
		while(root.left!=null) {
			stack.push(root.left);
			root= root.left;
		}
	}
 2) But the best code is below. Right is pushed initially. Then there after root.left
 	if (null != result.right) {
		TreeNode root = result.right;
		while ( root!=null) {
			stack.push(root);
			root = root.left;
		}
	}
===================================================================================================================================
*/
public class BinarySearchTreeIterator {

  private Deque<TreeNode> stack = new ArrayDeque<>();

  public BinarySearchTreeIterator(TreeNode root) {
    while (null != root) {
      stack.push(root);
      root = root.left;
    }
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    TreeNode result = stack.pop(); //3, 4
    if (null != result.right) {
      TreeNode root = result.right;
      while (null != root) {
        stack.push(root);
        root = root.left;
      }
    }
    return result.val;
  }
}
