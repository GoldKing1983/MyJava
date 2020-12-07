package com.interview.leetcode.ebay;

import com.interview.leetcode.ListNode;

/*
==========================================================Requirement============================================================
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given a sorted linked list, delete all duplicates such that each element appear only once.

Input: 1->1->2
Output: 1->2

Input: 1->1->2->3->3
Output: 1->2->3
========================================================Solution Approach========================================================
1) Always compare current and next
2) If currentValue and nextValue are same...Skip the next by pointing current.next to next.next
3) Else current = next.
4) Next is always current.next.
 */
public class RemoveDuplicatesFromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    ListNode current = head;

    while (true) {

      ListNode next = current.next;

      if (next == null) break;

      if (current.val == next.val) current.next = next.next;
      else current = next;
    }

    return head;
  }
}
