package com.interview.leetcode.topic.linkedlist;

/*
https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
 */
public class DeleteDuplicateValueNodesFromASortedLinkedList {
  class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
  }

  static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
    if (head == null) return null;
    SinglyLinkedListNode resultHead = head;
    while (head.next != null) {
      if (head.data == head.next.data) {
        head.next = head.next.next;
      } else {
        head = head.next;
      }
    }
    return resultHead;

  }

}
