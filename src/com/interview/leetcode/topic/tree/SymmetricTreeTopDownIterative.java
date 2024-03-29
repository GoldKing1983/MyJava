package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/*
* https://leetcode.com/problems/symmetric-tree/description/
*
Ex:
				 	1
				   / \
				  2   2
				 / \ / \
				3  4 4  3

*/
public class SymmetricTreeTopDownIterative {

  public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode t1 = q.poll();
      TreeNode t2 = q.poll();
      if (t1 == null && t2 == null) continue;
      if (t1 == null || t2 == null) return false;
      if (t1.val != t2.val) return false;
      q.add(t1.left);
      q.add(t2.right);
      q.add(t1.right);
      q.add(t2.left);
    }
    return true;
  }
}
