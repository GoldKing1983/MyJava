package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;

/*

https://leetcode.com/problems/add-two-numbers/
==========================================================Requirement============================================================
1) Do addition  from left to right. 
2) If there is Carry, propagated right.
============================================================Example1=============================================================
                  2 4 3
                  5 6 4
                  =====
                  7 0 8
                  ======
============================================================Example2=============================================================
                  0 2 4 3
                  5 6 4
                  =====
                  5 8 8 3
                  ======
========================================================Solution Approach========================================================
1) Sum l1PtrValue and l2PtrValue and carry.
2) Save the sum(sum%10) in currNode. Carry=sum>=10 or sum/10
3) If prevNode is not null. Connect prevNode and currNode. prevNode=currNode.
=================================================================================================================================

Avoid 2nd loop for remaining data by setting to 0 whichever is null

		int l1Value = l1 != null ? l1.val : 0;
		int l2Value = l2 != null ? l2.val : 0;
*/
public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1Ptr, ListNode l2Ptr) {
    ListNode result = new ListNode(0);
    ListNode resultHead = result;
    int carry = 0;
    while (l1Ptr != null || l2Ptr != null) {
      int l1Value = l1Ptr != null ? l1Ptr.val : 0;
      int l2Value = l2Ptr != null ? l2Ptr.val : 0;
      int sum = l1Value + l2Value + carry;
      ListNode currResult = new ListNode(sum % 10);
      result.next = currResult;
      result = result.next;
      carry = sum / 10;
      l1Ptr = l1Ptr != null ? l1Ptr.next : null;
      l2Ptr = l2Ptr != null ? l2Ptr.next : null;
    }
    if (carry > 0) {
      result.next = new ListNode(1);
    }
    return resultHead.next;
  }

  public ListNode addTwoNumbersWithoutDummyHead(ListNode l1, ListNode l2) {
    ListNode result = null;
    ListNode resultHead = null;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int num1 = l1 == null ? 0 : l1.val;
      int num2 = l2 == null ? 0 : l2.val;

      int sum = num1 + num2 + carry;

      ListNode currResult = new ListNode(sum % 10);

      if (result == null) { // Runs only during the first time
        result = currResult;
        resultHead = currResult;
      } else {
        result.next = currResult;
        result = result.next;
      }

      carry = sum / 10;

      l1 = l1 == null ? l1 : l1.next;
      l2 = l2 == null ? l2 : l2.next;
    }

    if (carry == 1) result.next = new ListNode(1);

    return resultHead;
  }
}
