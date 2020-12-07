package com.interview.leetcode.amazon.easy;

import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/merge-two-binary-trees/description/

*/
public class MergeTwoBinaryTreesBFS {

  // root1 is considered as resultNode
  public TreeNode mergeTreesBFS(TreeNode root1, TreeNode root2) {
    Queue<TreeNode[]> q = new LinkedList<>();
    if (root1 == null) return root2;
    if (root2 == null) return root1;
    q.offer(new TreeNode[] {root1, root2});
    while (!q.isEmpty()) {
      TreeNode[] root1Root2 = q.poll();
      TreeNode t1 = root1Root2[0];
      TreeNode t2 = root1Root2[1];
      t1.val += t2.val;
      if (t1.left != null && t2.left != null) {
        q.offer(new TreeNode[] {t1.left, t2.left});
      } else if (t1.left == null && t2.left != null) {
        t1.left = t2.left;
      }
      if (t1.right != null && t2.right != null) {
        q.offer(new TreeNode[] {t1.right, t2.right});
      } else if (t1.right == null && t2.right != null) {
        t1.right = t2.right;
      }
    }
    return root1;
  }
}
