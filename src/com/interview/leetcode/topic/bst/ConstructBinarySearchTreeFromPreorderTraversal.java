package com.interview.leetcode.topic.bst;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
See Also ConstructBinaryTreeFromInorderAndPostorderTraversal
===========================================================Requirement===========================================================
1) Given a array of number in pre-order traversal.
2) Build the BST. 


Input: [8,5,1,7,10,12]
							8
						   / \
						  5   10
						 / \   \
						1   7   12
=========================================================Initial Thought=========================================================
Observation1: FirstNode is root. From there whatever less should come at left.
								 From there whatever more should come at right.
								8
							  /   \
                         {5,1,7} {10,12}

                                8
                              /   \
                            {5} {10,12}
                            / \
                          {1} {7} 
========================================================Solution Approach========================================================
1) For the given array find 3 things.
    1a) RootValue. It is at preorder[start].
	1b) Find LeftWindow for root. 
		1bb) To Calculate leftWindow, find cutPoint. if cutPointValue>rootNumber. Break  
		For above Ex: cutPoint found at index4. LeftWindow=start+1 to cutPoint-1
	1c) Find RightWindow for root.
		1cc) From above calculated cutPoint find rightWindow. For above Ex: cutPoint is at index4. RightWindow=cutPoint to end.
2) Do step1 recursively.
3) If start>end return null.
=========================================================================================================================
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

  public TreeNode bstFromPreorder(int[] preorder) {
    return recur(preorder, 0, preorder.length - 1);
  }

  public TreeNode recur(int[] preorder, int start, int end) {
    if (start > end) return null;

    // Find LeftWindow and RightWindow
    int rootValue = preorder[start];
    int cutPoint;
    for (cutPoint = start; cutPoint <= end; cutPoint++) {
      int cutPointValue = preorder[cutPoint];
      if (cutPointValue > rootValue) break;
    }

    // cutPoint stops at index4. LeftWindow is 1to3 and rightWindow is 4to5
    TreeNode root = new TreeNode(rootValue);
    root.left = recur(preorder, start + 1, cutPoint - 1);
    root.right = recur(preorder, cutPoint, end);

    return root;
  }
}
