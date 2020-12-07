package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/merge-two-sorted-lists/description/
See Also ReverseLinkedListBottomUp
=================Solution Note=======================================
1) Solution is based on both forwardRecursion and bottomUpRecursion.
2) During forwardRecursion values are set for clonedNodes.
3) During bottomUpRecursion cloned nodes are connected from lastNode.
4) See the picture "MergeTwoSortedLists.jpg" for understanding.
5) Nodes are connected from last to first and first small value node is returned.

==================================Tricky- how the bottomUp recurseBack or bubbleUp=============================
		one step before Last recursion
   		l1-->	5 --> null
   		l2-->	6 --> null

		5 is smaller. So Last recursion goes for (5.next)
   			null(5.next)
   			6 --> null

	    bottomUp startsHere with null(5.next) exitCondition "returning 6". to 5.next
=================BottomLine---bottomUp bubbles back from 5.next returning 6... Watch Carefully=================

  Input : 1->3->5, 2->4->6
  Output: 1->2->3->4->5->6
 */

public class MergeTwoSortedListsClone {
  // Returns cloned ListNode. This code will not change the source l1 and l2
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2; // 5.next is null. So return 6.
    if (l2 == null) return l1;
    ListNode clone = new ListNode();
    if (l1.val <= l2.val) {
      clone.val = l1.val;
      clone.next = mergeTwoLists(l1.next, l2);
      return clone;
    }
    clone.val = l2.val;
    clone.next = mergeTwoLists(l1, l2.next);
    return clone;

  }

  // Returns cloned ListNode. Sweet code without if condition
  public ListNode mergeTwoListsCloneShort(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode clone = new ListNode();
    clone.val = l1.val <= l2.val ? l1.val : l2.val;
    clone.next = l1.val <= l2.val ? mergeTwoListsCloneShort(l1.next, l2)
        : mergeTwoListsCloneShort(l1, l2.next);
    return clone;
  }
}
