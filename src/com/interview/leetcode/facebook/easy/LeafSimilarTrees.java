package com.interview.leetcode.facebook.easy;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/leaf-similar-trees/
*
* Problem: Compare 2 "tree leaf" from left to right, if all leafs are equal return true.
*

*/
public class LeafSimilarTrees {

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> root1Leaf = recur(root1, new ArrayList<>());
    List<Integer> root2Leaf = recur(root2, new ArrayList<>());
    return root1Leaf.equals(root2Leaf);
  }

  private List<Integer> recur(TreeNode root, List<Integer> result) {
    if (root == null) return result;

    if (root.left == null && root.right == null) result.add(root.val);

    recur(root.left, result);
    return recur(root.right, result);
  }
}
