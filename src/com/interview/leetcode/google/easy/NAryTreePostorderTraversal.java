package com.interview.leetcode.google.easy;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.Node;

/*
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal
 */
public class NAryTreePostorderTraversal {
  public List<Integer> postorder(Node root) {
    List<Integer> result = new ArrayList<>();
    recur(root, result);
    return result;
  }

  private void recur(Node root, List<Integer> result) {
    if (root == null) return;
    for (Node child : root.children) {
      recur(child, result);
    }
    result.add(root.val);
  }

  List<Integer> result = new ArrayList<>();

  public List<Integer> postorderSimplified(Node root) {
    if (root == null) return result;
    for (Node child : root.children) {
      postorder(child);
    }
    result.add(root.val);
    return result;
  }

}
