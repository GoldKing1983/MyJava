package com.interview.leetcode.google.easy;

import com.interview.leetcode.ListNode;

/*
Intersection is different from "spanning from singlePoint" like Tree. Ex: Below case is not possible,
because 3.next can point to 4 or 7 and not both.
		========Wrong Case========
				 --->4--->5--->6
				|
 1--->2--->3--->
 				|
 				 --->7--->8--->9
		========Right Case========
		--->4--->5--->6
						|
						 --->1--->2--->3
						|
		--->7--->8--->9
================================================================================================================
1) Get the Length of ListA and ListB.
2) Move the pointer of biggestLength list to the difference.
	Ex: listALength = 10.  listBLength = 20.
	Then move ptrB to position10.
3) Run both the ptrA and PtrB. When both same return ptrA or PtrB.

*/
public class IntersectionOfTwoLinkedListsAlternate {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = getLen(headA);
    int lenB = getLen(headB);

    if (lenA == 0 || lenB == 0) return null;

    int cnt = 0;

    if (lenA > lenB) {
      while (cnt != lenA - lenB) {
        headA = headA.next;
        cnt++;
      }
    } else {
      while (cnt != lenB - lenA) {
        headB = headB.next;
        cnt++;
      }
    }

    while (headA != null) {
      if (headA == headB) return headA;
      headA = headA.next;
      headB = headB.next;
    }

    return headA;
  }

  public int getLen(ListNode head) {
    int cnt = 0;
    ListNode cur = head;

    while (cur != null) {
      cnt++;
      cur = cur.next;
    }

    return cnt;
  }
}
