package com.interview.leetcode.topic.tree;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/find-leaves-of-binary-tree/description/

                    Input: [1,2,3,4,5]
                      
                           (2)1
                             / \
                         (1)2   3(0)
                           / \     
                       (0)4   5(0)    
                    
                    Output: [[4,5,3],[2],[1]]

=======Logic is same as getting "Height of Tree" with saving the node data=========

 There are 2 points to note here.
1) Finding the index of leaf node from bottom to top, which is achieved by backtracking (Height Of Tree Logic)
2) Create ArrayList "only one time" for each level from bottom and Saving the node data to specific level index.

  Also similar to BinaryTreeLevelOrderTraversalDFS
  In BinaryTreeZigzagLevelOrderTraversalRecursionBest list is created from topToBottom.
  Here list is created from bottomToTop.
 */
public class FindLeavesOfBinaryTreeBottomUpRecurse {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    treeHeight(root, result);
    return result;
  }

  // traverse the tree bottom-up recursively
  public int treeHeight(TreeNode root, List<List<Integer>> result) {
    if (root == null) return -1;

    int height = 1 + Math.max(treeHeight(root.left, result), treeHeight(root.right, result));

    if (result.size() == height) result.add(new ArrayList<>());
    result.get(height).add(root.val);

    return height;
  }
}
