package com.interview.leetcode.topic.linkedlist;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/merge-two-sorted-lists/description/
See Also ReverseLinkedListBottomUp
=================Solution Note=======================================
1) Solution is based on bottom-up recursion and not forward recursion.
2) See the picture "MergeTwoSortedLists.jpg" for understanding.
3) Nodes are connected from last to first and first small value node is returned.

  Input : 1->3->5, 2->4->6
  Output: 1->2->3->4->5->6
=======================================================Data Flow Analysis========================================================
  Input : 1->null, 2->null

  mergeTwoLists((l1)1,(l2)2)
          |
  l1.val <= l2.val
  l1.next = mergeTwoLists(null,2)
          |
       return 2
          |
     l1.next = 2
     1.next  = 2
     return l1.... 1->2

=======================================================Data Flow Analysis========================================================
  Input : 2->null, 1->null

  mergeTwoLists((l1)2,(l2)1)
          |
  l1.val > l2.val
  l2.next = mergeTwoLists(2,null)
          |
       return 2
          |
     l2.next = 2
     1.next  = 2
     return l2.... 1->2
 */

public class MergeTwoSortedListsInPlace {

  // in-place change. This will change both the node l1 and l2
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
