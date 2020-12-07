package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.list.Node;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/

Input: root = [4,2,5,1,3]
						4
					   / \
					  2   5
					 / \
					1   3

				  HEAD------->  1 -> 2 -> 3-> 4 -> 5 ------
						  |  --   <-   <-  <-   <-  <- <-  |
						  |	|							 | |
						  |  ----------------------------  |						    |
						   --------------------------------

Output: [1,2,3,4,5]

 * 1) Form DoubleLinkedList with Tree itself
 * 2) Tree Right points to next node
 * 3) Tree Left points to previous node.
 *
 * Main Logic :
 * 1) From Root Node push all left node to stack
 * 2) Pop a node(current).
 * 			If there is right. Then push all of its left node to stack. Take a node(next)
 * 			If there is no right. Then pop a node(next).
 * 3) Connect current and next
 *
 * SubLogic:
 * 1) Connect Last Node right with and First Node.
 * 2) Connect First Node left with Last Node.
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

  /*
   Memory Complexity
   Linear, O(h).
  */
  public Node treeToDoublyList(Node root) {

    if (root == null) return null;
    Deque<Node> stack = new ArrayDeque<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
    Node head = stack.peek(); // The leftmost node is the new head
    Node cur = null;
    while (!stack.isEmpty()) {
      Node top = stack.peek();
      cur = stack.pop();
      if (cur.right != null) {
        cur = cur.right;
        while (cur != null) {
          stack.push(cur);
          cur = cur.left;
        }
      }
      if (!stack.isEmpty()) {
        top.right = stack.peek();
        stack.peek().left = top;
      }
    }
    cur.right = head;
    head.left = cur;
    return head;
  }
}
