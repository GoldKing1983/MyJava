package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;

/*
==========================================================Requirement============================================================
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
========================================================Solution Approach========================================================
1) Always compare current and next
2) If currentValue and nextValue are same...Skip the next by pointing current.next to next.next
3) Else current = next.
4) Next is always current.next.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = cur.next;
                }
                cur = cur.next;
            }
        }
        return head;
    }
}
