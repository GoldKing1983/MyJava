package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/rotate-list/

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL


One difference why RotateList logic differs from RotateArray is.
Nodes are connected in List, whereas array it is not connected.
So interchanging logic will work. But complicated.
======================================Solution Approach======================================
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL

Step1) Move tempHead to 5 for step2.
Step2) Connect 5 to 1. Now the list is a circular list.
Step3) Move head to 3. for step4 and step5
Step4) Set newHead to 4, which is start of node
Step5) Set 3's next to null.

 */
public class RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;
    int n = 1; // since we are already at head node
    ListNode tempHead = head;

    // Step1) Move tempHead to 5 for step2.
    while (tempHead.next != null) {
      n++;
      tempHead = tempHead.next;
    }

    // Step2) Connect 5 to 1. Now the list is a circular list.
    tempHead.next = head;

    // Step3) Move head to 3. for step4 and step5
    k = k % n; // If the number of rotation is more than n. Then rotation = rotation%size of data.
    int noOfRotation = (n - k) - 1;
    while (noOfRotation-- > 0) head = head.next;

    // Step4) Set newHead to 4, which is start of node
    ListNode newHead = head.next;

    // Step5) Set 3's next to null.
    head.next = null;

    return newHead;
  }
}
