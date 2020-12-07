package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/odd-even-linked-list/

Given a singly linked list, group all odd nodes together followed by the even nodes.
Please note here we are talking about the "node number" and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

========================================================Solution Approach========================================================
Step1) Connect all odd nodes.
Step2) Connect all even nodes.
Step3) Connect oddNodeEnd to evenNodeBegin. 
Note: Step1 and Step2 must be done in same loop. Because we are not cloning.  

Ex: [1,2,3,4,5]
node1  -->  node2 --> node3 --> node4  -->node5
oddNode-->evenNode-->oddNode-->evenNode-->oddNode
1) Connect 1->3->5
2) Connect 2->4
3) Connect 5->2
=================================================================================================================================
 */

public class OddEvenLinkedList {

  //Ex: [1,2,3,4,5]
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode odd = head; // stays at 1
    ListNode even = odd.next; // stays at 2
    ListNode evenNodeBegin = even; // stays at 2
    while (odd.next != null && even.next != null) {
      odd.next = even.next; // Connect 1 and 3
      odd = even.next; // move odd to 3
      even.next = odd.next;
      even = odd.next;
    }
    odd.next = evenNodeBegin; // connect 5 and 2
    return head;
  }
}
