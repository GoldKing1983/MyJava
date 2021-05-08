package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Pre-Order for serialize and de-serialize

				      1  
				   /     \
				  2       3
		        /   \    / \
			   4     5  n   n
	          / \   / \
	         n   n n   n
=======================================================Solution Approach - Time Complexity O(n)==================================
1) Append "," as delimiter between nodes. 
2) Append "n," as delimiter for nullNodes.

Serialized String =  1,   2,   4,n,n,   5,n,n,   3,n,n,

 */
public class SerializeAndDeserializeBinaryTreePreOrder1 {

  public String serialize(TreeNode root) {
    StringBuilder serializedString = new StringBuilder();
    serialize(root, serializedString);
    return serializedString.toString();
  }

  private void serialize(TreeNode root, StringBuilder serializedString) {
    if (root == null) {
      serializedString.append("n,");
    } else {
      serializedString.append(root.val).append(",");
      serialize(root.left, serializedString);
      serialize(root.right, serializedString);
    }
  }

  public TreeNode deserialize(String serializedString) {
    if (serializedString == null || serializedString.length() == 0) return null;
    String[] serializedSplitString = serializedString.split(",");
    return deserialize(serializedSplitString);
  }

  // index once incremented cannot go down. So need global value or array with size 1 needed 
  // or see SerializeAndDeserializeBinaryTreePreOrder2
  int index = 0;

  private TreeNode deserialize(String[] serializedSplitString) {
    if (index == serializedSplitString.length) return null; // Reached end

    String val = serializedSplitString[index++];
    if (val.equals("n")) return null; // Empty Leaf

    TreeNode root = new TreeNode(Integer.valueOf(val));
    root.left = deserialize(serializedSplitString);
    root.right = deserialize(serializedSplitString);

    return root;
  }
}
