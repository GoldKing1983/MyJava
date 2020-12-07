package com.interview.leetcode.google.easy;

import com.interview.leetcode.ListNode;

/*
============================================Solution Approach - Simple Maths=====================================================
1) Run the loop 2 times. firstTime ptrA  points ListA, second time ptrA points ListB.
2) Run the loop 2 times. firstTime ptrB  points ListB, second time ptrB points ListA.
3) Now, if  there is a cycle or not. Both ptrA and ptrB will meet at samePoint.
4) Because length they are iterating combinely is same. totalLength = list1.length + list2.length.
5) If the meeting point is null, then there is no intersection else intersection is there.
=====================================================Solution Approach===========================================================
Trick to this solution is running both the listNode at the same time.
1) Maintain two pointers ptrA and ptrB initialized at the head of A and B, respectively.
2) Then let them both traverse through the lists, one node at a time.
3) When ptrA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.);
similarly when ptrB reaches the end of a list, redirect it the head of A.
4) Second time ptrA meets ptrB in all cases(have or no intersection). Return intersection node ptrA or ptrB.

Visualization of this solution:

============================Case 1 (Have Intersection & Same Len):============================
		===================
       a
A:     a1 → a2 → a3
                   ↘
                     c1 → c2 → c3 → null
                   ↗
B:     b1 → b2 → b3
       b
		===================
            a
A:     a1 → a2 → a3
                   ↘
                     c1 → c2 → c3 → null
                   ↗
B:     b1 → b2 → b3
            b
		===================
                 a
A:     a1 → a2 → a3
                   ↘
                     c1 → c2 → c3 → null
                   ↗
B:     b1 → b2 → b3
		===================
                 b
A:     a1 → a2 → a3
                   ↘ a
                     c1 → c2 → c3 → null
                   ↗ b
B:     b1 → b2 → b3
Since a == b is true, end loop while(a != b), return the intersection node a = c1.

============================Case 2 (Have Intersection & Different Len):============================
		===================
            a
A:          a1 → a2
                   ↘
                     c1 → c2 → c3 → null
                   ↗
B:     b1 → b2 → b3
       b
		===================
                 a
A:          a1 → a2
                   ↘
                     c1 → c2 → c3 → null
                   ↗
B:     b1 → b2 → b3
            b
		===================
A:          a1 → a2
                   ↘ a
                     c1 → c2 → c3 → null
                   ↗
B:     b1 → b2 → b3
                 b
		===================
A:          a1 → a2
                   ↘      a
                     c1 → c2 → c3 → null
                   ↗ b
B:     b1 → b2 → b3
		===================
A:          a1 → a2
                   ↘           a
                     c1 → c2 → c3 → null
                   ↗      b
B:     b1 → b2 → b3
		===================
A:          a1 → a2
                   ↘                a = null, then a = b1
                     c1 → c2 → c3 → null
                   ↗           b
B:     b1 → b2 → b3
		===================
A:          a1 → a2
                   ↘
                     c1 → c2 → c3 → null
                   ↗                b = null, then b = a1
B:     b1 → b2 → b3
       a
		===================
            b
A:          a1 → a2
                   ↘
                     c1 → c2 → c3 → null
                   ↗
B:     b1 → b2 → b3
            a
		===================
                 b
A:          a1 → a2
                   ↘
                     c1 → c2 → c3 → null
                   ↗
B:     b1 → b2 → b3
                 a
		===================
A:          a1 → a2
                   ↘ b
                     c1 → c2 → c3 → null
                   ↗ a
B:     b1 → b2 → b3
Since a == b is true, end loop while(a != b), return the intersection node a = c1.

============================Case 3 (Have No Intersection & Same Len):============================

       a
A:     a1 → a2 → a3 → null
B:     b1 → b2 → b3 → null
       b
            a
A:     a1 → a2 → a3 → null
B:     b1 → b2 → b3 → null
            b
                 a
A:     a1 → a2 → a3 → null
B:     b1 → b2 → b3 → null
                 b
                      a = null
A:     a1 → a2 → a3 → null
B:     b1 → b2 → b3 → null
                      b = null
Since a == b is true (both refer to null), end loop while(a != b), return a = null.

============================Case 4 (Have No Intersection & Different Len):============================

       a
A:     a1 → a2 → a3 → a4 → null
B:     b1 → b2 → b3 → null
       b
            a
A:     a1 → a2 → a3 → a4 → null
B:     b1 → b2 → b3 → null
            b
                 a
A:     a1 → a2 → a3 → a4 → null
B:     b1 → b2 → b3 → null
                 b
                      a
A:     a1 → a2 → a3 → a4 → null
B:     b1 → b2 → b3 → null
                      b = null, then b = a1
       b                   a = null, then a = b1
A:     a1 → a2 → a3 → a4 → null
B:     b1 → b2 → b3 → null
            b
A:     a1 → a2 → a3 → a4 → null
B:     b1 → b2 → b3 → null
       a
                 b
A:     a1 → a2 → a3 → a4 → null
B:     b1 → b2 → b3 → null
            a
                      b
A:     a1 → a2 → a3 → a4 → null
B:     b1 → b2 → b3 → null
                 a
                           b = null
A:     a1 → a2 → a3 → a4 → null
B:     b1 → b2 → b3 → null
                      a = null

Since a == b is true (both refer to null), end loop while(a != b), return a = null.


 */
public class IntersectionOfTwoLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // boundary check
    if (headA == null || headB == null) return null;

    ListNode ptrA = headA;
    ListNode ptrB = headB;

    // if a & b have different len, then we will stop the loop after second iteration
    while (ptrA != ptrB) {
      // for the end of first iteration, we just reset the pointer to the head of another linkedlist
      ptrA = ptrA == null ? headB : ptrA.next;
      ptrB = ptrB == null ? headA : ptrB.next;
    }

    return ptrA;
  }
}
