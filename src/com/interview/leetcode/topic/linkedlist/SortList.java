package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/sort-list

Using Insertion sort to sort the list

1) Iterate list one by one. 
2) If the current lies between prev and next. insert  
 */
public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    ListNode curr = head;
    ListNode next = null;

    while (curr != null) {
      next = curr.next;
      while (prev.next != null && prev.next.val < curr.val) {
        prev = prev.next;
      }
      curr.next = prev.next;
      prev.next = curr;
      curr = next;
      prev = dummy;
    }
    return dummy.next;
  }
}
