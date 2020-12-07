package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
======================================================Requirement================================================================
Given a singly linked list, determine if it is a palindrome.

Input: 1->2
Output: false

Input: 1->2->2->1
Output: true
======================================================Solution Approach==========================================================
This method takes O(n) time and O(1) extra space.
1) Get the middle of the linked list.
2) Reverse the second half of the linked list.
3) Check if the first half and second half are identical.
4) Note: Original Structure destroyed

 */
public class PalindromeLinkedListReverseApproach {

  public boolean isPalindrome(ListNode head) {

    if (head == null) return true;

    // 1) Get the middle of the linked list.
    ListNode middleOfList = endOfFirstHalf(head);
    // 2) Reverse the second half of the linked list.
    ListNode secondHalfStart = reverseList(middleOfList.next);

    // 3) Check if the first half and second half are identical.
    ListNode ptr1 = head;
    ListNode ptr2 = secondHalfStart;
    while (ptr2 != null) {
      if (ptr1.val != ptr2.val) return false;
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    return true;
  }

  // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  private ListNode endOfFirstHalf(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
