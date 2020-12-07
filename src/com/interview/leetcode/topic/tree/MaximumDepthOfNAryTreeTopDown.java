package com.interview.leetcode.topic.tree;

import com.interview.leetcode.Node;

/*
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/



                  10
                /    \
              20      30

1) Similar to AllPathsFromSourceToTargetDFSClone. Update result for each node from topToBottom.
2) This code can be migrated to MaximumDepthOfNAryTreeBottomUp              
              
 */
public class MaximumDepthOfNAryTreeTopDown {

  public int maxDepth(Node root) {
    if (root == null) return 0;
    recur(root, 1);
    return maxLevel;
  }

  int maxLevel = 1;

  private void recur(Node root, int level) {
    if (root == null) return;
    maxLevel = Math.max(level, maxLevel);
    for (Node child : root.children) {
      recur(child, level + 1);
    }
  }
}
