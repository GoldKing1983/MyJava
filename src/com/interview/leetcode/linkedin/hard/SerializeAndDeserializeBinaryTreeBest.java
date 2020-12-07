package com.interview.leetcode.linkedin.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Pre-Order for serialize and In-Order for de-serialize

				      1  
				   /     \
				  2       3
				 / \    /   \
			    n	n  4     5
			          / \   / \
                     n   n n   n
=======================================================Solution Approach - Time Complexity O(n)==================================
1) Append "," as delimiter between nodes. 
2) Append "#," as delimiter for nullNodes.

Serialized String =  1,   2,#,#,   3,   4,#,#,    5,#,#,

 */
public class SerializeAndDeserializeBinaryTreeBest {

  private TreeNode dfs(Queue<String> q) {
    String s = q.poll();
    if (s.equals("#")) return null;

    TreeNode root = new TreeNode();
    root.left = dfs(q);
    root.val = Integer.valueOf(s);
    root.right = dfs(q);
    return root;
  }

  public String serialize(TreeNode root) {
    StringBuilder serializedString = new StringBuilder();
    serialize(root, serializedString);
    return serializedString.toString();
  }

  private void serialize(TreeNode root, StringBuilder serializedString) {
    if (root == null) {
      serializedString.append("#,");
    } else {
      serializedString.append(root.val).append(",");
      serialize(root.left, serializedString);
      serialize(root.right, serializedString);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    return dfs(q);
  }
}
