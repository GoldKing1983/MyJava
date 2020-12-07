package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/serialize-and-deserialize-bst

=======================================================Solution Approach - Time Complexity O(n)==================================

1) Using the code of SerializeAndDeserializeBinaryTreeRecursionBestPreOrder is perfectly fine. But there it adds "#" for "null"
2) Here we can avoid that during serialize. Use BST property during de-serialize. 

3) Append "," as delimiter between nodes. 

                  10
                 /  \
                5    20

Serialized String =  10,   5,   20

4) Use BST property when de-serializing.    
        1) If rootValue lies between low and high, create root. Recurse again. 
        2) else return null

 */
public class SerializeAndDeserializeBSTPreOrder {
  public String serialize(TreeNode root) {
    if (root == null) return null;

    StringBuilder serializedString = new StringBuilder();
    serialize(root, serializedString);
    return serializedString.toString();
  }

  private void serialize(TreeNode root, StringBuilder serializedString) {
    if (root == null) return;

    serializedString.append(root.val).append(",");
    serialize(root.left, serializedString);
    serialize(root.right, serializedString);
  }

  public TreeNode deserialize(String serializedString) {
    if (serializedString == null || serializedString.length() == 0) return null;

    String[] nodes = serializedString.split(",");
    return deserialize(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  int index = 0;

  // Similar to ValidateBinarySearchTreeOrValidBST
  private TreeNode deserialize(String[] serializedSplitString, int low, int high) {
    if (index == serializedSplitString.length) return null;

    int rootValue = Integer.parseInt(serializedSplitString[index]);
    if (rootValue > low && rootValue < high) {
      TreeNode root = new TreeNode(rootValue);
      index++;
      root.left = deserialize(serializedSplitString, low, rootValue); // low=5, rootValue=10
      root.right = deserialize(serializedSplitString, rootValue, high); // low=10, rootValue=20
      return root;
    }
    return null;
  }

}
