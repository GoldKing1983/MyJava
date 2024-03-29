package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/reverse-linked-list/description
https://www.youtube.com/watch?v=MRe3UsRadKw --- watch from 2.44
Similar to problem pattern MergeTwoSortedListsClone

Key point here is Make recursive calls until you reach the last element - 1.

	Input:	a -> b -> c -> null

			=================================
		    a -> b for "b", "c" is sent. "c.next" is null. So "c" returned

		           <-
		  a -> b       c  //head.next.next=head. reverse. Link "Child to Parent".
		     	   ->
		  ===At this point b is pointing c and c is pointing b.===

		  a -> b <- c // head.next= null. Cut "Parent to Child" Link (i.e) Cut "b -> c" link


		  ================================

*/
public class ReverseLinkedListRecursion {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    reverse(head);
    return cacheLastNode; // lastNode is the firstNode. Return firstNode.
  }

  ListNode cacheLastNode = null;

  // Ex: a->b->c->null
  private void reverse(ListNode head) {
    if (head.next == null) { // on seeing c.. set c in result and return
      cacheLastNode = head;
      return;
    }

    reverse(head.next); // current is still b
    head.next.next = head; // reverse. Link "Child to Parent". Connect c->b
    head.next = null; // Cut "Parent to Child" Link. b->null
  }
}
