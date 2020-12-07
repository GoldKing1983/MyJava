package com.interview.leetcode.facebook.medium;

import java.util.ArrayDeque;
import java.util.Deque;
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

 */
public class AddTwoNumbersII {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Deque<Integer> s1 = new ArrayDeque<>(), s2 = new ArrayDeque<>();

    while (l1 != null) {
      s1.push(l1.val);
      l1 = l1.next;
    }

    while (l2 != null) {
      s2.push(l2.val);
      l2 = l2.next;
    }

    int sum = 0;
    ListNode head = new ListNode(0);
    while (!s1.isEmpty() || !s2.isEmpty() || sum != 0) {
      int num1 = s1.isEmpty() ? 0 : s1.pop();
      int num2 = s2.isEmpty() ? 0 : s2.pop();

      sum += num1 + num2;

      ListNode node = new ListNode(sum % 10);
      node.next = head.next;
      head.next = node;
      sum /= 10;
    }
    return head.next;
  }
}
