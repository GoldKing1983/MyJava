package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.ListNode;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

Similar to ConvertSortedArrayToBinarySearchTree.
To find the cutPoint traverse using slow and fast pointer.
 */
public class ConvertSortedListToBinarySearchTree {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    return toBST(head, null);
  }

  public TreeNode toBST(ListNode head, ListNode tail) {
    ListNode slow = head;
    ListNode fast = head;
    if (head == tail) return null;

    while (fast != tail && fast.next != tail) {
      fast = fast.next.next;
      slow = slow.next;
    }
    TreeNode thead = new TreeNode(slow.val);
    thead.left = toBST(head, slow);
    thead.right = toBST(slow.next, tail);
    return thead;
  }
}
