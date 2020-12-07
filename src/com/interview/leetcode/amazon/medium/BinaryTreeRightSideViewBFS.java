package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/binary-tree-right-side-view/description/
==========================================================Solution Approach======================================================
1) Traverse the Tree by Level Order.
2) At Each Level, save the lastNode to result.
=================================================================================================================================
 */
public class BinaryTreeRightSideViewBFS {
  public List<Integer> rightSideView(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        root = queue.poll();
        if (root.left != null) queue.offer(root.left);
        if (root.right != null) queue.offer(root.right);
      }
      result.add(root.val);
    }

    return result;
  }
}
