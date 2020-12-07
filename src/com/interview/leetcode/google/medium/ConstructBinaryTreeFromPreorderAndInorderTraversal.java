package com.interview.leetcode.google.medium;

import java.util.HashMap;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 https://www.youtube.com/watch?v=PoBGyrIWisE

            1
          /   \
         2     3
              / \
             4   5
        PreOrder :  1 2 3 4 5
        InOrder  :  2 1 4 3 5

 1) From the PreOrder First Node I can say it is the root(1).
 2) Taking the root and comparing it to InOrder, we know left and right.

Step1:
            1
          /   \
         2   {4,3,5}
Step2:
	Now my updated InOrder is [2] [4,3,5].
==================================Solution Approach==============================================================================
1) Take PreOrder as source to build root. Build element0 as root.
2) Now element0 is the "cutPoint". From cutPoint find "leftStartIndex, leftEndIndex" and "rightStartIndex, rightEndIndex"
3) Recursively assign left and right.
===================================Implementation Note===========================================================================
1) InOrder data is fed into map, to find the cutPoint index. Without map, forLoop search is needed which affects performance.
2) See problem "ConstructBinarySearchTreeFromPreorderTraversal". There a for loop is done.
3) But key-point in "ConstructBinarySearchTreeFromPreorderTraversal" is TreeMap is needed, because of sorted nature. 
So for loop is better.
=================================================================================================================================

 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
  int index = 0;
  // key as nodeValue and value as indexOfNodeValue
  HashMap<Integer, Integer> inOrderMap = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; ++i) inOrderMap.put(inorder[i], i);
    return recur(preorder, 0, inorder.length - 1);
  }

  public TreeNode recur(int[] preorder, int low, int high) {
    if (low > high) return null;

    int rootNodeValue = preorder[index++];
    TreeNode root = new TreeNode(rootNodeValue);
    int cutPoint = inOrderMap.get(rootNodeValue);

    root.left = recur(preorder, low, cutPoint - 1);
    root.right = recur(preorder, cutPoint + 1, high);
    return root;
  }
}
