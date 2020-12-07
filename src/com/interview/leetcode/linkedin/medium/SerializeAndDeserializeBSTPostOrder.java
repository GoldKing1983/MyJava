package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*

https://leetcode.com/problems/serialize-and-deserialize-bst

=======================================================Solution Approach - Time Complexity O(n)==================================

1) Using the code of SerializeAndDeserializeBinaryTreeRecursionBestPreOrder is perfectly fine. But there it adds "#" for "null"
2) Here we can avoid that during serialize and de-serialize. 

3) Append "," as delimiter between nodes. 

                  10
                 /  \
                5    20

Serialized String =  5, 20, 10

4) Use BST property when de-serializing.    
        1) If rootValue lies between low and high, create root. Recurse again. 
        2) else return null

 */
public class SerializeAndDeserializeBSTPostOrder {

  public String serialize(TreeNode root) {
    if (root == null) return null;

    StringBuilder sb = new StringBuilder();
    serializeBST(root, sb);
    return sb.toString();
  }

  private void serializeBST(TreeNode root, StringBuilder sb) {
    if (root == null) return;

    serializeBST(root.left, sb);
    serializeBST(root.right, sb);
    sb.append(Integer.valueOf(root.val)).append(",");
  }

  public TreeNode deserialize(String serializedString) {
    if (serializedString == null || serializedString.length() == 0) return null;

    String[] serializedSplitString = serializedString.split(",");
    index = serializedSplitString.length - 1;
    return deserialize(serializedSplitString, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  int index;

  // Similar to ValidateBinarySearchTreeOrValidBST
  private TreeNode deserialize(String[] serializedSplitString, int low, int high) {
    if (index < 0) return null;

    int rootValue = Integer.parseInt(serializedSplitString[index]);
    if (rootValue > low && rootValue < high) {
      TreeNode root = new TreeNode(rootValue);
      index--;
      root.right = deserialize(serializedSplitString, rootValue, high); // low=10, rootValue=20
      root.left = deserialize(serializedSplitString, low, rootValue); // low=5, rootValue=10
      return root;
    }
    return null;
  }
}
