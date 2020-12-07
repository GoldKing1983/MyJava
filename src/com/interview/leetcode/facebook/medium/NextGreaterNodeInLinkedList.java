package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.ListNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
https://leetcode.com/problems/next-greater-element-ii/
===========================================================Requirement===========================================================
1) Similar to NextGreaterElementIRightApproach. But list can contain duplicates.

2) In NextGreaterElementIRightApproach we save data in stack and map to store result for easier understanding.
Understand that problem, it is very important. Here we update result directly.
===========================================================Solution Approach=====================================================
1) Convert the ListNode data to ArrayList.
2) Do NextGreaterElementIRightApproach.

Example: [9, 8, 7, 3, 2, 1, 6]

Stack saves the index. ArrayList holds the data.
The stack will first contain [0, 1, 2, 3, 4, 5] and then we see 6 which is greater than 1,
so we pop index and update the result array, whose next greater element should be 6.
result = [0, 0, 0, 6, 6, 6, 1]
=================================================================================================================================
 */
public class NextGreaterNodeInLinkedList {
  public int[] nextLargerNodes(ListNode head) {
    ArrayList<Integer> list = new ArrayList<>();
    for (ListNode node = head; node != null; node = node.next) list.add(node.val);
    int[] res = new int[list.size()];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < list.size(); ++i) {
      while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
        res[stack.pop()] = list.get(i);
      }
      stack.push(i);
    }
    return res;
  }
}
