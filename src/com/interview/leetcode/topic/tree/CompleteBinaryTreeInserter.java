package com.interview.leetcode.topic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/complete-binary-tree-inserter/
===========================================================Requirement===========================================================
1) A complete-binary-tree is given as input....
Example1: 
          0
        /   \
       1     2
      / \
     3   4

Example2:     
          0
        /   \
       1     2
      / 
     3   
2) Add the new-node to the tree. Return parent. 
   In Example1 new-node is added to left of 3. Return 3.
   In Example2 new-node is added to right of 2. Return 2.
=======================================================Data Flow Analysis========================================================
1) Add each node to list by their index.
2) To insert the new-node find the nodeIndex...
   get the node from nodeList. 
   if leftIsAvailble add new-node to left else add it to right.
            
 */
public class CompleteBinaryTreeInserter {
  List<TreeNode> nodeList = new ArrayList<>();
  TreeNode rootToReturn = null;

  public CompleteBinaryTreeInserter(TreeNode root) {
    rootToReturn = root;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      if (cur == null) break;
      nodeList.add(cur);

      q.add(cur.left);
      q.add(cur.right);
    }
  }

  public int insert(int v) {
    TreeNode newNode = new TreeNode(v);
    // for Example1... (5-1)/2 = 4/2=2
    // for Example2... (4-1)/2 = 3/2=1
    int nodeIdToInsert = (nodeList.size() - 1) / 2;
    TreeNode parent = nodeList.get(nodeIdToInsert);

    if (parent.left == null) parent.left = newNode;
    else parent.right = newNode;

    nodeList.add(newNode);
    return parent.val;
  }

  public TreeNode get_root() {
    return rootToReturn;
  }
}
