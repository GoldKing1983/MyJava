package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/delete-nodes-and-return-forest/
https://www.youtube.com/watch?v=aaSFzFfOQ0o

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

 						1
 					  /   \
 					 2     3
 					/ \   / \
 				   4   5 6   7

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

=========================================================Solution Approach=========================================================
Step1) Add Template of Delete Code
	1a) root.left  = recurseLeft
	1b) root.right = recurseRight
Step2) Do the processing Logic. Post-Order
	2a) Here at this point we have "root,rootLeft and rootRight"
	2b) If the root is to be deleted (toDelete contains root).
	 			22a) if (root.left!=null)  Add root.left to forest.
	 			22b) if (root.right!=null) Add root.right to forest.
				22c) Return null, to break connection to child.

 */
public class DeleteNodesAndReturnForest {
  public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
    Set<Integer> toDeleteSet = new HashSet<>();
    for (int del : toDelete) toDeleteSet.add(del);
    List<TreeNode> remaining = new ArrayList<>();
    if (!toDeleteSet.contains(root.val)) remaining.add(root);
    recur(root, toDeleteSet, remaining);
    return remaining;
  }

  public TreeNode recur(TreeNode root, Set<Integer> toDelete, List<TreeNode> forest) {
    // Step1) Add Template of Delete Code
    if (root == null) return null;
    root.left = recur(root.left, toDelete, forest);
    root.right = recur(root.right, toDelete, forest);

    // Step2) Do the processing Logic. Post-Order Here we have "root,rootLeft and rootRight"
    if (toDelete.contains(root.val)) {
      if (root.left != null) {
        forest.add(root.left);
      }
      if (root.right != null) {
        forest.add(root.right);
      }
      return null;
    }
    return root;
  }
}
