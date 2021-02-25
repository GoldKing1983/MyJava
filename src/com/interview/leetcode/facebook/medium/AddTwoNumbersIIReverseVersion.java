package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/add-two-numbers-ii/

==========================================================Requirement============================================================
1) Do addition  from right to left, just like regular addition.
2) If there is Carry, propagated left.
============================================================Example1=============================================================
 7 2 4 3
   5 6 4
=========
 7 8 0 7
=========

========================================================Solution Approach========================================================
1) Reverse l1.
2) Reverse l2.
3) Sum .
4) Reverse the result.

      3 4 2 7 --> reversed input1
      4 6 5   --> reversed input2
      ========
      7 0 8 7 --> Sum

      7 8 0 7 --> reversed Final Result.

=====Performance Point=====
1) To avoid step4, we can sum and connect current.next = prev.

 */
public class AddTwoNumbersIIReverseVersion {
  public ListNode reverseList(ListNode head) {
    ListNode last = null;
    while (head != null) {
      // keep the next node
      ListNode tmp = head.next;
      // reverse the link
      head.next = last;
      // update the last node and the current node
      last = head;
      head = tmp;
    }
    return last;
  }

  public ListNode addTwoNumbers(ListNode l1Ptr, ListNode l2Ptr) {
    // reverse lists
    l1Ptr = reverseList(l1Ptr);
    l2Ptr = reverseList(l2Ptr);

    ListNode prevNodePtr = new ListNode(0);
    ListNode head = prevNodePtr;
    int carry = 0;
    while (l1Ptr != null || l2Ptr != null) {
      int l1Value = l1Ptr != null ? l1Ptr.val : 0;
      int l2Value = l2Ptr != null ? l2Ptr.val : 0;
      int sum = l1Value + l2Value + carry;
      ListNode currNode = new ListNode(sum % 10);
      prevNodePtr.next = currNode;
      prevNodePtr = currNode;
      carry = sum / 10;
      l1Ptr = l1Ptr != null ? l1Ptr.next : null;
      l2Ptr = l2Ptr != null ? l2Ptr.next : null;
    }
    if (carry > 0) {
      prevNodePtr.next = new ListNode(1);
    }


    return reverseList(head.next);


  }
}
