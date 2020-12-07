package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/sort-list

 */
public class SortListMergeSort {
  // Copied from MergeTwoSortedListsClone
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2; // 5.next is null. So return 6.
    if (l2 == null) return l1;
    ListNode clone = new ListNode();
    if (l1.val <= l2.val) {
      clone.val = l1.val;
      clone.next = mergeTwoLists(l1.next, l2);
      return clone;
    }
    clone.val = l2.val;
    clone.next = mergeTwoLists(l1, l2.next);
    return clone;

  }


  public ListNode split(ListNode head) {
    //bottom case
    if (head == null || head.next == null) return head;


    ListNode slowPtr = head;
    ListNode fastPtr = head;
    ListNode cutPoint = head;

    while (fastPtr != null && fastPtr.next != null) {
      cutPoint = slowPtr;
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }
    // to split the list into half..set the firstHalf's end to null.
    cutPoint.next = null;

    //handle those two sub list
    ListNode leftHalf = split(head);
    ListNode rightHalf = split(slowPtr);

    return mergeTwoLists(leftHalf, rightHalf);

  }

  public ListNode sortList(ListNode head) {
    return split(head);
  }
}
