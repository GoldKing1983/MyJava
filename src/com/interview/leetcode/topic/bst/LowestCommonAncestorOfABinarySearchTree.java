package com.interview.leetcode.topic.bst;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
Note: node1 and node2 are always different and both values will always exist in the BST.

                              5
                             / \
                            1   10
                             \    \
                              2    20
node1=1 and node2=10. Ans=5
node1=1 and node2=5.  Ans=5
node1=5 and node2=10.  Ans=5
====================================================Solution Approach============================================================
1) If value of both node1 and node2 are greater than the root's value, then they both must exist on right side of the root.
Therefore, move right: root = root.right.
Ex: node1=10 and node2=20

2) If value of both node1 and node2 are smaller than the root's value, then they both must exist on left side of the root.
Therefore, move left: root = root.left.
Ex: node1=1 and node2=2

3) Else means p and q are on either side of the root, which means root is the answer. Therefore, we break loop at this point.
Ex: node1=2 and node2=20

Time Complexity: O(h) ---> h is height of tree.... Note: it is not O(log(n))
=================================================================================================================================
 */
public class LowestCommonAncestorOfABinarySearchTree {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {

    // Root null check is not needed, because it will never touch leaf's left or right which is null. Because as per assumption "root", "node1" and "node2" all exists.
    //if(root==null) return null;

    int rootValue = root.val;
    int node1Value = node1.val;
    int node2Value = node2.val;

    // Both the values are greater than root value. So go right side
    if (rootValue < node1Value && rootValue < node2Value) {
      return lowestCommonAncestor(root.right, node1, node2);
    }

    // Both the values are less than root value. So go left side
    if (rootValue > node1Value && rootValue > node2Value) {
      return lowestCommonAncestor(root.left, node1, node2);
    }
            /*
               node1= 5 and node2= 10
                  5
                   \
                    10
             */
            
    // root is the answer
//    if (rootValue == node1Value || rootValue == node2Value) { ====> I don't need this code as below covers this case. 
//      return root;
//    }
    
        /*
         node1=1 and node2=10. So one lies left and one lies right. So return root.
                 5
               /   \
              4     10
             /
            1       
         */

    return root; // this case executes when rootValue==node1Value || rootValue==node2Value
  }
}
