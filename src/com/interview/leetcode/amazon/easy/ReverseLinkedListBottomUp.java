package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/reverse-linked-list/description
https://www.youtube.com/watch?v=MRe3UsRadKw --- watch from 2.44
Similar to problem pattern MergeTwoSortedListsClone

Understand ReverseLinkedListRecursion. Here we return cacheLastNode instead of global variable.

*/
public class ReverseLinkedListBottomUp {
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    return recur(head);
  }

  private ListNode recur(ListNode head) {
    if (head.next == null) return head;
    ListNode cacheLastNode = reverseList(head.next);
    // =================== Reverse Logic Start ===================
    head.next.next = head; // Child point back to Parent.
    head.next = null; // Cut "Parent to Child" Link.
    // =================== Reverse Logic End ===================
    return cacheLastNode;
  }
}
