package com.interview.leetcode.topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
See image for how it is saved "SerializeDeSerializeBinaryTree.JPG"

Serialization can be done in any ways, as long as it can be de-serialized.

1) Serialize: (Modified Level Order Traversal. If node is null insert n)
		a) Logic is not inserting n for end of level. It is about inserting n leaf.
		b) =====Note: I don't have to worry about level at all....=========
		c) So for a tree with 1 node there will be 2 n,
			  for a tree with 3 node there will be 4 n.. check the diagram SerializeAndDeSerializeBinaryTree.jpg

				    1
				   / \
				  2   3
				     / \
				    4   5
			Note: Append "," between numbers, Append "n," for null.
			serialized data = 1,  2,3,n,n, 4,5,  n,n,n,n


2) De-Serialize:(Queue approach, but not level order traversal. Only one for loop)
		a) Split the string by ","
		b) Iterate each data and look for n.  If it n then skip creating node and skip adding node to queue.
		c) =====Doubt: how come if a tree growing one side and without managing level, how de-serialization works?
				It works, because each node has exactly 2 child left and right.
				At any point, if a left or right child is null, I will skip adding child(left or right) to the parent.
				It works also because of Queue
	=====This Logic will not work for n-ary tree because n-ary tree has more than 2(left and right) node==========
 *
 */
public class SerializeAndDeserializeBinaryTreeQueueApproach {

  private static final String EMPTY_NODE_INDICATOR = "n";
  private static final String NODE_SEPERATOR = ",";

  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    StringBuilder result = new StringBuilder();
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (node == null) {
          result = result.append(EMPTY_NODE_INDICATOR + NODE_SEPERATOR);
        } else {
          result.append(node.val + NODE_SEPERATOR);
          q.offer(node.left);
          q.offer(node.right);
        }
      }
    }
    return result.substring(0, result.length() - 1);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if ("".equals(data)) return null;
    String dataArray[] = data.split(NODE_SEPERATOR);
    TreeNode root = new TreeNode(Integer.valueOf(dataArray[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int dataIndex = 1;
    while (!q.isEmpty()) {
      TreeNode parent = q.poll();
      if (!dataArray[dataIndex].equals(EMPTY_NODE_INDICATOR)) {
        TreeNode left = new TreeNode(Integer.valueOf(dataArray[dataIndex]));
        parent.left = left;
        q.offer(left);
      }
      dataIndex++;
      if (!dataArray[dataIndex].equals(EMPTY_NODE_INDICATOR)) {
        TreeNode right = new TreeNode(Integer.valueOf(dataArray[dataIndex]));
        parent.right = right;
        q.offer(right);
      }
      dataIndex++;
    }
    return root;
  }
}
