package com.interview.leetcode.topic.linkedlist;

import java.util.HashSet;
import java.util.Set;
import com.interview.leetcode.ListNode;

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode fastPtrNode = head;
    ListNode slowPtrNode = head;
    while (fastPtrNode.next != null && fastPtrNode.next.next != null) {
      slowPtrNode = slowPtrNode.next;
      fastPtrNode = fastPtrNode.next;
      fastPtrNode = fastPtrNode.next;
      if (fastPtrNode == slowPtrNode) return true;

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
