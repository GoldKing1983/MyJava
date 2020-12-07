package com.interview.leetcode.amazon.easy;

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
    return cacheLastNode;
  }

  ListNode cacheLastNode = null;

  private void reverse(ListNode head) {
    if (head.next == null) {
      cacheLastNode = head;
      return;
    }

    reverse(head.next);
    head.next.next = head; // reverse. Link "Child to Parent".
    head.next = null; // Cut "Parent to Child" Link.
  }
}
