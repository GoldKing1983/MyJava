package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.ListNode;
import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand

METHOD 1 (Use a Stack or list(parse from last))
A simple solution is to use a stack of list nodes. This mainly involves three steps.
1) Traverse the given list from head to tail and push every visited node to stack.
2) Traverse the list again. For every visited node, pop a node from stack and compare data of popped node 
with currently visited node.
3) If all nodes matched, then return true, else false.

Time complexity of above method is O(n), but it requires O(n) extra space.

 */
public class PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {
    ListNode temp = head;
    Deque<ListNode> stack = new ArrayDeque<>();
    while (temp != null) {
      stack.push(temp);
      temp = temp.next;
    }
    while (!stack.isEmpty()) {
      if (head.val != stack.pop().val) {
        return false;
      }
      head = head.next;
    }
    return true;
  }
}
