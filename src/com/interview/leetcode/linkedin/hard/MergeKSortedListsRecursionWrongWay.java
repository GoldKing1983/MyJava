package com.interview.leetcode.linkedin.hard;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 *

Ex: there are 5 elements in ListNode[]
 I could call mergetTwoLists for [01] [02] [03] [04]. which still work but it is not best solution.

 It has to be [0 4] [1 3] [2] Then [0134] [2] Then [01234]

 Below solution will increase the size of index[0] and will cause more time.

 *
 * O(nlogk).
 */
public class MergeKSortedListsRecursionWrongWay {
  public ListNode mergeKLists(ListNode[] lists) {
    int len = lists.length;
    if (len == 0) return null;
    for (int i = 1; i < len; i++) {
      lists[0] = mergeTwoLists(lists[i], lists[0]);
    }
    return lists[0];
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val <= l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    }
    l2.next = mergeTwoLists(l1, l2.next);
    return l2;
  }
}
