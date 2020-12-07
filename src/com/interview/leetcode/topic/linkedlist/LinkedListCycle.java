package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next;
      fastPtr = fastPtr.next;

      if (slowPtr == fastPtr) return true; // loop found
    }
    return false;
  }

  public boolean hasCycleSetApproach(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
      if (nodesSeen.contains(head)) {
        return true;
      }
      nodesSeen.add(head);

      head = head.next;
    }
    return false;
  }
}
