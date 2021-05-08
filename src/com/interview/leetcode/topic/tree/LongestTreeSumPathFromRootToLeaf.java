package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://binarysearch.com/problems/Longest-Tree-Sum-Path-From-Root-to-Leaf

1) Given a binary tree root. 
2) Return the sum of the longest path from the root to a leaf node. 
3) If there are two equally long paths, return the larger sum.

 Ex1:               1
                   / \
                  2   5
                 /     \
                3       6
      ans:12
            
            1->2->3 and 1->5->6 both forms longest path. So compare by sum. So answer is 12    

                  
Ex2:                1
                   / \
                  1   5
                 /     
                1       
      ans:3
            longest path is 1->1->1    
                    
 */
public class LongestTreeSumPathFromRootToLeaf {

  public int solve(TreeNode root) {
    return recur(root)[1];
  }

  // 0index height 1index sum
  private int[] recur(TreeNode root) {
    if (root == null) return new int[] {0, 0};
    int[] left = recur(root.left);
    left[0]++;
    left[1] = left[1] + root.val;

    int[] right = recur(root.right);
    right[0]++;
    right[1] = right[1] + root.val;


    if (left[0] > right[0]) { // left height is bigger
      return left;
    } else if (right[0] > left[0]) { // right height is bigger
      return right;
    }
    // both height is same... Return biggest sum.
    if (left[1] > right[1]) {
      return left;
    }
    return right;
  }

}
