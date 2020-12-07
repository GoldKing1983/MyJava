package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.newer.newer.Node;
import java.util.ArrayDeque;
import java.util.Deque;

/*

Input:
1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL


Output: [1,2,3,7,8,11,12,9,10,4,5,6]

=====================================Solution Approach=====================================
1) If there is child, push next to stack, and follow the child;
2) If there is no child, but has next, follow the next;
3) If there is no child, no next, but has stack, pop one and follow
4) Otherwise finish

=======================================================Data Flow Diagram==============================================
Initial State
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
Stack[]

Step 1:
 1---2---3
         |
         7---8---9---10--NULL
             |
             11--12--NULL
Stack[4---5---6--NULL]

Step 2:
 1---2---3
         |
         7---8
             |
             11--12--NULL
Stack[4---5---6--NULL, 9---10--NULL]

Step 3:
1---2---3---7---8---11---12---9---10---NULL
Stack[4---5---6--NULL]

Step 4:
1---2---3---7---8---11---12---9---10---4---5---6---NULL
Stack[]
============================================================================================================================

 */
public class FlattenAMultilevelDoublyLinkedList {
  public Node flatten(Node tempHead) {
    if (tempHead == null) return null;
    Deque<Node> stack = new ArrayDeque<>();
    Node head = tempHead;
    while (true) {
      if (head.child != null) {
        if (head.next != null) stack.push(head.next);
        head.next = head.child;
        head.next.prev = head;
        head.child = null;
      } else {
        if (head.next == null) {
          if (stack.isEmpty()) break;
          head.next = stack.pop();
          head.next.prev = head;
        }
      }
      head = head.next;
    }

    return tempHead;
  }
}
