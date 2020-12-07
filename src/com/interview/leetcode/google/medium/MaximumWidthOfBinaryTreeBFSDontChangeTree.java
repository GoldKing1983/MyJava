package com.interview.leetcode.google.medium;

import java.util.Deque;
import java.util.LinkedList;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/maximum-width-of-binary-tree/
==============================================================Requirement========================================================
1) Given a binary tree, write a function to get the maximum width of the given tree.
2) The width of a tree can exist at any levels.
3) The width of one level is defined as the length between the end-nodes (he leftmost and right most non-null nodes in the level)
=======================================================ExampleNote===============================================================
In all below example "node.val" is updated to indexValue for easier understanding. Because result doesn't depend on "node.val"
==============================================================Example1===========================================================
 		    				1           level1==>1
 		    			 /     \
 		    			2		3       level2==>(3-2)+1 = 2
 		    		   / \	   / \
 		    		  4   5   6   7     level3==>(7-4)+1 = 4
 		    		 / \		   \
 		    		8   9           15  level4==>(15-8)+1= 8
Output: 8
==============================================================Example2===========================================================
 		    				 1          level1==>1          ==>MaxWidth=1
 		    			    / \
 		    			   2   3        level2==>(3-2)+1 = 2==>MaxWidth=2
 		    			  /		\
 		    		     4       7      level3==>(7-4)+1 = 4==>MaxWidth=4
 		    		    /		  \
 		    		   8           15   level4==>(15-8)+1= 8==>MaxWidth=8
Output: 8
==============================================================Example3===========================================================
								  1     level1==>1          ==>MaxWidth=1
						         /
						        2		level2==>(2-2)+1 = 1==>MaxWidth=1
						       / \
						      4   5		level3==>(5-4)+1 = 2==>MaxWidth=2
						     /
						    8 			level4==>(8-8)+1 = 1
Output: 2 [Note: Maximum answer is at level3]
=========================================Solution Approach===See "TreeIndexingNodes.jpeg"========================================
0) To keep the TreeNode data. We are using Pair here
1) Do simple level order traversal.
2) Index the nodeValue at eachLevel, starting from root. Initially root index set as 1.
3) Calculate IndexOfEachNode at eachLevel by formula "left"-> root.val*2.... for "right"->root.val*2+1
4) Calculate maxWidth at eachLevel by "lastNodeIndexValue-firstNodeIndexValue+1"
===========================================================================

 */
public class MaximumWidthOfBinaryTreeBFSDontChangeTree {
  public int widthOfBinaryTree(TreeNode root) {
    Deque<Pair> q = new LinkedList<>();
    q.offer(new Pair(root, 1));
    int maxWidth = 0;
    while (!q.isEmpty()) {

      maxWidth = Math.max(maxWidth, q.peekLast().id - q.peekFirst().id + 1);

      int size = q.size();

      for (int i = 0; i < size; i++) {
        Pair parent = q.poll();
        TreeNode parentNode = parent.node;
        int parentId = parent.id;

        if (parentNode.left != null) {
          TreeNode childNode = parentNode.left;
          int childId = parentId * 2;
          q.offer(new Pair(childNode, childId));
        }

        if (parentNode.right != null) {
          TreeNode childNode = parentNode.right;
          int childId = parentId * 2 + 1;
          q.offer(new Pair(childNode, childId));
        }
      }
    }
    return maxWidth;
  }

  class Pair {
    TreeNode node;
    int id;

    public Pair(TreeNode node, int id) {
      this.id = id;
      this.node = node;
    }
  }


}
