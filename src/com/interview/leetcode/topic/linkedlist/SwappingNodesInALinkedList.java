package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

===========================================================Requirement===========================================================
1) Given the head of a linked list, and an integer k.
2) Swap the beginning of kth value with ending of kth value.
========================================================Solution Approach========================================================
    1) get n.
    2) goto n-k
    3) goto k
    4) swap n-k and k


 */
public class SwappingNodesInALinkedList {
  public ListNode swapNodes(ListNode head, int k) {

    int n = 0;
    ListNode tempHead = head;
    while (tempHead != null) {
      tempHead = tempHead.next;
      n++;
    }

    tempHead = head;
    int nMinusK = n - k;
    while (nMinusK-- > 0) {
      tempHead = tempHead.next;
    }
    ListNode tempHead2 = head;
    k--;
    while (k-- > 0) {
      tempHead2 = tempHead2.next;
    }

    int temp = tempHead.val;
    tempHead.val = tempHead2.val;
    tempHead2.val = temp;

    return head;

  }

}
