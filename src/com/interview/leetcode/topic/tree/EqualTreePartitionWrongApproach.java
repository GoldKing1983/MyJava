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

=========================================================Wrong Solution Approach=======================================================

1) Use In-order traversal and update sum. 

[2,1,null,null,2,1] Output: true

Inorder traversal fails on above case and will return false.
                                


 */
public class EqualTreePartitionWrongApproach {
  private Set<Integer> set = new HashSet<>();
  int sum = 0;

  public boolean checkEqualTree(TreeNode root) {
    if (root == null) return false;
    dfs(root);
    return (sum % 2 == 0) && set.contains(sum / 2);
  }

  private void dfs(TreeNode root) {
    if (root == null) return;
    dfs(root.left);

    sum += root.val;
    set.add(sum);


    dfs(root.right);

  }
}
