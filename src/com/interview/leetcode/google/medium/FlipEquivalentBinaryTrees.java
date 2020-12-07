package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
Requirement:
1) Each time Flipping(right or left) of node1 or node2 should return same value.
2) Straight top-bottom recursion tree. Post-Order.
================================================================================================================
Input:
 [1,2,3]
 [1,3,2]
Output: true
			     1                 1
			   /   \			 /   \
			  2     3           3	  2
================================================================================================================
Input:
 [1,2,3]
 [1,2,3]
Output: true
			     1                 1
			   /   \			 /   \
			  2     3           2	  3
================================================================================================================
Input:
 [1,2,3,4]
 [1,3,2,4]
Output: false

			     1                 1
			   /   \			 /   \
			  2     3           3	  2
			 /				   /
			4	              4
==================================================ImportantCase1==============================================================
Input:
 [1,2,3,4]
 [1,3,2,null,null,null,4]
Output: true
			     1                 1
			   /   \			 /   \
			  2     3           3	  2
			 /				   		   \
			4	              			4
==================================================ImportantCase2==============================================================
Input:
 [1,2,3,4]
 [1,3,2,null,null,4]
Output: true
			     1                 1
			   /   \			 /   \
			  2     3           3	  2
			 /				   		 /
			4	              		4
====================================Solution Approach==============================================================
1) At any-point "root1.left and root2.left" with "root1.right and root2.right" may be same. i.e left and right are same.
2) At any-point "root1.left and root2.right" with "root1.right and root2.left" may be same. i.e left and right are mirrored.
3) return (mirrorTreeLeft && mirrorTreeRight) || (sameTreeLeft && sameTreeRight);
4) Base conditions are
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;
    if (root1.val != root2.val) return false;
================================================================================================================
 */
public class FlipEquivalentBinaryTrees {
  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;
    if (root1.val != root2.val) return false;
    // Ex: [1,2,3] [1,2,3]
    boolean sameTreeLeft = flipEquiv(root1.left, root2.left);
    boolean sameTreeRight = flipEquiv(root1.right, root2.right);
    // Ex: [1,2,3] [1,3,2]
    boolean mirrorTreeLeft = flipEquiv(root1.left, root2.right);
    boolean mirrorTreeRight = flipEquiv(root1.right, root2.left);
    return (mirrorTreeLeft && mirrorTreeRight) || (sameTreeLeft && sameTreeRight);
  }
}
