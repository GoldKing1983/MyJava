package com.interview.leetcode.topic.tree;

import com.interview.leetcode.Node;

/*
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

1) Understand MaximumDepthOfNAryTreeTopDown first. 
1) Similar to binary tree height. But instead of "left" and "right" using for loop.

                  10
                /    \
              20      30
              
              
              20 returns 0+1 =1
              30 returns 0+1 =1
              
              10 returns Math.max(1,1) +1 =2
 */
public class MaximumDepthOfNAryTreeBottomUp {

  public int maxDepth(Node root) {
    if (root == null) return 0;

    // Visualize below variable levels the maximum for a parent.  
    int maxDepth = 0;
    for (Node n : root.children) {
      int currentDepth = maxDepth(n);
      maxDepth = Math.max(currentDepth, maxDepth);
    }
    return 1 + maxDepth;
  }
}
