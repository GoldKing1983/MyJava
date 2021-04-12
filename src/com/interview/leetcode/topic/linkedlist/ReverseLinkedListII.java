package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;

/*

https://leetcode.com/problems/reverse-linked-list-ii/


1) Skip the first p-1 nodes, to reach the node at position p.
2) Remember the node at position p-1 to be used later to connect with the reversed sub-list.
3) Next, reverse the nodes from p to q using the same approach discussed in Reverse a LinkedList.
4) Connect the p-1 and q+1 nodes to the reversed sub-list.

 */
public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int p, int q) {
    if (p == q) return head;
    ListNode pthNode = head, pMinus1thNode = null;
    for (int i = 1; i < p; i++) {
      pMinus1thNode = pthNode;
      pthNode = pthNode.next;
    }

    reverseNNodesFromStart(pthNode, q - p);

    // Ex: [10,20] p=1 q=2... here head can directly point reversedFirstNode.  
    if (p == 1) head = reversedFirstNode;
    else pMinus1thNode.next = reversedFirstNode;

    pthNode.next = qThNode;

    return head;
  }

  ListNode reversedFirstNode = null;
  ListNode qThNode = null;

  private void reverseNNodesFromStart(ListNode root, int n) {
    if (n == 0) {
      reversedFirstNode = root;
      qThNode = root.next;
      return;
    }
    reverseNNodesFromStart(root.next, n - 1);
    root.next.next = root;
    root.next = null;
  }

}
