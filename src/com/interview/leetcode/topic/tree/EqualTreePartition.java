package com.interview.leetcode.topic.tree;

import java.util.HashSet;
import java.util.Set;
import com.interview.leetcode.TreeNode;

/*
============================================================Requirement==========================================================
Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal 
sum of values after removing exactly one edge on the original tree.

                          Input:     
                              5
                             / \
                            10 10
                              /  \
                             2    3
                          
                          10 5 2 10 3
                          
                          Output: True

                          Explanation: 
                              5
                             / 
                            10
                                
                          Sum: 15
                          
                             10
                            /  \
                           2    3
                          
                          Sum: 15

set = [2, 3, 10, 15]

=========================================================Solution Approach=======================================================
1) This problem can be solved only using BottomUp approach. Because we need totalSum of "root+left+right".
2) See also BinaryTreeMaximumPathSum
 */
public class EqualTreePartition {
  private Set<Integer> set = new HashSet<>();

  public boolean checkEqualTree(TreeNode root) {
    if (root == null) return false;
    int totalSum = root.val + postorder(root.left) + postorder(root.right);
    return (totalSum % 2 == 0) && set.contains(totalSum / 2);
  }

  private int postorder(TreeNode root) {
    if (root == null) return 0;
    int leftSum = postorder(root.left);
    int rightSum = postorder(root.right);
    int totalSum = root.val + leftSum + rightSum;
    set.add(totalSum);
    return totalSum;
  }
}
