package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.list.Node;

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
                          | |                            | |
                          |  ----------------------------  |                            |
                           --------------------------------

Output: [1,2,3,4,5]

 * 1) Form DoubleLinkedList with Tree itself
 * 2) Tree Right points to next node
 * 3) Tree Left points to previous node.

 * 1) Do In-Order Traversal.
 * 2) Connect previous.right = current.
 * 3) current.left = previous
 * 4) previous = current
 *
 * SubLogic:
 * 1) Connect Last Node right with and First Node.
 * 2) Connect First Node left with Last Node.
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
  private Node prev = null;

  public Node treeToDoublyList(Node root) {
    if (root == null) return null;
    Node dummy = new Node(0, null, null);
    prev = dummy;
    recur(root);
    // connect head and tail
    prev.right = dummy.right;
    dummy.right.left = prev;
    return dummy.right;
  }

  private void recur(Node cur) {
    if (cur == null) return;
    recur(cur.left);
    prev.right = cur;
    cur.left = prev;
    prev = cur; // Important. Update previous to current
    recur(cur.right);
  }
}
