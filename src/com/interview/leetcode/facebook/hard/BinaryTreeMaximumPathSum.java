package com.interview.leetcode.facebook.hard;

import java.util.stream.IntStream;
import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/

				1
			  /   \
			 2	   6
		    / \
		   4   5

For above answer is 14 and the path is 5 2 1 6
Initial MaxValue : 4
Then MaxValue    : 5
Then MaxValue    : 11
Then MaxValue    : 11
Final MaxValue   : 14
=========================
			    -1
			  /    \
			 2	    -6
			/ \
		  -4  -5
		Output : 2
==========Note=========See also BinaryTreeMaximumPathSum
1) When getting the max, it should be max of
 	a) root alone (If left or right is negative. Then root alone.)
 	b) root + left
 	c) root + right
 	d) left + root + right
2) When returning path, it should be max of
 	a) root alone (If left or right is negative. Then root alone.)
 	b) root + left
 	c) root + right
	The reason is path can grow long from either one side only.

 */
public class BinaryTreeMaximumPathSum {

  int maxPathSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    postorder(root);
    return maxPathSum;
  }

  private int postorder(TreeNode root) {
    if (root == null) return 0;
    int left = postorder(root.left);
    int right = postorder(root.right);
    int currentMax = IntStream
        .of(left + root.val, right + root.val, root.val, left + right + root.val).max().getAsInt();
    maxPathSum = Math.max(currentMax, maxPathSum);
    return IntStream.of(left + root.val, right + root.val, root.val).max().getAsInt();
  }
}
