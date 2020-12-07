package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/construct-string-from-binary-tree/

===================For interview below 2 case is enough===============
Input1: Binary tree: [1,2,3,4]
       1
        \
         3

Output: "1(()(3))"

Input2: Binary tree: [1,2,3,4]
        1
       /
      2

Output: "1((2))"
===================For interview above 2 case is enough===============

 */
public class ConstructStringFromBinaryTree {
  public String tree2str(TreeNode t) {
    StringBuilder s = new StringBuilder();
    if (t == null) return s.toString();
    recur(t, s);
    return s.toString();
  }

  public void recur(TreeNode t, StringBuilder s) {

    s.append(t.val);
    if (t.left != null) {
      s.append("(");
      recur(t.left, s);
      s.append(")");
    }
    if (t.right != null) {

      if (t.left == null) s.append("()"); // This is for corner case. See input1

      s.append("(");
      recur(t.right, s);
      s.append(")");
    }
  }
}
