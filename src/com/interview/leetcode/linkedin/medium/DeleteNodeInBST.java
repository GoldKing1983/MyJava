package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/delete-node-in-a-bst/
https://www.youtube.com/watch?v=gcULXE7ViZw&vl=en

Given a root node reference of a BST and a key, delete the node with the given key in the BST.
Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

							    5
							   / \
							  3   6
							 / \   \
							2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

							    5
							   / \
							  4   6
							 /     \
							2       7

Another valid answer is [5,2,6,null,4,null,7].

							    5
							   / \
							  2   6
							   \   \
							    4   7

See the image "Delete a Node In BST.JPG".

Case 1) If the node to be deleted has no child. simply delete.
Case 2) If the node to delete has 1 child.
			2a) If the child is right. Link root with right.
			2b) If the child is  left. Link root with left.
Case 3) Else
		a) Find right most minimum of root.
		b) delete the "right most minimum of root".
		c) set the root data with "right most minimum data of root"...Note: It is not linking. it is setting the data in root.

 */

public class DeleteNodeInBST {
  public TreeNode deleteNode(TreeNode root, int key) {
    // if root is null, return null
    if (root == null) return root;

    // delete current node if root is the target node
    if (root.val == key) {
      if (root.left == null && root.right==null) return null;  
      if (root.left == null) return root.right;
      if (root.right == null) return root.left;

      // replace root with its successor if root has left and right children
      TreeNode p = findSuccessor(root);
      root.val = p.val;
      root.right = deleteNode(root.right, p.val);
      return root;
    }
    // find target in right subtree if root->val < key
    if (root.val < key) root.right = deleteNode(root.right, key);
    // find target in left subtree if root->val > key
    else root.left = deleteNode(root.left, key);

    return root;
  }

  private TreeNode findSuccessor(TreeNode root) {
    TreeNode cur = root.right;
    while (cur != null && cur.left != null) cur = cur.left;
    return cur;
  }
}
