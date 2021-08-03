package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
                                1
                               / \
                              2   3
                             /     \
                            4       6
                           /
                          5     

Output : [1] [2,3] [4,6] [5]                         
======================================Solution Approach======================================
1) Record currentNodeValue during pre-order traversal.
2) In pre-order we go by root,left and right. 
3) So for the above example.... [1][2][4][5] will be saved.
4) Then [2,3] [4,6] will be updated.

 */
public class BinaryTreeLevelOrderTraversalDFS {
  public List<List<Integer>> levelOrderDFS(TreeNode root) {
    return levelOrder(root, 0, new ArrayList<>());
  }

  private List<List<Integer>> levelOrder(TreeNode root, int level, List<List<Integer>> result) {
    if (root == null) return result;
    if (result.size() == level) result.add(new ArrayList<>());
    result.get(level).add(root.val);
    levelOrder(root.left, level + 1, result);
    return levelOrder(root.right, level + 1, result);
  }
}
