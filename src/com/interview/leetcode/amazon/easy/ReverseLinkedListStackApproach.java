package com.interview.leetcode.amazon.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/reverse-linked-list/description
https://www.youtube.com/watch?v=MRe3UsRadKw --- watch from 2.44


Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

*/
public class ReverseLinkedListStackApproach {
  public ListNode reverseList(ListNode head) {
    Deque<ListNode> stack = new ArrayDeque<>();
    if (head == null) return null;
    while (head.next != null) {
      stack.push(head);
      head = head.next;
    }
    ListNode newHead = head;
    // head = 5 stackTop = 4
    while (!stack.isEmpty()) {
      head.next = stack.pop();
      head = head.next;
    }
    head.next = null;

    return newHead;
  }
}
