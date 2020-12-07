package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

    10->20->30->40->50->60->70->80->90->100
    
    n=4... Remove 70... Connect 60 and 80..
    

=====Solution Logic====
1) Take 2 pointers p1 and p2. 

2) Move p1 to n times. Ex: p1 moves to 40.
  
3) Move both p1 and p2 till p1 reaches null.
      Ex: p1 moves to null. p2 stands in 60.

4) Connect p2.next with p2.next.next
	Edge Case: Delete 1st node itself.
==============
There are 2 cases
1) Most cases, we need to do the connect on 1st and 3rd node by skipping 2nd node.
	Ex: Node:[1,2,3] remove 2rd from last
		Node:[1,2,3] remove 1st from last
2) Edge Case : Remove the 1st node itself. In that case. p1 will be null. Just send head.next
    Ex: Node:[1] remove 1st from last
     	Node:[1,2] remove 2nd from last
     	Node:[1,2,3] remove 3rd from last

*/

public class RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p1 = head;
    ListNode p2 = head;
    // Move p1 to n
    for (int i = 1; i <= n; i++) p1 = p1.next;

    // Edge Case: For 3 node. Remove 3rd Node From Last.
    if (p1 == null) return head.next;

    while (p1.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    p2.next = p2.next.next;
    return head;
  }
}
