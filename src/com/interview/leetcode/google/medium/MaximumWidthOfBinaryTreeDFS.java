package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/maximum-width-of-binary-tree/
==============================================================Requirement========================================================
1) Given a binary tree, write a function to get the maximumWidth of the given tree at anyOneLevel.
2) The width of a tree can exist at any levels.
3) The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level)
=======================================================ExampleNote===============================================================
In all below example "node.val" is updated to indexValue for easier understanding. Because result doesn't depend on "node.val"
==============================================================Example1===========================================================
                            1           level1==>1
                         /     \
                        2       3       level2==>(3-2)+1 = 2
                       / \     / \
                      4   5   6   7     level3==>(7-4)+1 = 4
                     / \           \
                    8   9           15  level4==>(15-8)+1= 8
Output: 8
==============================================================Example2===========================================================
                             1          level1==>1          ==>MaxWidth=1
                            / \
                           2   3        level2==>(3-2)+1 = 2==>MaxWidth=2
                          /     \
                         4       7      level3==>(7-4)+1 = 4==>MaxWidth=4
                        /         \
                       8           15   level4==>(15-8)+1= 8==>MaxWidth=8
Output: 8
==============================================================Example3===========================================================
                                  1     level1==>1          ==>MaxWidth=1
                                 /
                                2       level2==>(2-2)+1 = 1==>MaxWidth=1
                               / \
                              4   5     level3==>(5-4)+1 = 2==>MaxWidth=2
                             /
                            8           level4==>(8-8)+1 = 1
Output: 2 [Note: Maximum answer is at level3]
=========================================Solution Approach===See "TreeIndexingNodes.jpeg"========================================
1) Recur and save startId and endId for each level.
   1) During firstTime of that level, save startId and endId as same.
   2) During secondTime onwards for that level, keep update the endId.
2) In the main calculate maxWidth for each level.

Time Complexity : O(n). Space Complexity O(h)
 */
public class MaximumWidthOfBinaryTreeDFS {
  public int widthOfBinaryTree(TreeNode root) {
    List<Integer> startIdList = new ArrayList<>();
    List<Integer> endIdList = new ArrayList<>();
    dfs(root, 0, 1, startIdList, endIdList);
    int heightOfTree = startIdList.size();
    int maxHeight = 0;
    for (int i = 0; i < heightOfTree; i++) {
      maxHeight = Math.max(maxHeight, endIdList.get(i) - startIdList.get(i) + 1);
    }
    return maxHeight;
  }

  public void dfs(TreeNode root, int level, int parentId, List<Integer> startIdList,
      List<Integer> endIdList) {
    if (root == null) return;

    if (startIdList.size() == level) {
      startIdList.add(parentId);
      endIdList.add(parentId); // For only 1 node at that leve1, "end" will be set as "start"
    } else endIdList.set(level, parentId);

    int leftChildId = 2 * parentId;
    dfs(root.left, level + 1, leftChildId, startIdList, endIdList);

    int rightChildId = 2 * parentId + 1;
    dfs(root.right, level + 1, rightChildId, startIdList, endIdList);
  }
}
