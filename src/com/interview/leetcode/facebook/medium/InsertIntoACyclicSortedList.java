package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.newer.Node;

/*
 * https://leetcode.com/problems/insert-into-a-cyclic-sorted-list/
 *
1) Think of the problem as, in a sorted array, insert a number.
2) Number can come in duplicate.
3) We cannot do binary search because it is linked list.
4) Iterate nodes for the first time. Make the head pointer to come in lowest
number and prev pointer to the highest number.
5) There are only 3 cases can come
	a) number to be inserted is at front.
	b) number to be inserted is at last.
	c) number to be inserted is at anywhere in middle.
6) For the case 5a and 5b we can insert number between prev and head.
7) For the case 5c. Iterate for the second time.
	Start from low, verify ins >= curr && ins <= next. Then insert. Else loop it.

Ex: Data...
123 -> insert 0 -> case5a
123 -> insert 4 -> case5b
1235 -> insert 4 -> case5c
null -> insert 1 -> special case, handle separately
1 -> insert 0 -> case5a
1 -> insert 2 -> case5b
 */
public class InsertIntoACyclicSortedList {

  public Node insert(Node head, int insertVal) {
    Node newNode = new Node(insertVal);
    newNode.next = newNode;
    if (head == null) {
      return newNode;
    }

    Node current = head;
    Node biggest = head;
    do {
      if (current.val <= insertVal && current.next.val >= insertVal) {
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
        return head;
      }

      if (current.next.val < current.val) {
        biggest = current;
      }

      current = current.next;
    } while (current != head);

    Node temp = biggest.next;
    biggest.next = newNode;
    newNode.next = temp;

    return head;
  }
}
