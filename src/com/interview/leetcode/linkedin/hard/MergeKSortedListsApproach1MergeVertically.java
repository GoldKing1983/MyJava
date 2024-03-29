package com.interview.leetcode.linkedin.hard;

import java.util.PriorityQueue;
import java.util.Queue;
import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/merge-k-sorted-lists/description/
=======================================================Requirement===============================================================
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
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
=====================================================Solution Approach===========================================================
1) First time fill priority queue with 0th index of node from all array.
2) Poll a node from queue, which is the least value and 1st result.
3) If the node has next node, offer the next node. Else poll next node from queue.
===========================================================Trick=================================================================
We don't need to maintain array index to poll "next data" specifically from particular index of array.
It is done implicitly because of node data structure "node.next"
If the node is not having the "next" attribute itself, then solution would be more tricky.

====Solution Approach for matrix of numbers(Not for below problem, because below problem is based on Array of connected node)====
1) Assume there are 5*6 matrix of sorter numbers where each row is sorted.
2) Add each rows first data to pQ. The data should be offered as pair<data, row, col> in pQ.
3) Poll a data pair from queue, which is the least value and 1st result.
4) from the pair load the next go to the specific row and load next column.
3) If the row is not fully traversed, offer the next element. Else poll next element from queue.
====Solution Approach for array of numbers(Not for below problem, because below problem is based on Array of connected node)====
0) Assume there are 5 of sorted arrays.
1) The data should be offered as pair<data, arrayId, arrayIndex> in priority queue
2) First time fill priority queue with 0th index of pair<data, arrayId, arrayIndex>  from all array.
3) Poll a data pair from queue, which is the least value and 1st result.
4) from the pair load the next go to the specific row and load next column.
3) If the array is not empty, offer the next element. Else poll next element from queue.


Time Complexity: O(n(log(k))) n is allElementsSize, k is listsSize
*/
public class MergeKSortedListsApproach1MergeVertically {
  public ListNode mergeKLists(ListNode[] lists) {
    Queue<ListNode> pQ = new PriorityQueue<>((list1, list2) -> list1.val - list2.val);
    ListNode result = new ListNode(0);
    ListNode dummyResult = result;
    for (ListNode list : lists) {
      if (list != null) pQ.offer(list);
    }
    while (!pQ.isEmpty()) {
      ListNode list = pQ.poll();
      ListNode temp = new ListNode(list.val); // Clone the data instead of changing source... 
      result.next = temp;
      result = result.next;
      if (list.next != null) pQ.offer(list.next);
    }
    return dummyResult.next;
  }
}
