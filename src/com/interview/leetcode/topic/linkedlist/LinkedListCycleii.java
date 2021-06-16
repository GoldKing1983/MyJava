package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/linked-list-cycle-ii/

1) Detect Loop using single pointer and double pointer approach. Loop point is not same as Cycle point.
2) Move fast to head again. Now move both slow and fast. The meeting point is cycle point.
 */
public class LinkedListCycleii {
  public ListNode detectCycle(ListNode head) {
    ListNode slowPtr = head;
    ListNode fastPtr = head;

    boolean cycleFound = false;
    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if (fastPtr == slowPtr) {
        cycleFound = true;
        break;
      }
    }
    if (cycleFound) {
      fastPtr = head;
      while (fastPtr != slowPtr) {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next;
      }
      return fastPtr;
    }

    return null;
  }

  public ListNode detectCycleSetApproach(ListNode head) {
    Set<ListNode> visited = new HashSet<>();

    ListNode node = head;
    while (node != null) {
      if (visited.contains(node)) {
        return node;
      }
      visited.add(node);
      node = node.next;
    }

    return null;
  }
}
