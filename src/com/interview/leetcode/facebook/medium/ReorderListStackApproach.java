package com.interview.leetcode.facebook.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/reorder-list
==========================================================Requirement============================================================
Given 1->2->3->4, reorder it to 1->4->2->3.
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
========================================================Solution Approach========================================================   
1) Traverse the node and put it in stack. So that last node can be taken
2) Traverse eachNode from head, connect head and last. Keep doing it.
3) The only trick is to set null at end of list, based on odd and even number of counts.
 */
public class ReorderListStackApproach {
  public void reorderList(ListNode head) {
    Deque<ListNode> stack = new ArrayDeque<>();
    ListNode tempHead = head;
    int size = 0;
    while (tempHead != null) {
      stack.push(tempHead);
      tempHead = tempHead.next;
      size++;
    }
    if (size < 2) {
      return;
    }
    for (int i = 0; i < (size - 1) / 2; i++) {
      ListNode lastNode = stack.pop(); // lastNode
      ListNode secondNode = head.next; // cache secondNode
      head.next = lastNode; // connect first and lastNode... that will make "firstNode-->secondNode"
      lastNode.next = secondNode; // connect lastNode with seconNode... that will make "secondNode-->thirdNode"  
      head = secondNode; // move head to thirdNode
    }
    if (size % 2 == 0) head = head.next;

    head.next = null;
  }
}
