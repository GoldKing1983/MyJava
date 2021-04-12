package com.interview.leetcode.topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/validate-binary-search-tree/description/

==================================BST Definition====================================
The left subtree of a node contains only nodes with keys less than the node's(all parents) key.
The right subtree of a node contains only nodes with keys greater than the node's(all parents) key.

Below input might look like valid BST. But it is not. Because 6 cannot go at right at any-point.

Input:[10,5,15,null,null,6,20]
Output: false.
					10
				  /	   \
				5       15
			  /  \     /   \
			 n    n   6     20
============================================Wrong - Solution Approach Initial Thinking===========================================
We might think of taking 3 node at any-point, taking root as parent, check left is lesser and right is greater.
That logic will fail for above. Because 15's child 6,20 is valid with respect to 15. But it is not Valid with respect to 10
===========================================BruteForce Solution===================================================================
		a) Do In-Order Traversal of the given tree and store the result in a temp array.
		b) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.
		Time Complexity: O(n) Space Complexity: O(n)
===========================================Solution Approach=====================================================================
1) At any-point if root lies between leftBoundary and rightBoundary. Then proceed.
2) At any-point if root goes less than leftBoundary or greater than rightBoundary. Then return false.
=========================================Data Flow Analysis======================================================================
		1) Consider 3 node.... 10 5 15 
		                        10 
		                       /  \
		                      5    15   
		2) At any point left is smaller and right is greater.
		3) Set low and high...
		4) Then Validate ---> node lies between --->   low and high...
		5) For root -->  low,    root  , high   ---> 	-∞, 10, ∞
								10
							   /  \
							 -∞    ∞
		6) For left -->  low, root.left, root   ---> 	-∞, 5 , 10
								5
							   / \
							 -∞   10
		7) For right--> root, root.right, high  --->	10, 15 , ∞
								15
							   /  \
							 10    ∞
		8) At any point if "current value" is "less than or equal to low" or greater than or equal to high" return false.
		9) if reached end, return true.
		10) result = left && right ==note here===

		Time Complexity: O(n) Space Complexity: O(1)

                  -∞   ∞
					10
				5         15
			  n   n     6   20

		low      root      high
		=======================
		-∞   ||  10   ||    ∞
		-∞   ||  5    ||    10
		10   ||  15   ||    ∞
		10   ||  6    ||    15 ==============> logic fails here
============================================================================================================================
 */
public class ValidateBinarySearchTreeOrValidBSTRangeApproach {
  // ====================================Approach1 Recursion=======================================
  public boolean isValidBST(TreeNode root) {
    return isValid(Long.MIN_VALUE, root, Long.MAX_VALUE);
  }

  private boolean isValid(long low, TreeNode root, long high) {
    if (root == null) return true;
    // Duplicate can present so add equalTo. Ex: [2,2,3] 
    if (root.val <= low || root.val >= high) return false;
    boolean left = isValid(low, root.left, root.val);
    boolean right = isValid(root.val, root.right, high);
    return left && right;
  }

  // ====================================Approach2 Queue===========================================
  public boolean isValidBST1(TreeNode mainRoot) {
    Queue<Object[]> q = new LinkedList<>();
    if (mainRoot != null) q.offer(new Object[] {Long.MIN_VALUE, mainRoot, Long.MAX_VALUE});
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Object[] objectNode = q.poll();
        Long low = Long.valueOf(objectNode[0] + "");
        TreeNode root = (TreeNode) objectNode[1];
        Long high = Long.valueOf(objectNode[2] + "");
        if (low >= root.val || root.val >= high) return false;
        if (root.left != null) q.offer(new Object[] {low, root.left, root.val});
        if (root.right != null) q.offer(new Object[] {root.val, root.right, high});
      }
    }
    return true;
  }
}
