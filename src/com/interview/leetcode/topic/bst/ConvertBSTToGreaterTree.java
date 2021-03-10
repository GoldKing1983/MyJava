package com.interview.leetcode.topic.bst;

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
Step1) Do In-order traversal, save result in list. Ex: [1,5,10]
Step2) Update list like Fibonacci Series from last. Ex: [16,15,10]
Step3) Do In-order traversal. Update listValue with nodeValue.
=========================================================Solution Approach=======================================================
1) If I do in-order traversal, I will be getting 
        1 --> 5 --> 10 

2) If I do right-First-in-order traversal, I will be getting
        10 --> 5 --> 1

3) Like Fibonacci, set currentValue = currentValue + previousValue from last.
        10+0=10 --> 5+10=15 --> 1+15=16
        
        last    = last   + 0
        last-1  = last-1 + last.
        last-2  = last-2 + last-1.
   
 */
public class ConvertBSTToGreaterTree {


  int previousSum = 0;

  public TreeNode convertBST(TreeNode root) {
    convert(root);
    return root;
  }

  public void convert(TreeNode cur) {
    if (cur == null) return;

    convert(cur.right);

    int currentSum = cur.val + previousSum;
    cur.val = currentSum;
    previousSum = currentSum;

    convert(cur.left);
  }
}
