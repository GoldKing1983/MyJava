package com.interview.leetcode.topic.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Pre-Order for serialize and de-serialize. Same as SerializeAndDeserializeBinaryTreeRecursionBestPreOrder. 
But using q for de-serialize. This is better, because we don't need global index. 

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

    return serialize(root, new StringBuilder()).toString();
  }

  private StringBuilder serialize(TreeNode root, StringBuilder serializedString) {
    if (root == null) return serializedString.append("n,");

    serializedString.append(root.val).append(",");
    serialize(root.left, serializedString);
    return serialize(root.right, serializedString);

  }

  //Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {

    Deque<String> q = new ArrayDeque<>(List.of(data.split(",")));
    return dfs(q);
  }

  private TreeNode dfs(Queue<String> q) {
    if (q.isEmpty()) return null;
    String s = q.poll();
    if (s.equals("n")) return null;

    TreeNode root = new TreeNode(Integer.valueOf(s));
    root.left = dfs(q);
    root.right = dfs(q);

    return root;
  }

}
