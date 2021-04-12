package com.interview.leetcode.topic.linkedlist;

import java.util.Random;
import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/linked-list-random-node/description/

 */
public class LinkedListRandomNode2Pass {

  int count = 0;
  ListNode head;
  Random random = new Random();

  public LinkedListRandomNode2Pass(ListNode head) {
    this.head = head;
    ListNode tempHead = head;
    while (tempHead != null) {
      count++;
      tempHead = tempHead.next;
    }

  }

  /** Returns a random node's value. */
  public int getRandom() {
    int randomNumber = random.nextInt(count);
    ListNode tempHead = head;
    while (randomNumber-- != 0) {
      tempHead = tempHead.next;
    }
    return tempHead.val;
  }
}
