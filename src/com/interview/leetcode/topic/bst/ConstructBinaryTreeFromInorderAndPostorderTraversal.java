package com.interview.leetcode.topic.bst;

import java.util.HashMap;
import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * See......ConstructBinaryTreeFromPreorderAndInorderTraversal.... Just minor difference
==================================Solution Approach============================================================
1) Take PostOrder as source to build root. Build elementN-1 as root.
2) Now elementN-1 is the "cutPoint". From cutPoint find "leftStartIndex, leftEndIndex" and "rightStartIndex, rightEndIndex"
3) Recursively assign left and right.
===================================Implementation Note===================================================================
1) recursion is done for right first then left, because... post-order if we go bottom-up, right then left.
2) inorder is fed into map, to find the cutPoint index. Without map, forLoop search is needed, which can increase performance.
See problem "ConstructBinarySearchTreeFromPreorderTraversal". There a for loop is done. 
But key-point in "ConstructBinarySearchTreeFromPreorderTraversal" is TreeMap is needed, because of sorted nature. So for loop is better.
======================================================================================================
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
  int index;
  HashMap<Integer, Integer> inOrderMap = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    index = postorder.length - 1;
    for (int i = 0; i < inorder.length; ++i) inOrderMap.put(inorder[i], i);
    return recur(postorder, 0, inorder.length - 1);
  }

  private TreeNode recur(int[] postorder, int low, int high) {

    if (low > high) return null;

    int rootNodeValue = postorder[index--];

    TreeNode root = new TreeNode(rootNodeValue);

    int cutPoint = inOrderMap.get(rootNodeValue);

    root.right = recur(postorder, cutPoint + 1, high);
    root.left = recur(postorder, low, cutPoint - 1);

    return root;
  }
}
