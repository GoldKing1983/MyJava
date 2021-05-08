package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Post-Order for serialize and de-serialize

				       1
				   /      \
				  2        3

Note: Append "," between numbers, Append "#," for null.

Serialized String =  	#,#,2,  #,#,3  1

DeSerialze ==> come from last. Build from right.

 */
public class SerializeAndDeserializeBinaryTreeRecursionPostOrder {
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  private void serialize(TreeNode x, StringBuilder sb) {
    if (x == null) {
      sb.append("#,");
    } else {
      serialize(x.left, sb);
      serialize(x.right, sb);
      sb.append(x.val).append(",");
    }
  }

  public TreeNode deserialize(String s) {
    if (s == null || s.length() == 0) return null;
    String[] st = s.split(",");
    index = st.length - 1;
    return deserialize(st);
  }

  // index once incremented cannot go down. So need global value or array with size 1 needed
  int index = 0;

  private TreeNode deserialize(String[] st) {
    if (index < 0) return null; // Reached end
    String val = st[index--];
    if (val.equals("#")) return null; // Empty Leaf
    TreeNode root = new TreeNode(Integer.parseInt(val));
    root.right = deserialize(st);
    root.left = deserialize(st);
    return root;
  }
}
