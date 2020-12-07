package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/binary-tree-right-side-view/description/

See "BoundaryOfBinaryTree" which is triple complex of the same problem
====================================Solution Approach====================================
			   1            <--- level0
			 /   \
			2     3         <--- level1
			 \     \
			  5     4       <--- level2
Output: 1,3,4

1) At each level I need to pick 1 element.
2) Traverse entire tree in rightFirst pre-order.
3) If the result size is same as level then add firstRightData to result.

 *
 */

public class BinaryTreeRightSideViewDFS {
  public List<Integer> rightSideView(TreeNode root) {
    return recur(root, new ArrayList<>(), 0);
  }

  private List<Integer> recur(TreeNode root, List<Integer> result, int level) {
    if (root == null) return result;
    if (result.size() == level) result.add(root.val);
    recur(root.right, result, level + 1);
    return recur(root.left, result, level + 1);
  }
}
