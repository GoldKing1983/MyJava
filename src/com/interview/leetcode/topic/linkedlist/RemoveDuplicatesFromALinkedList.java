package com.interview.leetcode.topic.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
https://www.educative.io/courses/coderust-hacking-the-coding-interview/lYZoV

 */
public class RemoveDuplicatesFromALinkedList {


  public static LinkedListNode removeDuplicates(LinkedListNode head) {
    Set<Integer> set = new HashSet<>();
    if (head == null) return null;
    LinkedListNode resultHead = head;
    set.add(head.data);
    LinkedListNode prev = head;
    head = head.next;
    while (head != null) {
      if (set.contains(head.data)) {
        prev.next = head.next;
        head = prev.next;
      } else {
        set.add(head.data);
        prev = prev.next;
        head = head.next;
      }
    }
    return resultHead;
  }

  class LinkedListNode {
    int data;
    LinkedListNode next;
  }
}
