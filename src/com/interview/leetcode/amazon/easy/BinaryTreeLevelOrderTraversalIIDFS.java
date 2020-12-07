package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).


Input:
 	3
   / \
  9  20
    /  \
   15   7
Output:
[
  [15,7],
  [9,20],
  [3]
]

==============================Solution Approach DFS==============================

1) From top to bottom insertion always happens at 0th index, because of addFirst.
2) Index will change only after a while for more level. Visualize it.
		     1
		   /   \
		  2     3
	     / \   / \
 		4   5 6   7
 		
 		output :[[4,5,6,7]
 		         [2,3]
 		         [1]]
 		         
3) 1,2,5 are created by linkedlist addFirst.  
4) For level2 node5. resultIndex = 3-2-1=0
5) For level1 node3. resultIndex = 3-1-1=1
6) For level2 node4. resultIndex = 3-2-1=0
7) For level2 node5. resultIndex = 3-2-1=0

*/
public class BinaryTreeLevelOrderTraversalIIDFS {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    recur(root, 0, result);
    return result;
  }

  public void recur(TreeNode node, int level, LinkedList<List<Integer>> result) {
    if (node == null) return;
    if (level == result.size()) result.addFirst(new LinkedList<>());
    result.get(result.size() - level - 1).add(node.val);
    recur(node.left, level + 1, result);
    recur(node.right, level + 1, result);
  }
}
