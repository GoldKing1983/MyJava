package com.interview.leetcode.linkedin.hard;

import com.interview.leetcode.ListNode;
import com.interview.leetcode.topic.linkedlist.MergeTwoSortedListsInPlace;

/*
https://leetcode.com/problems/merge-k-sorted-lists/description/
=======================================================Requirement===============================================================
1) You are given an array of k linked-lists lists,
2) Each linked-list is sorted in ascending order.
3) Merge all the linked-lists into one sorted linked-list and return it.
========================================================Example1=================================================================
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
=====================================================Solution Approach O(n*logk)=================================================
1) At any-point merge 2 listNodes. Keep doing it, till size becomes 1.  
2) Ex: Assume there are 5 lists from 0 to 4.
    =====Option1 Merge Style=====
     Merge - [0 4] 
     Merge - [1 3] 
     Merge - [2] 
     Merge - [0134] 
     Merge - [2] 
     Merge - [01234]
    =====Option2 Merge Style=====Below code works on Option2.
     ----n = 5. Traverse from 0 to n/2(2 times)---- 
     Merge - [0 1] 
     Merge - [2 3]
     Move  - list[4] to list[2] - Because odd list don't have anything to merge. 
     ----n = 3. Traverse from 0 to n/2(1 time)---- 
     Merge - [01 23]
     Move  - list[2] to list[1] 
     ----n = 1. Traverse from 0 to n/2----
     Merge - [0123 4]. 
======================================================Wrong Approach=============================================================
     Merge - [01] 
     Merge - [02] 
     Merge - [03] 
     Merge - [04]. which still work but it is not best solution.
Because it will increase the size of index[0] and will consume more space/time.

See MergeKSortedListsRecursionWrongWay.java
=================================================================================================================================
 */
public class MergeKSortedListsRecursion {
  MergeTwoSortedListsInPlace m = new MergeTwoSortedListsInPlace();

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    int n = lists.length; // no extra memory, decrease end of lists each time when merge two
    while (n != 1) {
      boolean isOdd = n % 2 == 1;
      n = n / 2; // decrease n by half
      for (int i = 0; i < n; i++) {
        int current = i * 2; // 0 2 4 // Similar to logic "MaximumWidthOfBinaryTreeDFS"
        int next = i * 2 + 1;// 1 3 6
        lists[i] = m.mergeTwoLists(lists[current], lists[next]);
      }
      // if the list is odd, then move the "last missed one to index n"
      if (isOdd) { // Ex: [1][2][3]... [1][2] merged to lists[0]... n=1... move [3] to lists[1]
        lists[n] = lists[n * 2];
        n++;
      }

    }
    return lists[0]; // all lists are merged.    

  }
}
