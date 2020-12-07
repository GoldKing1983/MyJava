package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/convert-bst-to-greater-tree/description/
============================================================Requirement==========================================================
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the 
original key plus sum of all keys greater than the original key in BST.


Input: The root of a Binary Search Tree like this:
              5
            /   \
           1     10

Output: The root of a Greater Tree like this:
             15
            /   \
          16     10
============================================================BruteForce===========================================================
1) Do In-order traversal, save result in list. Ex: [1,5,10]
2) Update list with Fibonacci from last. Ex: [16,15,10] 
3) Do In-order traversal. Update listValue with nodeValue. 
=========================================================Solution Approach=======================================================
1) If I do in-order traversal, I will be getting 
        1 --> 5 --> 10 
                      
2) Do Fibonacci of current and previous from last.
        1 --> 5 --> 10 
                      
                    10+0=10 --> 5+10=15 --> 1+15=16 
        
3) last    = last   + 0
   last-1  = last-1 + last.
   last-2  = last-2 + last-1.
   
4) Do the sum logic in "rightFirst-in-order" traversal. Because we need to do sum from right-root-left
   
 */
public class ConvertBSTToGreaterTree {


  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    convert(root);
    return root;
  }

  public void convert(TreeNode cur) {
    if (cur == null) return;
    convert(cur.right);

    cur.val += sum;
    sum = cur.val;

    convert(cur.left);
  }
}
