package com.interview.leetcode.topic.tree;

/*
https://binarysearch.com/problems/Binary-Tree-to-Linked-List

 */
public class BinaryTreeToLinkedList {
  
/*  
  LLNode head;
  public LLNode solve(Tree root) {
      if(root == null) return null;
      inorder(root, null);
      return head;
  }

  private LLNode inorder(Tree root, LLNode parent) {
      if(root == null) {
          return parent;
      }
      LLNode current = new LLNode(root.val);
      LLNode left = inorder(root.left, current);
      if(head == null) head = current;
      current.next = inorder(root.right, parent);
      return left;
  }
  
  */

}
