package com.interview.leetcode.topic.bst;

import com.interview.leetcode.TreeNode;

/*

1) If I sort the tree in ascending order. The firstNode greater than current is the answer. 
   Ex: [1 3 5 7 9] p=5... 7 is the answer.
2) Do In-Order Traversal, cache the firstResult > p.val
3) Worst Case : if p=9. I have to search entire BST. The Time Complexity will be O(n).

4) If I use the property of BST. Then Time Complexity would be O(log(n)). See InorderSuccessorInBSTBest
   


 */
public class InorderSuccessorInBSTBruteForce {

  TreeNode cacheResult = null;

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null || cacheResult != null) return cacheResult;

    inorderSuccessor(root.left, p);

    if (cacheResult == null && root.val > p.val) {
      cacheResult = root;
      return cacheResult;
    }

    return inorderSuccessor(root.right, p);

  }
}
