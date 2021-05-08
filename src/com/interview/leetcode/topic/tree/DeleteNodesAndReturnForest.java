package com.interview.leetcode.topic.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.interview.leetcode.TreeNode;

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
Output: [[1,2,null,4],[6],[7]] . Below 3 tree

                                1
                               / 
                              2
                             /
                            4  
                                  6
                                 / \
                                n   n
                                  7
                                 / \
                                n   n  
========================================================Logical Thinking=========================================================
1) If node to delete is empty. Then return input root as such..
2) If I delete a node.                                 
========================================================Solution Approach========================================================
Step1) Add Template of Delete Code
    
	1a) root.left  = recurseLeft
	1b) root.right = recurseRight
	1c) return root;
Step2) Do the processing Logic. Post-Order
	2a) Here at this point we have "root,rootLeft and rootRight"
	2b) If the root is to be deleted (toDelete contains root).
	 			22a) if (root.left!=null)  Add root.left to forest.
	 			22b) if (root.right!=null) Add root.right to forest.
				22c) Return null, to break connection to child or parent(left or right) to connect with null

 */
public class DeleteNodesAndReturnForest {
  public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
    Set<Integer> toDeleteSet = new HashSet<>();
    for (int del : toDelete) toDeleteSet.add(del); // Add all nodeToDelete in set for easier finding

    List<TreeNode> remaining = new ArrayList<>(); // Add all result or broken forest here.
    // Corner Case, if root value itself to be deleted then   
    if (!toDeleteSet.contains(root.val)) remaining.add(root);

    recur(root, toDeleteSet, remaining);
    return remaining;
  }

  public TreeNode recur(TreeNode root, Set<Integer> toDelete, List<TreeNode> forest) {
    // Step1a) Add Template of Delete Code
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
    // Step1b) Add Template of Delete Code
    return root;
  }
}
