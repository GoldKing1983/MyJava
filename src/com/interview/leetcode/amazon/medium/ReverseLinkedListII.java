package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.ListNode;

/*

https://leetcode.com/problems/reverse-linked-list-ii/
https://www.educative.io/courses/grokking-the-coding-interview/qVANqMonoB2
[3,5]
1
2


 */
public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int p, int q) {
    if (p == q) return head;
    ListNode current = head, previous = null;
    int i = 1;
    while (i < p) {
      previous = current;
      current = current.next;
      i++;
    }

    ListNode previousCache = previous; // points to the node at index 'p-1'
    ListNode currentCache = current;

    ListNode next = null; // will be used to temporarily store the next node
    while (i++ <= q) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    if (previousCache != null) previousCache.next = previous;
    else head = previous;

    currentCache.next = current;

    return head;
  }
}
