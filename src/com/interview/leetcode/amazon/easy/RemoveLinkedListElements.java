package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/remove-linked-list-elements/description/

1) if the targetKey matches currentHead. Connect previous.next and currentHead.next.

2) Use dummyHead to avoid "if check" inside while condition. 
   1) If the target lies in firstNode itself. previous will be null. So connect logic will throw NPE.
   2) To avoid NPE. I can start previous with dummyHead. Finally return dummyHead.next. 
   
 */
public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummyHead = new ListNode();
    dummyHead.next = head; // Change1

    ListNode previous = dummyHead; // Change2
    ListNode currentHead = head; // This code is same as without dummyHead

    while (currentHead != null) {
      if (currentHead.val == val) {
        previous.next = currentHead.next;
      } else {
        previous = currentHead;
      }
      currentHead = currentHead.next;
    }
    return dummyHead.next;// Change3
  }

  public ListNode removeElementsWithoutDummyHead(ListNode head, int val) {
    ListNode previous = null;
    ListNode currentHead = head;
    while (currentHead != null) {
      if (currentHead.val == val) {
        if (previous == null) {
          head = head.next;
        } else {
          previous.next = currentHead.next;
        }
      } else {
        previous = currentHead;
      }

      currentHead = currentHead.next;//move head ahead, common statement for both case
    }
    return head;
  }

}
