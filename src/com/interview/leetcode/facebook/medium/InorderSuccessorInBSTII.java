package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.newer.newer.parent.Node;

public class InorderSuccessorInBSTII {
  /*
   * https://leetcode.com/problems/inorder-successor-in-bst-ii/
   *
  1) Successor can come in only 2 ways, in right side or in parent.
  2) If it is in right side, one step right and all way to left is answer.
  3) If it is in parent, all the way up, at any-point greater than > current is answer.
  */
  public Node inorderSuccessor(Node x) {

    while (x != null) {
      if (x.right != null) {
        Node successor = x.right;
        while (successor.left != null) successor = successor.left;
        return successor;
      } else if (x.parent != null) {
        while (x.parent != null && x.parent.val < x.val) x = x.parent;
        return x.parent != null ? x.parent : null;
      } else return null;
    }
    return null;
  }
}
