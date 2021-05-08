package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
https://www.youtube.com/watch?v=13m9ZCB8gjw
===========================================================Requirement===========================================================
				           1
				         /   \ 
				       2       3
				      / \	  / \
				     4   5   6   7

========================================================Logical Thinking=========================================================				     
Best Approach: (Using Single Traversal)
==========
If we assume that the keys n1 and n2 are always present in Binary Tree, we can find LCA using single traversal of
Binary Tree and without extra storage for path arrays.
1) Traverse(post order) the tree starting from root.
2) If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present).
3) If root doesn’t match with any of the keys, we recur for left and right subtree.
4) The node which has one key present in its left subtree and the other key present in right subtree is the LCA.
If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.

		Ex1:	1		    Ex2:	1
				  2               2
				    3           3
				      4       4
		For above example. to find LCA of 2 and 4.
		recursion stops at 2. Because left is null and since is 2 is found, 4 must be below (assuming 4 present all time)
========================================================Solution Approach========================================================
1) Solution is done through POST-Order traversal. 
2) When node1 or node2 is found we return parent or root to the caller.
3) Now as per post-order we have root, leftResult and rightResult. 
4) Now I can play with 3 nodes based on requirement criteria. 

 */

/* @formatter:off  disabling for tree structure analysis not to collapse*/
public class LowestCommonAncestorOfABinaryTreeOrLCADetail {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root; // Note : we are returning parent. Not the foundNode.

    TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
    TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
    
                /*
                for 2 and 3 ans=1
                1
               / \
              2   3
              */
      if(leftResult!=null && rightResult!=null) return root;
      
      
                /*
            ====case1====    
            for 2 and 3 ans=2
               1
              /
             2
            /
           3
           
           at node2 right is null. So return 2. I don't need to traverse 3.
            ====case2====
                
                for 4 and 3... ans=1
                1
               / \
              2   3
             /
            4 
                at point2 right is null... so return 4
                Then tree will change like
                1
               / \
              4   3
              */
      
      if(leftResult!=null && rightResult==null) return leftResult; 
      
                    /*
                   for 3 and 5 or 3 and 7
                   at node3 left is null. return 3 
                    1
                     \
                      3
                       \
                        5
                         \
                          7
                    */
      
      if(rightResult!=null && leftResult==null) return rightResult;
      
    
    return null;
  }

}
