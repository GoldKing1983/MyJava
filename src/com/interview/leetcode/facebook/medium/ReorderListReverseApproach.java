package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/reorder-list
====================================================Requirement==================================================================
Given 1->2->3->4, reorder it to 1->4->2->3.
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
==================================================Solution Approach==============================================================   
1) Find the middle of the list
2) Reverse the second half. 
        So  1->2->3->4->5->6 
 changed to 1->2->3->6->5->4
3) Start reorder one by one, 1->2->3->6->5->4 to 1->6->2->5->3->4
=================================================================================================================================
 */
public class ReorderListReverseApproach {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    //Find the middle of the list
    ListNode p1 = head;
    ListNode p2 = head;
    while (p2.next != null && p2.next.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }

    //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
    ListNode preMiddle = p1;
    ListNode preCurrent = p1.next;
    while (preCurrent.next != null) {
      ListNode current = preCurrent.next;
      preCurrent.next = current.next;
      current.next = preMiddle.next;
      preMiddle.next = current;
    }

    //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
    p1 = head;
    p2 = preMiddle.next;
    while (p1 != preMiddle) {
      preMiddle.next = p2.next;
      p2.next = p1.next;
      p1.next = p2;
      p1 = p2.next;
      p2 = preMiddle.next;
    }
  }
}
