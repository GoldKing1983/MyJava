package com.interview.leetcode.ebay;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/binary-tree-cameras/

Given a binary tree, we install cameras on the nodes of the tree. 

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.

======================================================Example1===================================================================
Input: [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.

                0
             /     \
            0(c)    n
           / \
          0   0
======================================================Example2===================================================================          
Input: [0,0,null,null,0,0,null,null,0,0]
Output: 2
              0 - returns back ROOT_DEPEND_ON_CHILD_CAMERA
             / 
            0 - (c) returns back CAMERA_NODE  
             \
              0 - returns back LEAF_DEPENDS_ON_PARENT_CAMERA
             /
            0 - returns back ROOT_DEPEND_ON_CHILD_CAMERA
             \
              0 - (c) returns back CAMERA_NODE
             /
            0  - returns back LEAF_DEPENDS_ON_PARENT_CAMERA
======================================================Example3===================================================================
Input: [0,null,0,null,0,null,0]
Output: 2
                0 - returns back LEAF_DEPENDS_ON_PARENT_CAMERA
                 \
                  0 - returns back ROOT_DEPEND_ON_CHILD_CAMERA
                   \
                    0 - (c) returns back CAMERA_NODE
                     \
                      0 - returns back LEAF_DEPENDS_ON_PARENT_CAMERA
               
               increment camerasCount in main       
====================================================Initial Thinking=============================================================
Consider a node in the tree.
It can be covered by its parent, itself, its two children. Four options.

Consider the root of the tree.
It can be covered by left child, or right child, or itself. Three options.

Consider one leaf of the tree.
It can be covered by its parent or by itself. Two options.

If we set a camera at the leaf, the camera can cover the leaf and its parent.
If we set a camera at its parent, the camera can cover the leaf, its parent and its sibling.

We can see that the second plan is always better than the first.
Now we have only one option, set up camera to all leaves' parent.

Here is our greedy solution:

Set cameras on all leaves' parents, then remove all covered nodes.
Repeat step 1 until all nodes are covered.
            
 */
public class BinaryTreeCameras {
  private int camerasCount = 0;

  private enum Status {
    NULL_MONITOR_NOT_NEEDED, LEAF_DEPENDS_ON_PARENT_CAMERA, ROOT_DEPEND_ON_CHILD_CAMERA, CAMERA_NODE
  }

  public int minCameraCover(TreeNode root) {
    // Corner Case Example3
    if (recur(root) == Status.LEAF_DEPENDS_ON_PARENT_CAMERA) camerasCount++;
    return camerasCount;
  }

  // Take Example1 and explain
  private Status recur(TreeNode node) {
    if (node == null) return Status.NULL_MONITOR_NOT_NEEDED;// Leaf Nodes left&right null
    Status leftStatus = recur(node.left);
    Status rightStatus = recur(node.right);
    // In Example1 Staying on CAMERA_NODE
    if (leftStatus == Status.LEAF_DEPENDS_ON_PARENT_CAMERA
        || rightStatus == Status.LEAF_DEPENDS_ON_PARENT_CAMERA) {
      camerasCount++;
      return Status.CAMERA_NODE;
    }

    // In Example1 Staying on ROOT
    if (leftStatus == Status.CAMERA_NODE || rightStatus == Status.CAMERA_NODE)
      return Status.ROOT_DEPEND_ON_CHILD_CAMERA;

    // In Example1 Staying on LEAF
    return Status.LEAF_DEPENDS_ON_PARENT_CAMERA;
  }
}
